import java.util.*;
class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set=new HashSet<>();
        int[] ele=new int[elements.length*2];
        for(int q=0;q<2;q++)
        {
            for(int w=0;w<elements.length;w++)
                ele[w+(elements.length*q)]=elements[w];
        }
        
        for(int q=0;q<elements.length;q++) 
        {       
            
            for(int w=0;w<elements.length;w++)
            {
                int num=0;
                for(int e=0;e<=w;e++)
                {
                    num+=ele[q+e];
                }
                set.add(num);
            }
        }
        
        return set.size();
    }
}