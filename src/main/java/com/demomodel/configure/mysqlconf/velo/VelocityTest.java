package com.demomodel.configure.mysqlconf.velo;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**没测试
 * ==Velocity之Hello Wordld入门程序==
 * <p>
 * 首先，我们在代码中初始化了VelocityEngine这个模板引擎，对其设置参数进行初始化，
 * 指定使用ClasspathResourceLoader来加载vm文件。然后我们就可以往VelocityContext这个Velocity
 * 容器中存放对象了，在vm文件中我们可以取出这些变量，从而进行模板输出。
 */
public class VelocityTest {

    private static final String VM_PATH = "template/velocity/helloworld.vm";

    public static void main(String[] args) {
        // 初始化模板引擎
        VelocityEngine velocityEngine = new VelocityEngine();
        velocityEngine.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        velocityEngine.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        velocityEngine.init();

        // 获取模板文件
        Template template = velocityEngine.getTemplate(VM_PATH);

        // 设置变量，velocityContext是一个类似map的结构
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("name", "world");
        List<String> list = new ArrayList<String>();
        list.add("jack");
        list.add("kitty");
        velocityContext.put("list", list);

        // 输出渲染后的结果
        StringWriter stringWriter = new StringWriter();
        template.merge(velocityContext, stringWriter);
        System.out.println("com.demomodel.configure.mysqlconf.velo.VelocityTest"+stringWriter.toString());
    }
}