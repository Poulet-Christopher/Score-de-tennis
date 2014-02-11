package models;

import java.util.*;
import javax.validation.*;
import play.data.validation.Constraints.*;

public class Jeu {

	private int[] scores = {0,0};
	
 
	public String score() {
	 	StringBuilder sb = new StringBuilder();
	 	sb.append(this.scores[0]).append("-").append(this.scores[1]);
	 	return sb.toString();
	}

	public String JoueurGagne(String joueur, int point){
		if(joueur == "j1")
		{
			if(point == 1){
				this.scores[0] = 15;
			}
			if(point == 2){
				this.scores[0] = 30;
			}
			if(point == 3){
				this.scores[0] = 40;
			}
			
		}
		else
		{
			if(point == 1){
				this.scores[1] = 15;
			}
			if(point == 2){
				this.scores[1] = 30;
			}
			if(point == 3){
				this.scores[1] = 40;
			}
		}

		return this.score();
	}
 
}
