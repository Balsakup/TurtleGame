package fr.balsaeize.turtlegame;

import java.util.ArrayList;
import java.util.List;

import fr.balsaeize.turtlegame.game.Game;
import fr.balsaeize.turtlegame.game.Player;
import fr.balsaeize.turtlegame.game.card.Packet;

/**
 * Classe principale du jeu, c'est ici que se trouve la m�thode principale
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class TurtleGame {
	
	/** Nom du syst�me d'exploitation **/
	public static String osName;
	
	/**
	 * Constructeur du jeu
	 */
	public TurtleGame()
	{
		osName = System.getProperty("os.name").toLowerCase();
		
		/*SplashGUI splash = new SplashGUI();
		
		splash.init();
		splash.render();
		
		MenuGUI menu = new MenuGUI();
		
		menu.init();
		menu.render();*/
		
		List<Player> players = new ArrayList<Player>();	
		
		players.add(new Player("Balsakup", 19));
		players.add(new Player("BalsaGirl", 18));
		players.add(new Player("MrAEize", 20));
		players.add(new Player("Benjamin", 10));
		
		Game game = new Game(players);
		game.initGame();
	}

	/**
	 * M�thode principale du jeu
	 * 
	 * @param args Arguments pass�s en param�tre � l'ex�cution du jeu
	 */
	public static void main(String[] args)
	{				
		/** TODO: Ajouter `equals` et `toString` **/
		
List<Player> players = new ArrayList<Player>();	
		
		players.add(new Player("Balsakup", 19));
		players.add(new Player("BalsaGirl", 18));
		players.add(new Player("MrAEize", 20));
		players.add(new Player("Benjamin", 10));
		players.add(new Player("Yolo", 99));
		
		Packet packet = new Packet();
		
		packet.initTile();
		packet.distributeTile(players);
		
		//new TurtleGame();
	}

}
