package fr.balsaeize.turtlegame.game.shuffle;

import java.util.List;

import fr.balsaeize.turtlegame.game.card.Card;

/**
 * Classe qui gère le mélange en pile
 * Le mélange en pile conciste à faire plusieurs pile de carte et des les rassembler après
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class PileShuffle implements InterfaceShuffle {

	@Override
	public List<Card> shuffling(List<Card> cards)
	{				
		int nbDivisor  = 0; // Nombre de diviseurs pour le nombre de carte
		
		// On parcours tous les nombres de 2 à n / 2 + 1
		for (int i = 2; i < cards.size() / 2 + 1; i++)
		{
			if (cards.size() % i == 0) // Si c'est égale à 0 alors c'est un diviseur
				nbDivisor++; // On ajoute 1 au nombre de diviseur
		}
		
		int j          = 0; // Va nous permettre de stocker les diviseurs dans un tableau
		int[] dividers = new int[nbDivisor]; // Tableau des diviseurs
		
		// On parcours tous les nombres de 2 à n / 2 + 1
		for (int i = 2; i < cards.size() / 2 + 1; i++)
		{
			if (cards.size() % i == 0) // Si c'est égale à 0 alors c'est un diviseur
			{
				dividers[j] = i;  // On ajoute le diviseur dans la tableau
				
				j++; // On rajoute 1 à l'indice
			}
		}
		
		// On réaliser le mélange entre 10 et 100 fois, pour être sûr que ça soit bien mélangé
		for (int m = 0; m < 10 + (int)(Math.random() * ((100 - 10) + 1)); m++)
		{
			// On fait un choix de diviseur (On utilisa jamais le même diviseur pour le mélange)
			int choice     = dividers[0 + (int)(Math.random() * ((nbDivisor - 1) + 1))];
			// On fait un tableau 2D pour accueillir les piles
			Card[][] piles = new Card[choice][cards.size() / choice];
			
			j = 0;
			
			// On met les cartes dans les tableaux (Les piles)
			for (int i = 0; i < cards.size() / choice; i++)
			{
				for (int k = 0; k < choice; k++)
				{
					piles[k][i] = cards.get(j);
					
					j++;
				}
			}
			
			j = 0;
			
			// Puis on remet les cartes dans la liste des cartes
			for (int i = 0; i < choice; i++)
			{
				for (int k = 0; k < cards.size() / choice; k++)
				{
					cards.set(j, piles[i][k]);
					
					j++;
				}
			}
		}
		
		return cards; // On retourne notre liste de carte
	}

}
