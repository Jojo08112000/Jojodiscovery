package testEntretien;

import java.util.HashMap;
import java.util.Map;

public class ScannerID {
	private static int compteur2x;  // Le compteur permettant de savoir combien de fois on a des ID qui contiennent une lettre qui apparaît 2 fois
	private static int compteur3x;  // Le compteur permettant de savoir combien de fois on a des ID qui contiennent une lettre qui apparaît 3 fois
	
	// La fonction permettant de compter le nombre d'ID respectant chaque condition et retournant la somme de contrôle
	public static int compteurID(String[] listID) {
		compteur2x = 0;
		compteur3x = 0;
		// Je parcours la liste d'identifiant en récupérant chaque identifiant 
		for (int i = 0; i < listID.length; i++) {
			
			int cpt2 = 0;
			int cpt3 = 0;
			String id = listID[i];// Je récupère chaque identifiant de la liste
			
			//Je vérifie la répétition des lettre au sein d'un identifiant 
			for (int j = 0; j < id.length(); j++) {
				char lettre = id.charAt(j);//Je récupère la lettre à la position j
				int count = 0;
				for (int k = 0; k < id.length(); k++) {
					if (lettre == id.charAt(k)) {
						count++;
					}
				}
				if (count == 2) {
					cpt2 = 1;
				} else if (count == 3) {
					cpt3 = 1;
				}
			}
			
			//Je met à jour chaque compteur
			compteur2x += cpt2; 
			compteur3x += cpt3;
			
		}
		
		return compteur2x * compteur3x;
		
	} 
	
	//En utilisant un tableau comme structure de données, c'est l'algorithme le plus optimal qu'on puisse obtenir. 
	//La complexité temporelle de ce algorithme est O(n²)
	//Néanmoins, on peut encore optimiser ce code et travailler à obtenir un code de complexité O(n) avec biensur n la longeur moyenne des identifiants des différentes boites
	//Pour cela il nous faudra utiliser une structure de données, une collection HashMap(clé, valeur)pour compter le nombre d ' occurences de lettre
	//Voir le code suivant : 
	
	public static int compteurID2(String[] listID) {
        compteur2x = 0;
        compteur3x = 0;
        for (String id : listID) {
        	
            Map<Character, Integer> collectionID = new HashMap<>(); //Création de la collection HashMap
            
            for (char lettre : id.toCharArray()) {//Je parcours chaque lettre de l'identifiant 
                collectionID.put(lettre, collectionID.getOrDefault(lettre, 0) + 1); //J'incrémente le comptzur de la lettre dans le dictionnaire 
            }

            if (collectionID.containsValue(2)) {
                compteur2x++;
            }
            if (collectionID.containsValue(3)) {
                compteur3x++;
            }
        }
        return compteur2x * compteur3x;
    }

	
	public static void main(String[] args) {
		String[] listID = {"abcdef", "bababc", "abbcde", "abcccd", "aabcdd", "abcdee", "ababab"};
		int sommeControle = compteurID(listID);
		System.out.println("Version avec un tableau comme structure de données");
		System.out.println("Le nombre d'identifiant contenant 2 lettres identiques est :" + compteur2x);
		System.out.println("Le nombre d'identifiant contenant 3 lettres identiques est :" + compteur3x);
		System.out.println("Somme de contrôle : " + sommeControle);
		int sommeControle2 = compteurID2(listID);
		System.out.println("Version avec une collection HasMap comme structure de données");
		System.out.println("Le nombre d'identifiant contenant 2 lettres identiques est :" + compteur2x);
		System.out.println("Le nombre d'identifiant contenant 3 lettres identiques est :" + compteur3x);
		System.out.println("Somme de contrôle : " + sommeControle2);
	}
}



