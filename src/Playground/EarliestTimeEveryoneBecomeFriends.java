package Playground;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EarliestTimeEveryoneBecomeFriends {

    // Implementation of DSU
    static class UnionFind {
        private int[] parent;
        private int[] rank;
        private int time;
        private int count;
        // Constructor to create and
        // initialize sets of N items
        public UnionFind(int N)
        {
            parent = new int[N];
            rank = new int[N];
            time = 0;
            count = N;
            // Creates N single item sets
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        // Function to find the set of
        // given item node
        public int find(int node)
        {
            if (node == parent[node])
                return node;
            return parent[node] = find(parent[node]);
        }
        // Function to perform the union of
        // two sets represented by u and v,
        // and update the value of time
        public void performUnion(int u, int v, int updatedTime)
        {
            if (count == 1)
                return;
            // Find current sets of u and v
            int rootX = find(u);
            int rootY = find(v);
            // Put smaller ranked item under
            // bigger ranked item if ranks
            // are different
            if (rootX != rootY) {
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                }
                else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                }
                else {
                    parent[rootX] = rootY;
                    rank[rootY] += 1;
                }
                // Update the value of the
                // current timestamp
                time = updatedTime;

                // Update the value of
                // set count
                count--;
            }
        }
        // Function to return current
        // set count
        public int getCount() { return count; }

        // Function to return current
        // time stamp
        public int getTime() { return time; }
    }

    class Main {
        private static int earliestTime(List<int[]> arr, int N)
        {
            arr.sort(Comparator.comparingInt(a -> a[2]));

            UnionFind unionFind = new UnionFind(N);

            for (int[] it : arr) {
                unionFind.performUnion(it[0], it[1], it[2]);
            }

            return unionFind.getCount() == 1
                    ? unionFind.getTime()
                    : -1;
        }

        public static void main(String[] args)
        {
            int N = 6;
            List<int[]> arr
                    = Arrays.asList(new int[][] { { 0, 1, 4 },
                    { 3, 4, 5 },
                    { 2, 3, 14 },
                    { 1, 5, 24 },
                    { 2, 4, 12 },
                    { 0, 3, 42 },
                    { 1, 2, 41 },
                    { 4, 5, 11 } });

            System.out.println(earliestTime(arr, N));
        }
    }
}
