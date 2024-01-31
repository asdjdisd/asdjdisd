import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        int max=A.length;
        int a[]=A.clone();
        int b[]=B.clone();
        int num=0;
        Arrays.sort(a);
        Arrays.sort(b);
        
        for(int q=0;q<max;q++)
            answer+=a[q]*b[max-(1+q)];
        for(int q=0;q<max;q++)
            num+=a[max-(1+q)]*b[q];
        answer=answer<num?answer:num;
        
        return answer;
    }
}