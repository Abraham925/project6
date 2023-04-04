package calc;

import java.awt.event.ActionListener;
import java.util.Stack;

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
	ListStack<Character> calc = new ListStack<Character>();
	private boolean neg;
	CalculatorFace face;
	
	public CalcStorage() {
		neg = false;
	}
	public int op1() {
		char operand1 = ' ';
		while(calc.top() != '.') {
			operand1 += calc.top();
			calc.pop();
		}calc.pop();
		return operand1 - '0';
	}
	
	public int op2() {
		char operand2 = ' ';
		while(calc.top() != null) {
			operand2 += calc.top();
			calc.pop();
		}
		
		return operand2 - '0';
	}

	public void addNumber(int x) {
		for(int i=0; i<10;i++) {
			if(i==x) {
				char f = (char)x;
				calc.push(f);
			}
		}

	}
	public void addOp(char x) {
		int sum = 0;
		int mod = 0;
		switch(x) {
			case('C'):
				face.writeToScreen("");
				while(calc.top() != null) {
					calc.pop();
				}; break;
			case('.'): calc.push(x); break;
			case('+'): sum = op1() + op2();
					   while(sum != 0) {
						    mod = sum%10;
							calc.push((char)mod);
							sum = sum/10;
					   }break;
			case('-'): sum = op1() - op2();
					   while(sum != 0) {
						   mod = sum%10;
						   calc.push((char)mod);
						   sum = sum/10;
					   }break;
			case('*'): sum = op1() * op2();
					   while(sum != 0) {
						   mod = sum%10;
						   calc.push((char)mod);
						   sum = sum/10;
					   }break;
			case('/'): 
			if(op2()!=0) {
				sum = op1() / op2();
			    while(sum != 0) {
				    mod = sum%10;
					calc.push((char)mod);
					sum = sum/10;
			    }
			}break;
		}
		
		calc.push('.');
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
