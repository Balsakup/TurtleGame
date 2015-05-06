package fr.balsaeize.turtlegame.gui.cmd;

import java.util.Scanner;

import fr.balsaeize.turtlegame.gui.InterfaceGUI;
import fr.balsaeize.turtlegame.util.Executor;
import fr.balsaeize.turtlegame.util.Executor.Command;

public class MenuGUI implements InterfaceGUI {
	
	private String[] menu;

	@Override
	public void init()
	{
		menu = new String[2];
		
		StringBuilder mainMenu = new StringBuilder();
		
		mainMenu.append("---------- MODE DE JEU ----------\n")
				.append("1. Regarder l'ordinateur jouer   \n")
				.append("2. Jouer avec les ordinateurs    \n")
				.append("-----------------------------------");
		
		StringBuilder pcMenu = new StringBuilder();
		
		pcMenu.append("------------------------- MODE ORDINATEUR -------------------------\n")
			  .append("Commenbien de joueur voulez-vous voir jouer ? (2, 3, 4 ou 5) ");
		
		menu[0] = mainMenu.toString();
		menu[1] = pcMenu.toString();
	}

	@Override
	public void render()
	{
		System.out.println(menu[0]);
		
		Scanner sc = new Scanner(System.in);
		String line = null;
		int option = -1;
		
		while ((line = sc.nextLine()) != null)
		{
			try
			{
				option = Integer.parseInt(line);
				
				if (option == 1 || option == 2)
				{
					Executor.executeCommand(Command.CLEAR_CONSOLE);
					
					System.out.println(menu[1]);
				}
				else
				{
					Executor.executeCommand(Command.CLEAR_CONSOLE);
					
					System.out.println(menu[0]);
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
				
				System.out.println("Vous devez préciser un chiffre.");
			}
		}
		
		sc.close();
	}

	public String[] getMenu()
	{
		return menu;
	}

	public void setMenu(String[] menu)
	{
		this.menu = menu;
	}

}
