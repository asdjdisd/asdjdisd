import java.util.*;
class Solution {
    int bfs(String a,String b,String[] wo)
    {
        int count=0;
        Queue<String> qu=new LinkedList<>();
        qu.add(a);
        while(!qu.isEmpty())
        {
            int size=qu.size();
            for(int q=0;q<size;q++)
            {
                String z=qu.poll();
                if(z.equals(b))
                    return count;
                for(int w=0;w<wo.length;w++)
                {
                    int num=0;
                    for(int e=0;e<wo[w].length();e++)
                        if(z.charAt(e)!=wo[w].charAt(e))
                            num++;
                    if(num==1)
                        qu.add(wo[w]);
                }
            }
            count++;
        }
        return -1;
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean a=false;
        for(int q=0;q<words.length;q++)
            if(target.equals(words[q]))
                a=true;
        if(a)
            answer=bfs(begin,target,words);
        else
            return 0;
        
        return answer;
    }
}