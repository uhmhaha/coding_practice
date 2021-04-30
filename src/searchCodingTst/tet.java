package searchCodingTst;

class Solution {
    public int solution(String s) {
        int answer = 0;
        return answer;
    }
    
    private String[] splitVar(String s, int size){
        String[] strArr = s.split("");
        
		return strArr;
        
    }
    public int[] solution(int[] prices) {
        int size = prices.length;
        int valtime = 0;
        int[] answer = new int[size];
        
        for(int i = 0; i < size-1; i++)
        {
            for(int j = 1; j < size; j ++)
            {
                if(prices[j] - prices[i] > 0)
                { 
                    valtime++;
                }
            }
            answer[i] = valtime;
            valtime = 0;
        }
        answer[size-1] = 0;
            
        return answer;
    }
}