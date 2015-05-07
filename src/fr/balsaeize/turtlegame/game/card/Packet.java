package fr.balsaeize.turtlegame.game.card;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import fr.balsaeize.turtlegame.game.Player;
import fr.balsaeize.turtlegame.util.Color.ColorCode;

public class Packet {
	
	private List<Card> cards;
	private List<Card> tiles;

	public Packet()
	{
		setCards(new LinkedList<Card>());
		setTiles(new ArrayList<Card>());
	}
	
	public void initTile()
	{
		tiles.add(new Card(ColorCode.BLUE));
		tiles.add(new Card(ColorCode.YELLOW));
		tiles.add(new Card(ColorCode.RED));
		tiles.add(new Card(ColorCode.GREEN));
		tiles.add(new Card(ColorCode.MAGENTA));
	}
	
	public void distributeTile(List<Player> players)
	{
		for (Player p : players)
		{
			Card tile = null;
			int i;
			
			do
			{
				i    = 0 + (int)(Math.random() * ((4 - 0) + 1));
				tile = tiles.get(i);
			}
			while (tile == null);
			
			p.setTile(tile);
			tiles.set(i, null);
		}
	}

	public List<Card> getCards()
	{
		return cards;
	}

	public void setCards(List<Card> cards) 
	{
		this.cards = cards;
	}

	public List<Card> getTiles()
	{
		return tiles;
	}

	public void setTiles(List<Card> tiles)
	{
		this.tiles = tiles;
	}
	
}
