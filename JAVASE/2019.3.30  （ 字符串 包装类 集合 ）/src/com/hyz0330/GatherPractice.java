package com.hyz0330;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//������ص���ϰ
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
	//set�ӿ�
			Set set=new HashSet();
			set.add(1);   //�Զ�װ��  �Զ���1 new Integer(1)
		    set.add("ɽ��");
		    set.add("ɽ��");
		    set.add(true); 
		    set.add("shanghai");
		    System.out.println(set);
		    
		    Iterator iterator=set.iterator();
		    while(iterator.hasNext()) {
		    	Object o =iterator.next();
		    	System.out.println(o);
		    }
	    }
	
	//list��index���ԣ�����ֱ��ͨ��index�����б����������ֻ��list��
	public void testList() {
	
		List list=new ArrayList();
		list.add(1);   //�Զ�װ��  �Զ���1 new Integer(1)
		list.add("ɽ��");
		list.add("ɽ��");
		list.add(true); 
		list.add("shanghai");
	    System.out.println(list);
	    
	  /*  Iterator iterator=list.iterator();
	    while(iterator.hasNext()) {
	    	Object o =iterator.next();
	    	System.out.println(o);
	    }**/
	    
	    for(int i=0;i<list.size();i++) {
	    	System.out.println(list.get(i));//��get������ȡ����Ӧ�±��ֵ
	    }
	
	 }
	
	public void testList1() {
	/**
	 * �˴�set�ж�����������ȫ��ͬ�Ķ���Ϊ������ͬ������
	 * set�ж�����Ԫ���Ƿ���� �ȱȽ�����Ԫ�ص�hashCode,
	 * ���hashCode����ͬ��ֱ�Ӳ���ͬ���������equals����
	 * ���hashCode��ͬ�������equals�������ٽ��бȽ�
	 * */
		Set<Person>set1=new HashSet<Person>();
		set1.add(new Person("��ɺ","Ů"));
		set1.add(new Person("��ɺ","Ů"));
		
		System.out.println(set1.size());
		
	}
	
	public void testMap() {
		
		Map<String,String>map=new HashMap<String,String>();
		map.put("����","��ɺ");
		map.put("�Ա�","Ů");
		System.out.println(map.size());
		System.out.println(map.get("�Ա�"));
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
		list.add(1);   //�Զ�װ��  �Զ���1 new Integer(1)
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
	    	System.out.println(list.get(i));//��get������ȡ����Ӧ�±��ֵ
	    }
	
	 }
	
	public void testList4() {
		
		List<Admin> list=new ArrayList<Admin>();
		list.add(new Admin(2));   //�Զ�װ��  �Զ���1 new Integer(1)
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
	    	System.out.println(list.get(i));//��get������ȡ����Ӧ�±��ֵ
	    }**/
	
	 }
	
	
	
	
}
