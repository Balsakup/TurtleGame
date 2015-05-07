package fr.balsaeize.turtlegame.game.card;

import fr.balsaeize.turtlegame.util.Color.ColorCode;

public class ProgressCard extends Card {
	
	public enum ProgressType {
		
		PLUS_2(1, 0),
		PLUS(5, 5),
		MINUS(2, 2),
		FORWARD_2(0, 2),
		FORWARD(0, 3);
		
		private final int nbByColor;
		private final int nbNeutral;
		
		private ProgressType(int nbByColor, int nbNeutral)
		{
			this.nbByColor = nbByColor;
			this.nbNeutral = nbNeutral;
		}
		
		public int getNbByColor()
		{
			return nbByColor;
		}
		
		public int getNbNeutral()
		{
			return nbNeutral;
		}
		
		@Override
		public String toString()
		{
			return "[" + name() + "] nbByColor: " + nbByColor + ", nbNeutral: " + nbNeutral;
		}
		
	}
	
	private ProgressType type;

	public ProgressCard(ColorCode color)
	{
		super(color);
		
		type = null;
	}
	
	public ProgressCard(ColorCode color, ProgressType type)
	{
		super(color);
		
		this.setType(type);
	}

	public ProgressType getType()
	{
		return type;
	}

	public void setType(ProgressType type)
	{
		this.type = type;
	}

}
