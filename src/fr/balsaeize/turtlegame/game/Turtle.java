package fr.balsaeize.turtlegame.game;

import fr.balsaeize.turtlegame.util.Color.ColorCode;

public class Turtle {

	private ColorCode color;
	
	public Turtle(ColorCode color)
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
