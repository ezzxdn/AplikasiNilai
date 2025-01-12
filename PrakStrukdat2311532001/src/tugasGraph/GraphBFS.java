package tugasGraph;
import java.util.*;

public class GraphBFS {

	    private int V;
	    private LinkedList<Integer> adj[];

	    // Create a graph
	    GraphBFS(int v) {
	        V = v;
	        adj = new LinkedList[v];
	        for (int i = 0; i < v; ++i)
	            adj[i] = new LinkedList();
	    }

	    // Add edges to the graph
	    void addEdge(int v, int w) {
	        adj[v].add(w);
	    }

	    // BFS algorithm
	    void BFS(int s) {
	        boolean visited[] = new boolean[V];
	        LinkedList<Integer> queue = new LinkedList();
	        visited[s] = true;
	        queue.add(s);

	        while (queue.size() != 0) {
	            s = queue.poll();
	            System.out.print(s + " ");

	            Iterator<Integer> i = adj[s].listIterator();
	            while (i.hasNext()) {
	                int n = i.next();
	                if (!visited[n]) {
	                    visited[n] = true;
	                    queue.add(n);
	                }
	            }
	        }
	    }

	    public static void main(String args[]) {
	        GraphBFS g = new GraphBFS(7);
	        g.addEdge(0, 1);
	        g.addEdge(0, 2);
	        g.addEdge(1, 2);
	        g.addEdge(2, 0);
	        g.addEdge(2, 3);
	        g.addEdge(3, 3);
	        g.addEdge(3, 4);
	        g.addEdge(4, 5);
	        g.addEdge(4, 2);
	        g.addEdge(5, 3);
	        g.addEdge(5, 6);
	        g.addEdge(6, 6);

	        //vertex 1 adalah node awal yang digunakan sebagai titik awal untuk menjelajahi grafik
	        System.out.println("Berikut ini adalah Breadth First Traversal yang dimulai dari simpul/vertex 1:" );
	        g.BFS(1);
	    }
}
