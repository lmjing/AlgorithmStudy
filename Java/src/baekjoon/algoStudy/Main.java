package baekjoon.algoStudy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        KruskalMSTGraph mst = new KruskalMSTGraph(sc.nextInt(), sc.nextInt());

        for (int i = 0; i < mst.E; i++)
            mst.setEdge(i, sc.nextInt(), sc.nextInt(), sc.nextInt());
        mst.KruskalMST();
    }

    public static class KruskalMSTGraph {
        public int V, E;
        public Edge[] edges;
        Subset[] subsets;

        public KruskalMSTGraph(int v, int e) {
            V = v;
            E =e;
            edges = new Edge[E];
            subsets = new Subset[V + 1];
        }

        public void setEdge(int i, int v1, int v2, int weight) {
            edges[i] = new Edge(v1, v2, weight);
        }

        public void KruskalMST() {
            Edge[] result = new Edge[V - 1];
            int e = 0;
            long sum = 0;

            for (int i = 1; i < V + 1; i++)
                subsets[i] = new Subset(i);

            Arrays.sort(edges);

            for (int i = 0; i < edges.length && e < V - 1; i++) {
                Edge edge = edges[i];
                int v1Root = find(edge.v1);
                int v2Root = find(edge.v2);

                if (v1Root != v2Root) {
                    sum += edge.weight;
                    result[e++] = edge;
                    union(subsets[v1Root], subsets[v2Root]);
                }
            }
            System.out.println(sum);
        }

        private void union(Subset x, Subset y) {
            //다르게 함.
            subsets[y.parent].parent = x.parent;
        }

        private int find (int v) {
            if (subsets[v].parent != v)
                subsets[v].parent = find(subsets[v].parent);
            return subsets[v].parent;
        }

        private class Subset {
            int parent, rank;

            public Subset(int parent) {
                this.parent = parent;
            }
        }

        public class Edge implements Comparable<Edge> {
            int v1, v2, weight;

            public Edge(int v1, int v2, int weight) {
                this.v1 = v1;
                this.v2 = v2;
                this.weight = weight;
            }

            @Override
            public int compareTo(Edge o) {
                return this.weight - o.weight;
            }
        }
    }
}