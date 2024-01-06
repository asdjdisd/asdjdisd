class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        int h=0;
        int a=0;
        int max=health;
        for(int q=0;q<=attacks[attacks.length-1][0];q++)
        {  
            if(q==attacks[a][0])
            {
                health -= attacks[a][1];
                if(health<=0)
                {
                    health = -1;
                    break;
                }
                a++;
                h=0;
            }
            else
            {
                h++;
                health+=bandage[1];
                if(h==bandage[0])
                {
                    health+=bandage[2];
                    h=0;
                }
                if(health>max)
                    health=max;
            }
        }
        answer=health;
        return answer;
    }
}