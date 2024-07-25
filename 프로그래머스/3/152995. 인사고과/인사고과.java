import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        int num=1;
        int length=scores.length;
        int x=scores[0][0];
        int y=scores[0][1];
        Arrays.sort(scores,(a,b)->{
            return Integer.compare(b[1]+b[0],a[0]+a[1]);
        });
        for(int q=0;q<length;q++)
        {
            if(scores[q][0]==x&&scores[q][1]==y)
            {
                for(int w=0;w<q;w++)
                {
                    if(scores[w][0]>x&&scores[w][1]>y)
                        return -1;
                }
                return q+num;
            }
            
            int a=scores[q][0];
            int b=scores[q][1];
            for(int w=0;w<q;w++)
            {
                if(scores[w][0]>a&&scores[w][1]>b)
                {
                    num--;
                    break;
                }
            }
        }
        return -1;
    }
}