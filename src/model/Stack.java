/**
 * Created by alex on 8/28/14.
 */

package model;

public class Stack {

    private double stack[];
    private int size;
    private int tos;
    private double radToDeg = Math.PI/200;

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

    public int getTos()
    {
        return tos;
    }

    public int getSize()
    {
        return size;
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

    // -- two operand functions -- //
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

    public void modulus()
    {
        if (tos < 1) return;

        double rightOperand = pop();
        double leftOperand = pop();
        push(leftOperand % rightOperand);
    }

    public void pow()
    {
        if (tos < 1) return;

        double exponent = pop();
        double base = pop();
        push(Math.pow(base, exponent));
    }

    // -- one operand functions -- //
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

    public void pow(int exp)
    {
        if (tos < 0) return;

        double base = pop();
        push(Math.pow(base, exp));
    }

    public void sin(String trigMode)
    {
        if (tos < 0) return;
        switch (trigMode) {
            case "DEG":
                push(Math.sin(Math.toRadians(pop())));
                return;
            case "RAD":
                push(Math.sin(pop()));
                return;
            case "GRAD":
                push(Math.sin(pop()*radToDeg));
                return;
        }
    }

    public void cos(String trigMode)
    {
        if (tos < 0) return;
        switch (trigMode) {
            case "DEG":
                push(Math.cos(Math.toRadians(pop())));
                return;
            case "RAD":
                push(Math.cos(pop()));
                return;
            case "GRAD":
                push(Math.cos(pop()*radToDeg));
                return;
        }
    }

    public void tan(String trigMode)
    {
        if (tos < 0) return;
        switch (trigMode) {
            case "DEG":
                push(Math.tan(Math.toDegrees(pop())));
                return;
            case "RAD":
                push(Math.tan(pop()));
                return;
            case "GRAD":
                push(Math.tan(pop()*radToDeg));
                return;
        }
    }

    public void ln()
    {
        if (tos < 0) return;
        push(Math.log(pop()));
    }

    public void log()
    {
        if (tos < 0) return;
        push(Math.log10(pop()));
    }

    public void factorial()
    {
        if (tos < 0) return;
        int f = (int)pop();
        for (int i=f-1; i>0; i--)
            f *= i;

        push((double)f);
    }

    public void abs()
    {
        if (tos < 0) return;
        push(Math.abs(pop()));
    }

    public void sign()
    {
        if (tos < 0) return;
        push(Math.signum(pop()));
    }

    public void cot(String trigMode)
    {
        if (tos < 0) return;
        push(Math.cosh(pop()));
    }
}
