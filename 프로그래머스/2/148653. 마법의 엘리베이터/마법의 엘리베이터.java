import java.util.*;
class Solution {
    public int solution(int storey) {
        String size=Integer.toString(storey);
        int answer = 0;
        int num=storey;
        int checknum=0;

        for(int q=0;q<size.length();q++)
        {
            int check=(num/(int)Math.pow(10,q))%10;
            if(check==5)
                if(q+1<size.length()&&(num/(int)Math.pow(10,q+1))%10>=5)
                    num+=(10-check)*(int)Math.pow(10,q);
            if(check>5)
                num+=(10-check)*(int)Math.pow(10,q);
        }
        
        checknum=num-storey;
        int test=num;
        while(num!=0)
        {
            answer+=num%10;
            num/=10;
        }
        while(checknum!=0)
        {
            answer+=checknum%10;
            checknum/=10;
        }
        return answer;
    }
}