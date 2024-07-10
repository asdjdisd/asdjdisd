import java.util.*;
class Solution {
    int answer=0;
    public void dfs(int k, int[][] dun, boolean[] check,int n)
    {

        for(int q=0;q<dun.length;q++)
        {
            if(!check[q]&&k>=dun[q][0])
            {
                check[q]=true;
                dfs(k-dun[q][1],dun,check,n+1);
                check[q]=false;
            }
        }
        answer=Math.max(answer,n);
    }
    public int solution(int k, int[][] dungeons) {

        boolean[] check=new boolean[dungeons.length];
        dfs(k,dungeons,check,0);
        return answer;
    } 
}