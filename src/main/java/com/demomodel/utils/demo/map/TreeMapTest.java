package com.demomodel.utils.demo.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {
	public static void main(String[] args) {
		//  ByMapKey();
		ByMapValue();
	}
	
	public static void ByMapValue() {
	  Map<String, String> map = new TreeMap<String, String>();
      map.put("d", "ddddd");
      map.put("b", "bbbbb");
      map.put("a", "aaaaa");
      map.put("c", "ccccc");
      
      //这里将map.entrySet()转换成list
      List<Map.Entry<String,String>> list = new ArrayList<Map.Entry<String,String>>(map.entrySet());
      //然后通过比较器来实现排序
      Collections.sort(list,new Comparator<Map.Entry<String,String>>() {
          //升序排序
          public int compare(Entry<String, String> o1,
                  Entry<String, String> o2) {
              return o1.getValue().compareTo(o2.getValue());
          }
          
      });
      
      for(Map.Entry<String,String> mapping:list){ 
             System.out.println(mapping.getKey()+":"+mapping.getValue()); 
        } 
//      a:aaaaa
//      b:bbbbb
//      c:ccccc
//      d:ddddd
	}  
	//map排序
    public static void ByMapKey() {
        Map<String, String> map = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return obj2.compareTo(obj1);
                    }
                });
        map.put("c", "ccccc");
        map.put("a", "aaaaa");
        map.put("b", "bbbbb");
        map.put("d", "ddddd");
        
        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            System.out.println(key + ":" + map.get(key));
        }
//        d:ddddd
//        c:ccccc
//        b:bbbbb
//        a:aaaaa
    }
    
    
    public void removeByIterator(){//正确的删除方式
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        System.out.println(map);
        Iterator<Map.Entry<Integer, String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Integer, String> entry = it.next();
            if(entry.getKey() == 2)
                it.remove();//使用迭代器的remove()方法删除元素
        }
        System.out.println(map);
    }
}