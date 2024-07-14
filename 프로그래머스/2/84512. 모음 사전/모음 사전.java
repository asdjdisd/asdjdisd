class Solution {
    public int solution(String word) {
        int answer = word.length();
        int[] num={781,156,31,6,1};
        int[] wor=new int[word.length()];
        for(int q=0;q<word.length();q++)
        {
            if(word.charAt(q)=='A')
                wor[q]=0;
            
            else if(word.charAt(q)=='E')
                wor[q]=1;
            
            else if(word.charAt(q)=='I')
                wor[q]=2;
            
            else if(word.charAt(q)=='O')
                wor[q]=3;
            
            else if(word.charAt(q)=='U')
                wor[q]=4;
            
        }
        for(int q=0;q<word.length();q++)
            answer+=num[q]*wor[q];
        
        return answer;
    }
}