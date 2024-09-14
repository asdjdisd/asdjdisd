import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int maxx=0;
        int maxy=0;
        int maxc=0;
        for(int q=0;q<points.length;q++)
        {
            maxx=Math.max(maxx,points[q][0]);
            maxy=Math.max(maxy,points[q][1]);
        }
        int[][][] map=new int[maxx+1][maxy+1][15000];
        
        for(int q=0;q<routes.length;q++)
        {
            int check=0;
            int ax;
            int ay;
            int bx;
            int by;
            for(int w=1;w<routes[q].length;w++)
            {
                ax=points[routes[q][w-1]-1][0];
                ay=points[routes[q][w-1]-1][1];
                bx=points[routes[q][w]-1][0];
                by=points[routes[q][w]-1][1];
                
                if(check==0)
                    map[ax][ay][check]++;
                
                while(ax!=bx||ay!=by)
                {
                    if(ax!=bx)
                    {
                        if(bx>ax)
                            ax++;
                        else
                            ax--;
                    }
                    else
                    {
                        if(by>ay)
                            ay++;
                        else
                            ay--;
                    }
                    check++;
                    map[ax][ay][check]++;
                }
            }
            maxc=Math.max(maxc,check);
        }
        for(int q=0;q<map.length;q++)
        {
            for(int w=0;w<map[0].length;w++)
            {
                for(int e=0;e<maxc+1;e++)
                {
                    if(map[q][w][e]>=2)
                        answer++;
                }
            }
        }
        return answer;
    }
}