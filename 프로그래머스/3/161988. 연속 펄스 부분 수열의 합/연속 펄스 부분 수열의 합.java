import java.util.*;
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int[] a=new int[sequence.length];
        int[] b=new int[sequence.length];
        long max=a[0];
        for(int q=0;q<sequence.length;q++)
        {
            if(q%2==0)
                a[q]=sequence[q];
            else
                a[q]=sequence[q]*-1;
            max=Math.max(a[q],max+a[q]);
            answer=Math.max(answer,max);
        }
        max=b[0];
        for(int q=0;q<sequence.length;q++)
        {
            if(q%2==1)
                b[q]=sequence[q];
            else
                b[q]=sequence[q]*-1;
            max=Math.max(b[q],max+b[q]);
            answer=Math.max(answer,max);
        }
        return answer;
    }
}