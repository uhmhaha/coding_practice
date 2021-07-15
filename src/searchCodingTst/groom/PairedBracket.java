package searchCodingTst.groom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class PairedBracket {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String value = "";
		Stack<String> stack = new Stack<>();
		String result = "False";
		for(int i = 0; i < input.length(); i++) {
			value = input.substring(i, i+1);
			if(value.matches("[(\\[{]")) {
				//push to array
				stack.push(value);
			}else {
				if(value.equals(")")) {
					if(stack.peek().equals("(")) {
						stack.pop();
					}else {
						result = "False";
						break;
					}
				}else if(value.equals("}")) {
					if(stack.peek().equals("{")) {
						stack.pop();
					}else {
						result = "False";
						break;
					}
				}else if(value.equals("]")) {
					if(stack.peek().equals("[")) {
						stack.pop();
					}else {
						result = "False";
						break;
					}
				}
			}
		}
		
		if(stack.size() == 0) {
			result = "True";
			System.out.println(result);
		}else {
			System.out.println(result);
		}
	}
}
		
//		if(value.equals(")")) {
//			if(input.substring(distance-1, distance).equals("(")) {
//				distance--;
//				result--;
//			}else {
//				result = 0;
//				break;
//			}
//		}else if(value.equals("}")) {
//			if(input.substring(distance, distance+1).equals("{")) {
//				distance--;
//				result--;
//			}else {
//				result = 0;
//				break;
//			}
//		}else if(value.equals("]")) {
//			if(input.substring(distance, distance+1).equals("[")) {
//				distance--;
//				result--;
//			}else {
//				result = 0;
//				break;
//			}
//		}
//
//	}
//		
//}
//if(result == -1) {
//	System.out.print("True");
//}else {
//	System.out.print("False");
//}
