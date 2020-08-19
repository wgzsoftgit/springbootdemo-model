package com.demomodel.utils.demo.arraytext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

	}


}
