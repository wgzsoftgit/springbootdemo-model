package com.demomodel.utils.demo.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.demomodel.bean.User;




public class mapgroup {

	public static void main(String[] args) {
		List<User> list = new ArrayList<>();
		list.add(new User(1, 1));
		list.add(new User(1, 2));
		list.add(new User(5, 1));
		list.add(new User(5, 2));
		list.add(new User(4, 1));
		list.add(new User(1, 2));
		list.add(new User(2, 1));
		list.add(new User(6, 1));
		list.add(new User(2, 3));
		list.add(new User(2, 2));
		list.add(new User(3, 1));
		Map<Integer, List<User>> map = new HashMap<>();
	
		for(User user : list){
			if(map.containsKey(user.getId())){//map中存在此id，将数据存放当前key的map中
				map.get(user.getId()).add(user);
			}else{//map中不存在，新建key，用来存放数据
				List<User> tmpList = new ArrayList<>();
				tmpList.add(user);
				map.put(user.getI(), tmpList);
			}
		}
		System.out.println(map.toString());
		Map<Integer, Integer> map2 = new HashMap<>();
		for(User user : list){
			if(map2.containsKey(user.getId())){//map中存在此id，将数据存放当前key的map中			
				map2.put(user.getI(), map2.get(user.getId())+1);
			}else{//map中不存在，新建key，用来存放数据
				
				map2.put(user.getI(), 1);
			}
		}
		System.out.println(map2.toString());
		
		List<Map<String, Object>> list2=new ArrayList<Map<String,Object>>();
		Map<String, Object> map4=new ConcurrentHashMap<String, Object>() ;
		map4.put("1",new User(1, 1) );
		map4.put("2",new User(2, 1) );
		map4.put("6",new User(5, 1) );
		map4.put("5",new User(4, 1) );
		map4.put("4",new User(5, 2) );
		map4.put("3",new User(5, 2) );
		System.out.println("请空前"+map4.toString());

	//	map4.clear();//清空map
		System.out.println("请空后"+map4.toString());
		list2.add(map4);
		Map<String, List<Map<String, Object>>> map3= transition(list2);//分组排序
		System.out.println(map3.toString());
		listsort();
		List<String> listtest= Arrays.asList("a", "B", "c", "d"); //初始化数组
  
		List collect =listtest.stream().map(String::toUpperCase).collect(Collectors.toList());
		List collect2 =listtest.stream().map(String::toLowerCase).collect(Collectors.toList());
		System.out.println(collect); //[A, B, C, D]
		System.out.println(collect2); //[A, B, C, D]
	}
	
	public static void listsort() {
		List<String> list = new ArrayList<String>();
		list.add("beijing");
		list.add("shanghai");
		list.add("hangzhou");
//		Collections.sort(lm, (param1, param2) ->
//        (param2.get(entity.getKey()).toString().compareTo(param1.get(entity.getKey()).toString()))
//                     );
		Collections.sort(list, new Comparator<String>() {
		public int compare(String str1, String str2) {

		/**
		* 升序排的话就是第一个参数.compareTo(第二个参数);
		* 降序排的话就是第二个参数.compareTo(第一个参数);
		*/

		// 按首字母升序排
		// return str1.compareTo(str2);
		// 按第二个字母升序排
		char c1 = str1.charAt(1);
		char c2 = str2.charAt(1);
		return c1 - c2;
		}
		});
		System.out.println(list);
		}
//	分组排序
	public static Map<String, List<Map<String, Object>>> transition(List<Map<String, Object>> list){

        Map<String, List<Map<String, Object>>> map = new HashMap<>();

        // 分组       
        for(Map<String, Object> temp : list) {

            // 获取Map的每一对值          
        Iterator<Map.Entry<String, Object>> iterator = temp.entrySet().iterator();

            while (iterator.hasNext()) {

                List<Map<String, Object>> listAndMap = new ArrayList<>();

                // 获取到每一个实体                
                Map.Entry<String, Object> entity = iterator.next();

                if (map.containsKey(entity.getKey())) {

                    // 获取原来存在的数据                   
                	List<Map<String, Object>> lm = map.get(entity.getKey());

                    lm.add(new HashMap<String, Object>() {{

                        put(entity.getKey(), entity.getValue());

                    }});

                    Collections.sort(lm, (param1, param2) ->

                            (param2.get(entity.getKey()).toString().compareTo(param1.get(entity.getKey()).toString()))

                    );

                    map.replace(entity.getKey(), lm);

                } else {

                    listAndMap.add(new HashMap<String, Object>() {{

                        put(entity.getKey(), entity.getValue());

                    }});

                    map.put(entity.getKey(), listAndMap);

                }

            }

        }

        return map;

    }


}
/**
return Arrays.stream(rp.getHits().getHits()).map(b -> {
return b.getSourceAsMap();
}).collect(Collectors.toList());
{
"_index":"suggest2",
"_type":"folks",
"_id":"KGpW13IBYPi_ZUEZPMmT",
"_score":1.0,
"_source":{
"name":"桃子"
}
},
{
"_index":"suggest2",
"_type":"folks",
"_id":"kqAV2XIB9P74YTRQxbiR",
"_score":1.0,
"_source":{
"name":"水中花"
}
}

*/