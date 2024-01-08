import java.util.*;
class Solution {
    int dx[]={1,0,-1,0};
    int dy[]={0,-1,0,1};
    boolean check =false;
    int bfs(int sx,int sy,char[][] map)
    {
        int [][]dis=new int[map.length][map[0].length];
        for(int q=0;q<map.length;q++)
            for(int w=0;w<map[0].length;w++)
                dis[q][w]=-1;
        
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{sx,sy});
        dis[sx][sy]=0;
        while(!q.isEmpty())
        {
            int a[]=q.poll();
            int x=a[0];
            int y=a[1];
            for(int w=0;w<4;w++)
            {
                int nx=x+dx[w];
                int ny=y+dy[w];
                if(nx>=0 && ny>=0 && nx<map.length && ny<map[0].length && map[nx][ny]!='X' && dis[nx][ny]==-1)
                {
                    q.add(new int[]{nx,ny});
                    dis[nx][ny]=dis[x][y]+1;
                    
                    if(map[nx][ny]=='L' && check==false)
                    {
                        check=true;
                        return dis[nx][ny];
                    }
                    if(map[nx][ny]=='E' && check==true)
                        return dis[nx][ny];
                }
            }
        }
        return -1;
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        int sum=0;
        int sum2=0;
        int start[][]=new int [2][2];
        char map[][]=new char[maps.length][];
        for(int q=0;q<maps.length;q++)
            map[q]=maps[q].toCharArray();
        
        for(int q=0;q<map.length;q++)
        {
            for(int w=0;w<map[0].length;w++)
            {
                if(map[q][w]=='S')
                {
                    start[0][0]=q;
                    start[0][1]=w;
                }
                if(map[q][w]=='L')
                {
                    start[1][0]=q;
                    start[1][1]=w;
                }
            }
        }
        
        sum=bfs(start[0][0],start[0][1],map);
        sum2=bfs(start[1][0],start[1][1],map);
        
        if(sum!=-1&&sum2!=-1)
            answer=sum+sum2;
        else
            answer=-1;
        return answer;
    }
}