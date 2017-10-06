package constants;

import java.awt.Toolkit;

public class Constants {

	public static int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static String MSG_JOUEUR_NOM_BLANK = "Un joueur n'a pas de nom !";
	public static String MSG_JOUEUR_DOUBLON = "Des joueurs semblent avoir le m�me nom...";
	public static String MSG_FILE_VIDE = "Aucun fichier import�. Veuillez en importer au moins un.";
	
}
