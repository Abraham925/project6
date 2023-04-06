package calc;

import java.util.Stack;
/**
 * Calc Storage
 * does all the calculations
 * 
 *
 * @author Abraham Austin
 * CS 245, Wheaton College
 * April 4, 2023
*/
public class CalcStorage {
    Stack<Integer> calc = new Stack<Integer>();//stack to hold the integers
    private StringBuilder screen;// StringBuilder to hold the screen input
    private StringBuilder currentNumber;//StringBuilder to hold the current number

    /**
     * 
     * Constructor initializes the screen and currentNumnber
     */
    public CalcStorage() {
        screen = new StringBuilder();
        currentNumber = new StringBuilder();
    }

    /**
     * writes the number on the calculator screen and saves it in addNumber
     * @param x - number
     * @param face
     */
    public void addNumber(int x, CalculatorFace face) {
        currentNumber.append(x);
        screen.append(x);
        face.writeToScreen(screen.toString());
    }
    /**
     * pushes the number to the stack
     */
    private void processNumber() {
        if (currentNumber.length() > 0) {
            calc.push(Integer.parseInt(currentNumber.toString()));
            currentNumber.setLength(0);
        }
    }
    /**
     * Calculates the numbers in the stack based on the given operator
     * @param x - operator
     * @param face
     */
    public void addOp(String x, CalculatorFace face) {
    	if(calc.size() >= 1) {
    		processNumber();
    	}
    	
    	
        switch (x) {
            case "C":
                face.writeToScreen("");
                calc = new Stack<Integer>();
                screen.setLength(0);
                currentNumber.setLength(0);
                break;
            case ".":
            	processNumber();
            	screen.setLength(0);
                face.writeToScreen(screen.toString());
                break;
            case "+":
            case "-":
            case "*":
            case "/":
                if (calc.size() >= 2) {
                    int op2 = calc.pop();
                    int op1 = calc.pop();
                    int result = 0;
                    switch (x) {
                        case "+":
                            result = op1 + op2;
                            break;
                        case "-":
                            result = op1 - op2;
                            break;
                        case "*":
                            result = op1 * op2;
                            break;
                        case "/":
                            if (op2 != 0) {
                                result = op1 / op2;
                            }
                            break;
                    }
                    calc.push(result);
                    screen.setLength(0);
                    screen.append(result);
                    face.writeToScreen(screen.toString());
                }//else if(Integer.parseInt(currentNumber.toString()) == 1) {
                	
                //}
                break;
            case "=":
                if (!calc.empty()) {
                    face.writeToScreen(String.valueOf(calc.peek()));
                }
                break;
        }
    }


    /**
     * toggles the plus or minus
     * @param face
     */
    public void togglePlusMinus(CalculatorFace face) {
        if (currentNumber.length() > 0) {
            int currentValue = Integer.parseInt(currentNumber.toString()) * -1;
            currentNumber.setLength(0);
            currentNumber.append(currentValue);
            processNumber();
            screen.setLength(0);
            screen.append(currentValue);
            face.writeToScreen(screen.toString());
            screen.setLength(0);
        }
        else if(calc.size() ==1){
        	int currentValue = calc.pop();
        	currentValue = currentValue * -1;
        	calc.push(currentValue);
        	screen.setLength(0);
            screen.append(currentValue);
            face.writeToScreen(screen.toString());

        }
    }
}

