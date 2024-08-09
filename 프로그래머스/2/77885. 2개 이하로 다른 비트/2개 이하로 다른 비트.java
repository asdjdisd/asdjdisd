import java.util.*;
class Solution {
    public long[] solution(long[] numbers) {
        int length=numbers.length;
        long[] answer = new long[length];
        for(int q=0;q<length;q++)
        {
            if(numbers[q]%2==0)
                answer[q]=numbers[q]+1;
            else
            {
                long check=numbers[q]/2;
                int num=0;
                int rem=Integer.MAX_VALUE;
                while(check!=1&&check>0)
                {
                    if(check%2==0)
                        rem=Math.min(num,rem);
                    check/=2;
                    num++;
                }
                if(rem==Integer.MAX_VALUE)
                    answer[q]=numbers[q]+(numbers[q]/2+1);
                else
                    answer[q]=numbers[q]+(long)Math.pow(2,rem);
            }
        }
        
        return answer;
    }
}