import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by gray on 15-10-03.
 */
class Node {
    Node(String name) {
        this.name = name;
    }

    void addNeighbors(String node) {
        neighbors.add(new Node(node));
    }

    Set<Node> neighbors;
    String name;
}
public class TornToPieces {

    private static ArrayList<String> search(String start, String end, HashMap<String, Node> graph) {

        ArrayDeque<Node> frontier = new ArrayDeque<Node>();

        Node current = graph.get(start);
        for (Node n: current.neighbors) {
            frontier.push(n);
        }

        while (!frontier.isEmpty()) {
            current = frontier.pop();
            if (current.name == end) {
                break;
            }

            for (Node n: current.neighbors) {
                frontier.push(n);
            }
        }
        ArrayList<String> path = new ArrayList<String>();
        if (current.name == end) {
           // Node parent = current.parent;
        }



        return path;
    }

    public static void main(String[] args) {
        Scanner scanny = new Scanner(System.in);

        int n = scanny.nextInt();
        HashMap<String, Node> graph = new HashMap<String, Node>();
        scanny.nextLine();

        for (int i = 0; i < n; i++) {
            String[] stuff = scanny.nextLine().split(" ");
            Node node;
            if (!graph.containsKey(stuff[0])) {
                node = new Node(stuff[0]);
            }
            else {
                node = graph.get(stuff[0]);
            }

            for (int j = 1; j < stuff.length; j++) {
                Node neighbor = new Node(stuff[j]);
                node.addNeighbors(stuff[j]);

                if (!graph.containsKey(stuff[j]))
                    graph.put(stuff[j], neighbor);

            }


            if (!graph.containsKey(stuff[0]))
                graph.put(stuff[0], node);
        }

        String start = scanny.next();
        String end = scanny.next();

        ArrayList<String> path = search(start, end, graph);

        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i < path.size() - 1)
                System.out.print(" ");
            else
                System.out.print("\n");
        }
    }
}
