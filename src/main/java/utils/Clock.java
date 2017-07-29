package utils;

public class Clock {

	static long start;
	public static void start() {
		
		start= System.currentTimeMillis();
	}
	
	public static void stop()
	{
		System.out.println("\nTime Taken for the process  :: "+((System.currentTimeMillis()-start))+" ms.");
	}

}
