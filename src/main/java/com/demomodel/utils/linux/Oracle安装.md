## Linux Centos 7下静默安装Oracle11gR2

记得设置编码格式

### 准备工作

> 在网上搜索的是Centos7

> 1. 确认主机名称一致
>
>    ~~~shell
>    [root@ora11g ~]# vim /etc/hosts
>    192.168.134.159    ora11g
>    ~~~
>
> 2. 上传数据库安装的压缩文件
>
>    ~~~shell
>    [root@ora11g ~]# ll
>    -rw-r--r--  1 root root 1239269270 Apr 25 20:41 linux.x64_11gR2_database_1of2.zip
>    -rw-r--r--  1 root root 1111416131 Apr 25 20:40 linux.x64_11gR2_database_2of2.zip
>    
>    [root@ora11g ~]# unzip linux.x64_11gR2_database_1of2.zip
>    [root@ora11g ~]# unzip linux.x64_11gR2_database_2of2.zip 
>    # 解压完成出现database文件夹
>    ~~~
>
> 3. 验证所需要的RPM包是否齐全
>
>    ~~~shell
>    [root@ora11g ~]# rpm -q binutils compat-libcap1 compat-libstdc++-33 gcc gcc-c++ glibc glibc-devel ksh
>    binutils-2.27-41.base.el7_7.3.x86_64
>    compat-libcap1-1.10-7.el7.x86_64
>    compat-libstdc++-33-3.2.3-72.el7.x86_64
>    gcc-4.8.5-39.el7.x86_64
>    gcc-c++-4.8.5-39.el7.x86_64
>    glibc-2.17-292.el7.x86_64
>    glibc-devel-2.17-292.el7.x86_64
>    ksh-20120801-140.el7_7.x86_64
>    
>    [root@ora11g ~]# rpm -q libgcc libstdc++ libstdc++-devel libaio libaio-devel make sysstat unixODBC unixODBC-devel
>    libgcc-4.8.5-39.el7.i686
>    libgcc-4.8.5-39.el7.x86_64
>    libstdc++-4.8.5-39.el7.x86_64
>    libstdc++-devel-4.8.5-39.el7.x86_64
>    libaio-0.3.109-13.el7.x86_64
>    libaio-0.3.109-13.el7.i686
>    libaio-devel-0.3.109-13.el7.i686
>    libaio-devel-0.3.109-13.el7.x86_64
>    make-3.82-24.el7.x86_64
>    sysstat-10.1.5-18.el7_7.1.x86_64
>    unixODBC-2.3.1-14.el7.x86_64
>    unixODBC-devel-2.3.1-14.el7.x86_64
>    ~~~

### 修改系统文件参数

> 1. 配置linux内核参数
>
>    ~~~shell
>    # 添加如下参数
>    [root@ora11g ~]# vim /etc/sysctl.conf
>    kernel.shmmax = 68719476736
>    kernel.shmall = 4294967296
>    fs.file-max = 6815744
>    kernel.shmmni = 4096
>    kernel.sem = 250 32000 100 128
>    net.ipv4.ip_local_port_range = 9000 65500
>    net.core.rmem_default = 262144
>    net.core.rmem_max = 4194304
>    net.core.wmem_default = 262144
>    net.core.wmem_max = 1048586
>    fs.aio-max-nr = 1048576
>    ~~~
>
> 2. 配置资源使用情况
>
>    ~~~shell
>    # 添加如下参数
>    [root@ora11g ~]# vim /etc/security/limits.conf
>    oracle soft nproc 2047
>    oracle hard nproc 16384
>    oracle soft nofile 1024
>    oracle hard nofile 65536
>    oracle hard stack 10240
>    ~~~
>
> 3. 登录设置
>
>    ~~~shell
>    # 追加如下参数
>    [root@ora11g ~]# vim /etc/pam.d/login
>    session required /lib64/security/pam_limits.so
>    session required pam_limits.so
>    
>    [root@ora11g ~]# vim /etc/profile
>    if [ $USER = "oracle" ]; then
>       if [ $SHELL = "/bin/ksh" ]; then
>           ulimit -p 16384
>           ulimit -n 65536
>        else
>           ulimit -u 16384 -n 65536
>       fi
>    fi
>    ~~~
>
> 4. 关闭selinux,确保SELINUX=disable
>
>    ~~~shell
>    [root@ora11g ~]# vim /etc/selinux/config
>    # This file controls the state of SELinux on the system.
>    # SELINUX= can take one of these three values:
>    #     enforcing - SELinux security policy is enforced.
>    #     permissive - SELinux prints warnings instead of enforcing.
>    #     disabled - No SELinux policy is loaded.
>    SELINUX=disabled
>    # SELINUXTYPE= can take one of three two values:
>    #     targeted - Targeted processes are protected,
>    #     minimum - Modification of targeted policy. Only selected processes are protected.
>    #     mls - Multi Level Security protection.
>    SELINUXTYPE=targeted
>    ~~~

### 创建用户,用户组和安装目录

> 1. 创建oinstall和dba组,oracle用户
>
>    ~~~shell
>    [root@ora11g ~]# groupadd oinstall
>    
>    [root@ora11g ~]# groupadd dba
>    
>    [root@ora11g ~]# useradd -g oinstall -G dba oracle
>    
>    # 修改oracle用户密码
>    [root@ora11g ~]# passwd oracle
>    ~~~
>
> 2. 创建安装目录并修改所属用户和组
>
>    ~~~shell
>    [root@ora11g ~]# mkdir -p /u01/app/oracle
>    
>    [root@ora11g ~]# chown -R oracle:oinstall /u01/app/
>    ~~~

### 修改环境变量

> 1. 切换到oracle用户
>
>    ~~~shell
>    [root@ora11g ~]# su - oracle
>    ~~~
>
> 2. 修改环境变量
>
>    ~~~shell
>    # 进入到根路径
>    [oracle@ora11g root]$ cd
>    
>    # 修改环境变量
>    [oracle@ora11g ~]$ vim .bash_profile
>    export ORACLE_BASE=/u01/app/oracle
>    export ORACLE_HOME=$ORACLE_BASE/product/11.2.0/db_1
>    export ORACLE_SID=ora11g
>    export PATH=$PATH:$HOME/bin:$ORACLE_HOME/bin
>    export LD_LIBRARY_PATH=$ORACLE_HOME/lib:/usr/lib
>    
>    # 使环境变量生效
>    [oracle@ora11g ~]$ source .bash_profile
>    ~~~

### 移动database文件夹(解压后的文件夹)

> 1. 切换回root用户
>
>    ~~~shell
>    # 切换成 root 用户,输入登录密码
>    [oracle@ora11g ~]$ su root
>    Password:
>    ~~~
>
> 2. 移动database文件文件夹
>
>    ~~~shell
>    [root@ora11g ~]# mv database/ /u01/
>    
>    [root@ora11g ~]# chown -R oracle:oinstall database/
>    
>    [root@ora11g ~]# cd /u01/
>    
>    [root@ora11g u01]# chmod -R 777 database/
>    ~~~

### 静默安装oracle

> 1. 修改相应文件 db_install.rsp 
>
>    ~~~shell
>    [root@ora11g ~]# vim /u01/database/response/db_install.rsp
>    
>    oracle.install.option=INSTALL_DB_SWONLY          #选择安装类型：1.只装数据库软件 2.安装数据库软件并建库 3.升级数据库
>    
>    ORACLE_HOSTNAME=ora11g                           #指定操作系统主机名，通过hostname命令获得
>    
>    UNIX_GROUP_NAME=oinstall                         #指定oracle inventory目录的所有者，通常会是oinstall或者dba
>    
>    INVENTORY_LOCATION=/u01/app/oraInventory         #指定产品清单oracle inventory目录的路径
>    
>    SELECTED_LANGUAGES=en,zh_CN,zh_TW                #指定数据库语言，可以选择多个，用逗号隔开
>    
>    ORACLE_HOME=/u01/app/oracle/product/11.2.0/db_1  #设置ORALCE_HOME的路径
>    
>    ORACLE_BASE=/u01/app/oracle                      # 设置ORALCE_BASE的路径
>    
>    oracle.install.db.InstallEdition=EE              #选择Oracle安装数据库软件的版本
>    
>    oracle.install.db.isCustomInstall=false
>    
>    oracle.install.db.DBA_GROUP=dba                  #指定拥有OSDBA、OSOPER权限的用户组，通常会是dba组
>    
>    oracle.install.db.OPER_GROUP=oinstall
>    
>    oracle.install.db.config.starterdb.type=GENERAL_PURPOSE      #选择数据库的用途，一般用途/事物处理，数据仓库
>    
>    oracle.install.db.config.starterdb.globalDBName=ora11g       #指定GlobalName
>    
>    oracle.install.db.config.starterdb.SID=ora11g                #指定SID
>    
>    oracle.install.db.config.starterdb.characterSet=AL32UTF8     #选择字符集。不正确的字符集会给数据显示和存储带来麻烦无数。
>                                              #通常中文选择的有ZHS16GBK简体中文库，根据公司规定自行选择
>                                              
>    oracle.install.db.config.starterdb.password.ALL=123456       #设定所有数据库用户使用同一个密码，其它数据库用户就不用单独设置了。
>    
>    DECLINE_SECURITY_UPDATES=true                   # False表示不需要设置安全更新，注意，在11.2的静默安装中疑似有一个BUG
>    ~~~
>
> 2. 切换到 oracle 用户
>
>    ~~~shell
>    # 切换用户
>    [root@ora11g u01]# su oracle
>    
>    # 进入database,执行runInstaller
>    [oracle@ora11g database]$ ./runInstaller -silent -ignorePrereq -responseFile /u01/database/response/db_install.rsp
>    ~~~
>
> 3. 切换到root用户,使用tail -f查看实时日志
>
> 4. 等待出现提示
>
>    ~~~shell
>    出现类似如下提示表示安装完成：
>    #-------------------------------------------------------------------
>    ...
>    /u01/app/oraInventory/orainstRoot.sh
>    /u01/app/oracle/product/11.2.0/db_1/root.sh
>    To execute the configuration scripts:
>    1. Open a terminal window 
>    2. Log in as "root" 
>    3. Run the scripts 
>    4. Return to this window and hit "Enter" key to continue
>     
>    Successfully Setup Software.
>    #-------------------------------------------------------------------
>    ~~~
>
> 5. 打开新窗口,使用root用户执行以下命令
>
>    ~~~shell
>    [root@ora11g ~]#  /u01/app/oraInventory/orainstRoot.sh
>    
>    [root@ora11g ~]#  /u01/app/oracle/product/11.2.0/db_1/root.sh
>    ~~~

### 静默安装监听

> ```shell
> [oracle@ora11g ~]$ /u01/app/oracle/product/11.2.0/db_1/bin/netca /silent /responseFile /u01/database/response/netca.rsp
> ```

### 静默创建数据库

> 1. 编辑dbca.rsp
>
>    ~~~shell
>    [root@ora11g ~]# vim /u01/database/response/dbca.rsp
>    
>    #以下内容不要修改
>    RESPONSEFILE_VERSION = "11.2.0"
>    
>    OPERATION_TYPE = "createDatabase"
>    
>    #以下内容必须设置
>    GDBNAME = "ora11g"
>    
>    SID = "ora11g"
>    
>    TEMPLATENAME = "General_Purpose.dbc"
>    
>    #以下内容根据需要修改
>    CHARACTERSET = "ZHS16GBK"
>    ~~~
>
> 2. 使用oracle用户执行建库命令
>
>    ~~~shell
>    [oracle@ora11g ~]$ /u01/app/oracle/product/11.2.0/db_1/bin/dbca -silent -responseFile /u01/database/response/dbca.rsp
>    
>    
>    # 会出现将命令全部删除,变成什么都没有的黑窗口,直接输入配置的密码即可,这里是提示输入sys和system的密码
>    
>    # 这里我是配置的123456,输入两边即可
>    
>    # 出现如下提示:
>    Copying database files
>    
>    ...
>    
>    37% complete
>    
>    Creating and starting Oracle instance
>    
>    ...
>    
>    62% complete
>    
>    Completing Database Creation
>    
>    ...
>    
>    100% complete
>    
>    Look at the log file "/u01/app/oracle/cfgtoollogs/dbca/ORCL/ORCL.log" for further details.
>    ~~~

### 静默安装完成



## 远程连接相关



### 关闭oracle

> 1. 切换到oracle用户
>
>    ~~~shell
>    [root@ora11g ~]# su oracle
>    
>    # 关闭监听
>    [oracle@ora11g ~]$ lsnrctl stop
>    bash: lsnrctl: command not found
>    
>    # 如果找不到命令,就查看一下 .bash_profile 文件中是否是在 oracle 用户下进行添加的环境变量
>    [oracle@ora11g ~]$ vim .bash_profile
>    export ORACLE_BASE=/u01/app/oracle
>    export ORACLE_HOME=$ORACLE_BASE/product/11.2.0/db_1
>    export ORACLE_SID=ora11g
>    export PATH=$PATH:$HOME/bin:$ORACLE_HOME/bin
>    export LD_LIBRARY_PATH=$ORACLE_HOME/lib:/usr/lib
>    
>    # 使环境变量生效
>    [oracle@ora11g ~]$ source .bash_profile
>    
>    # 使用管理员身份连接数据库
>    [oracle@ora11g ~]$ sqlplus / as sysdba
>    
>    # 关闭实例
>    SQL> shutdow immediate;
>    ~~~
>
>    

### 修改相关配置文件

> 1. 修改配置文件 tnsnames.ora 
>
>    ~~~shell
>    [oracle@ora11g ~]$ cd /u01/app/oracle/product/11.2.0/db_1/network/admin/
>    [oracle@ora11g admin]$ ll
>    total 16
>    -rw-r--r-- 1 oracle oinstall 539 Apr 26 11:13 listener.ora
>    drwxr-xr-x 2 oracle oinstall  64 Apr 26 09:24 samples
>    -rw-r--r-- 1 oracle oinstall 187 May  7  2007 shrept.lst
>    -rw-r--r-- 1 oracle oinstall 219 Apr 26 09:29 sqlnet.ora
>    -rw-r----- 1 oracle oinstall 326 Apr 26 10:15 tnsnames.ora
>    
>    # 修改配置文件
>    [oracle@ora11g admin]$ vim tnsnames.ora
>    ORA11G =
>      (DESCRIPTION =
>        (ADDRESS = (PROTOCOL = TCP)(HOST = ora11g)(PORT = 1521))
>        (CONNECT_DATA =
>          (SERVER = DEDICATED)
>          (SERVICE_NAME = ora11g)
>        )
>      )
>    ~~~
>
> 2. 修改监听文件  listener.ora 
>
>    ~~~shell
>    # 修改配置文件
>    [oracle@ora11g admin]$ vim listener.ora
>    
>    # 内容如下
>    LISTENER =
>      (DESCRIPTION_LIST =
>        (DESCRIPTION =
>          (ADDRESS = (PROTOCOL = IPC)(KEY = EXTPROC1521))
>          (ADDRESS = (PROTOCOL = TCP)(HOST = ora11g)(PORT = 1521))
>        )
>      )
>    
>    SID_LIST_LISTENER =
>      (SID_LIST =
>      (SID_DESC =
>          (SID_NAME = ora11g)
>          (ORACLE_HOME = /u01/app/oracle/product/11.2.0/db_1)
>          (GLOBAL_DBNAME= ora11g)
>        )
>    )
>    
>    ADR_BASE_LISTENER = /u01/app/oracle
>    ~~~

### 启动oracle

> 1. 启动
>
>    ~~~shell
>    # 使用管理员身份连接数据库
>    [oracle@ora11g ~]$ sqlplus / as sysdba
>    
>    # 开启实例
>    SQL> startup;
>    
>    # 启动监听
>    [oracle@ora11g ~]$ lsnrctl start
>    ~~~