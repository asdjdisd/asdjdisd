import java.util.*;
class Solution {
    public boolean bfs(String[] place,int[] a)
    {
        int lenx=place[0].length();
        int leny=place.length;
        boolean[][] visited=new boolean[leny][lenx];
        visited[a[1]][a[0]]=true;
        Queue<int[]> st=new LinkedList<>();
        st.add(a);
        int[] movex={1,-1,0,0};
        int[] movey={0,0,1,-1};
        int num=0;
        while(!st.isEmpty()&&num<2)
        {
            num++;
            int stsize=st.size();
            for(int w=0;w<stsize;w++)
            {
                int[] check=st.poll();
                int x=check[0];
                int y=check[1];
                for(int e=0;e<4;e++)
                {
                    int nx=x+movex[e];
                    int ny=y+movey[e];
                    if(nx>=0&&nx<lenx&&ny>=0&&ny<leny&&!visited[ny][nx])
                    {
                        visited[ny][nx]=true;
                        if(place[ny].charAt(nx)=='P')
                            return true;
                        else if(place[ny].charAt(nx)=='O')
                            st.add(new int[]{nx,ny});
                    }
                }
            }
        }
        return false;
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int q=0;q<answer.length;q++)
            answer[q]=1;
        for(int q=0;q<places.length;q++)
            out:
            for(int w=0;w<places[q].length;w++)
                for(int e=0;e<places[q][w].length();e++)
                    if(places[q][w].charAt(e)=='P')
                        if(bfs(places[q],new int[]{e,w}))
                        {
                            answer[q]=0;
                            break out;
                        }
        return answer;
    }
}