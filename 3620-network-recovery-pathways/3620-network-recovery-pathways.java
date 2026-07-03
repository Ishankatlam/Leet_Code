class Solution {
    static class Edge{
        int to ;
        int w ;
        Edge(int t , int w)
        {
            this.to = t;
            this.w = w;

        }
    }
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
       int n = online.length;

       List<Edge>[] graph = new ArrayList[n];

       for(int i=0;i<n;i++)
       {
        graph[i] = new ArrayList<>();
       }

       int[] indegree = new int[n];

       int maxEdge = 0;

       for(int[] e : edges)
       {
        graph[e[0]].add(new Edge(e[1], e[2]));
        indegree[e[1]]++;
        maxEdge = Math.max(maxEdge , e[2]);
       }
    

    Queue<Integer> q = new LinkedList<>();

    for(int i=0;i<n;i++)
        if(indegree[i] ==0) q.offer(i);


        List<Integer> topo = new ArrayList<>();

        while(!q.isEmpty())
        {
            int u = q.poll();

            topo.add(u);

            for(Edge e : graph[u])
            {
                if(--indegree[e.to]==0)
                {
                    q.offer(e.to);
                }
            }
        }
    

    int lo = 0;
    int hi = maxEdge;
    int ans = -1;

    while(lo <=hi)
    {
        int mid = lo + (hi-lo)/2;
        if(check(mid , graph , topo , online  ,  k , n)){
            ans = mid ;
            lo = mid + 1;
        }else 
        {
            hi = mid -1;
        }
    }
    
    return ans ;
}
     
    public boolean check(int limit , List<Edge>[] graph , List<Integer> topo , boolean[] online , long k, int n)
     {
         long INF = Long.MAX_VALUE/4;

         long[] dist = new long[n];
         Arrays.fill(dist , INF);

         dist[0] = 0;

         for(int u : topo)
         {
            if(dist[u] == INF)continue ;

            if(u != 0 && u != n-1 && !online[u])continue ;

            for(Edge e : graph[u]){
                if(e.w < limit)continue ;

                int v = e.to;

                if(v != n-1 && !online[v])continue ;

                dist[v] = Math.min(dist[v] , dist[u] + e.w);

            }
         }

         return dist[n-1] <=k ;
     } 










}