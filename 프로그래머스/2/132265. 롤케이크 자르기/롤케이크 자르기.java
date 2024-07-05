import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int check=0;
        int check2=0;
        int[] num=new int[10001];
        int[] num2=new int[10001];
        for(int q:topping)
            num[q]++;
        for(int q=0;q<10001;q++)
        {
            if(num[q]>0)
                check++;
        }
        for(int q=0;q<topping.length;q++)
        {
            num[topping[q]]--;
            if(num[topping[q]]==0)
                check--;
            
            if(num2[topping[q]]==0)
                check2++;
            num2[topping[q]]++;
            
            if(check==check2)
                answer++;
        }
        return answer;
    }
}