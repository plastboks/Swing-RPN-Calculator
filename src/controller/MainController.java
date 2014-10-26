/**
 * Created by alex on 8/28/14.
 */

package controller;

import model.StackArithmetic;
import types.RichDouble;

public class MainController {

    private StackArithmetic<RichDouble> stack = new StackArithmetic<>();

    public RichDouble[] getStack()
    {
        int i = 0;
        RichDouble[] tmp = new RichDouble[stack.size()];

        for (RichDouble item: stack) {
            tmp[i] = item;
            i++;
        }
        return tmp;
    }

    public void pushToStack(String str) throws
            StackOverflowError
    {
        if (stack.getSize() -1 == stack.getTos())
            throw new StackOverflowError("Stack Overflow!");
        stack.push(RichDouble.parseDouble(str));
    }

    public void operateOnStack(String key, String trigMode) throws
            StackOperationError
    {
        /**
         * Operation that demands at least one element in stack
         */
        if (stack.getTos() <= 0)
            throw new StackOperationError("Not enough elements in "+
                                          "stack for this operation");
        switch (key) {
            case "Drop":
                stack.pop();
                return;
            case "Clear":
                stack.clear();
                return;
            case "sqrt":
                stack.sqrt();
                return;
            case "+/-":
                stack.toggleScale();
                return;
            case "1/x":
                stack.reciprocal();
                return;
            case "x^2":
                stack.pow2();
                return;
            case "sin":
                stack.sin(trigMode);
                return;
            case "cos":
                stack.cos(trigMode);
                return;
            case "tan":
                stack.tan(trigMode);
                return;
            case "ln":
                stack.ln();
                return;
            case "log":
                stack.log();
                return;
            case "n!":
                stack.factorial();
                return;
            case "abs":
                stack.abs();
                return;
            case "sign":
                stack.sign();
                return;
            case "cot":
                stack.cot(trigMode);
                return;
        }
        /**
         * Operation that demands at least two elements in stack
         */
        if (stack.getTos() < 2)
            throw new StackOperationError("Not enough elements in "+
                                          "stack for this operation");
        switch (key) {
            case "*":
                stack.multiply();
                return;
            case "/":
                stack.divide();
                return;
            case "+":
                stack.addition();
                return;
            case "-":
                stack.subtract();
                return;
            case "mod":
                stack.modulus();
                return;
            case "y^x":
                stack.pow();
                return;
            case "Swap":
                stack.swap();
                return;
        }
    }
}
