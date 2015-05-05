package fr.balsaeize.turtlegame.test;

import java.util.ArrayList;
import java.util.List;

import fr.balsaeize.turtlegame.game.Game;
import fr.balsaeize.turtlegame.game.Player;

/**
 * Permet d'effectuer des testes sur la classe Player
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class PlayerTest {

	public PlayerTest()
	{
		List<Player> players = new ArrayList<Player>();	
		
		players.add(new Player("Balsakup", 19));
		players.add(new Player("BalsaGirl", 18));
		players.add(new Player("MrAEize", 20));
		players.add(new Player("Benjamin", 10));
		
		Game game = new Game(players);
		
		System.out.println(game.getCurrentPlayer().getName());
	}
	
}
