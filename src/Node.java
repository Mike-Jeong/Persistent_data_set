
public class Node<E extends Comparable<E>> {
	public final static boolean RED = true;
	public final static boolean BLACK = false;
	
	public E value;
	public Node<E> left = null, right = null;
	public boolean colour = true;
	
	public Node(E value) { this.value = value; this.colour = RED; }
	
	public Node(E value, boolean colour) { this.value = value; this.colour = colour; }
	
	public Node(E value, Node<E> left, Node<E> right, boolean colour) {
		this.value = value; this.left = left; this.right = right; this.colour = colour;
	}
	
	public boolean isRed() { return colour; }
	
	public boolean hasRedChild() { return (left != null && left.colour) || (right != null && right.colour); }
	
	@Override
	public Node<E> clone() { return new Node<>(value, left, right, colour); }
	
	@Override
	public String toString() { return value.toString(); }
	
	public String toString(boolean coloured) { return value.toString() + (coloured ? (isRed() ? "(R)" : "(B)") : ""); }
}
