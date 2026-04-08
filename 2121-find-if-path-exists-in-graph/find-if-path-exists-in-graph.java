class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(i,new ArrayList<>());
        }
        for(int[] x:edges){
            map.get(x[0]).add(x[1]);
            map.get(x[1]).add(x[0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        boolean[] vis = new boolean[n];
        vis[source] = true;
        while(!q.isEmpty()){
            int a = q.poll();
            if(a==destination) return true;
            for(int x:map.get(a)){
                if(!vis[x]){
                    q.add(x);
                    vis[x] = true;
                }
            }
        }
        return false;
  
    }
    //return true;
}