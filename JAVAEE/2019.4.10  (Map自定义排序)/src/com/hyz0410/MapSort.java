package com.hyz0410;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapSort {
		public static void main(String[] args) {
			Map<Integer, Student> map = new HashMap<Integer, Student>();
	        Student student1=new Student(2014,"马克",66);
	        Student student2=new Student(2015,"麦克",77);
	        Student student3=new Student(2016,"琳娜",88);
	        map.put(student1.getID(), student1);
	        map.put(student2.getID(), student2);
	        map.put(student3.getID(), student3);
	        
			//按照 value 排序
			List<Map.Entry<Integer, Student>> list = new ArrayList<Map.Entry<Integer, Student>>(
					map.entrySet());
			Collections.sort(list, new Comparator<Map.Entry<Integer, Student>>() {
				@Override
				public int compare(Entry<Integer, Student> o1,
						Entry<Integer, Student> o2) {
					return o2.getValue().getScore() - o1.getValue().getScore();
				}
			});
			
			System.out.println(list);
		}
}
