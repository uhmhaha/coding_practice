package searchCodingTst.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Stack {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = "";
		int stackIdx = -1;
		int stackSize = Integer.valueOf(br.readLine());
		int[] stack1 = new int[Integer.valueOf(stackSize)];
		int[] stack2= new int[Integer.valueOf(stackSize)];
		
		while( (input = br.readLine()).matches("0|1")) {
			if(input.equals("0")) {
				//push
				if(stackIdx == stackSize - 1) {
					System.out.println("overflow");
				}else {

					stackIdx++;
					stack1[stackIdx] = Integer.valueOf(br.readLine());
					//System.out.print(stack1[stackIdx]);
					if(stackIdx == stackSize-1)
						for(int att:stack1)
							System.out.print(att+" ");
				}
			}else if(input.equals("1")) {
				//pop
				if(stackIdx == -1) {
					System.out.println("underflow");
				}else {
					//pop
					System.arraycopy(stack1, 0, stack2, 0, stackIdx);
					System.arraycopy(stack2, 0, stack1, 0, stack2.length);
					stackIdx--;
					
				}
			}
		};
		
		for(int i = 0; i <= stackIdx; i++)
			System.out.print(stack1[i]+" ");
	}
	
}
