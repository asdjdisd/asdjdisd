import java.util.*;
class Solution {
    public long time(int[] diffs, int[] times, int level, long num)
    {
        for(int q=1;q<diffs.length;q++)
        {
            if(level<diffs[q])
                num+=(times[q]+times[q-1])*(diffs[q]-level);
        }
        return num;
    }
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        long num=0;
        int length=times.length;
        for(int q=0;q<length;q++)
        {
            num+=times[q];
            answer=Math.max(answer,diffs[q]);
        }
        int a=1;
        int b=answer;
        
        while(true)
        {
            answer=(a+b)/2;
            long n=time(diffs,times,answer,num);
            if(n>limit)
                a=answer+1;
            else
            {
                long n2=time(diffs,times,answer-1,num);
                if(n2>limit)
                    break;
                else
                    b=answer-1;
            }
            if(answer<=1)
            {
                answer=1;
                break;
            }
        }
        return answer;
    }
}