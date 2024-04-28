package Playground;

import java.util.*;

public class MinimumHeightTree {

    class Solution {
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {

            List<Integer> result = new ArrayList<>();

            if(n==1){
                result.add(0);
                return result;
            }

            HashMap<Integer, HashSet> map = new HashMap<>();
            int[] indep = new int[n];

            for(int i=0; i<edges.length; i++){
                int[] edge = edges[i];
                int a = edge[0];
                int b = edge[1];
                indep[a]++;
                indep[b]++;

                if(!map.containsKey(a)){
                    HashSet<Integer> adj = new HashSet<>();
                    adj.add(b);
                    map.put(a, adj);
                }else{
                    map.get(a).add(b);
                }

                if(!map.containsKey(b)){
                    HashSet<Integer> adj = new HashSet<>();
                    adj.add(a);
                    map.put(b, adj);
                }else{
                    map.get(b).add(a);
                }

            }

            Queue<Integer> q = new LinkedList<>();
            for(int i=0; i<n; i++){
                if(indep[i]==1){
                    q.add(i);
                }
            }

            HashSet<Integer> visited = new HashSet<>();

            while(visited.size()<(n-2)){
                int size = q.size();

                while(size>0){
                    int curr = q.remove();
                    visited.add(curr);
                    HashSet adj = map.get(curr);
                    Iterator<Integer> it =adj.iterator();
                    while(it.hasNext()){
                        int node = it.next();
                        map.get(node).remove(curr);
                        indep[node]--;
                        if(indep[node]==1){
                            q.add(node);
                        }
                    }
                    size--;
                }
            }

            while(!q.isEmpty()){
                result.add(q.remove());
            }

            return result;
        }
    }
}
