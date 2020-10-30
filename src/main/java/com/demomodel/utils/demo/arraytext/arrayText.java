package com.demomodel.utils.demo.arraytext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.sf.jsqlparser.expression.operators.relational.LikeExpression;

public class arrayText {

	public static void main(String[] args) {
		String arrtem="0-5";
		String[] split = arrtem.split("-");
		for (String string : split) {
			System.err.println(string);
		}
		
		
		int[] intArray = new int[]{1, 2, 3};  //初始化数组
		Integer[] integerArray = new Integer[]{1, 2, 3}; //初始化数组
		List<Integer> integerList2 = Arrays.asList(1, 2, 3); //初始化数组
		
		
		List<int[] > intArrayList = Arrays.asList(intArray); //数组转化成list集合
		List<Integer> integerList = Arrays.asList(integerArray);
		
	//遍历数组
		for (int i = 0; i < intArray.length; i++) {
			System.err.println(intArray[i]);
		}
		
		String[] temarr=new String[4];
		temarr[0]="1";temarr[1]="1";temarr[2]="1";temarr[3]="1";
		String[] strs = new String[]{};//，这种方式数组长度会默认为0，也就是一个空数组，但是要注意了，这种方式是无法给数组动态赋值的，赋值会抛出数组越界异常

//定义数组 
		String[] arr = {"ID", "姓名", "年龄"};
        //  将数组转化为集合
        List<String> list1 = Arrays.asList(arr);
       // List<String> list3=new LinkedList<String>();
        // 定义集合 2 ，并向其中添加元素: 性别、出生日期
        List<String> list2 = new ArrayList<>();
		list2.add("性别");
        list2.add("出生日期");
        // 定义新集合
        List<String> titleList = new ArrayList<String>();
     titleList.addAll(list1);  // 将集合 1 中的元素添加到新集合中
     titleList.addAll(list2);   // 将集合 2 中的元素添加到新集合中
  // 将新集合转化回新数组
     String[] newArr = titleList.toArray(new String[titleList.size()]);
  

  System.out.println(Arrays.toString(newArr));
  // 将数组转化为字符串，输出
  
  
  
  //判断字符是否存在数组中
  String[] strArr = {"aa", "bb", "cc"};
  boolean res = Arrays.asList(strArr).contains("aa"); // true
  System.out.println(ifcontainsByArrays(strArr,"aa"));
  String[] strArr2 = {"aa", "bb", "cc"};
  long count = Arrays.stream(strArr2).filter(str -> str.equals("cc")).count(); // 1
  
System.err.println(res +"&&"+count);


//在循环中删除一个列表中的元素，见如下代码，我建议使用removeByIterator方法
List<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
for (String s : removeByIterator(list, "c")) {
	System.out.print(s);
}
System.out.println();
System.out.println("----------------------------");
for (String s : removeByNewList(list1, "c")) {
	System.out.print(s);
}


	}
	
	//遍历删除元素
	public static List<String> removeByNewList(List<String> list, String str) {
		List<String> newList = new ArrayList<String>();
		for (String s : list) {
			if (!s.equals(str)) {
				newList.add(s);
			}
		}
		return newList;
	}
	//推荐              遍历删除元素
	public static List<String> removeByIterator(List<String> list, String str) {
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			String s = iterator.next();
			if (s.equals(str)) {
				// 移除迭代器返回的元素
				iterator.remove();
			}
		}	
		return list;
	}
	
	
	//推荐  判断字符是否在数组中
	public static boolean ifcontainsByArrays(String [] strs, String str) {
		// 注意：Arrays.asList()方法返回的是 java.util.Arrays.ArrayList而不是java.util.ArrayList
		return Arrays.asList(strs).contains(str);
	}
	//判断字符是否在数组中
	public boolean ifcontains(String [] strs, String str) {
		for (String s : strs) {
			if (s.equals(str)) {
				return true;
			}
		}
		return false;
	}


}
