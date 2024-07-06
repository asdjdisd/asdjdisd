import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int num=0;
        int length=tangerine.length;
        int[] check=new int[10000001];

        for(int q:tangerine)
            check[q]++;
        
        Arrays.sort(check);
        int w=10000000;
        while(num<k&&w>=0)
        {
            num+=check[w];
            answer++;
            w--;
        }
        return answer;
    }
}