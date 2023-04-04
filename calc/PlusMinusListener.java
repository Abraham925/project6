package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * PlusMinusListener
 * 
 * adds an action to the plusminus button
 *
 * @author Abraham Austin
 * CS 245, Wheaton College
 * Feb 13, 2023
*/

public class PlusMinusListener implements ActionListener {

	CalcStorage storage;
	CalculatorFace face;
	
	PlusMinusListener(CalculatorFace face, CalcStorage storage){
		this.storage = storage;
		this.face = face;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		storage.setNeg();
	}

}
