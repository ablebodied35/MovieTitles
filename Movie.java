import java.util.*;
import java.io.*;

public class Movie {

	public static void main(String[] args)throws IOException {
		
		//Variables, readers
		BufferedReader week = new BufferedReader(new FileReader("movies.csv"));
		
		File output = new File("output.txt");
		PrintWriter out = new PrintWriter(output);
		String line = week.readLine();
		String title;
		int year = 0;
		String tempYear;
		BinaryTree tree = new BinaryTree();
		
		//While loop reads in the block of text after the first comma(',') and before 
		//the last comma. Done this way because some titles had commas inside their 
		//titles which made it difficult to use .split(","). The block of text was then
		//subsetted into a title and parsed into a year separately which were then sent
		//to our binary tree class to be processed.
		while (week.ready()) {
			line = week.readLine();
			String token = line.substring(line.indexOf(",")+1,line.lastIndexOf(","));
			title = token.substring(0, token.lastIndexOf(" ") + 1 );
			tempYear = token.substring(token.lastIndexOf("(")+1, token.lastIndexOf(")") );
			year = Integer.parseInt(tempYear);
			tree.addNode(title, year);
			
		}

		out.println("Check if findNode method works in following line:");
		out.println(tree.findNode("Zoom"));
		out.println();
		
		out.println("RANGE: Grumpier Old Men to Harry Potter");
		tree.Print(tree.getroot(), "Grumpier Old Men", "Harry Potter",out);
		out.println();
		
		out.println("RANGE: Toy Story to WALL-E");
		tree.Print(tree.getroot(), "Toy Story", "WALL-E",out);
		out.println();
		
		out.println("RANGE: Babylon 5 to Zoom");
		tree.Print(tree.getroot(), "Babylon 5", "Zoom",out);
	
	
	
		out.close();
	}

}
