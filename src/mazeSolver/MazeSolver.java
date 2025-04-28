package mazeSolver;

import java.util.LinkedList;

public class MazeSolver {

	static int[][] maze= {									//Φτιάχνω την maze			
			{2,0,1,1},
			{1,1,1,0},
			{0,1,0,0}	
	};
			//0=wall
			//1=path
			//4=places that we have passing by 
			//2=destination
	static LinkedList<Position> path = new LinkedList<Position>();       			//Φτιαχνουμε μια linkedList με όνομα path που εκει μέσα θα μπάινουν τα βήματα της διαδρομής
											        //Την δηλώνω static επειδη εχω δηλώσει και το maze static
	public static void main(String[] args) {
		Position p = new Position(0,3);							//Φτιάχνω ενα αντικέιμενο p τύπου Position
		path.push(p);									//Βάζω push αντι για add γιατι θέλω να βάλω το στοιχείο στην αρχή της λίστας (stack)
		
	while(true) {										//Η while επαναλαμβάνεται μέχρι κάποιο return να σπάσει τερματίσει την συνθήκη 
		
		int y= path.peek().y;								//Mε την peek βρίσκω κάθε στοιχίο που περάσαμε και το αλλάζω σε 4,
		int x= path.peek().x;
		maze[y][x]= 4;										   
	
		//one step down
		if(isValid(y+1,x)) {
		if(maze[y+1][x]==2) {								//Ελέγχει αν ένα βήμα κάτω ειναι "2" σημαίνει οτι φτάσαμε στον προορισμό 
			System.out.println("Moved down.\nYou won!");
			return;									//τερματίζει το πρόγραμμα 
		} else if(maze[y+1][x]==1) {							//Ελέγχει αν ένα βήμα κάτω ειναι "1" σημαίνει οτι υπάρχει διαδρομή,   
			System.out.println("Moved down");
			path.push(new Position(y+1,x));						//Οπότε παιρνει τις συντεταγμένες απο τη θέση που βρίσκεται ενα βήμα κάτω και τη βάζει στο path 		
			continue;
		}
		}
		
		//one step left
		if(isValid(y,x-1)) {
		if(maze[y][x-1]==2) {								//Ελέγχει αν ένα βήμα αριστερά ειναι "2" σημαίνει οτι φτάσαμε στον προορισμό 
			System.out.println("Moved left.\nYou won!");
			return;									//τερματίζει το πρόγραμμα 
		} else if(maze[y][x-1]==1) {							//Ελέγχει αν ένα βήμα αριστερά ειναι "1" σημαίνει οτι υπάρχει διαδρομή,   
			System.out.println("Moved left");
			path.push(new Position(y,x-1));						//Οπότε παιρνει τις συντεταγμένες απο τη θέση που βρίσκεται ενα βήμα αριστερά και τη βάζει στο path 		
			continue;
		}
		}
		
		if(isValid(y-1,x)) {
		//one step up
		if(maze[y-1][x]==2) {								//Ελέγχει αν ένα βήμα πάνω ειναι "2" σημαίνει οτι φτάσαμε στον προορισμό 
			System.out.println("Moved up.\nYou won!");
			return;									//τερματίζει το πρόγραμμα 
		} else if(maze[y-1][x]==1) {							//Ελέγχει αν ένα βήμα πάνω ειναι "1" σημαίνει οτι υπάρχει διαδρομή,   
			System.out.println("Moved up");
			path.push(new Position(y-1,x));						//Οπότε παιρνει τις συντεταγμένες απο τη θέση που βρίσκεται ενα βήμα πάνω και τη βάζει στο path 		
			continue;
		}
		}
		
		//one step right
		if(isValid(y,x+1)) {
		if(maze[y][x+1]==2) {								//Ελέγχει αν ένα βήμα δεξιά ειναι "2" σημαίνει οτι φτάσαμε στον προορισμό 
			System.out.println("Moved right.\nYou won!");
			return;									//τερματίζει το πρόγραμμα 
		} else if(maze[y][x+1]==1) {							//Ελέγχει αν ένα βήμα δεξιά ειναι "1" σημαίνει οτι υπάρχει διαδρομή,   
			System.out.println("Moved right");
			path.push(new Position(y,x+1));						//Οπότε παιρνει τις συντεταγμένες απο τη θέση που βρίσκεται ενα βήμα δεξιά και τη βάζει στο path 		
			continue;
		}
		}
				
		path.pop();
		System.out.println("Moved back");						//Σε περίπτωση που δεν προχωρήσει σε κανένα απο τα παραπάνω γιατι συναντάει 0, θα πάει ενα βήμα πίσω, 
		if(path.size()<= 0) {								//Αν η λίστα που αποθηκεύεται το path ειναι μικρότερη του μηδενός σημαίνει οτι δεν υπάρχει διαδρομή
			System.out.println("There is no path");
			return;
		}
		
		}//while close	
		
	
	
	
		}//main close	
	
		public static boolean isValid(int y, int x) {
			if(y<0 || y >= maze.length || x<0 || x>= maze[y].length) {	  	//Φτιάχνουμε μια μέθοδο isValid. και την καλούμε πρίν απο κάθε βήμα για να δούμε εαν με το επόμενο β΄λημα θα είμαστε εντος ορίων 
				return false;
			}
			return true;
		}
		
	
	

}// class close
