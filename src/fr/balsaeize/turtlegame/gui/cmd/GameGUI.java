package fr.balsaeize.turtlegame.gui.cmd;

import java.util.Scanner;

import fr.balsaeize.turtlegame.game.Game;
import fr.balsaeize.turtlegame.gui.InterfaceGUI;
import fr.balsaeize.turtlegame.util.Color;
import fr.balsaeize.turtlegame.util.Color.ColorCode;

/**
 * Permet d'affichier l'interface homme/machine de la partie en cours sous format console
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class GameGUI implements InterfaceGUI {
	
	private final Game game;
	private StringBuilder gui;
	private String[] turtle;
	
	public GameGUI(Game game)
	{
		this.game = game;
		
		init();
		render();
		
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext())
			System.out.println(sc.next());
		
		System.out.println();
	}

	@Override
	public void init()
	{
		gui = new StringBuilder();
		turtle = new String[3];
		
		turtle[0] = "  .-./*)";
		turtle[1] = "_/___\\/ ";
		turtle[2] = "  U U   ";
		
		gui.append("G |                                                                " + new Color(ColorCode.RED, false).getColorCode() + turtle[0] + Color.reset() + "        | E\n")
		   .append("O |----------------------------------------------------------------" + new Color(ColorCode.RED, false).getColorCode() + turtle[1] + Color.reset() + "--------| N\n")
		   .append("! |                                                                " + new Color(ColorCode.RED, false).getColorCode() + turtle[2] + Color.reset() + "        | D\n")
		   .append("\n")
		   .append("G |                                                                " + new Color(ColorCode.BLUE, false).getColorCode() + turtle[0] + Color.reset() + "        | E\n")
		   .append("O |----------------------------------------------------------------" + new Color(ColorCode.BLUE, false).getColorCode() + turtle[1] + Color.reset() + "--------| N\n")
		   .append("! |                                                                " + new Color(ColorCode.BLUE, false).getColorCode() + turtle[2] + Color.reset() + "        | D\n")
		   .append("\n")
		   .append("G |                                                                " + new Color(ColorCode.GREEN, false).getColorCode() + turtle[0] + Color.reset() + "        | E\n")
		   .append("O |----------------------------------------------------------------" + new Color(ColorCode.GREEN, false).getColorCode() + turtle[1] + Color.reset() + "--------| N\n")
		   .append("! |                                                                " + new Color(ColorCode.GREEN, false).getColorCode() + turtle[2] + Color.reset() + "        | D\n")
		   .append("\n")
		   .append("G |                                                " + new Color(ColorCode.YELLOW, false).getColorCode() + turtle[0] + Color.reset() + "                        | E\n")
		   .append("O |------------------------------------------------" + new Color(ColorCode.YELLOW, false).getColorCode() + turtle[1] + Color.reset() + "------------------------| N\n")
		   .append("! |                                                " + new Color(ColorCode.YELLOW, false).getColorCode() + turtle[2] + Color.reset() + "                        | D\n")
		   .append("\n")
		   .append("G |                        " + new Color(ColorCode.MAGENTA, false).getColorCode() + turtle[0] + Color.reset() + "                                                | E\n")
		   .append("O |------------------------" + new Color(ColorCode.MAGENTA, false).getColorCode() + turtle[1] + Color.reset() + "------------------------------------------------| N\n")
		   .append("! |                        " + new Color(ColorCode.MAGENTA, false).getColorCode() + turtle[2] + Color.reset() + "                                                | D\n")
		   .append("\n")
		   .append("  >>" + new Color(ColorCode.YELLOW, true).getColorCode() + "  C'est au tour de Balsakup de jouer  " + Color.reset() + "\n")
		   .append("  >>  Ses cartes: ")
		   .append(new Color(ColorCode.YELLOW, false).getColorCode() + "[++]" + Color.reset() + "(1)  ")
		   .append(new Color(ColorCode.GREEN, false).getColorCode() + "[-]" + Color.reset() + "(2)  ")
		   .append(new Color(ColorCode.RED, false).getColorCode() + "[->]" + Color.reset() + "(3)  ")
		   .append(new Color(ColorCode.BLUE, false).getColorCode() + "[->->]" + Color.reset() + "(4)  ")
		   .append(new Color(ColorCode.WHITE, false).getColorCode() + "[--]" + Color.reset() + "(5)  ")
		   .append("\n\n")
		   .append("  >>  " + new Color(ColorCode.GREEN, false).getColorCode() + "Quelle carte voulez-vous jouer ? (Entrez le num�ro de la carte) " + Color.reset());
	}
	
	@Override
	public void render()
	{
		System.out.print(gui.toString());
	}
	
	public Game getGame()
	{
		return game;
	}

	public StringBuilder getGui()
	{
		return gui;
	}

	public void setGui(StringBuilder gui)
	{
		this.gui = gui;
	}

	public String[] getTurtle()
	{
		return turtle;
	}

	public void setTurtle(String[] turtle)
	{
		this.turtle = turtle;
	}

}
