package Playground;

public class NumberOfProvinces {
    //union find O(N) and O(1)
    class Solution {
        public int findCircleNum(int[][] isConnected) {
            if (isConnected.length == 1 && isConnected[0].length == 1) {

                return 1;
            }
            int n = isConnected.length;

            UnionFind union = new UnionFind(n);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isConnected[i][j] == 1 && i!=j) {
                        union.merge(i, j);
                        if (union.setCount == 1) {
                            break;
                        }
                    }
                }
            }

            //System.out.println(Arrays.toString(union.parent));

            return union.setCount;
        }

        class UnionFind {
            int setCount;
            int[] parent;
            int[] rank;

            public UnionFind(int n) {
                parent = new int[n];
                rank = new int[n];
                setCount = n;

                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    rank[i] = 1;
                }
            }

            private int find(int city) {
                if (city == parent[city]) {
                    return city;
                } else {
                    return parent[city] = find(parent[city]);
                }
            }

            private void merge(int city1, int city2) {
                if (setCount == 1) {
                    return;
                }

                int root1 = find(city1);
                int root2 = find(city2);
                if (root1 != root2) {
                    if (rank[root1] > rank[root2]){
                        parent[root2]= root1;
                    } else if (rank[root2] > rank[root1]) {
                        parent[root1] = root2;
                    } else {
                        rank[root2]++;
                        parent[root1] = root2;
                    }
                    setCount--;
                }


            }

        }
    }
}
