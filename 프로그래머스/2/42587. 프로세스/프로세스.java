import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        int check=priorities.length-1;
        Queue<int[]> qu = new LinkedList<>();
        for(int q=0;q<priorities.length;q++)
        {
            int a[]=new int[2];
            a[0]=priorities[q];
            if(q==location)
                a[1]=1;
            else
                a[1]=0;
            qu.add(a);
        }
        Arrays.sort(priorities);
        while(true)
        {
            int a[]=qu.poll();
            if(a[1]==1&&a[0]==priorities[check])
                break;
            else if(a[0]==priorities[check])
            {
                check--;
                answer++;
            }
            else
                qu.add(a);
        }
        return answer;
    }
}