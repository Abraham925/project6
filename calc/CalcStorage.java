package calc;


/**
 * CalcStorage
 * 
 * Acts as a storage for the numbers and operator values
 *
 * @author Abraham Austin
 * CS 245, Wheaton College
 * Feb 13, 2023
*/

public class CalcStorage {
	ListStack<String> calc = new ListStack<String>();
	private boolean neg;
	private int op1;
	private int op2;
	private String screen; 
	
	public CalcStorage() {
		neg = false;
		op1 = 0;
		op2 = 0;
		screen = "";
	}
	
	public int saveOperand() {
		String operand1 = "";
	//need to check if the the operand is an integer or not
		while(!calc.empty()) {
			operand1 = String.valueOf(calc.top()) + operand1;
			calc.pop();
		}
		return Integer.parseInt(operand1);
	}
	

	public void addNumber(int x, CalculatorFace face) {
		for(int i=0; i<10;i++) {
			if(i==x) {
				
				calc.push(String.valueOf(x));
				screen += String.valueOf(x);
				face.writeToScreen(screen);
			}
		}

	}
	public void addOp(String x, CalculatorFace face) {
		screen+= x;
		face.writeToScreen(screen);
		switch(x) {
			case("C"):
				face.writeToScreen("");
				while(!calc.empty()) {
					calc.pop();
				}; 
				op1 = 0;
				op2 = 0;
				screen = "";break;
			case("."): op1 = saveOperand(); 
						face.writeToScreen("");
						break;
			case("+"): op2 = saveOperand();
						op1 = op1 + op2;
						screen = String.valueOf(op1);
						face.writeToScreen(screen);
					   op2 = 0;break;
			case("-"): op2 = saveOperand();
						op1 = op1 - op2;
						screen = String.valueOf(op1);
						face.writeToScreen(screen);
			   			op2 = 0;break;
			case("*"): op2 = saveOperand();
						op1 = op1 * op2;
						screen = String.valueOf(op1);
						face.writeToScreen(screen);
			   			op2 = 0;break;
			case("/"): 
			op2 = saveOperand();
			if(op2!=0) {
					op1 = op1/op2;
					screen = String.valueOf(op1);
					face.writeToScreen(screen);
				   op2 = 0;break;
			}break;
			case("="):face.writeToScreen(calc.top());
				      calc.pop();break;
		}
		
		
		
	}
	
	public void setNeg() {
		if(neg == true) {
			neg = false;
		}
		else {
			neg = true;
		}
	}
	public boolean neg() {
		return neg;
	}
}
