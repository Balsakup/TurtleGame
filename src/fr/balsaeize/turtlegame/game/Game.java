package fr.balsaeize.turtlegame.game;

import java.util.List;

/**
 * Classe qui g�re le d�roulement du jeu
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @verison 1.0.0
 */
public class Game {
	
	/** Liste des joueurs qui participent au jeu **/
	private List<Player> players;
	/** Joueur courant. Celui qui doit joueur **/
	private Player currentPlayer;

	/**
	 * Permet de cr�er une nouvelle partie de jeu
	 * 
	 * @param players Joueurs participant au jeu
	 */
	public Game(List<Player> players)
	{
		this.players  = players;
		currentPlayer = getYoungest(); // R�cup�re le joueur le plus jeune
	}
	
	/**
	 * Permet de r�cup�rer le joueur le plus jeune parmis tous les joueurs
	 * 
	 * @return Le joueur le plus jeune
	 */
	public Player getYoungest()
	{
		int age         = 200;  // On suppose qu'il n'y aura pas de joueur de plus de 200 ans
		Player youngest = null; // Il n'y a pas de plus jeune au d�but
		
		// Pour tous les joueurs pr�sent
		for (Player p : players)
		{
			// Si l'age du joueur est inf�rieur � l'age du joueur le plus jeune (200 pa d�faut)
			if (p.getAge() < age)
			{
				age      = p.getAge(); // L'�ge devient celui du joueur le plus jeune
				youngest = p;          // On remplace le joueur le plus jeune  
			}
		}
		
		return youngest; // On retourne le plus jeune
	}

	/**
	 * Permet de r�cup�rer tous les joueurs
	 * 
	 * @return La liste des joueurs
	 */
	public List<Player> getPlayers()
	{
		return players;
	}

	/**
	 * Permet de modifier la liste des joueurs
	 * 
	 * @param players Nouvelle liste de joueur
	 */
	public void setPlayers(List<Player> players)
	{
		this.players = players;
	}

	/**
	 * Permet de r�cup�rer le joueur courant, celui qui doit jouer
	 * 
	 * @return Le joueur courant
	 */
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}

	/**
	 * Permet de changer le joueur courant, celui qui doit jouer
	 * 
	 * @param currentPlayer Le nouveau joueur courant
	 */
	public void setCurrentPlayer(Player currentPlayer)
	{
		this.currentPlayer = currentPlayer;
	}
	
}
