package fr.balsaeize.turtlegame.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.balsaeize.turtlegame.game.card.Card;
import fr.balsaeize.turtlegame.game.card.Packet;
import fr.balsaeize.turtlegame.game.card.ProgressCard;
import fr.balsaeize.turtlegame.gui.cmd.GameGUI;
import fr.balsaeize.turtlegame.util.Color;
import fr.balsaeize.turtlegame.util.Color.ColorCode;
import fr.balsaeize.turtlegame.util.Executor;
import fr.balsaeize.turtlegame.util.Executor.Command;
import fr.balsaeize.turtlegame.util.Log;
import fr.balsaeize.turtlegame.util.Randomizer;
import fr.balsaeize.turtlegame.util.Util;

/**
 * Classe qui gère le déroulement du jeu
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class Game {
	
	/** Liste des joueurs qui participent au jeu **/
	private List<Player> players;
	/** Joueur courant. Celui qui doit joueur **/
	private Player currentPlayer;
	/** Plateau du jeu sous forme de liste **/
	private ArrayList<ArrayList<Turtle>> platform;
	/** Paquet de carte du jeu **/
	private Packet packet;
	/** Etat du jeu **/
	public static boolean isFinish = false;

	/**
	 * Permet de créer une nouvelle partie de jeu
	 */
	public Game()
	{
		players  = new ArrayList<Player>(); // Création de la liste des joueurs
		platform = new ArrayList<ArrayList<Turtle>>(); // Création du plateau de jeu
		packet   = new Packet(); // Création des paquets de carte (Cartes et tuilles)
	}
	
	/**
	 * Permet de récupérer le joueur le plus jeune parmis tous les joueurs
	 * 
	 * @return Le joueur le plus jeune
	 */
	public Player getYoungest()
	{
		int age         = 200;  // On suppose qu'il n'y aura pas de joueur de plus de 200 ans
		Player youngest = null; // Il n'y a pas de plus jeune au d�but
		
		// Pour tous les joueurs pr�sent
		for (Player p : players)
		{
			// Si l'age du joueur est inf�rieur � l'age du joueur le plus jeune (200 pa d�faut)
			if (p.getAge() < age)
			{
				age      = p.getAge(); // L'�ge devient celui du joueur le plus jeune
				youngest = p;          // On remplace le joueur le plus jeune  
			}
		}
		
		return youngest; // On retourne le plus jeune
	}
	
	/**
	 * Permet d'initialiser le jei
	 * 
	 * @param nbPlayer Nombre de joueur à render manuellement
	 */
	public void initGame(int nbPlayer)
	{
		Executor.executeCommand(Command.CLEAR_CONSOLE); // On nettoie la console
		
		System.out.println("  -------------------- DEBUT INITIALISATION --------------------\n"); // Affichage d'un titre
		System.out.println("  >> Vous avez choisi d'ajouter " + nbPlayer + " joueur" + ((nbPlayer > 1) ? "s" : "") + "\n"); // On affiche une information renseignent sur le nombre de joueur à ajouter manuellement
		
		// Boucle pour ajouter les joueurs manuellement
		for (int i = 0; i < nbPlayer; i++)
			addPlayer(); // cf. Fonction addPlayer()
		
		// Pour les joueurs qui reste, on laisse faire le Randomizer
		for (int i = 0; i < 5 - nbPlayer; i++)
			players.add(players.size(), Randomizer.getRandomPlayer()); // cf. Ramdomizer.getRandomPlayer()
		
		packet.initCard(); // On initialise le paquet de carte
		packet.initTile(); // On initialise le paquet de tuile
		
		packet.distributeTile(players); // On distribue les tuilles aux joueurs
		packet.distributeCards(players); // On distribue les cartes aux joueurs
		
		currentPlayer = getYoungest(); // Le joueur qui commence est le joueur le plus jeune
		
		// Il y a 5 joueurs, donc 5 lignes composées de 10 cases pour la plateau
		// Cette boucle permet de remplir toutes les cases de la matrice afin de minimiser les bugs
		for (int i = 0; i < 5; i++)
		{
			List<Turtle> list = new ArrayList<Turtle>(); // On initialise une liste tampon
			
			// Boucle permettant de remplir toutes les cases
			for (int j = 0; j < 10; j++)
				list.add(j, null); // On ajoute `null` pour signifier qu'il y a personne dans cette case
			
			platform.add(i, (ArrayList<Turtle>) list); // Puis on ajoute cette liste à la liste de liste (C'est assez compliqué à comprendre, mais ça fonctionne bien)
		}
		
		// Initialisation des 5 tortues et attribution des couleurs en fonction des joueurs (mais les couleurs restes aléatoires)
		Turtle t1 = new Turtle(players.get(0).getTile().getColor());
		Turtle t2 = new Turtle(players.get(1).getTile().getColor());
		Turtle t3 = new Turtle(players.get(2).getTile().getColor());
		Turtle t4 = new Turtle(players.get(3).getTile().getColor());
		Turtle t5 = new Turtle(players.get(4).getTile().getColor());
		
		// On définie qui est la monture de qui, et qui est le cavalier de qui
		t1.setRider(t2);
		t2.setRider(t3);
		t3.setRider(t4);
		t4.setRider(t5);
		t2.setMount(t1);
		t3.setMount(t2);
		t4.setMount(t3);
		t5.setMount(t4);
		
		// On place les tortues sur la première case du plateau
		// Une liste correspond à une tortue, cette tortue dispose ensuite d'une autre liste pour le déplacement
		platform.get(0).set(0, t1);
		platform.get(1).set(0, t2);
		platform.get(2).set(0, t3);
		platform.get(3).set(0, t4);
		platform.get(4).set(0, t5);
		
		System.out.println("  --------------------  FIN INITIALISATION  --------------------\n\n"); // Affichage d'infos
		
		/* 
		 * LOG: Ici ce sont les logs de l'initialisation du jeu. On liste dans un fichier les joueurs avec leur couleur, leurs cartes et leur age 
		 * cf. Logo.java
		 */
		Log.print("  >> Les joueurs inscrits sont :\n");
		Log.print(String.format("  %-20s %-5s %-10s %s\n", "Nom", "Age", "Couleur", "Cartes"));
		
		for (int i = 0; i < players.size(); i++)
		{
			StringBuilder log = new StringBuilder();
			
			log.append(String.format("  %-20s %-5s %-10s", players.get(i).getName(), players.get(i).getAge(), players.get(i).getTile().getColor().name()));
			
			for (Card c : players.get(i).getCards())
			{
				log.append(String.format(" %-10s %-10s;", ((ProgressCard)c).getType().name(), c.getColor().name()));
			}
			
			Log.print(log.toString() + "\n");
		}
		
		loopGame(); // Après l'initialisation, on lance la boucle du jeu
	}
	
	/**
	 * Permet de bon déroulement du jeu. C'est la boucle principale du jeu	 * 
	 */
	private void loopGame()
	{
		GameGUI gameGUI = new GameGUI(this); // On instancie l'interface graphique du jeu

		gameGUI.init(); // On initialise cette interface
		
		// Tant que le jeu n'est pas fini
		while (!isFinish)
		{	
			// On récupère une carte aléatoire dans la main du joueur (indice entre 0 et 4)
			Card card = currentPlayer.getCards().get((int)(Math.random() * (4 + 1)));
			
			// Si la couleur de la carte est blance (Carte neutre), on joue une tortue aléatoire
			if (card.getColor().equals(ColorCode.WHITE))
			{			
				int index       = (int)(Math.random() * (4 + 1)); // Indexe de la tortue à jouer
				boolean isFound = false; // Permet de dire si une tortue est trouvée ou pas (Cette variable efface certain bug inexpliquable)
				
				// On parcours la liste correspondant à l'indexe aléatoire pour trouver la tortue
				for (int i = 0; i < platform.get(index).size(); i++)
				{
					// La contenue de la case est différent de `null` et que la tortue n'est pas encore trouvée
					if (platform.get(index).get(i) != null && !isFound)
					{						
						Turtle turtle  = platform.get(index).get(i); // On stocke la tortue
						
						turtle.move(platform, index, card); // On déplace la tortue
						
						isFound = true; // On signale qu'on a trouvé la tortue
					}
				}
			}
			// Sinon, c'est que les cartes ont une couleur
			else
			{		
				boolean isFound = false; // Permet de dire si une tortue est trouvée ou pas (Cette variable efface certain bug inexpliquable)
				
				// Certe fois si on parcours toutes les cases pour chercher la tortue qui a la même couleur que la carte
				// Ici parcours de la liste de liste
				for (int i = 0; i < platform.size(); i++)
				{
					// Ici parcours de la liste de tortue
					for (int j = 0; j < platform.get(i).size(); j++)
					{
						// Si la case n'est pas `null` (Ca veut dire qu'il y a une tortue) alors
						if (platform.get(i).get(j) != null)
						{
							// On teste si la couleur de la tortue est bien de la même couleur que la carte et que la tortue n'a pas été encore trouvée
							if (card.getColor().equals(platform.get(i).get(j).getColor()) && !isFound)
							{																
								Turtle turtle  = platform.get(i).get(j); // On stocke la tortue
								
								turtle.move(platform, i, card); // On déplace la tortue
								
								isFound = true; // On signale qu'on a trouvé la tortue
							}
						}
					}
				}
			}
			
			currentPlayer.getCards().add(packet.getCards().get(0)); // On pioche la première carte du paquet pour la mettre dans la main du joueur
			packet.getCards().remove(0); // On supprimer cette carte du paquet
			currentPlayer.getCards().remove(card); // On supprimer la carte jouée du paquet du joueur
			packet.getCards().add(packet.getCards().size(), card); // On remet la carte jouée à la fin du paquet
			
			// On change le joueur courant. Si l'indice du joueur d'après est > 4, alors on retourne au début, sinon on prendre le joueur joueurCourrant++
			currentPlayer = (players.indexOf(currentPlayer) + 1 > 4) ? players.get(0) : players.get(players.indexOf(currentPlayer) + 1);
			
			Util.sleep(1000); // On attend 1 seconde pour bien voir le plateau
			
			gameGUI.render(); // On réaffiche la plateau pour voir les modifications
			
			// On indique la carte jouée
			System.out.println("  >> Carte jouée: " + new Color(card.getColor(), true).getColorCode() + "[" + ((ProgressCard)card).getType().getSchema() + "]" + Color.reset());
		}
		
		Turtle tWinner = null; // Tortue gagnante
		Player pWinner = null; // Joueur gagnant
		
		// On parcours la dernière case de chaque liste pour récupérer la tortue gagnante
		for (int i = 0; i < platform.size(); i++)
		{
			if (platform.get(i).get(9) != null) // Si la dernière case est différente de `null` (Tortue trouvée) alors
				tWinner = platform.get(i).get(9); // On dit que c'est elle la gagnante
		}
		
		// On parcours tous les joueurs pour trouver la gagnant
		for (Player p : players)
		{
			if (p.getTile().getColor().equals(tWinner.getColor())) // Si la couleur de la tuille du joueur est la même que la couleur de la tortue gagnante
				pWinner = p; // Alors c'est ce joueur qui a gagné
		}
		
		// On affiche le petit message disant le nom et la couleur du joueur gagnant
		System.out.println("\n\n  >> BRAVO ! La Gagnant est " + pWinner.getName() + " avec la tortue " + tWinner.getColor().name().toLowerCase());
	}
	
	/**
	 * Permet l'ajout manuel des joueurs
	 */
	@SuppressWarnings("resource")
	public void addPlayer()
	{
		Scanner sc     = new Scanner(System.in); // On initialise le scanner
		String line    = null; // On définie la variable pour stockers les entrées clavier
		String confirm = null; // Variable permettant la confirmation d'une entrée clavier
		String name    = null; // Nom du joueur à ajouter
		int age        = -1; // Age du joueur à ajouter
		
		Executor.executeCommand(Command.CLEAR_CONSOLE); // On nettoie la console
		
		System.out.println("  ---------- AJOUTER UN JOUEUR ----------"); // On affiche des infos
		
		// Tant que la ligne entrée est différente de `null
		while (line == null)
		{
			System.out.print("  >> Préciser le nom du joueur : "); // On demande le nom du joueur
			
			line = sc.nextLine(); // On récupérer l'entrée clavier
			
			do
			{
				System.out.print("  >> Vous avez choisi " + line + ", cela vous plait ? (Oui ou Non) "); // On demande une confirmation
				
				confirm = sc.nextLine(); // On récupère la confirmation
				
				// Parser pour la réponse
				switch (confirm.toLowerCase()) // On met en miniscule pour ne pas être sensible à la case
				{
					case "oui": continue; // Si c'est oui, on contine
					case "non": // Si c'est non, on met line à `null`pour continuer de boucler
						line = null;
						
						continue;
					default:
						confirm = null; // Si on ne capte rien, on redemande la confirmation
				}
			}
			while (confirm == null); // Tant que la confirmation n'est pas clair
		}
		
		name = line; // Le nom est égale à la ligne entrée
		line = null; // On remet la ligne à `null` pour l'étape de l'âge
		
		// Tant que la ligne entrée est différente de `null
		while (line == null)
		{
			System.out.print("  >> Préciser l'âge du joueur : "); // On demande l'âge du joueur
			
			line = sc.nextLine(); // On récupère l'âge du joueur
			
			try
			{
				age = Integer.parseInt(line); // On vérifie que le joueur entre bien un chiffre
			}
			catch (Exception e)
			{
				System.out.println("  >> Vous devez fournir un chiffre !"); // Sinon on lui dit
				
				line = null; // On remet à `null` pour reboucler
				
				continue;
			}
			
			// Si la personne à moins de 4 ans et plus de 100 ans
			if (age < 4 || age > 100)
			{
				System.out.println("  >> Vous devez avoir entre 4 et 100 pour jouer !"); // Alors elle peut pas jouer
				
				line = null; // On remet à `null` pour reboucler
				
				continue; // Et on continue
			}
			
			do
			{
				System.out.print("  >> Vous avez choisi " + line + ", cela vous plait ? (Oui ou Non) "); // On demande une confirmation
				
				confirm = sc.nextLine(); // On récupère la confirmation
				
				// Parser pour la réponse
				switch (confirm.toLowerCase()) // On met en miniscule pour ne pas être sensible à la case
				{
					case "oui": continue; // Si c'est oui, on contine
					case "non": // Si c'est non, on met line à `null`pour continuer de boucler
						line = null;
						
						continue;
					default:
						confirm = null; // Si on ne capte rien, on redemande la confirmation
				}
			}
			while (confirm == null); // Tant que la confirmation n'est pas clair
		}
		
		// On ajoute le joueur à la liste des joueurs
		players.add(players.size(), new Player(name, age));
		
		// On affiche les informations sur le joueur ajouté
		System.out.println("\n  >> Le joueur " + name + " (age: " + age + ", id: " + (players.size() - 1) + ") a été ajouté au jeu.\n");
	}

	/**
	 * Permet de récupérer tous les joueurs
	 * 
	 * @return La liste des joueurs
	 */
	public List<Player> getPlayers()
	{
		return players;
	}

	/**
	 * Permet de modifier la liste des joueurs
	 * 
	 * @param players Nouvelle liste de joueur
	 */
	public void setPlayers(List<Player> players)
	{
		this.players = players;
	}

	/**
	 * Permet de r�cup�rer le joueur courant, celui qui doit jouer
	 * 
	 * @return Le joueur courant
	 */
	public Player getCurrentPlayer()
	{
		return currentPlayer;
	}

	/**
	 * Permet de changer le joueur courant, celui qui doit jouer
	 * 
	 * @param currentPlayer Le nouveau joueur courant
	 */
	public void setCurrentPlayer(Player currentPlayer)
	{
		this.currentPlayer = currentPlayer;
	}

	/**
	 * Permet de récupérer la matrice du plateau de jeu
	 * 
	 * @return La plateau du jeu
	 */
	public ArrayList<ArrayList<Turtle>> getPlatform()
	{
		return platform;
	}

	/**
	 * Permet de changer le plateau du jeu
	 * 
	 * @param platform Nouveau plateau de jeu
	 */
	public void setPlatform(ArrayList<ArrayList<Turtle>> platform)
	{
		this.platform = platform;
	}
	
	/**
	 * Permet de récupérer le paquet du jeu
	 * 
	 * @return Le paquet du jeu
	 */
	public Packet getPacket()
	{
		return packet;
	}
	
	/**
	 * Permet de changer le paquet du jeu
	 * 
	 * @param packet Nouveau paquet du jeu
	 */
	public void setPacket(Packet packet)
	{
		this.packet = packet;
	}
	
}
