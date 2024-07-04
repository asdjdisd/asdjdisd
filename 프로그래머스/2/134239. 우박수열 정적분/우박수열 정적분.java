import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        int length=ranges.length;
        double[] answer = new double[length];
        List<Integer> list=new ArrayList<>();
        list.add(k);
        while(k>1)
        {
            if(k%2==0)
                k/=2;
            else 
                k=k*3+1;
            list.add(k);
            if(k<=1)
                break;
        }
        
        for(int q=0;q<length;q++)
        {
            int a=ranges[q][0];
            int b=list.size()+ranges[q][1]-1;
            double sum=0;

            if(a==b)
            {
                answer[q]=0.0;
                continue;
            }
            else if(a>b)
            {
                answer[q]=-1.0;
                continue;
            }
            
            for(int w=a;w<b;w++)
                sum+=list.get(w)+list.get(w+1);
            
            answer[q]=sum/2;
        }
        return answer;
    }
}