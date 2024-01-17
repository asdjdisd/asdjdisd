import java.util.*;
class Solution {
    Set<Integer> l = new HashSet<>();
    Set<Integer> check = new HashSet<>();
    void dfs(int[][] wires,int a)
    {
        l.add(wires[a][0]);
        l.add(wires[a][1]);
        check.add(a);
        for(int q=0;q<wires.length;q++)
        {
            if(check.contains(q))
                continue;
            if(l.contains(wires[q][1])||l.contains(wires[q][0]))
                dfs(wires,q);
        }
    }
    public int solution(int n, int[][] wires) {
        int answer=n;
        int wir[][]=new int[wires.length-1][];
        for(int q=0;q<wires.length;q++)
        {
            for (int w=0,e=0;w<wires.length;w++) 
            {
                if (w==q)
                    continue;
                wir[e] = wires[w].clone();
                e++;
            }
            check.clear();
            l.clear();
            dfs(wir,0);
            int a=Math.abs(n-l.size()*2);
            answer=Math.min(answer,a);
        }
        return answer;
    }
}