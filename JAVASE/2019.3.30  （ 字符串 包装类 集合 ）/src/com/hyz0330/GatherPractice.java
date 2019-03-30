package com.hyz0330;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//集合相关的练习
public class GatherPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GatherPractice g=new GatherPractice();
		g.testset();
		g.testList();
		g.testList1();
		g.testMap();
		g.testList3();
		g.testList4();
	}
	public void testset() {
	//set接口
			Set set=new HashSet();
			set.add(1);   //自动装箱  自动将1 new Integer(1)
		    set.add("山西");
		    set.add("山西");
		    set.add(true); 
		    set.add("shanghai");
		    System.out.println(set);
		    
		    Iterator iterator=set.iterator();
		    while(iterator.hasNext()) {
		    	Object o =iterator.next();
		    	System.out.println(o);
		    }
	    }
	
	//list有index属性，可以直接通过index来进行遍历，但这个只有list有
	public void testList() {
	
		List list=new ArrayList();
		list.add(1);   //自动装箱  自动将1 new Integer(1)
		list.add("山西");
		list.add("山西");
		list.add(true); 
		list.add("shanghai");
	    System.out.println(list);
	    
	  /*  Iterator iterator=list.iterator();
	    while(iterator.hasNext()) {
	    	Object o =iterator.next();
	    	System.out.println(o);
	    }**/
	    
	    for(int i=0;i<list.size();i++) {
	    	System.out.println(list.get(i));//用get方法获取到对应下标的值
	    }
	
	 }
	
	public void testList1() {
	/**
	 * 此处set判断两个属性完全相同的对象为两个不同的数据
	 * set判断两个元素是否相等 先比较两个元素的hashCode,
	 * 如果hashCode不相同，直接不相同，不会调用equals方法
	 * 如果hashCode相同，则调用equals方法，再进行比较
	 * */
		Set<Person>set1=new HashSet<Person>();
		set1.add(new Person("张珊","女"));
		set1.add(new Person("张珊","女"));
		
		System.out.println(set1.size());
		
	}
	
	public void testMap() {
		
		Map<String,String>map=new HashMap<String,String>();
		map.put("名字","张珊");
		map.put("性别","女");
		System.out.println(map.size());
		System.out.println(map.get("性别"));
		Set<Map.Entry<String,String>> set=map.entrySet();
		
		Iterator<Map.Entry<String,String>> it=set.iterator();
		while(it.hasNext()) {
			Map.Entry<String,String> entry=it.next();
			String key=entry.getKey();
			String value=entry.getValue();
			System.out.println(key+"="+value);
		}
		
		
	}
	
	public void testList3() {
		
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);   //自动装箱  自动将1 new Integer(1)
		list.add(4);
		list.add(0);
		list.add(6); 
		list.add(9);
		Collections.sort(list);
	    System.out.println(list);
	    
	  /*  Iterator iterator=list.iterator();
	    while(iterator.hasNext()) {
	    	Object o =iterator.next();
	    	System.out.println(o);
	    }**/
	    
	    for(int i=0;i<list.size();i++) {
	    	System.out.println(list.get(i));//用get方法获取到对应下标的值
	    }
	
	 }
	
	public void testList4() {
		
		List<Admin> list=new ArrayList<Admin>();
		list.add(new Admin(2));   //自动装箱  自动将1 new Integer(1)
		list.add(new Admin(6));
		list.add(new Admin(7));
		list.add(new Admin(3)); 
		list.add(new Admin(9));
		Collections.sort(list);
	    //System.out.println(list);
	    
	  Iterator<Admin> iterator=list.iterator();
	    while(iterator.hasNext()) {
	    	Admin o =iterator.next();
	    	System.out.println(o);
	    }
	    
	    /*for(int i=0;i<list.size();i++) {
	    	System.out.println(list.get(i));//用get方法获取到对应下标的值
	    }**/
	
	 }
	
	
	
	
}
