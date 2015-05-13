package fr.balsaeize.turtlegame.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Permet de faire les logs du jeu
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class Log {

	/**
	 * Permet d'enregistrer les logs du jeu dans un fichier log
	 * 
	 * @param str Texte à mettre dans les logs
	 */
	public static void print(String str)
	{
		SimpleDateFormat folderFormat = new SimpleDateFormat("dd-MM-yyyy"); // Format du jour pour le dossier
		SimpleDateFormat hourFormat   = new SimpleDateFormat("hh:mm:ss"); // Formation de l'heure pour préfixer les lignes de logs
		Date now                      = new Date(); // La date de maintenant
		File logFolder                = new File("logs/" + folderFormat.format(now)); // Le dossier où sont les logs
		
		// Si les dossiers l'existe pas
		if (!logFolder.exists())
			logFolder.mkdirs(); // alors on les créait
		
		// Buffer d'écriture
		BufferedWriter out = null;
		
		try
		{
			// On ouvre l'écriture vers le fichier
			out = new BufferedWriter(new FileWriter(logFolder.getPath() + "/out.log", true));
			
			// On écrit dedans en préfixant avec l'heure
			out.write("[" + hourFormat.format(now) + "]"+ str);
		}
		catch (IOException  e)
		{
			e.printStackTrace();
			
			System.exit(1); // Si erreur on arrête
		}
		// Finallement, on ferme l'ouverture vers le fichier
		finally
		{
			try
			{
				if (out != null)
					out.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
}
