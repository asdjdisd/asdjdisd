import java.util.*;
class Solution {
    public int solution(String s) {
        Stack<Integer> st=new Stack<>();
        int answer = 0;
        int length=s.length();
        if(length<=1)
            return 0;
        for(int q=0;q<length;q++)
        {
            int num=1;
            for(int w=0;w<length;w++)
            {
                if(s.charAt(w)=='(')
                    st.add(1);
                else if(s.charAt(w)=='{')
                    st.add(2);
                else if(s.charAt(w)=='[')
                    st.add(3);
                else if(s.charAt(w)==')')
                {
                    if(st.isEmpty()||st.pop()!=1)
                    {
                        num=0;
                        break;
                    }
                        
                }
                else if(s.charAt(w)=='}')
                {
                    if(st.isEmpty()||st.pop()!=2)
                    {
                        num=0;
                        break;
                    }
                }
                else if(s.charAt(w)==']')
                {
                    if(st.isEmpty()||st.pop()!=3)
                    {
                        num=0;
                        break;
                    }
                }
            }
            if(st.isEmpty())
                answer+=num;
            st.clear();
            s=s.substring(1)+s.charAt(0);//왼쪽으로 1개의 문자 회전
        }
        return answer;
    }
}