import java.util.List;
import java.util.Scanner;

public class ProcessStep {
    
    public void testBinary(BinarySearchTree tree) {
        System.out.println("tree : " + tree.toString());
        System.out.println("rootnode : " + tree.rootNode);
        System.out.println();
        TreePrinter.print(tree.rootNode, false);

        System.out.println();
        System.out.println("Remove owl");
        tree.remove("owl");
        System.out.println("tree : " + tree.toString());
        System.out.println("rootnode : " + tree.rootNode);

        System.out.println();
        TreePrinter.print(tree.rootNode, false);

        System.out.println();
        System.out.println("Remove cow");
        tree.remove("cow");
        System.out.println("tree : " + tree.toString());
        System.out.println("rootnode : " + tree.rootNode);

        System.out.println();
        TreePrinter.print(tree.rootNode, false);

        System.out.println();
        System.out.println("Add asp");
        tree.add("asp");
        System.out.println("tree : " + tree.toString());
        System.out.println("rootnode : " + tree.rootNode);

        System.out.println();
        TreePrinter.print(tree.rootNode, false);

        System.out.println();
        System.out.println("Final : ");
        TreePrinter.print(tree.rootNode, false);

        System.out.println();
        System.out.println("Checking tree has the specific element : dog");
        System.out.println("Result : " + tree.contains("dog"));

        System.out.println();
        System.out.println("Checking tree has the specific element : aaa");
        System.out.println("Result : " + tree.contains("aaa"));

        System.out.println();
        System.out.println("Checking tree has the specific element : cow");
        System.out.println("Result : " + tree.contains("cow"));

        System.out.println();
        System.out.println("first value : " + tree.first());
        System.out.println("last value : " + tree.last());
    }

    public void testPersistent(PersistentDynamicSet tree) {
        System.out.println("tree : " + tree.toString());
        System.out.println("rootnode : " + tree.rootNode);
        System.out.println();
        TreePrinter.print(tree.rootNode, false);

        System.out.println();
        System.out.println("Remove owl");
        tree.remove("owl");
        System.out.println("tree : " + tree.toString());
        System.out.println("rootnode : " + tree.rootNode);

        System.out.println();
        TreePrinter.print(tree.rootNode, false);

        System.out.println();
        System.out.println("Remove cow");
        tree.remove("cow");
        System.out.println("tree : " + tree.toString());
        System.out.println("rootnode : " + tree.rootNode);

        System.out.println();
        TreePrinter.print(tree.rootNode, false);

        System.out.println();
        System.out.println("Add asp");
        tree.add("asp");
        System.out.println("tree : " + tree.toString());
        System.out.println("rootnode : " + tree.rootNode);

        System.out.println();
        TreePrinter.print(tree.rootNode, false);

        System.out.println();
        System.out.println("Final : ");
        TreePrinter.print(tree.rootNode, false);

        System.out.println();
        System.out.println("Node affected version : ");
        List<List<Node>> version = tree.gethist();
        for (int i = 0; i < version.size(); ++i) {
            System.out.println(i + " : " + version.get(i).toString());
        }

        System.out.println();
        System.out.println("first value : " + tree.first());
        System.out.println("last value : " + tree.last());

        System.out.println("Select Version : ");
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        System.out.println("Version " + a + " : ");

        if (a == (version.size() - 1)) {
            TreePrinter.print(tree.rootNode, false);

        } else {
            TreePrinter.print((Node) tree.treehistory.get(a), false);
        }

    }

    public void testBalanced(BalancedPersistentDynamicSet tree) {
        System.out.println("tree : " + tree.toString());
        System.out.println("root : " + tree.rootNode);
        System.out.println();
        TreePrinter.print(tree.rootNode, true);

        System.out.println();
        System.out.println("Remove owl");
        tree.remove("owl");
        System.out.println("tree : " + tree.toString());
        System.out.println("root : " + tree.rootNode);

        System.out.println();
        TreePrinter.print(tree.rootNode, true);

        System.out.println();
        System.out.println("Remove cow");
        tree.remove("cow");
        System.out.println("tree : " + tree.toString());
        System.out.println("root : " + tree.rootNode);

        System.out.println();
        TreePrinter.print(tree.rootNode, true);

        System.out.println();
        System.out.println("Add asp");
        tree.add("asp");
        System.out.println("tree : " + tree.toString());
        System.out.println("rootnode : " + tree.rootNode);

        System.out.println();
        TreePrinter.print(tree.rootNode, true);

        System.out.println();
        System.out.println("Final : ");
        TreePrinter.print(tree.rootNode, true);

        System.out.println();
        System.out.println("History : ");
        for (int i = 0; i < tree.hist.size(); ++i) {
            System.out.println(i + " : " + tree.toString((Node) tree.hist.get(i)));
        }
        System.out.println(" Lastest : " + tree.toString());

        System.out.println();

        System.out.println("Select Version : ");
        Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        System.out.println("Version " + a + " : ");
        TreePrinter.print((Node) tree.hist.get(a), true);

    }
}
