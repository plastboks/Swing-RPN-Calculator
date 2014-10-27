/**
 * Created by alex on 10/23/14.
 */

package type;

public class RichDouble implements Numeric<RichDouble>
{
    private double d;

    private RichDouble(double d)
    {
        this.d = d;
    }

    public static RichDouble of(double d)
    {
        return new RichDouble(d);
    }

    public static RichDouble parseDouble(String s)
    {
        return RichDouble.of(Double.parseDouble(s));
    }

    @Override
    public RichDouble div(RichDouble other)
    {
        return RichDouble.of(this.d / other.d);
    }

    @Override
    public RichDouble mul(RichDouble other)
    {
        return RichDouble.of(this.d * other.d);
    }

    @Override
    public RichDouble sub(RichDouble other)
    {
        return RichDouble.of(this.d - other.d);
    }

    @Override
    public RichDouble add(RichDouble other)
    {
        return RichDouble.of(this.d + other.d);
    }

    @Override
    public RichDouble mod(RichDouble other)
    {
        return RichDouble.of(this.d % other.d);
    }

    @Override
    public RichDouble pow(RichDouble other)
    {
        return RichDouble.of(Math.pow(other.d, this.d));
    }

    @Override
    public RichDouble pow2()
    {
        /* backwards because of stack poping */
        return RichDouble.of(Math.pow(this.d, 2));
    }

    @Override
    public RichDouble sqrt()
    {
        return RichDouble.of(Math.sqrt(this.d));
    }

    @Override
    public RichDouble toggleScale()
    {
        return RichDouble.of(- this.d);
    }

    @Override
    public RichDouble reciprocal()
    {
        return RichDouble.of(1/this.d);
    }

    @Override
    public RichDouble ln()
    {
        return RichDouble.of(Math.log(this.d));
    }

    @Override
    public RichDouble log()
    {
        return RichDouble.of(Math.log10(this.d));
    }

    @Override
    public RichDouble fact()
    {
        for (int i = (int)this.d-1; i>0; i--)
            this.d *= i;

        return RichDouble.of(this.d);
    }

    @Override
    public RichDouble abs()
    {
        return RichDouble.of(Math.abs(this.d));
    }

    @Override
    public RichDouble sign()
    {
        return RichDouble.of(Math.signum(this.d));
    }

    @Override
    public RichDouble cot()
    {
        return RichDouble.of(Math.cosh(this.d));
    }

    @Override
    public  RichDouble sin()
    {
        return RichDouble.of(Math.sin(this.d));
    }

    @Override
    public  RichDouble sinDeg()
    {
        return RichDouble.of(Math.sin(Math.toRadians(this.d)));
    }

    @Override
    public  RichDouble sinGrad()
    {
        return RichDouble.of(Math.sin(this.d*radToDeg));
    }

    @Override
    public  RichDouble cos()
    {
        return RichDouble.of(Math.cos(this.d));
    }

    @Override
    public  RichDouble cosDeg()
    {
        return RichDouble.of(Math.cos(Math.toRadians(this.d)));
    }

    @Override
    public  RichDouble cosGrad()
    {
        return RichDouble.of(Math.cos(this.d*radToDeg));
    }

    @Override
    public  RichDouble tan()
    {
        return RichDouble.of(Math.tan(this.d));
    }

    @Override
    public  RichDouble tanDeg()
    {
        return RichDouble.of(Math.tan(Math.toRadians(this.d)));
    }

    @Override
    public  RichDouble tanGrad()
    {
        return RichDouble.of(Math.tan(this.d*radToDeg));
    }

    @Override
    public String toString()
    {
        return String.format("%s", d);
    }
}
