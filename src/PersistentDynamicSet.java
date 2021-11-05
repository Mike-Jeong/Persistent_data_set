/* Persistent Dynamic Set which shows the version of tree change. 
   this class stored nodes that effected in each changes */

import java.util.LinkedList;
import java.util.List;


public class PersistentDynamicSet<E extends Comparable<E>> extends BinarySearchTree<E> {
    public List<List<Node<E>>> hist = new LinkedList<>();
    protected List<Node<E>> tempList = new LinkedList<>();
    public LinkedList<Node<E>> treehistory = new LinkedList<>();

    @Override
    protected Node<E> add_pre(Node<E> node) {
        if (node != null) {
            treehistory.add(node);
        }
        return node;
    }

    @Override
    protected Node<E> history_Nodeadd(Node<E> node) {
        return node.clone();
    }

    @Override
    protected Node<E> remove_pre(Node<E> node) {
        if (node != null) {
            treehistory.add(node);
        }
        return node;
    }

    @Override
    protected Node<E> history_NodeRemove(Node<E> node) {
        return node.clone();
    }

    @Override
    protected Node<E> nodeDiscovered(Node<E> node) {
        tempList.add(node);
        return node;
    }

    @Override
    public void nodeVersion(boolean result) {
        if (result) {
            hist.add(tempList);
        }
        tempList = new LinkedList<>();
    }

    public List<List<Node<E>>> gethist() {
        return hist;
    }

}
