package fr.balsaeize.turtlegame.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Permet d'écrire les résultats de la commande exécutée
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class ExecutorRunnable implements Runnable {

	/** Permet de lire dans le terminal **/
	private final InputStream inputStream;
	
	/**
	 * Constructeur pour récupérer le retour des commandes exécutées et écrire dans le terminal
	 * 
	 * @param inputStream Entrée de la lecture
	 */
	public ExecutorRunnable(InputStream inputStream)
	{
		this.inputStream = inputStream;
	}
	
	@Override
	public void run()
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(inputStream)); // On récupère le flux sur l'entrée
		String line = ""; // Permet de récupérer la ou les lignes retournées par l'exécution de la commande
		
		try
		{
			while ((line = br.readLine()) != null) // Tant qu'il y a des résultats
				System.out.print(line); // On affiche ces résultats (Ce que retourne la commande)
			
			br.close();
		}
		catch (IOException e)
		{
			e.printStackTrace(); // Sinon on affaire la trace de l'erreur
		}
	}

}
