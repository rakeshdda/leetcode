class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        int V = numCourses;

        for(int i =0; i< V; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: prerequisites){
            int u = edge[0];
            int v = edge[1];

            adj.get(v).add(u);
        }


        int[] indi = new int[V];

        for(int i =0 ;i< V; i++){
            for(int neighbour: adj.get(i)){
                indi[neighbour]++;
            }
        }


        int count =0;

        Queue<Integer> queue = new LinkedList<>();

        for(int i=0; i< V; i++){
            if(indi[i] == 0){
                queue.offer(i);
                count++;
            }
        }

        while(!queue.isEmpty()){
            int curr = queue.poll();

            for(int neighbour: adj.get(curr)){
                indi[neighbour]--;

                if(indi[neighbour] == 0){
                    queue.offer(neighbour);
                    count++;
                }
            }
        }

        if(count == V){
            return true;
        }
        return false;
    }
}
