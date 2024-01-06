import java.util.*;
class Solution {
    int dx[]={1,0,-1,0};
    int dy[]={0,1,0,-1};
    List<Integer> l = new ArrayList<Integer>();
    int count=0;
    
    public int dfs(int x,int y,int[][] a)
    {
        count+=a[x][y];
        a[x][y]=0;
        for(int q=0;q<4;q++)
        {
            int nx=x+dx[q];
            int ny=y+dy[q];
            if(0<=nx&&nx<a.length&&0<=ny&&ny<a[0].length)
                if(a[nx][ny]!=0)
                    dfs(nx,ny,a);
        }
        return count;
    }
    
    public int[] solution(String[] maps) {
        int[][] a=new int[maps.length][maps[0].length()];
        for(int q=0;q<maps.length;q++)
        {
            maps[q]=maps[q].replace("X","0");
        }
        
        for(int q=0;q<maps.length;q++)
        {
            for(int w=0;w<maps[0].length();w++)
                a[q][w]=Integer.parseInt(maps[q].substring(w,w+1));
        }
        
        for(int q=0;q<a.length;q++)
        {
            for(int w=0;w<a[0].length;w++)
            {
                if(a[q][w]!=0)
                    l.add(dfs(q,w,a));
                count=0;
            }
        }
        int[] answer;
        Collections.sort(l);
        if(l.size()==0)
        {
            answer=new int[]{-1};
        }
        else
        {
            answer=new int[l.size()];
            for(int q=0;q<l.size();q++)
                answer[q]=l.get(q);
        }
        return answer;
    }
}