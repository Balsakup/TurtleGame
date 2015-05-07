package fr.balsaeize.turtlegame.game;

/**
 * Classe qui g�re les joueurs, elle permet de cr�er les joueurs
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class Player {

	/** Nom du joueur **/
	private String name;
	/** Age du joueur **/
	private int age;
	/** Sa tortue **/
	private Turtle turtle;
	
	/**
	 * Permet de cr�er un nouveau joueur
	 * 
	 * @param name Nom du joueur
	 * @param age Age du joueur
	 */
	public Player(String name, int age)
	{
		this.name = name;
		this.age  = age;
	}

	/**
	 * Permet de r�cup�rer le nom du joueur
	 * 
	 * @return Nom du joueur
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Permet de changer le nom du joueur
	 * 
	 * @param name Nouveau nom du joueur
	 */
	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Permet de r�cup�rer l'�ge du joueur
	 * 
	 * @return Age du joueur
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * Permet de changer l'age du joueur
	 * 
	 * @param age Age du joueur
	 */
	public void setAge(int age)
	{
		this.age = age;
	}

	public Turtle getTurtle()
	{
		return turtle;
	}

	public void setTurtle(Turtle turtle)
	{
		this.turtle = turtle;
	}
	
}
