package fr.balsaeize.turtlegame.util;

/**
 * Classe permettant de gérer la couleur dans le terminal
 * La console Windows ne prennant pas en compte les code ANSI,
 * cette classe n'est fonctionnel que pour Unix ou les terminaux émulant Unix
 * 
 * @author Quentin CATHERINE et Axel ELAIN
 * @version 1.0.0
 */
public class Color {
	
	/**
	 * Enumération permettant de lister les différents couleurs utilisable
	 * 
	 * @author Quentin CATHERINE et Axel ELAIN
     * @version 1.0.0
	 */
	public enum ColorCode {
		
		BLACK(0),
		RED(1),
		GREEN(2),
		YELLOW(3),
		BLUE(4),
		MAGENTA(5),
		CYAN(6),
		WHITE(7);
		
		/** Code de la couleur **/
		private final int code;
		
		/**
		 * Permet de créer les énumération de couleur
		 * 
		 * @param code Code de la couleur (0 pour noire, 1 pour rouge, etc...)
		 */
		private ColorCode(int code)
		{
			this.code = code;
		}
		
		/**
		 * Permet de récupérer le code de la couleur sous forme d'un entier
		 * 
		 * @return Code couleur
		 */
		public int toInt()
		{
			return code;
		}
		
		
		@Override
		public String toString()
		{
			return String.valueOf(code);
		}
		
	}

	/** Code couleur de fond **/
	private ColorCode background;
	/** Code couleur du texte **/
	private ColorCode foreground;
	/** Clarité du texte **/
	private boolean bright;
	
	/**
	 * Permet d'instancier une couleur contenant une couleur de fond, une couleur et une clairité de couleur
	 * 
	 * @param background Code couleur du fond
	 * @param foreground COde couleur du texte
	 * @param bright Clarité du texte
	 */
	public Color(ColorCode background, ColorCode foreground, boolean bright)
	{
		this.background = background;
		this.foreground = foreground;
		this.bright     = bright;
	}

	/**
	 * Permet d'instancier une couleur contenant une couleur de fond
	 * 
	 * @param background Code couleur du fond
	 */
	public Color(ColorCode background)
	{
		this(background, null, false);
	}
	
	/**
	 * Permet d'instancier une couleur contenant une couleur et une clairité de couleur
	 * 
	 * @param foreground COde couleur du texte
	 * @param bright Clarité du texte
	 */
	public Color(ColorCode foreground, boolean bright)
	{
		this(null, foreground, bright);
	}
	
	/**
	 * Permet de formater une chaine permettant le changement des couleurs
	 * 
	 * @return Code ANSI changant les couleurs
	 */
	public String getColorCode()
	{
		StringBuilder color = new StringBuilder();
		
		color.append("\u001B[")
		     .append(background != null ? 40 + background.toInt() : "")
		     .append(background != null && foreground != null ? ";" : "")
		     .append(foreground != null ? 30 + foreground.toInt() : "")
		     .append(foreground != null && bright != false ? ";" : "")
		     .append(bright != false ? "1" : "")
		     .append("m");
		
		return color.toString();
	}
	
	/**
	 * Permet de rétablir les paramètres par défaut
	 * 
	 * @return Code de 'reset'
	 */
	public String reset()
	{
		return "\u001B[0m";
	}
	
	@Override
	public String toString()
	{
		StringBuilder string = new StringBuilder();
		
		string.append("Color[")
		      .append("background:" + (background != null ? background.name() : "none"))
		      .append("; foreground:" + (foreground != null ? foreground.name() : "none"))
		      .append("; bright:" + bright)
		      .append("]");
		
		return string.toString();
	}

	/**
	 * Permet de récupérer le code couleur du fond
	 * 
	 * @return Code couleur du fond
	 */
	public ColorCode getBackground()
	{
		return background;
	}

	/**
	 * Permet de changer le code couleur du fond
	 * 
	 * @param background Nouvelle couleur du fond
	 */
	public void setBackground(ColorCode background)
	{
		this.background = background;
	}

	/**
	 * Permet de récupérer le code couleur du texte
	 * 
	 * @return Code couleur du texte
	 */
	public ColorCode getForeground()
	{
		return foreground;
	}

	/**
	 * Permet de changer la couleur du texte
	 * 
	 * @param foreground Nouvelle couleur du texte
	 */
	public void setForeground(ColorCode foreground)
	{
		this.foreground = foreground;
	}

	/**
	 * Permet de savoir sur la couleur du texte est clare ou non
	 * 
	 * @return Clarité du texte
	 */
	public boolean isBright()
	{
		return bright;
	}

	/**
	 * Permet de changer la clarité du texte
	 * 
	 * @param bright Nouvelle clarité du texte
	 */
	public void setBright(boolean bright)
	{
		this.bright = bright;
	}
	
}
