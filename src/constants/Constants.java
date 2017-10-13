package constants;

import java.awt.Toolkit;

public class Constants {

	public static int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	public static int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	public static String MSG_JOUEUR_NOM_BLANK = "Un joueur n'a pas de nom !";
	public static String MSG_JOUEUR_DOUBLON = "Des joueurs semblent avoir le même nom...";
	public static String MSG_NO_JOUEUR = "Veuillez entrer au moins un joueur.";
	public static String MSG_FILE_VIDE = "Aucun fichier importé. Veuillez en importer au moins un.";
	public static String MSG_FILE_INVALID = "Fichier invalide : ";
	public static String MSG_CORRUPTED_FILE = "Fichier corrompu : ";
	public static String END_MSG = "Fin de partie, merci d'avoir joué !";
	public static int NB_TURNS = 40;
}
