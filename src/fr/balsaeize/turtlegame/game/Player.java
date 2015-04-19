package fr.balsaeize.turtlegame.game;

/**
 * Classe qui gère les joueurs, elle permet de créer les joueurs
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class Player {

	/** Nom du joueur **/
	private String name;
	/** Age du joueur **/
	private int age;
	
	/**
	 * Permet de créer un nouveau joueur
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
	 * Permet de récupérer le nom du joueur
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
	 * Permet de récupérer l'âge du joueur
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
	
}
