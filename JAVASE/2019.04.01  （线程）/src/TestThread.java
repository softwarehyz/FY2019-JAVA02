
public class TestThread extends Thread {

	private int num;
	
	public TestThread(int num) {
		this.num=num;
	}
	
    public TestThread() {
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	/**	for(int i=0;i<10;i++) {
		System.out.println("��һ���߳�");	
		TestThread t1=new TestThread(i);
        t1.start();
	     }
		
		for(int i=0;i<5;i++) {	
			TestThread t1=new TestThread(i,"�����߳�");
			t1.setPriority(MAX_PRIORITY);
	        t1.start();
		     }
		*/
		
		for(int i=0;i<2;i++) {
			Runnable m=new MyRunnable();
			Thread t1=new Thread(m,"��һ������");
			t1.setPriority(MIN_PRIORITY);
	        t1.start();
		    }
		
		for(int i=0;i<3;i++) {
		Runnable m=new MyRunnable();
		Thread t1=new Thread(m,"�ڶ�������");
		t1.setPriority(MAX_PRIORITY);
        t1.start();
	    }
	}
	
	/**public void run() {
		System.out.println(num);
	}
    
    */
}
