public class BinarySearchTree<E extends Comparable<E>> {
	public Node<E> rootNode = null;
	private boolean result_a;
	private boolean result_b;

	public boolean add(E value) {

		rootNode = add_post(add_steps(add_pre(rootNode), value));
		nodeVersion(result_a);

		if (result_a) {

			System.out.println("Add success");
			return true;
		}

		else {
			System.out.println("Add fail");
			return false;
		}

	}

	protected Node<E> add_steps(Node<E> node, E value) {
		if (node == null) {
			Node<E> newroot = new Node<>(value, Node.RED);
			nodeDiscovered(newroot.clone());
			result_a = true;
			return newroot;
		}
                
                node = history_Nodeadd(node);
		nodeDiscovered(node.clone());
		int c = value.compareTo(node.value);
		if (c < 0) {
			node.left = add_steps(node.left, value);
		} else if (c > 0) {
			node.right = add_steps(node.right, value);
		}

		result_a = true;

		return history_Nodeadd_after(node);
	}

	public boolean remove(E value) {
		result_b = false;
		rootNode = remove_post(remove_steps(remove_pre(rootNode), value)); 
                nodeVersion(result_b);

		if (result_b) {

			System.out.println("Remove success");
			return true;
		}

		else {
			System.out.println("Remove fail");
			return false;
		}

	}
        
        protected Node<E> remove_steps(Node<E> node, E value) {
		if (node == null) {
			return null;
		}
                
                node = history_NodeRemove(node);

		if (value == node.value) {
			if (node.left == null && node.right == null) {
				return null;
			} else if (node.right == null) {
				
                            nodeDiscovered(node.left.clone());
                            node = returnLeftNode(node); 
                            return node.left;
			} else if (node.left == null) {
			
                            nodeDiscovered(node.right.clone());
                            return node.right;
			} else {
				E firstNode = first(node.right);
				node.value = firstNode;
				node.right = remove_steps(node.right, firstNode);
                                nodeDiscovered(node.clone());
				nodeDiscovered(node.left.clone());
                                return node;
			}
		}
                
            

		if (value.compareTo(node.value) < 0) {
                        
                        node = leftNodeRemove(node);
			node.left = remove_steps(node.left, value);
			nodeDiscovered(node.clone());
                        result_b = true;
                        return node;
		}
                else if (value.compareTo(node.value) > 0) {
                   
                    node = rightNodeRemove(node);
                    nodeDiscovered(node.clone());
		    node.right = remove_steps(node.right, value);
                    result_b = true;
		    return node;
                
                }
            return node;
                
	}
        
        
        public boolean contains(E value) {
		return contains_step(rootNode, value);
	}

	protected boolean contains_step(Node<E> node, E value) {
		if (node == null) {
			return false;
		}
		int c;

		if ((c = value.compareTo(node.value)) == 0) {
			return true;
		}
		return contains_step(c < 0 ? node.left : node.right, value);
	}

	public E first() {
		return first(rootNode);
	}

	protected E first(Node<E> node) {
		while (node.left != null) {
			node = node.left;
		}
		return node.value;
	}

	public E last() {
		return last(rootNode);
	}

	protected E last(Node<E> node) {
		while (node.right != null) {
			node = node.right;
		}
		return node.value;
	}
        
        
        

	/** Hook methods */

	protected Node<E> nodeDiscovered(Node<E> node) {
		return node;
	}
        
        protected Node<E> add_pre(Node<E> node) { return node; }
        

	protected Node<E> add_post(Node<E> node) {
		return node;
	}

	protected Node<E> remove_pre(Node<E> rootNode) {
		return rootNode;
	}

	protected Node<E> remove_post(Node<E> rootNode) {
		return rootNode;
	}

	protected Node<E> history_NodeRemove(Node<E> node) {
		return node;
	}

	protected Node<E> returnLeftNode(Node<E> node) {
		return node;
	}

	public void nodeVersion(boolean result) {
	};

        protected Node<E> history_Nodeadd(Node<E> node) { return node; }
        
        
	protected Node<E> history_Nodeadd_after(Node<E> node) {
		return node;
	}

	// Prepare for balanced persistent dynamic set
	protected Node<E> leftNodeRemove(Node<E> node) {
		return node;
	}

	protected Node<E> rightNodeRemove(Node<E> node) {
		return node;
	}

	@Override
	public String toString() {
		return rootNode != null ? toString(rootNode) : "";
	}

	public String toString(Node<E> node) {
		String s = node.value.toString();
		if (node.left != null) {
			s = toString(node.left) + " " + s;
		}
		if (node.right != null) {
			s = s + " " + toString(node.right);
		}

		return s;
	}
}
