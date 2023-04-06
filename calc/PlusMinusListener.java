package calc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlusMinusListener implements ActionListener {
    private CalcStorage storage;
    private CalculatorFace face;

    public PlusMinusListener(CalculatorFace face, CalcStorage storage) {
        this.storage = storage;
        this.face = face;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	storage.togglePlusMinus(face);
    }
}
