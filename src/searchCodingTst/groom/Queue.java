package searchCodingTst.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//
public class Queue {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inputTime = Integer.valueOf(br.readLine());
		int inputCurrentNum = 0;
		String[] queue = new String[10];
		//String[] qforCopy = new String[10];
		String input = "";
		int putIdx = -1;
		int popIdx = 0;
		String result = "";
		
		while(inputCurrentNum < inputTime
				&& (input = br.readLine()).matches("d|D|e|E")) {
			if(input.matches("e|E")){
				if(9 < inputCurrentNum)
					System.out.println("overflow");
				else {
					System.out.println("inputCurrentNum : " + inputCurrentNum);
					//queuing
					queue[++putIdx] = br.readLine();
				}
			}else if(input.matches("d|D")){
				if(popIdx > putIdx) {
					System.out.println("underflow");
				}else {
					//deQueuing
					//System.arraycopy(queue, 1, qforCopy, 0, inputIdx);
					//System.arraycopy(qforCopy, 0, queue, 0, qforCopy.length);
					popIdx++;
				}
			}
			inputCurrentNum++;
			System.out.println("inputCurrentNum" + inputCurrentNum);
		}
		
		for(int i= popIdx; i <= putIdx; i++) {
			if(queue[i] != null)
				result = result + queue[i];
			 	
			if(i != putIdx)
				result = result + " ";
		}
		System.out.print(result);
	}
	
	
}
