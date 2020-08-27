package InterviewPractice.Arrays;

import java.util.*;

public class CriticalRouters {

    public static void main(String[] args) {
        CriticalRouters solution = new CriticalRouters();
        ArrayList<ArrayList<Integer>> links = new ArrayList<>();

        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(0);
        a1.add(1);
        links.add(a1);

        ArrayList<Integer> a2 = new ArrayList<>();
        a2.add(0);
        a2.add(2);
        links.add(a2);

        ArrayList<Integer> a3 = new ArrayList<>();
        a3.add(1);
        a3.add(3);
        links.add(a3);

        ArrayList<Integer> a4 = new ArrayList<>();
        a4.add(2);
        a4.add(3);
        links.add(a4);

        ArrayList<Integer> a5 = new ArrayList<>();
        a5.add(2);
        a5.add(5);
        links.add(a5);

        ArrayList<Integer> a6 = new ArrayList<>();
        a6.add(5);
        a6.add(6);
        links.add(a6);

        ArrayList<Integer> a7 = new ArrayList<>();
        a7.add(3);
        a7.add(4);
        links.add(a7);

        List<Integer> result = solution.criticalRouters(7, 7, links);
        System.out.println(result);
    }
    private static List<Integer> criticalRouters(int numRouters, int numLinks,
                                                 ArrayList<ArrayList<Integer>> links){
        int[] disc = new int[numRouters], low = new int[numRouters];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.fill(disc, -1);

        // build graph
        for (int i = 0; i < links.size(); i++) {
            int from = links.get(i).get(0), to = links.get(i).get(1);
            if(!graph.containsKey(from))
                graph.put(from, new ArrayList<>());
            graph.get(from).add(to);
            if(!graph.containsKey(to))
                graph.put(to, new ArrayList<>());
            graph.get(to).add(from);
        }

        for (int i = 0; i < numRouters; i++) {
            if (disc[i] == -1) {
                dfs(i, low, disc, graph, res, i);
            }
        }

        Set<Integer> s = new HashSet<>();
        for(List<Integer> l: res){
            int f1 = l.get(0), f2=l.get(1);
            if(graph.get(f1).size() > 1 && !s.contains(f1))
                s.add(f1);
            if(graph.get(f2).size() > 1 && !s.contains(f2))
                s.add(f2);
        }
        return new ArrayList<>(s);

    }

    static int step = 0; // time when discover each vertex

    private static void dfs(int u, int[] low, int[] disc, Map<Integer, List<Integer>> graph, List<List<Integer>> res, int pre) {
        disc[u] = low[u] = ++step;
        for (int j = 0; j < graph.get(u).size(); j++) {
            int v = graph.get(u).get(j);
            if (v == pre) {
                continue;
            }
            if (disc[v] == -1) {
                dfs(v, low, disc, graph, res, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    res.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
