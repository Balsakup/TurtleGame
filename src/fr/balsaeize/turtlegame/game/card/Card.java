package fr.balsaeize.turtlegame.game.card;

import fr.balsaeize.turtlegame.util.Color.ColorCode;

public class Card {
	
	private ColorCode color;
	
	public Card(ColorCode color)
	{
		this.color = color;
	}

	public ColorCode getColor()
	{
		return color;
	}

	public void setColor(ColorCode color)
	{
		this.color = color;
	}
	
}
