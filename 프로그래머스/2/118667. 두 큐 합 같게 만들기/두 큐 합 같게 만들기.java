import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue <Integer> que1=new LinkedList<>();
        Queue <Integer> que2=new LinkedList<>();
        int answer = 0;
        long sum1=0;
        long sum2=0;
        for(int q:queue1)
        {
            sum1+=q;
            que1.add(q);
        }
        for(int q:queue2)
        {
            sum2+=q;
            que2.add(q);
        }
        
        if((sum1+sum2)%2!=0)
            return -1;
        
        while(!que1.isEmpty()&&!que2.isEmpty()&&answer<=queue1.length*2+queue2.length*2)
        {
            if(sum1==sum2)
                return answer;
            else if(sum1>sum2)
            {
                int temp=que1.poll();
                sum1-=temp;
                sum2+=temp;
                que2.add(temp);
            }
            else
            {
                int temp=que2.poll();
                sum2-=temp;
                sum1+=temp;
                que1.add(temp);
            }
            answer++;
        }
        return -1;
    }
}