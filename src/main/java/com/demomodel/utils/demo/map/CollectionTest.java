package com.demomodel.utils.demo.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionTest {
	public static void main(String[]args){
		List<String> listtest= Arrays.asList("a", "B", "c", "d"); //初始化数组
		List<String> arrayList= new ArrayList<String>();
		arrayList.add("s1");arrayList.add("s3");arrayList.add("s4");arrayList.add("s5");arrayList.add("s2");
		System.out.print("ArrayList:==========================");
		for(String arrList:arrayList){
			System.out.print(arrList);
			}
		List<String> linkedList=new LinkedList<String>();
		linkedList.add("s1");linkedList.add("s3");linkedList.add("s4");linkedList.add("s5");linkedList.add("s2");
		System.out.println("LinkedList:===========================");
		for(String linkList:linkedList){
			System.out.print(linkList);
			}
	
		Set<String> linkedHashSet=new LinkedHashSet<String>();
		linkedHashSet.add("s1");linkedHashSet.add("s3");linkedHashSet.add("s4");linkedHashSet.add("s5");linkedHashSet.add("s2");
		System.out.println("LinkedHashSet:=========================");
		for(String linkedst:linkedHashSet){ 
			System.out.print(linkedst);}
		
		Set<String> hashSet=new HashSet<String>();
		hashSet.add("s1");hashSet.add("s3");hashSet.add("s4");hashSet.add("s5");hashSet.add("s2");
		System.out.println("HashSet:==============================");
		for(String hashst:hashSet){
			System.out.print(hashst);
			}
		Set<String> treeSet=new TreeSet<String>();
		treeSet.add("s1");treeSet.add("s3");treeSet.add("s4");treeSet.add("s5");treeSet.add("s2");		
		System.out.println("TreeSet:==============================");
		for(String treest:treeSet){
			System.out.print(treest);
			}}
}