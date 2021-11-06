/* Balanced Persistent Dynamic Set class which implement the Red-Black tree */

import java.util.LinkedList;


public class BalancedPersistentDynamicSet<E extends Comparable<E>> extends BinarySearchTree<E> {
	
	public LinkedList<Node<E>> hist = new LinkedList<>();
	
	@Override
	protected Node<E> add_pre(Node<E> node) { if (node != null) { hist.add(node); } return node; }
	
	@Override
	protected Node<E> add_post(Node<E> node) { if (node != null) { node.colour = Node.BLACK; } return node; }
	
	@Override
	protected Node<E> history_Nodeadd(Node<E> node) {
		node = node.clone(); if (isRed(node.left) && isRed(node.right)) { flipColours(node); }
		return node;
	}
	
	@Override
	protected Node<E> history_Nodeadd_after(Node<E> node) {
		
		if (isRed(node.left) && !isRed(node.right) && node.left.hasRedChild()) {
			
			if (isRed(node.left.right)) { node.left.right.colour = Node.BLACK; node.left = rotateLeft(node.left); }
			
			else { node.left.colour = Node.BLACK; } node.colour = Node.RED; node = rotateRight(node);
		}
		
		if (isRed(node.right) && !isRed(node.left) && node.right.hasRedChild()) {
			
			if (isRed(node.right.left)) { node.right.left.colour = Node.BLACK; node.right = rotateRight(node.right); }
			
			else { node.right.colour = Node.BLACK; } node.colour = Node.RED; node = rotateLeft(node);
		}

		return node;
	}
	
	@Override
	protected Node<E> remove_pre(Node<E> root) {
		if (root != null) { hist.add(root); } else { return null; }
		if (!root.hasRedChild()) { root.colour = Node.RED; }
		return root;
	}
	
	@Override
	protected Node<E> remove_post(Node<E> root) {
		if (root != null) { root.colour = Node.BLACK; } return root;
	}
	
	@Override
	protected Node<E> history_NodeRemove(Node<E> node) { return node.clone(); }
	
	@Override
	protected Node<E> leftNodeRemove(Node<E> node) {
		if (!isRed(node.left)) { 
			if (isRed(node.right)) { if (!isRed(node)) { node = rotateRecolourLeft(node); }}
			
			else if (node.left != null && !node.left.hasRedChild()) {

				if (node.right != null && node.right.hasRedChild()) { node = rotateRemoveLeft(node); }

				else { flipColours(node); }
			}
		}
		
		return node;
	}
	
	
	@Override
	protected Node<E> rightNodeRemove(Node<E> node) {
		if (!isRed(node.right)) { 

			if (isRed(node.left)) { if (!isRed(node)) { node = rotateRecolourRight(node); }}
			
			
			else if (node.right != null && !node.right.hasRedChild()) {
				
				if (node.left != null && node.left.hasRedChild()) { node = rotateRemoveRight(node); }
				
				else { flipColours(node); }
			}
		}
		
		return node;
	}
	
	
	@Override
	protected Node<E> returnLeftNode(Node<E> node) {
		if (node.left != null) { node.left.colour = Node.BLACK; } return node;
	}
	
	
	private Node<E> rotateLeft(Node<E> node) {
		Node<E> p = node.right; node.right = p.left; p.left = node; return p;
	}
	
	
	private Node<E> rotateRight(Node<E> node) {
		Node<E> p = node.left; node.left = p.right; p.right = node; return p;
	}
	
	
	private Node<E> rotateRecolourLeft(Node<E> node) {
		Node<E> p = (node.right != null ? node.right.clone() : null);
		node.right = (p.left != null ? p.left.clone() : null);
		p.left = node; p.colour = node.colour; node.colour = Node.RED; return p;
	}
	

	private Node<E> rotateRecolourRight(Node<E> node) {
		Node<E> p = (node.left != null ? node.left.clone() : null);
		node.left = (p.right != null ? p.right.clone() : null);
		p.right = node; p.colour = node.colour; node.colour = Node.RED; return p;
	}
	
	private Node<E> rotateRemoveLeft(Node<E> node) {
		flipColours(node); if (isRed(node.right.left)) { node.right = rotateRecolourRight(node.right); }
		node = rotateRecolourLeft(node); flipColours(node); return node;
	}
	
	private Node<E> rotateRemoveRight(Node<E> node) {
		flipColours(node); if (isRed(node.left.right)) { node.left = rotateRecolourLeft(node.left); }
		node = rotateRecolourRight(node); flipColours(node); return node;
	}
	
	private boolean isRed(Node<E> node) { return node != null && node.isRed(); }
	
	private void flipColours(Node<E> node) {
		node.left = node.left.clone(); node.left.colour = !node.left.colour;
		node.right = node.right.clone(); node.right.colour = !node.right.colour;
		node.colour = !node.colour;
	}
}
