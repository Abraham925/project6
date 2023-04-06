package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * OperatorListener 
 * calls the addOp function in CalcStorage
 * 
 * class to add actions to the numbers
 *
 * @author Abraham Austin
 * CS 245, Wheaton College
 * April 4, 2023
*/
public class OperatorListener implements ActionListener{
	CalculatorFace face;
	CalcStorage storage;
	char x;
	
	public OperatorListener(CalculatorFace face, char x, CalcStorage storage) {
		this.face = face;
		this.storage = storage;
		this.x = x;
	}
	public void actionPerformed(ActionEvent e) {
		storage.addOp(String.valueOf(x), face);
	}
}
