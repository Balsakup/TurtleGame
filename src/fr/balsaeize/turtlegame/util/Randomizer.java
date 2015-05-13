package fr.balsaeize.turtlegame.util;

import fr.balsaeize.turtlegame.game.Player;

/**
 * Permet de faire des générations aléatoire
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class Randomizer {

	/**
	 * Permet de créer un joueur aléatoirement
	 * 
	 * @return Un joueur aléatoire
	 */
	public static Player getRandomPlayer()
	{
		// Plein de prénom (Issue ma famille :D )
		String[] name = new String[] { "Manon", "Mattheo", "Raphael", "Raphael", "Jean", "Maurice", "Claudine", "Marie-Therese", "Joel", "Sylvie", "Emilien", "Marie", "Christophe", "Emmanuel", "Frank", "Pierre", "Eloise", "Maelys", "Faustine", "Olivier", "Antoine", "Charline", "Jean", "Antoinette", "Philippe", "Margaux", "Remi", "Annette", "Pauline", "Vincent" };
		
		// On retourne un joueur avec un nom prit aléatoirement et un âge comprit entre 7 et 99 inclut
		return new Player(name[(int)(Math.random() * ((name.length - 1) + 1))], 7 + (int)(Math.random() * ((99 - 7) + 1)));
	}
	
}
