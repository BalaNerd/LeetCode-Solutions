class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[src] = 0;
        for(int i = 0; i<=k;i++){
            int[] temp = Arrays.copyOf(dp,n);
            for(int[] x:flights){
                int u = x[0];
                int v = x[1];
                int w = x[2];
                if(dp [u] != Integer.MAX_VALUE && dp[u]+w<temp[v]){
                    temp[v] = dp[u] + w;
                }
            }
            dp = temp;
        } 
        return dp[dst] == Integer.MAX_VALUE?-1:dp[dst]; 
    }
}