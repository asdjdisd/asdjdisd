import java.util.*;
class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack=new Stack<>();
        int length=order.length;
        List<Integer> list=new ArrayList<>();
        for(int q=1;q<=length;q++)
            list.add(q);
        int n=0;
        int check=0;
        while(check<length&&n<=list.size())
        {
            if(n<list.size()&&list.get(n)==order[check])
            {
                answer++;
                n++;
                check++;
            }
            else if(!stack.isEmpty()&&stack.peek()==order[check])
            {
                stack.pop();
                check++;
                answer++;
            }
            else
            {
                if(n<list.size())
                    stack.add(list.get(n));
                n++;
            }
            
            
        }
        return answer;
    }
}