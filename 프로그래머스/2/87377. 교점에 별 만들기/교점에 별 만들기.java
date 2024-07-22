import java.util.*;
class Solution {
    public String[] solution(int[][] line) {
        List<long[]> list=new ArrayList<>();
        long minx=Long.MAX_VALUE;
        long miny=Long.MAX_VALUE;
        long maxx=Long.MIN_VALUE;
        long maxy=Long.MIN_VALUE;
        
        for(int q=0;q<line.length;q++)
        {
            double a=line[q][0];
            double b=line[q][1];
            double e=line[q][2];
            for(int w=0;w<line.length;w++)
            {
                if(q==w)
                    continue;
                double c=line[w][0];
                double d=line[w][1];
                double f=line[w][2];
                if((a*d)-(b*c)==0)
                    continue;
                double xx=((b*f)-(e*d))/((a*d)-(b*c));
                double yy=((e*c)-(a*f))/((a*d)-(b*c));
                if(xx%1==0&&yy%1==0)
                {
                    long x=(long)xx;
                    long y=(long)yy;
                    long[] xy={x,y};
                    list.add(xy);
                    minx=minx>x?x:minx;
                    maxx=maxx<x?x:maxx;
                    miny=miny>y?y:miny;
                    maxy=maxy<y?y:maxy;
                }
            }
        }
        
        int xl=(int)(maxx-minx+1);
        int yl=(int)(maxy-miny+1);
        String[] answer=new String[yl];
        for(int q=0;q<yl;q++)
        {
            answer[q]=".";
            for(int w=0;w<xl-1;w++)
            {
                answer[q]+=".";
            }
        }
        
        for(int q=0;q<list.size();q++)
        {
            long[] xy=list.get(q);
            int x=(int)(xy[0]-minx);
            int y=(int)(maxy-xy[1]);
            answer[y]=answer[y].substring(0,x)+'*'+answer[y].substring(x+1);
        }
        
        return answer;
    }
}