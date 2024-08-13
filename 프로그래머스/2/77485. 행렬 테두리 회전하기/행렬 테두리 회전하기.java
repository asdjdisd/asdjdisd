import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer =new int[queries.length];
        int[][] map=new int[rows][columns];
        int num=1;
        int min;
        for(int q=0;q<rows;q++)
        {
            for(int w=0;w<columns;w++)
            {
                map[q][w]=num;
                num++;
            }
        }
        for(int q=0;q<queries.length;q++)
        {
            int minx=queries[q][1]-1;
            int maxx=queries[q][3]-1;
            int miny=queries[q][0]-1;
            int maxy=queries[q][2]-1;
            
            int a=map[miny][minx];
            min=a;
            int b;
            for(int w=minx+1;w<=maxx;w++)
            {
                b=map[miny][w];
                map[miny][w]=a;
                a=b;
                min=Math.min(min,a);
            }
            for(int w=miny+1;w<=maxy;w++)
            {
                b=map[w][maxx];
                map[w][maxx]=a;
                a=b;
                min=Math.min(min,a);
            }
            for(int w=maxx-1;w>=minx;w--)
            {
                b=map[maxy][w];
                map[maxy][w]=a;
                a=b;
                min=Math.min(min,a);
            }
            for(int w=maxy-1;w>=miny;w--)
            {
                b=map[w][minx];
                map[w][minx]=a;
                a=b;
                min=Math.min(min,a);
            }
            answer[q]=min;
        }
        return answer;
    }
}