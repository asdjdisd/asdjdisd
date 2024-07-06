import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Queue<String>que=new LinkedList<>();
        for(int q=0;q<10;q++)
        {
            que.add(discount[q]);
            for(int w=0;w<want.length;w++)
            {
                if(want[w].equals(discount[q]))
                    number[w]--;
            }
        }
        
        int check=0;
        for(int w=0;w<number.length;w++)
            if(number[w]<=0)
                check++;
        if(check==number.length)
            answer++;
        
        for(int q=10;q<discount.length;q++)
        {
            que.add(discount[q]);
            String checka=que.remove();
            for(int w=0;w<want.length;w++)
            {
                if(want[w].equals(discount[q]))
                    number[w]--;
                if(want[w].equals(checka))
                    number[w]++;
            }
            
            check=0;
            for(int w=0;w<number.length;w++)
                if(number[w]<=0)
                    check++;
            if(check==number.length)
                answer++;
        }
        return answer;
    }
}