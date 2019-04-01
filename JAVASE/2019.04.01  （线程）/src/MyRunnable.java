
public class MyRunnable implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread a=Thread.currentThread(); 
		System.out.println(a.getName());
		System.out.println(a.getId());
	}

}
