package models;

import java.util.*;
import javax.validation.*;
import play.data.validation.Constraints.*;

public class Joueur2{
	@Required
	public int point;
    public Joueur2() {}
    public Joueur2(int point) {
	this.point = point;
    }

	public int point(){
		int score;
		
		//factorisation score avant jeu

		switch(point)
		{
			case 1:
				score=15;
				break;			
			case 2:
				score=30;
				break;			
			case 3:
				score=40;
				break;
			default:
				score=0;			
		}

	 	return score;
	}
}