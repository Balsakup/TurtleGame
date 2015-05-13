package fr.balsaeize.turtlegame.game.shuffle;

import java.util.List;

import fr.balsaeize.turtlegame.game.card.Card;

/**
 * Classe qui gère le mélange riffle
 * Le mélange riffle conciste à séparer un paquet de carte en deux, se faire croiser les cartes de chaque paquet
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class RiffleShuffle implements InterfaceShuffle {

	@Override
	public List<Card> shuffling(List<Card> cards)
	{		
		// On réaliser le mélange entre 10 et 100 fois, pour être sûr que ça soit bien mélangé
		for (int l = 0; l < 10 + (int)(Math.random() * ((100 - 10) + 1)); l++)
		{
			int min       = cards.size() / 4; // Indice mini pour la première moitié
			int max       = cards.size() / 2; // Indice maxi pour la premi!re moitié
			int separator = min + (int)(Math.random() * ((max - min) + 1)); // On sélection en indice en mini et maxi
			Card[] start  = new Card[separator]; // La première moitié de cartes
			Card[] end    = new Card[cards.size() - separator]; // La seconde moitié de cartes
			
			// On fait la première moitié de carte
			for (int i = 0; i < start.length; i++)
				start[i] = cards.get(i);
			
			// On fait la seconde moitié de carte
			for (int i = 0; i < end.length; i++)
				end[i] = cards.get(start.length + i);
			
			int j = 0;
			int k = 0;
			
			// Puis on remet les cartes dans la liste les unes après les autres en alternant de moitié de paquet
			for (int i = 0; i < start.length * 2; i++)
			{
				if (i % 2 == 0)
				{
					cards.set(i, start[j]);
					
					j++;
				}
				else
				{
					cards.set(i, end[k]);
					
					k++;
				}
			}
		}
		
		return cards; // On retourne le paquet mélangé
	
	}

}
