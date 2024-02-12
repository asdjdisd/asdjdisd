import java.util.*;
class Solution {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int answer=arr[arr.length-1];
        
        while(true){
            boolean check=true;
            for(int q=0;q<arr.length;q++)
                if(answer%arr[q]!=0)
                    check=false;
            if(check)
                break;
            answer+=arr[arr.length-1];
        }
        
        return answer;
    }
}