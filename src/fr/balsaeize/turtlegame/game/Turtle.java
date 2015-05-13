package fr.balsaeize.turtlegame.game;

import java.util.ArrayList;
import java.util.List;

import fr.balsaeize.turtlegame.game.card.Card;
import fr.balsaeize.turtlegame.game.card.ProgressCard;
import fr.balsaeize.turtlegame.game.card.ProgressCard.ProgressType;
import fr.balsaeize.turtlegame.util.Color.ColorCode;

/**
 * Classe qui gère les tortues
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class Turtle {

	/** Couleur de la tortue **/
	private ColorCode color;
	/** Monture de la tortue **/
	private Turtle mount;
	/** Cavalier de la tortue **/
	private Turtle rider;
	
	/**
	 * Constructeur d'une tortue
	 * 
	 * @param color Couleur de la tortue
	 */
	public Turtle(ColorCode color)
	{
		this.color = color;
		mount      = null;
		rider      = null;
	}
	
	/**
	 * Permet de déplacer une tortue
	 * 
	 * @param platform La liste dans laquelle se trouve la tortue
	 * @param card La carte jouée
	 * @return Le nombre de case dont elle doit se déplacer
	 */
	private int getNewPos(List<Turtle> platform, ProgressCard card)
	{
		// Ou se situe la tortue
		int i = platform.indexOf(this);
		
		// Si la carte est ++
		if (card.getType().equals(ProgressType.PLUS_2))
		{
			// Si la tortue est en position 7 dans le tableau
			if (i == 7)
			{
				Game.isFinish = true; // Un ++ lui donnera la victoire
				
				return 2; // On retourne quand même 2 pour l'affichage
			}
			else
			// Si la tortue est en position 8 dans le tableau
			if (i > 7)
			{
				Game.isFinish = true; // Un ++ lui donnera la victoire
				
				return 1; // On retourne 1 car il lui faut une case pour arriver à l'arrivée
			}
			// Sinon on retourne 2
			else
				return 2;
		}
		else
		// Si la carte est +
		if (card.getType().equals(ProgressType.PLUS))
		{
			// Si la tortue est en position 8 dans la tableau
			if (i == 8)
			{
				Game.isFinish = true; // Un + lui donnera la victoire
				
				return 1; // On retourne quand même 1 pour l'affichage
			}
			// Sinon on retourne 1
			else
				return 1;
		}
		else
		// Si la carte est -
		if (card.getType().equals(ProgressType.MINUS))
		{
			// On la fait reculer seulement si elle peut reculer
			if (i >= 1)
				return -1;
		}
		else
		// Si la carte est ->->
		if (card.getType().equals(ProgressType.FORWARD_2))
		{
			// Si la tortue est en position 7 dans le tableau
			if (i == 7)
			{
				Game.isFinish = true; // Un ++ lui donnera la victoire
							
				return 2; // On retourne quand même 2 pour l'affichage
			}
			else
			// Si la tortue est en position 8 dans le tableau
			if (i > 7)
			{
				Game.isFinish = true; // Un ++ lui donnera la victoire
							
				return 1; // On retourne 1 car il lui faut une case pour arriver à l'arrivée
			}
			// Sinon on retourne 2
			else
				return 2;
		}
		else
		// Si la carte est un ->
		if (card.getType().equals(ProgressType.FORWARD))
		{
			// Si la tortue est en position 8 dans la tableau
			if (i == 8)
			{
				Game.isFinish = true; // Un + lui donnera la victoire
							
				return 1; // On retourne quand même 1 pour l'affichage
			}
			// Sinon on retourne 1
			else
				return 1;
		}
		
		// Par défaut on retourne 0
		return 0;
	}
	
	/**
	 * Permet de déplacer la tortue
	 * 
	 * @param platform Plateau du jeu
	 * @param i Index de la liste ou se situe la tortue
	 * @param card Carte de déplacement
	 */
	public void move(ArrayList<ArrayList<Turtle>> platform, int i, Card card)
	{
		int pos        = platform.get(i).indexOf(this); // On récupère sa position
		int newPos     = pos + getNewPos(platform.get(i), (ProgressCard) card); // On calcule sa nouvelle position en fonction de la case jouée
		
		platform.get(i).set(pos, null); // On met à `null` sa position actuelle
		platform.get(i).set(newPos, this); // On la position sur la nouvelle position
		
		if (((ProgressCard)card).getType().equals(ProgressType.MINUS))
		{
			if (mount != null)
				mount.setRider(null);
			
			if (rider != null)
				rider.setMount(null);
			
			mount = null;
			rider = null;
			
			for (int j = 0; j < platform.size(); j++)
			{
				Turtle t = platform.get(j).get(newPos);
				
				if (j != newPos && t != null)
				{
					mount = t;
					t.setRider(this);
				}
			}
		}
		else
		{
			Turtle r = rider;
			int saf  = 0;
			
			while (r != null && saf <= 5)
			{
				for (int j = 0; j < platform.size(); j++)
				{
					if (j != pos && platform.get(j).contains(r))
					{
						int pos2 = platform.get(j).indexOf(r);
						
						platform.get(j).set(pos2, null); // On met à `null` sa position actuelle
						platform.get(j).set(newPos, r); // On la position sur la nouvelle position
					}
				}

				Turtle tmp = r;
				r = r.getRider();
				tmp.setRider(null);
				tmp.setMount(null);
				saf++;
			}
		}
		
		mount = null;
		rider = null;
	}

	/**
	 * Permet de récupérer la couleur d'une tortue
	 * 
	 * @return Couleur de la tortue
	 */
	public ColorCode getColor()
	{
		return color;
	}

	/**
	 * Permet de changer la couleur de la tortue
	 * 
	 * @param color Nouvelle couleur de la torture
	 */
	public void setColor(ColorCode color)
	{
		this.color = color;
	}

	/**
	 * Permet de récupérer la monture de la tortue
	 * 
	 * @return Monture de la tortue
	 */
	public Turtle getMount()
	{
		return mount;
	}

	/**
	 * Permet de changer la monture de la tortue
	 * 
	 * @param mount Nouvelle monture de la tortue
	 */
	public void setMount(Turtle mount)
	{
		this.mount = mount;
	}

	/**
	 * Permet de récupérer le cavalier de la tortue
	 * 
	 * @return Cavalier de la tortue
	 */
	public Turtle getRider()
	{
		return rider;
	}

	/**
	 * Permet de changer la cavalier de la tortue
	 * 
	 * @param rider Nouveau cavalier de la tortue
	 */
	public void setRider(Turtle rider)
	{
		this.rider = rider;
	}
	
}
