class Solution {
    public int minCostConnectPoints(int[][] points) {
        int V = points.length;
        int min_cost =0;
        boolean[] visited = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        Map<Integer , Integer> map = new HashMap<>();

        pq.offer(new int[]{0,0});
        while(!pq.isEmpty())
        {
            int[] p = pq.poll();
            int cost = p[0];
            int u = p[1];

            if(visited[u])
            {
                continue ;
            }
            visited[u] = true ;
            min_cost += cost;

            for(int v=0;v<V;v++)
            {
                if(!visited[v]){
                    int dist = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    if(dist < map.getOrDefault(v , Integer.MAX_VALUE))
                    {
                        map.put(v , dist);
                        pq.offer(new int[]{dist , v});
                    }
                }
            }
        }
        return min_cost;
    }
}