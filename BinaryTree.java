import java.io.*;
public class BinaryTree {

	private TreeNode root;
	
	public TreeNode getroot() {
		return root;
	}

	
	/****************************************************************
	 * This method basically adds a node to the binary tree. It first 
	 * checks to see if the root is null, if it is it fills it in. 
	 * Next, we reference two nodes called focus and parent. Focus will
	 * be used for insertion and parent just to keep track and make sense.
	 * the if statements in the while loop check whether the node belongs left
	 * or right by using compareTo. Negative value means left child, while positive
	 * means right child. It moves the focus node into focus left child or right child
	 * based on the compare to method. Checks if the node is null, if it is we have added
	 * a node, if not we go on to the next node. 
	 */
	public void addNode(String title, int year) {
		
		TreeNode node = new TreeNode(title,year);
		
		if (root == null) 
			root = node;
		else {
			
			TreeNode focus  = root;
			TreeNode parent;
			
			while(true) {
				
				parent = focus;
				
				if(title.compareTo(focus.getTitle()) < 0 ) {
					focus = focus.getleftChild();	
				
				if(focus == null) {
					parent.setLeft(node);
					return;
				}
				}else {
					focus = focus.getrightChild();
					if (focus == null) {
						parent.setRight(node);
						return;
					}
				}
			}
		}
		
		
	}
	
	/*************************************************************
	 * This method finds a node through the title. It keeps moving
	 * down the right or left child until the title is equal to 
	 * the one we gave it as a paremeter. It then returns the node if
	 * we find the title or null if we dont. 
	 */
	public TreeNode findNode(String title) {
		TreeNode focusnode = root;
		
		while(!focusnode.getTitle().contains(title)) {
			if(title.compareTo(focusnode.getTitle()) < 0) {
				focusnode = focusnode.getleftChild();
			}
			else {
				focusnode = focusnode.getrightChild();
			}
			if (focusnode == null) {
				return null;
			}
		}
		return focusnode;
	}
	
	
		//Self explantory by the title. These 3 following methods are 
		//the traversals through the tree. 
		public void preorderTraverseTree(TreeNode focusNode) {
	
		   if (focusNode != null) {
               System.out.println("HI:      " + focusNode);
               preorderTraverseTree(focusNode.getleftChild());
               preorderTraverseTree(focusNode.getrightChild());
           }
		}
	   
		public void postorderTraverseTree(TreeNode focusNode) {
		
		   if (focusNode != null) { 
               preorderTraverseTree(focusNode.getleftChild());
               preorderTraverseTree(focusNode.getrightChild());
               System.out.println("HI:      " + focusNode);
           }
		}
   
		public void inorderTraverseTree(TreeNode focusNode) {

			if (focusNode != null) {
				preorderTraverseTree(focusNode.getleftChild());
				System.out.println("HI:      " + focusNode);
				preorderTraverseTree(focusNode.getrightChild()); 
			}
		}


	   
	   /*
	    * This piece of code I had to look up. It basically prints out 
	    * the nodes betweeen range start - end. It uses recursion. It first
	    * compares the start String to a nodes title. This node is the root, and we send
	    * it in the parameters in main. If the start is before the root then we call
	    * the method again except we send the leftchild instead of root. The recursion
	    * acts like inordertraversal. It does the same for the right child. 
	    * I will be honest, amongst the panic of the virus, schools closing, my mother being 
	    * extremely anxious about everything and me worrying about catching the virus 
	    * while riding the MTA I decided to look this piece of code up to quell some anxiety
	    * so I could finish up this assignment on time. 
	    * I did this with everything but I made sure I understood what was going on in other
	    * pieces of code. This one I  do not understand 100% completely but I do aim to work on it. 
	    * The code leaves out the last title in the range which is end. I tried to troubleshoot this 
	    * but failed to make any progress. I am submitting it like this in hopes that I can at least
	    * get some points instead of a 0. 
	    * I left the comments that the original coder typed up hoping it can help you out to understand. 
	    */
	   void Print(TreeNode node, String start, String end, PrintWriter out)throws IOException { 
	          
	        /* base case */
	        if (node == null) { 
	            return; 
	        } 
	  
	        /* Since the desired o/p is sorted, recurse for left subtree first 
	         If root->data is greater than start, then only we can get o/p keys 
	         in left subtree */
	        if (start.compareTo(node.getTitle()) < 0) { 
	            Print(node.getleftChild(), start, end, out); 
	        } 
	  
	        /* if root's data lies in range, then prints root's data */
	        if (start.compareTo(node.getTitle()) <= 0 && end.compareTo(node.getTitle()) >= 0) { 
	            out.println(node.getTitle() + " "); 
	        } 
	  
	        /* If root->data is smaller than end, then only we can get o/p keys 
	         in right subtree */
	        if (end.compareTo(node.getTitle()) > 0) { 
	            Print(node.getrightChild(), start, end,out); 
	        } 
	    } 

}
