import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int answer = 0;
        int check=0;
        int length=enemy.length;

        while(true)
        {
            if(answer>=length)
                break;
            
            heap.add(enemy[answer]);
            if(heap.size()>k)
                check+=heap.poll();
            
            if(n<check)
                break;
            answer++;
        }
        
        return answer;
    }
}