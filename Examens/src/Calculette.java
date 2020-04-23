import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Calculette {


	public Calculette() {
		while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez Faire un choix entre 1 et 4 : ");
		String operateur = sc.nextLine();
		
		System.out.println("Vous avez saisi : " + operateur);
		Float fermeture_ = Float.parseFloat(operateur);
		
		if(fermeture_ == 5)
			System.exit(1);
		System.out.println("Veuillez entrez le 1er nombre : ");
		String a = sc.nextLine();
		System.out.println("Vous avez saisi : " + a);
		
		System.out.println("Veuillez entrez le 2eme nombre :");
		String b = sc.nextLine();
		System.out.println("Vous avez saisi : " + b);
		
		String resultat = operation(a, operateur, b);
		
		System.out.println("Le resultat est : " + resultat);
		
		}


    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculette cal = new Calculette();

	}
	public String operation(String a, String op, String b) {
		String resultat = "";
		Float a_ = Float.parseFloat(a);
		Float b_ = Float.parseFloat(b);
		switch (op) {
		case "1":
			resultat = "" + (a_ + b_);
			break;
		case "2":
			resultat = "" + (a_ - b_);
			break;
		case "3":
			if (b_ != 0) {
				resultat = "" + (a_ / b_);
			} else {
				resultat = "ERREUR DIVISION PAR 0";
			}
			break;
		case "4":
			resultat = "" + (a_ * b_);
			break;
		}
		return resultat;
	}

}