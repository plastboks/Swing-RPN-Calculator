/**
 * Created by alex on 8/28/14.
 */

package Model;

public class Stack {

    private double stack[];
    private int size;
    private int tos;

    public Stack(int size)
    {
        this.stack = new double[size];
        this.size = size;
        clear();
    }

    public void push(double item)
    {
        if (tos != stack.length)
            stack[++tos] = item;
    }

    public double pop()
    {
        if (tos < 0)
            return 0;
        else
            return stack[tos--];
    }

    public double[] getReverseStack()
    {
        double[] revStack = new double[size];

        if (tos < 0) return revStack;

        /**
         * Setup a tmp 'top of stack' value, because we
         * don't want to alter the real tos value.
         */
        int tmpTos = tos;

        for (int i=0; i<=tos; i++)
            revStack[i] = stack[tmpTos--];

        return revStack;
    }

    public void swap()
    {
        if (tos <= 0) return;

        double rightOperand = pop();
        double leftOperand = pop();
        push(rightOperand);
        push(leftOperand);
    }

    public void clear()
    {
        tos = -1;
    }

    public void multiply()
    {
        if (tos < 1) return;

        double rightOperand = pop();
        double leftOperand = pop();
        push(leftOperand * rightOperand);
    }

    public void divide()
    {
        if (tos < 1) return;

        double rightOperand = pop();
        double leftOperand = pop();
        push(leftOperand / rightOperand);
    }

    public void addition()
    {
        if (tos < 1) return;

        double rightOperand = pop();
        double leftOperand = pop();
        push(leftOperand + rightOperand);
    }

    public void subtract()
    {
        if (tos < 1) return;

        double rightOperand = pop();
        double leftOperand = pop();
        push(leftOperand - rightOperand);
    }

    public void sqrt()
    {
        if (tos < 0) return;
        push(Math.sqrt(pop()));
    }

    public void toggleScale()
    {
        if (tos < 0) return;

        double operand = pop();
        push(operand-(operand * 2));
    }

    public void reciprocal()
    {
        if (tos < 0) return;
        push(1/pop());
    }

    public void pow()
    {
        if (tos < 1) return;

        double exponent = pop();
        double base = pop();
        push(Math.pow(base, exponent));
    }

    public void sin()
    {
        if (tos < 0) return;
        push(Math.sin(pop()));
    }

    public void cos()
    {
        if (tos < 0) return;
        push(Math.cos(pop()));
    }

    public void tan()
    {
        push(Math.tan(pop()));
    }
}
