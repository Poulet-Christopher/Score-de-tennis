package models;

import java.util.*;
import javax.validation.*;
import play.data.validation.Constraints.*;

public class Jeu {

	private String[] scores = {"0","0"};
	
 
	public String score() {
	 	StringBuilder sb = new StringBuilder();
	 	sb.append(this.scores[0]).append("-").append(this.scores[1]);
	 	return sb.toString();
	}

	public String JoueurGagne(String joueur, int point){
		int player, versus;
		String score ="";
		/*if(joueur == "j1")
		{
			if(point == 1){
				this.scores[0] = "15";
			}
			if(point == 2){
				this.scores[0] = "30";
			}
			if(point == 3){
				this.scores[0] = "40";
			}
			if(point == 4){
				if(this.scores[1] == "40"){
					this.scores[0] = "Av";
				}
			}
			
		}
		else
		{
			if(point == 1){
				this.scores[1] = "15";
			}
			if(point == 2){
				this.scores[1] = "30";
			}
			if(point == 3){
				this.scores[1] = "40";
			}
			if(point == 4){
				if(this.scores[0] == "40"){
					this.scores[1] = "Av";
				}
			}
		}*/

		if(joueur == "j1"){
			player=0;
			versus=1;
		}
		else{
			player=1;
			versus=0;
		}

		switch(point){
			case 1:
				this.scores[player] = "15";
				score = this.score();
				break;
			case 2:
				this.scores[player] = "30";
				score = this.score();
				break;
			case 3:
				this.scores[player] = "40";
				score = this.score();
				break;
			case 4:

				if(this.scores[versus] == "40" && this.scores[player] != "Av"){
					this.scores[player] = "Av";
					score = this.score();
				}
				else
				{
					if(this.scores[versus] == "Av" && this.scores[player] == "40"){
						this.scores[versus] = "40";
						score = this.score();
					}
					else
					{
						score = "jeu"+joueur;
						this.scores[player] = "0";
						this.scores[versus] = "0";
						this.score();
					}
				}


				break;
		}

		return score;
	}
 
}
