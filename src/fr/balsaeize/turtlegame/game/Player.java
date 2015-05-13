package fr.balsaeize.turtlegame.game;

import java.util.ArrayList;
import java.util.List;

import fr.balsaeize.turtlegame.game.card.Card;

/**
 * Classe qui gère les joueurs, elle permet de créer les joueurs
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class Player {

	/** Nom du joueur **/
	private String name;
	/** Age du joueur **/
	private int age;
	/** Couleur du joueur **/
	private Card tile;
	/** Cartes du joueur **/
	private List<Card> cards;
	
	/**
	 * Permet de cr�er un nouveau joueur
	 * 
	 * @param name Nom du joueur
	 * @param age Age du joueur
	 */
	public Player(String name, int age)
	{
		this.name = name;
		this.age  = age;
		cards     = new ArrayList<Card>();
	}

	/**
	 * Permet de r�cup�rer le nom du joueur
	 * 
	 * @return Nom du joueur
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Permet de changer le nom du joueur
	 * 
	 * @param name Nouveau nom du joueur
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Permet de r�cup�rer l'�ge du joueur
	 * 
	 * @return Age du joueur
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * Permet de changer l'age du joueur
	 * 
	 * @param age Age du joueur
	 */
	public void setAge(int age)
	{
		this.age = age;
	}

	/**
	 * Permet de récupérer la tuille du joueur
	 * 
	 * @return Tuille du joueur
	 */
	public Card getTile()
	{
		return tile;
	}

	/**
	 * Permet de changer la tuille du joueur
	 * 
	 * @param tile Nouvelle tuile du joueur
	 */
	public void setTile(Card tile)
	{
		this.tile = tile;
	}

	/**
	 * Permet de récupérer les cartes du joueurs
	 * 
	 * @return Cartes du joueur
	 */
	public List<Card> getCards()
	{
		return cards;
	}

	/**
	 * Permet de changer les cartes du joueurs
	 * 
	 * @param cards Nouvelles carte du joueur
	 */
	public void setCards(List<Card> cards)
	{
		this.cards = cards;
	}
	
}
