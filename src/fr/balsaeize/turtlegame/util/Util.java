package fr.balsaeize.turtlegame.util;

/**
 * Permet de gérer tous les utilitaires
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class Util {

	/**
	 * Permet de faire formir le programme
	 * 
	 * @param time Nombre de milliseconde que doit attendre le programme
	 * @return Si il a réussi à dormir ou pas
	 */
	public static boolean sleep(int time)
	{
		try
		{
			Thread.sleep(time); // On dit la la thread principale de dormir
			
			return true;
		}
		// Si elle veut pas, elle nous fait une jolie erreur
		catch (InterruptedException e)
		{
			e.printStackTrace();
			
			return false;
		}
	}
	
}
