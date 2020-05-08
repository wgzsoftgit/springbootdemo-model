package com.demomodel.configure.mysqlconf.AOPmybatismysql.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.demomodel.configure.mysqlconf.AOPmybatismysql.DataSourceType;
import com.demomodel.configure.mysqlconf.AOPmybatismysql.DataSourceType.DataBaseType;
/**定义AOP：就是不同业务切换不同数据库的入口。如果觉得execution太长不愿意写，就可以定义一个注解来实现。
 * 可参考于我的博客：https://blog.csdn.net/tuesdayma/article/details/79704238
 * https://github.com/mzd123/springboot-multipledatasources/tree/master  源码
 */
@Aspect
@Component
public class DataSourceAop {
    @Before("execution(* com.mzd.multipledatasources.service..*.test01*(..))")
    public void setDataSource2test01() {
        System.err.println("test01业务");
        DataSourceType.setDataBaseType(DataBaseType.TEST01);
    }

    @Before("execution(* com.mzd.multipledatasources.service..*.test02*(..))")
    public void setDataSource2test02() {
        System.err.println("test02业务");
        DataSourceType.setDataBaseType(DataBaseType.TEST02);
    }
}
//https://blog.csdn.net/tuesdayma/java/article/details/81081666