
public class ThreadSyn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTimer timer=new MyTimer();
		for(int i=0;i<3;i++) {
			Thread t1=new Thread(timer,"num"+i);
			t1.start();
		}
	}
}

	class MyTimer implements Runnable{
	    private int num;
		@Override
		public void  run() {
			// TODO Auto-generated method stub
			synchronized (this) {
			num++;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+"你是第"+num+"个访问的人");
		  }
		}	
	}