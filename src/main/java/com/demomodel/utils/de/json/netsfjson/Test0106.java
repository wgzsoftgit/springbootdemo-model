package com.demomodel.utils.de.json.netsfjson;
import net.sf.json.JSONObject;
import org.junit.Test;

import com.demomodel.utils.de.json.netsfjson.util.BeanConverter;
import com.demomodel.utils.de.json.netsfjson.util.Stu;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: hoobey
 * @Description:
 * @Date: Created in 9:16 2018/1/6
 * @Modified By:
 */
public class Test0106 {
    /*javaBean转换成Map*/
    @Test
    public void test1(){
        Map<String, String> map = BeanConverter.BeantoMap(new Stu("hoobey","123"));
    
      //  Set<Map.Entry<String, String>> entry = map.entrySet(); //Set集合中存储的是Map.Entry<String, String> entry
        //推荐使用这种map遍历 尤其是容量大的时候  map.entrySet()返回此映射中包含的映射关系的 Set视图
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println("key="+entry.getKey()+"，value="+entry.getValue());
        }
    }

    /*  * 将json对象转换成Map*/
    @Test
    public void test2(){

        JSONObject json =new JSONObject();
        json.put("hoobey","123");          //{"hoobey":"123"}
        json.put("ag",12); 
        Map<String, String> toMap = BeanConverter.JsontoMap(json);
        for(Map.Entry<String, String> entry : toMap.entrySet()){
            System.out.println("key="+entry.getKey()+"，value="+entry.getValue());
        }
    }

    /*将javaBean转换成JSONObject*/
    @Test
    public void test3(){
        JSONObject toJSON = BeanConverter.toJSON(new Stu("hoobey", "123"));
        System.out.println(toJSON);//{"password":"123","name":"hoobey"}
    }

    /*将map转换成Javabean   map中存放的键值一定和bean相对应*/
    @Test
    public void test4(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("name","hoobey");
        map.put("password","123");
        Object o = BeanConverter.toJavaBean(new Stu(), map);
        System.out.println(o);//Stu{name='hoobey', password='123'}
    }
}