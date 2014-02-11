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
			else{
				this.scores[0] = 30;
			}
			
		}
		else
		{
			this.scores[1]=15;
		}

		return this.score();
	}
 
}
