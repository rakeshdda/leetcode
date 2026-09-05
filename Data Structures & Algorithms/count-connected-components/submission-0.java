class Solution {
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i< n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int count =0;

        boolean[] visited= new boolean[n];

        for(int i=0; i< n; i++){
            if(!visited[i]){
                dfs(i, adj, visited);

                count++;
            }
        }
        return count;
    }

    public void dfs(int start,  ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[start] = true;

        for(int neighbour: adj.get(start)){
            if(!visited[neighbour]){
                dfs(neighbour, adj, visited);
            }
        }


    }
}
