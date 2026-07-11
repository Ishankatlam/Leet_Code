class Solution {

    List<Integer>[] graph;
    boolean[] vis;

    int vertices;
    int degreeSum;

    public int countCompleteComponents(int n, int[][] edges) {

        graph = new ArrayList[n];
        vis = new boolean[n];

        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (!vis[i]) {

                vertices = 0;
                degreeSum = 0;

                dfs(i);

                int edgeCount = degreeSum / 2;

                if (edgeCount == vertices * (vertices - 1) / 2)
                    ans++;
            }
        }

        return ans;
    }

    private void dfs(int node) {

        vis[node] = true;
        vertices++;

        degreeSum += graph[node].size();

        for (int nei : graph[node]) {
            if (!vis[nei])
                dfs(nei);
        }
    }
}