package mazeSolver;

import java.util.LinkedList;

public class MazeSolver {

	static int[][] maze= {						
			{2,0,1,1},
			{1,1,0,1},
			{0,1,1,1}	
	};
			//0=wall
			//1=path
			//4=places that we have passing by 
			//2=destination
	static LinkedList<Position> path = new LinkedList<Position>();        //Φτιαχνουμε μια linkedList με όνομα path που εκει μέσα θα μπάινουν τα βήματα της διαδρομής
																		  //Την δηλώνω static επειδη εχω δηλώσει και το maze static
	public static void main(String[] args) {
		Position p = new Position(3,0);									  //Φτιάχνω ενα αντικέιμενο p τύπου Position
																		  //Στα ορίσματα της μεθόδου Position δηλώνω το σημειο εκίνησης .   Γραμμή 0, στήλη 3
		path.push(p);													  //Βάζω push αντι για add γιατι θέλω να βάλω το στοιχείο στην αρχή της λίστας (stack)
		maze[path.peek().y][path.peek().x]= 4;							  //Mε την peek βρίσκω κάθε στοιχίο που περάσαμε και το αλλάζω σε 4, 
	}

}
