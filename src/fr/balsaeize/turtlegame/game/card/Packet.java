package fr.balsaeize.turtlegame.game.card;

import java.util.ArrayList;
import java.util.List;

import fr.balsaeize.turtlegame.game.Player;
import fr.balsaeize.turtlegame.game.card.ProgressCard.ProgressType;
import fr.balsaeize.turtlegame.game.shuffle.PileShuffle;
import fr.balsaeize.turtlegame.game.shuffle.RiffleShuffle;
import fr.balsaeize.turtlegame.util.Color.ColorCode;
import fr.balsaeize.turtlegame.util.Log;

/**
 * Classe qui gère les paquets de carte (Cartes du jeu et tuilles)
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class Packet {
	
	/** Liste des cartes du jeu **/
	private List<Card> cards;
	/** Liste des tuilles du jeu **/
	private List<Card> tiles;

	/**
	 * Permet de créer un nouveu paquet
	 */
	public Packet()
	{
		cards = new ArrayList<Card>();
		tiles = new ArrayList<Card>();
	}
	
	/**
	 * Permet d'initialiser les cartes
	 */
	public void initCard()
	{		
		// On parcours tous les types de carte
		for (ProgressType p : ProgressType.values())
		{
			// On récupère le nombre de carte par couleur
			for (int i = 0; i < p.getNbByColor(); i++)
			{
				cards.add(new ProgressCard(ColorCode.BLUE, p));
				cards.add(new ProgressCard(ColorCode.YELLOW, p));
				cards.add(new ProgressCard(ColorCode.RED, p));
				cards.add(new ProgressCard(ColorCode.GREEN, p));
				cards.add(new ProgressCard(ColorCode.MAGENTA, p));
			}
			
			// On récupère le nombre de carte neutre
			for (int i = 0; i < p.getNbNeutral(); i++)
				cards.add(new ProgressCard(ColorCode.WHITE, p));
		}
	}

	/**
	 * Permet de distribuer les cartes aux joueurs
	 * 
	 * @param players Joueurs de la partie
	 */
	public void distributeCards(List<Player> players)
	{
		int rand = (int)(Math.random() * 2); // Nombre aléatoire entre 0 et 1 pour choisir la technique de mélange
		
		// Si c'est 0, on fait le mélange en pile
		if (rand == 0)
		{
			cards = new PileShuffle().shuffling(cards); // On redéfinie les cartes avec la fonction de mélange. cf. PileShuffle.java
			
			Log.print("  >> Technique de mélange utilisee: Pile\n"); // On affiche dans les logs le mélange utilisé
		}
		// Si c'est 1, on fait le mélange riffle
		else
		{
			cards = new RiffleShuffle().shuffling(cards); // On redéfinie les cartes avec la fonction de mélange. cf. RiffleShuffle.java
			
			Log.print("  >> Technique de mélange utilisee: Riffle\n"); // On affiche dans les logs le mélange utilisé
		}
		
		// On donne 5 cartes aux 5 joueurs, on donne donc 25 carte
		for (int i = 0; i < 25; i++)
		{
			players.get(i % 5).getCards().add(cards.get(i)); // On distribue les cartes 1 par 1
			
			cards.set(i, null); // On change la case dans la paquet par du vide
		}
		
		List<Card> newPacket = new ArrayList<Card>(); // Nouveau paquet de carte près distribution
		
		// On transfert les cartes
		for (int i = 0; i < cards.size() - 25; i++)
			newPacket.add(i, cards.get(25 + i));
		
		cards.clear(); // On vide l'ancienne liste de carte
		cards.addAll(newPacket); // On met la nouvelle liste dans l'ancienne
	}
	
	/**
	 * Permet d'initialiser les tuites
	 */
	public void initTile()
	{
		tiles.add(new Card(ColorCode.BLUE));
		tiles.add(new Card(ColorCode.YELLOW));
		tiles.add(new Card(ColorCode.RED));
		tiles.add(new Card(ColorCode.GREEN));
		tiles.add(new Card(ColorCode.MAGENTA));
	}
	
	/**
	 * Permet de distribuer les tuilles aléatoirement aux joueurs de la parties
	 * 
	 * @param players Joueur de la partie
	 */
	public void distributeTile(List<Player> players)
	{
		// On parcours tous les jouers
		for (Player p : players)
		{
			Card tile = null;
			int i;
			
			do
			{
				i    = 0 + (int)(Math.random() * ((4 - 0) + 1)); // On prend un chiffre aléatoire entre 0 et 4
				tile = tiles.get(i); // On prend ce qui se trouve dans cette case
			}
			while (tile == null); // Tant que la tuille est `null` on pioche (il peut y avoir des tuilles `null` car on les enlèves après les avoir piochées
			
			p.setTile(tile); // On donne la tuille au joueur
			tiles.set(i, null); // On la remplace par `null` dans le paquet
		}
	}

	/**
	 * Permet de récupérer la liste de cartes du paquet
	 * 
	 * @return Les cartes du paquet
	 */
	public List<Card> getCards()
	{
		return cards;
	}

	/**
	 * Permet de modifier les cartes du paquet
	 * 
	 * @param cards Nouvelle liste de cartes
	 */
	public void setCards(List<Card> cards) 
	{
		this.cards = cards;
	}

	/**
	 * Permet de récupérer la liste de tuilles du paquet
	 * 
	 * @return Les tuilles du paquet
	 */
	public List<Card> getTiles()
	{
		return tiles;
	}

	/**
	 * Permet de modifier les tuilles du paquet
	 * 
	 * @param tiles Nouvelle liste de tuilles
	 */
	public void setTiles(List<Card> tiles)
	{
		this.tiles = tiles;
	}
	
}
