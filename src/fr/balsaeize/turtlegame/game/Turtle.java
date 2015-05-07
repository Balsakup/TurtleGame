package fr.balsaeize.turtlegame.game;

import fr.balsaeize.turtlegame.util.Color.ColorCode;

public class Turtle {

	private ColorCode color;
	private Turtle mount;
	private Turtle rider;
	
	public Turtle(ColorCode color)
	{
		this.color = color;
		mount = null;
		rider = null;
	}

	public ColorCode getColor()
	{
		return color;
	}

	public void setColor(ColorCode color)
	{
		this.color = color;
	}

	public Turtle getMount()
	{
		return mount;
	}

	public void setMount(Turtle mount)
	{
		this.mount = mount;
	}

	public Turtle getRider()
	{
		return rider;
	}

	public void setRider(Turtle rider)
	{
		this.rider = rider;
	}
	
}
