/**
 * Created by alex on 10/19/14.
 */

package model;

import type.Numeric;

public class StackArithmetic<T extends Numeric<T>> extends Stackend<T> {

    public void multiply()
    {
        if (hasTwo() == false) return;

        push(pop().mul(pop()));
    }

    public void divide()
    {
        if (hasTwo() == false) return;

        push(pop().div(pop()));
    }

    public void addition()
    {
        if (hasTwo() == false) return;

        push(pop().add(pop()));
    }

    public void subtract()
    {
        if (hasTwo() == false) return;

        push(pop().sub(pop()));
    }

    public void modulus()
    {
        if (hasTwo() == false) return;

        push(pop().mod(pop()));
    }

    public void pow()
    {
        if (hasTwo() == false) return;

        push(pop().pow(pop()));
    }

    // -- one operand functions -- //
    public void pow2()
    {
        if (isEmpty()) return;
        push(pop().pow2());
    }

    public void sqrt()
    {
        if (isEmpty()) return;
        push(pop().sqrt());
    }

    public void toggleScale()
    {
        if (isEmpty()) return;

        push(pop().toggleScale());
    }

    public void reciprocal()
    {
        if (isEmpty()) return;
        push(pop().reciprocal());
    }

    public void sin(String trigMode)
    {
        if (isEmpty()) return;

        switch (trigMode) {
            case "RAD":
                push(pop().sin());
                return;
            case "DEG":
                push(pop().sinDeg());
                return;
            case "GRAD":
                push(pop().sinGrad());
                return;
        }
    }

    public void cos(String trigMode)
    {
        if (isEmpty()) return;

        switch (trigMode) {
            case "RAD":
                push(pop().cos());
                return;
            case "DEG":
                push(pop().cosDeg());
                return;
            case "GRAD":
                push(pop().cosGrad());
                return;
        }
    }

    public void tan(String trigMode)
    {
        if (isEmpty()) return;

        switch (trigMode) {
            case "RAD":
                push(pop().tan());
                return;
            case "DEG":
                push(pop().tanDeg());
                return;
            case "GRAD":
                push(pop().tanGrad());
                return;
        }
    }

    public void ln()
    {
        if (isEmpty()) return;

        push(pop().ln());
    }

    public void log()
    {
        if (isEmpty()) return;

        push(pop().log());
    }

    public void factorial()
    {
        if (isEmpty()) return;

        push(pop().fact());
    }

    public void abs()
    {
        if (isEmpty()) return;

        push(pop().abs());
    }

    public void sign()
    {
        if (isEmpty()) return;

        push(pop().sign());
    }

    public void cot(String trigMode)
    {
        if (isEmpty()) return;

        push(pop().cot());
    }
}
