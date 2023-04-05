package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
