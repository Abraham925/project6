package calc;

import java.awt.event.ActionEvent;

public class OperatorListener {
	CalculatorFace face;
	CalcStorage storage;
	char x;
	
	public OperatorListener(CalculatorFace face, char x, CalcStorage storage) {
		this.face = face;
		this.storage = storage;
		this.x = x;
	}
	public void actionPerformed(ActionEvent e) {
		storage.addOp(x);
	}
}
