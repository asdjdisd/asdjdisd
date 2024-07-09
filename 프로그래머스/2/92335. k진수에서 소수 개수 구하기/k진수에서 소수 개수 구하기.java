import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder sb=new StringBuilder();
        while(n>0)
        {
            sb.insert(0,n%k);
            n/=k;
        }// 해당 진수로 변환
        String[] str=sb.toString().split("0");//0으로 스플릿
        for(int q=0;q<str.length;q++)
        {
            if(str[q].equals(""))
                continue;
            long num=Long.parseLong(str[q]);
            if(num==1)
                continue;
            boolean check=true;
            for(int w=2;w<=(int)Math.sqrt(num);w++)//소수확인
            {
                if(num%w==0)
                {
                    check=false;
                    break;
                }
            }
            if(check)
                answer++;
        }
        return answer;
    }
}