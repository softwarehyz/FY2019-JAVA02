package com.hyz0330;

public class Admin implements Comparable<Admin>{
private int age;

public Admin(){
	
}

public Admin(int age){
	this.age=age;
}

public int getAge(){
	return this.age;
}



/*
 * 
 * return  >o ��ǰ�����
 *         =0���
 *         <0��ǰ����С
 * **/
@Override
public int compareTo(Admin o) {
	// TODO Auto-generated method stub
	if(o==null) {
		return 1;
	}
	
return this.age-o.getAge();
}


public String toString() {
	return "age="+age;
}

}
