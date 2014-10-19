package model;

/**
 * Created by alex on 10/19/14.
 */
public class StackArithmetic extends Stackend {

    private double radToDeg = Math.PI/200;

    public void multiply()
    {
        if (hasTwo() == false) return;

        double rightOperand = pop();
        double leftOperand = pop();
        push(leftOperand * rightOperand);
    }

    public void divide()
    {
        if (hasTwo() == false) return;

        double rightOperand = pop();
        double leftOperand = pop();
        push(leftOperand / rightOperand);
    }

    public void addition()
    {
        if (hasTwo() == false) return;

        double rightOperand = pop();
        double leftOperand = pop();
        push(leftOperand + rightOperand);
    }

    public void subtract()
    {
        if (hasTwo() == false) return;

        double rightOperand = pop();
        double leftOperand = pop();
        push(leftOperand - rightOperand);
    }

    public void modulus()
    {
        if (hasTwo() == false) return;

        double rightOperand = pop();
        double leftOperand = pop();
        push(leftOperand % rightOperand);
    }

    public void pow()
    {
        if (hasTwo() == false) return;

        double exponent = pop();
        double base = pop();
        push(Math.pow(base, exponent));
    }

    // -- one operand functions -- //
    public void sqrt()
    {
        if (isEmpty()) return;
        push(Math.sqrt(pop()));
    }

    public void toggleScale()
    {
        if (isEmpty()) return;

        double operand = pop();
        push(operand-(operand * 2));
    }

    public void reciprocal()
    {
        if (isEmpty()) return;
        push(1/pop());
    }

    public void pow(int exp)
    {
        if (isEmpty()) return;

        double base = pop();
        push(Math.pow(base, exp));
    }

    public void sin(String trigMode)
    {
        if (isEmpty()) return;

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
        if (isEmpty()) return;

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
        if (isEmpty()) return;

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
        if (isEmpty()) return;

        push(Math.log(pop()));
    }

    public void log()
    {
        if (isEmpty()) return;

        push(Math.log10(pop()));
    }

    public void factorial()
    {
        if (isEmpty()) return;

        int f = (int)pop();
        for (int i=f-1; i>0; i--)
            f *= i;

        push((double)f);
    }

    public void abs()
    {
        if (isEmpty()) return;

        push(Math.abs(pop()));
    }

    public void sign()
    {
        if (isEmpty()) return;

        push(Math.signum(pop()));
    }

    public void cot(String trigMode)
    {
        if (isEmpty()) return;

        push(Math.cosh(pop()));
    }
}
