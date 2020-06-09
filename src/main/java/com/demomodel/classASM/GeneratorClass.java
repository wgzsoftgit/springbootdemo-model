package com.demomodel.classASM;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//import org.objectweb.asm.ClassWriter;
//import org.objectweb.asm.Opcodes;

/**
 * 通过asm生成类的字节码
 * ASM框架中的核心类有以下几个：

　　①  ClassReader:该类用来解析编译过的class字节码文件。

　　②  ClassWriter:该类用来重新构建编译后的类，比如说修改类名、属性以及方法，甚至可以生成新的类的字节码文件。

　　③  ClassAdapter:该类也实现了ClassVisitor接口，它将对它的方法调用委托给另一个ClassVisitor对象

生成D://Comparable.class
生成一个类的字节码文件只需要用到ClassWriter类即可，
生成Comparable.class后用javap指令对其进行反编译：javap -c Comparable.class >test.tx

https://blog.csdn.net/qilixiang012/article/details/43370985?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase
 * @author Administrator
 *
 */
public class GeneratorClass {

    public static void main(String[] args) throws IOException {
//        //生成一个类只需要ClassWriter组件即可
//        ClassWriter cw = new ClassWriter(0);
//        //通过visit方法确定类的头部信息
//        cw.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC+Opcodes.ACC_ABSTRACT+Opcodes.ACC_INTERFACE,
//                "com/asm3/Comparable", null, "java/lang/Object", new String[]{"com/asm3/Mesurable"});
//        //定义类的属性
//        cw.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL+Opcodes.ACC_STATIC,
//                "LESS", "I", null, new Integer(-1)).visitEnd();
//        cw.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL+Opcodes.ACC_STATIC,
//                "EQUAL", "I", null, new Integer(0)).visitEnd();
//        cw.visitField(Opcodes.ACC_PUBLIC+Opcodes.ACC_FINAL+Opcodes.ACC_STATIC,
//                "GREATER", "I", null, new Integer(1)).visitEnd();
//        //定义类的方法
//        cw.visitMethod(Opcodes.ACC_PUBLIC+Opcodes.ACC_ABSTRACT, "compareTo",
//                "(Ljava/lang/Object;)I", null, null).visitEnd();
//        cw.visitEnd(); //使cw类已经完成
//        //将cw转换成字节数组写到文件里面去
//        byte[] data = cw.toByteArray();
//        File file = new File("D://Comparable.class");
//        FileOutputStream fout = new FileOutputStream(file);
//        fout.write(data);
//        fout.close();
    }
}