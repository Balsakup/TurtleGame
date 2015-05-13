package fr.balsaeize.turtlegame.game.shuffle;

import java.util.List;

import fr.balsaeize.turtlegame.game.card.Card;

/**
 * Classe qui permet de donner le squelette aux classes de mélange
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public interface InterfaceShuffle {

	/**
	 * Permet d'effectuer le mélange
	 * 
	 * @param cards Liste des cartes à mélanger
	 * @return Liste de cartes mélangées
	 */
	public List<Card> shuffling(List<Card> cards);
	
}
