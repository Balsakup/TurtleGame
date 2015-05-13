package fr.balsaeize.turtlegame.game.card;

import fr.balsaeize.turtlegame.util.Color.ColorCode;

/**
 * Classe qui gère les cartes de progression
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class ProgressCard extends Card {
	
	/**
	 * Permet de gérer les différents type de carte de progression
	 * 
	 * @author Quentin CATHERINE et Axel ELAIN
	 * @version 1.0.0
	 */
	public enum ProgressType {
		
		PLUS_2(1, 0, "++"), // Les cartes ++
		PLUS(5, 5, "+"), // Les cartes +
		MINUS(2, 2, "-"), // Les cartes -
		FORWARD_2(0, 2, "->->"), // Les cartes ->->
		FORWARD(0, 3, "->"); // Les cartes ->
		
		/** Nombre de carte pour chaque couleur **/
		private final int nbByColor;
		/** Nombre de carte neutre **/
		private final int nbNeutral;
		/** Schéma de la carte (++, +, -, ->->, ->) **/
		private final String schema;
		
		private ProgressType(int nbByColor, int nbNeutral, String schema)
		{
			this.nbByColor = nbByColor;
			this.nbNeutral = nbNeutral;
			this.schema    = schema;
		}
		
		/**
		 * Permet de récupérer le nombre de carte pour chaque couleur
		 * 
		 * @return Nombre de carte par couleur
		 */
		public int getNbByColor()
		{
			return nbByColor;
		}
		
		/**
		 * Permet de récupérer le nombre de carte neutre
		 * 
		 * @return Nombre de carte neutre
		 */
		public int getNbNeutral()
		{
			return nbNeutral;
		}
		
		/**
		 * Permet de récupérer le schéma de la carte
		 * 
		 * @return Schéma de la carte
		 */
		public String getSchema()
		{
			return schema;
		}
		
		@Override
		public String toString()
		{
			return "[" + name() + "] nbByColor: " + nbByColor + ", nbNeutral: " + nbNeutral;
		}
		
	}
	
	/** Type de la carte de progression. cf. ProgressType **/
	private ProgressType type;
	
	/**
	 * Permet de créer une carte de progression
	 * 
	 * @param color Couleur de la carte
	 * @param type Type de la carte
	 */
	public ProgressCard(ColorCode color, ProgressType type)
	{
		super(color);
		
		this.type = type;
	}
	
	@Override
	public String toString()
	{
		return "[" + type.name() + "] " + super.getColor().name();
	}

	/**
	 * Permet de récupérer le type de la carte
	 * 
	 * @return Type de la carte
	 */
	public ProgressType getType()
	{
		return type;
	}

	/**
	 * Permet de changer le type de la carte
	 * 
	 * @param type Nouveau type de la carte
	 */
	public void setType(ProgressType type)
	{
		this.type = type;
	}

}
