package calc;


/**
 * SetUp
 * 
 * Class to set up and start the calculator, plus
 * facilities for test-driving the calculator.
 *
 * @author Abraham Austin
 * CS 245, Wheaton College
 * April 4, 2023
*/
public class SetUp {

	/**
	 * Method for initializing the calculator internals and
	 * connecting them to the calculator face.
	 * @param face The component representing the user interface of 
	 * the calculator. 
	 */
	public static void setUpCalculator(CalculatorFace face) {

		CalcStorage storage = new CalcStorage();
		
		for(int i = 0; i<10; i++) {
			face.addNumberActionListener(i, new numberListener(face, i, storage));
		}
		
		face.addPlusMinusActionListener(new PlusMinusListener(face, storage));
		
		char[] opArray = new char[7];
		opArray[0] = '.';
		opArray[1] = '+';
		opArray[2] = '-';
		opArray[3] = '*';
		opArray[4] = '/';
		opArray[5] = '=';
		opArray[6] = 'C';
		for(int i = 0; i<opArray.length; i++) {
			face.addActionListener(opArray[i], new OperatorListener(face, opArray[i], storage));
		}
	}
	
	
	/**
	 * This main method is for your testing of your calculator.
	 * It will *not* be used during grading. Any changes you make
	 * to this method will be ignored at grading.
	 */
	public static void main(String[] args) {
		setUpCalculator(new PlainCalculatorFace());
	}

}
