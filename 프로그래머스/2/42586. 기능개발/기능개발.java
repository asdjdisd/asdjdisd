import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> l=new ArrayList<>();
        int a[]=new int[progresses.length];
        int b[]=new int[progresses.length];
        int check=0;
        int c=0;
        while(true)
        {
            if(check>=progresses.length)
                break;
            for(int q=0;q<progresses.length;q++)
            {
                progresses[q]+=speeds[q];
                if(progresses[q]>=100)
                {
                    progresses[q]=-1;
                    speeds[q]=0;
                }
            }
            if(progresses[check]<=-1)
            {
                c++;
                int d=check;
                while(true)
                {
                    d++;
                    if(d>=progresses.length)
                        break;
                    if(progresses[d]<=-1)
                        c++;
                    else
                        break;
                }
                check+=c;
                l.add(c);
                c=0;
            }
        }
        int[] answer = new int[l.size()];
        for(int q=0;q<l.size();q++)
            answer[q]=l.get(q);
        return answer;
    }
}