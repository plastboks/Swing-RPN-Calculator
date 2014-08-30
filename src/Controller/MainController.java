/**
 * Created by alex on 8/28/14.
 */

package Controller;

import Model.Stack;

public class MainController {

    private Stack stack = new Stack(10);

    public double[] getStack()
    {
        return stack.getReverseStack();
    }

    public void pushToStack(String str) throws
            StackOverflowError
    {
        if (stack.getSize() -1 == stack.getTos())
            throw new StackOverflowError("Stack Overflow!");
        stack.push(Double.parseDouble(str));
    }

    public void operateOnStack(String key) throws
            StackOperationError
    {
        /**
         * Operation that demands at least one element in stack
         */
        if (stack.getTos() < 0)
            throw new StackOperationError("Not enough elements in "+
                                          "stack for this operation");
        switch (key) {
            case "Drop":
                stack.pop();
                return;
            case "Clear":
                stack.clear();
                return;
            case "Sqrt":
                stack.sqrt();
                return;
            case "+/-":
                stack.toggleScale();
                return;
            case "1/x":
                stack.reciprocal();
                return;
            case "Sin":
                stack.sin();
                return;
            case "Cos":
                stack.cos();
                return;
            case "Tan":
                stack.tan();
                return;
        }
        /**
         * Operation that demands at least two elements in stack
         */
        if (stack.getTos() <= 0)
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
            case "Y^x":
                stack.pow();
                return;
            case "Swap":
                stack.swap();
                return;
        }
    }
}
