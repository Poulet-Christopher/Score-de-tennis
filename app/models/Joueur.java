package models;

import java.util.*;
import javax.validation.*;
import play.data.validation.Constraints.*;

public class Joueur{
	@Required
	public String joueur;
    public Joueur() {}
    public Joueur(String joueur) {
	this.joueur = joueur;
    }

	public String point(){
		int scorej1=0;
		int scorej2=0;
	 	String score;

	 	if(joueur == "joueur1")
	 	{
	 		scorej1=15;
	 	}

	 	score = scorej1+"-"+scorej2;
	 	return score;
	}
}