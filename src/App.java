public class App {
    public static void main(String[] args) throws Exception {
       BinarySearchTree<String> tree = new BinarySearchTree<>();

       tree.add("cow");
       tree.add("fly");
       tree.add("dog");
       tree.add("bat");
       tree.add("fox");
       tree.add("cat");
       tree.add("eel");
       tree.add("ant");
       tree.add("owl");

       System.out.println("tree : " + tree.toString());
       System.out.println("rootnode : " + tree.rootNode);
       System.out.println();

    }
}
