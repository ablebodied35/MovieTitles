
public class TreeNode {
	
	private String title;
	private int year;
	
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	//Constructor
	public TreeNode(String title, int year) {
		this.title = title;
		this.year = year;
	}
	
	//Getter and setter methods.
	public String getTitle() {
		return title;
	}
	
	public int getYear() {
		return year;
	}
	
	public TreeNode getleftChild() {
		return leftChild;
	}
	
	public TreeNode getrightChild() {
		return rightChild;
	}
	
	public void setLeft(TreeNode node) {
		leftChild = node;
	}
	
	public void setRight(TreeNode node) {
		rightChild = node;
	}
	
	
	public String toString() {
		return title + " " + year;
	}
}
