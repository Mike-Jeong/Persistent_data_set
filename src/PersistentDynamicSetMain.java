public class PersistentDynamicSetMain {
    public static void main(String[] args) throws Exception {
       BinarySearchTree<String> tree = new BinarySearchTree<>();
       //PersistentDynamicSet<String> tree = new PersistentDynamicSet<>();
       //BalancedPersistentDynamicSet<String> tree = new BalancedPersistentDynamicSet();

       tree.add("cow");
       tree.add("fly");
       tree.add("dog");
       tree.add("bat");
       tree.add("fox");
       tree.add("cat");
       tree.add("eel");
       tree.add("ant");
       tree.add("owl");

       ProcessStep t = new ProcessStep();
        t.testBinary(tree);
       // t.testPersistent(tree);
       // t.testBalanced(tree);

    }
}
