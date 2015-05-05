package fr.balsaeize.turtlegame.gui.cmd;

import fr.balsaeize.turtlegame.gui.InterfaceGUI;

public class SplashGUI implements InterfaceGUI {

	private StringBuilder logo;
	
	@Override
	public void init()
	{
		logo = new StringBuilder();
		
		logo.append(" ____        _           _____ _         \n")
			.append("| __ )  __ _| |___  __ _| ____(_)_______ \n")
			.append("|  _ \\ / _` | / __|/ _` |  _| | |_  / _ \\\n")
			.append("| |_) | (_| | \\__ \\ (_| | |___| |/ /  __/\n")
			.append("|____/ \\__,_|_|___/\\__,_|_____|_/___\\___|\n")
			.append("                           Entertainement");
	}

	@Override
	public void render()
	{
		System.out.println(logo.toString());
	}

	public StringBuilder getLogo()
	{
		return logo;
	}

	public void setLogo(StringBuilder logo)
	{
		this.logo = logo;
	}

}
