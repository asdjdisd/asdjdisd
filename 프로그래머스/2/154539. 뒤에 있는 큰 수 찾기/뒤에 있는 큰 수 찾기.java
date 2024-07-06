import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int length=numbers.length;
        int[] answer = new int[length];
        answer[length-1]=-1;
        Stack<Integer> stack=new Stack<>();
        stack.add(numbers[length-1]);
        for(int q=length-1;q>0;q--)
        {
            if(numbers[q-1]>=numbers[q])
            {
                if(stack.peek()<=numbers[q-1])
                {
                    while(!stack.isEmpty())
                    {
                        stack.pop();
                        if(stack.isEmpty())
                        {
                            answer[q-1]=-1;
                            break;
                        }
                        if(stack.peek()>numbers[q-1])
                        {
                            answer[q-1]=stack.peek();
                            break;
                        }
                    }
                }
                else
                    answer[q-1]=stack.peek();
                 stack.add(numbers[q-1]);
            }
            else
            {
                answer[q-1]=stack.peek();
                stack.add(numbers[q-1]);
            }
        }
        return answer;
    }
}