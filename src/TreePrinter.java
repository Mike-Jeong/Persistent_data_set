import java.util.*;

public class TreePrinter {
    public static void print(Node rootnode, boolean colour) {
        List<List<String>> lines = new ArrayList<List<String>>();

        List<Node> stage = new ArrayList<Node>();
        List<Node> next = new ArrayList<Node>();

        stage.add(rootnode);
        int num = 1;
        int wide = 0;

        while (num != 0) {
            List<String> line = new ArrayList<String>();
            num = 0;

            for (Node node : stage) {
                if (node == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String draw = node.toString(colour);
                    line.add(draw);
                    if (draw.length() > wide) {
                        wide = draw.length();
                    }

                    next.add(node.left);
                    next.add(node.right);

                    if (node.left != null) {
                        num++;
                    }
                    if (node.right != null) {
                        num++;
                    }
                }
            }

            if (wide % 2 == 1) {
                wide++;
            }
            lines.add(line);

            List<Node> tamp = stage;
            stage = next;
            next = tamp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (wide + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '|' : '|';
                        } else {
                            if (j < line.size() && line.get(j) != null) {
                                c = '|';
                            }
                        }
                    }
                    System.out.print(c);

                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "_");
                        }
                        System.out.print(j % 2 == 0 ? " " : " ");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "_" : " ");
                        }
                    }
                }
                System.out.println();
            }

            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) {
                    f = "";
                }
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perpiece /= 2;
        }
    }
}
