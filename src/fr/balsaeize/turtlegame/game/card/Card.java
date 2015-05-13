package fr.balsaeize.turtlegame.game.card;

import fr.balsaeize.turtlegame.util.Color.ColorCode;

/**
 * Classe qui gère les cartes
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class Card {
	
	/**  Couleur de la carte **/
	private ColorCode color;
	
	/**
	 * Permet de créer une carte
	 * 
	 * @param color Couleur de la carte
	 */
	public Card(ColorCode color)
	{
		this.color = color;
	}

	/**
	 * Permet de récupérer la couleur de la carte
	 * 
	 * @return Couleur de la carte
	 */
	public ColorCode getColor()
	{
		return color;
	}

	/**
	 * Permet de changer la couleur de la carte
	 * 
	 * @param color Nouvelle couleur de la carte
	 */
	public void setColor(ColorCode color)
	{
		this.color = color;
	}
	
}
