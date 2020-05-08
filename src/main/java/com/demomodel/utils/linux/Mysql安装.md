# Mysql安装

> 1. 解压安装包:
>
>    ~~~shell
>    [root@ora11g ~]# tar -zxvf mysql-5.7.26-linux-glibc2.12-x86_64.tar.gz
>    ~~~
>
> 2. 移动到 /usr/local
>
>    ~~~shell
>    [root@ora11g ~]# mv mysql-5.7.26-linux-glibc2.12-x86_64  /usr/local
>    
>    # 修改名称
>    [root@ora11g local]# mv mysql-5.7.26-linux-glibc2.12-x86_64  mysql
>    ~~~
>
> 3. 创建data文件夹
>
>    ~~~shell
>    # 作为 datadir
>    [root@ora11g ~]# mkdir /usr/local/mysql/data
>    ~~~
>
> 4. 配置my.cnf文件
>
>    ~~~shell
>    [root@ora11g ~]# vim /etc/my.cnf
>    
>    # 配置以下内容
>    [mysql]
>    default-character-set=utf8
>    [mysqld]
>    skip-name-resolve
>    port = 3306
>    basedir=/usr/local/mysql
>    datadir=/usr/local/mysql/data	
>    max_connections=200
>    character-set-server=utf8
>    default-storage-engine=INNODB
>    lower_case_table_names=1
>    max_allowed_packet=16M
>    bind-address = 0.0.0.0
>    ~~~
>
> 5. 添加用户组,用户
>
>    ~~~shell
>    [root@ora11g ~]# groupadd mysql
>    [root@ora11g ~]# useradd -r -g mysql mysql
>    [root@ora11g ~]# chown -R mysql:mysql /usr/local/mysql
>    ~~~
>
> 6. 初始化mysql数据库,控制台会输出临时密码,请记下:  初始化后 显示 root@localhost:xxxxxx 
>
>    ~~~shell
>    # 进入安装目录下的bin文件夹
>    [root@ora11g ~]# cd /usr/local/mysql/bin/
>    
>    # 初始化mysql
>    [root@ora11g bin]# ./mysqld --initialize --user=mysql --basedir=/usr/local/mysql --datadir=/usr/local/mysql/data
>    
>    # 如果没有及时记下密码，可修改/etc/my.cnf文件，在[mysqld]下方添加skip-grant-tables，意思是跳过权限表的校验，可以免密登录
>    ~~~
>
> 7. 启动mysql
>
>    ~~~shell
>    [root@ora11g ~]# service mysqld start
>    Starting MySQL… [ OK ]
>    [root@ora11g ~]# mysql -uroot -p
>    Enter password:
>    
>    # 如果执行mysql -uroot -p,提示-bash: mysql: command not found那么可以通过软连接将mysql添加到系统中
>    [root@ora11g ~]# ln -s /usr/local/mysql/bin/mysql /usr/bin
>    ~~~
>
> 8. 修改密码,开启远程连接
>
>    ~~~sql
>    # 修改密码
>    mysql> update user set authentication_string=password('123456') where user='root';
>    Query OK, 0 rows affected, 1 warning (0.00 sec)
>    Rows matched: 1 Changed: 0 Warnings: 1
>    
>    # 开启允许所有ip连接
>    mysql> update user set host='%' where user='root';
>    Query OK, 0 rows affected (0.00 sec)
>    Rows matched: 1 Changed: 0 Warnings: 0
>    
>    # 授权远程主机允许连接mysql数据库
>    mysql> grant all privileges on . to root@'%' identified by '123456';
>    Query OK, 0 rows affected, 1 warning (0.00 sec)
>    
>    # 进行刷新
>    mysql> flush privileges;
>    Query OK, 0 rows affected (0.00 sec)
>    ~~~

# 有关无法远程连接问题

> 安装完成后,执行相关允许远程连接命令,都无法连接
>
> 1. 可能是网络没有连通,我的是通的
>
>    ~~~cmd
>    C:\Users\ThinkPad>ping 192.168.134.159
>    
>    正在 Ping 192.168.134.159 具有 32 字节的数据:
>    来自 192.168.134.159 的回复: 字节=32 时间=1ms TTL=62
>    来自 192.168.134.159 的回复: 字节=32 时间=1ms TTL=62
>    来自 192.168.134.159 的回复: 字节=32 时间=1ms TTL=62
>    来自 192.168.134.159 的回复: 字节=32 时间=1ms TTL=62
>    
>    192.168.134.159 的 Ping 统计信息:
>        数据包: 已发送 = 4，已接收 = 4，丢失 = 0 (0% 丢失)，
>    往返行程的估计时间(以毫秒为单位):
>        最短 = 1ms，最长 = 1ms，平均 = 1ms
>    ~~~
>
> 2. 有可能服务器端防火墙端口没开
>
>    ~~~cmd
>    C:\Users\ThinkPad>telnet 192.168.134.159 3306
>    
>    # 出现另外的命令窗口即是可以访问的,出现连接失败就是没有对外开放
>    ~~~
>
>    ~~~shell
>    # 对防火墙开通3306端口
>    [root@ora11g ~]# firewall-cmd --permanent --zone=public --add-port=3306/tcp
>    
>    # 重新加载防火墙配置
>    [root@ora11g ~]# firewall-cmd --reload
>    ~~~