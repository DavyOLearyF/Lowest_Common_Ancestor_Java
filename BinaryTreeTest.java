import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BinaryTreeTest {
	
	Node root;
	private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();


	@Test
	public void testFindLCA() {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		
		assertEquals("Checking the result of the LCA of 4 and 5 is 2", 2, tree.findLCA(4, 5));
		assertEquals("Checking the result of the LCA of two elements not in the tree", -1, tree.findLCA(13,23));
		assertEquals("Checking the result of the LCA of 2 and an element not in the tree", -1, tree.findLCA(2, 100));
	}
	
	@Test
	public void testFindPath() {
		BinaryTree tree = new BinaryTree();
		Node firstRoot = new Node(1);
		tree.root = firstRoot;
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
	    
		tree.findLCA(2, 7);
		assertEquals("Checking false is returned when root is null", false, tree.findPath(null, 1, path1));
		assertEquals("Checking true is returned when node is contained in the tree", true, tree.findPath(firstRoot, 7, path2));
		assertEquals("Checking false is returned when node is not contained in the tree", false, tree.findPath(firstRoot, 8, path1));
	}
	
}
