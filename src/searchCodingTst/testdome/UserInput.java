package searchCodingTst.testdome;

public class UserInput {
    
    public static class TextInput {
    	
    	String value = "";
    	
    	public void add(char str) {
    		value += str;
    	}
    	public String getValue() {
    		return value;
    	}
    }

    public static class NumericInput extends TextInput{
    	public void add(char ch) {
    		if( !Character.toString(ch).matches("[^$0-9.]"))
    			value += ch;
    	}
    	
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}
