/**
 * Created by alex on 8/28/14.
 */

package Controller;

import Model.Stack;

public class MainController {

    private Stack stack = new Stack(100);

    public double[] getStack()
    {
        return stack.getReverseStack();
    }

    public void pushToStack(String str)
    {
        stack.push(Double.parseDouble(str));
    }

    public void operateOnStack(String key)
    {
        switch (key) {
            case "*":
                stack.multiply();
                break;
            case "/":
                stack.divide();
                break;
            case "+":
                stack.addition();
                break;
            case "-":
                stack.subtract();
                break;
            case "Drop":
                stack.pop();
                break;
            case "Swap":
                stack.swap();
                break;
            case "Clear":
                stack.clear();
                break;
            case "Sqrt":
                stack.sqrt();
                break;
            case "+/-":
                stack.toggleScale();
                break;
            case "1/x":
                stack.reciprocal();
                break;
            case "Y^x":
                stack.pow();
                break;
            case "Sin":
                stack.sin();
                break;
            case "Cos":
                stack.cos();
                break;
            case "Tan":
                stack.tan();
                break;
        }
    }
}
