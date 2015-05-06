package fr.balsaeize.turtlegame.util;

public class Util {

	public static boolean sleep(int sec)
	{
		try
		{
			Thread.sleep(sec * 1000);
			
			return true;
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
			
			return false;
		}
	}
	
}
