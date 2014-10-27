/**
 * Created by alex on 10/23/14.
 */

package type;

public class RichInt implements Numeric<RichInt>
{
    private int i;

    private RichInt(int i)
    {
        this.i = i;
    }

    public static RichInt of(int i)
    {
        return new RichInt(i);
    }

    public static RichInt parseInt(String s)
    {
        return RichInt.of(Integer.parseInt(s));
    }

    @Override
    public RichInt div(RichInt other)
    {
        return RichInt.of(this.i / other.i);
    }

    @Override
    public RichInt mul(RichInt other)
    {
        return RichInt.of(this.i * other.i);
    }

    @Override
    public RichInt sub(RichInt other)
    {
        return RichInt.of(this.i - other.i);
    }

    @Override
    public RichInt add(RichInt other)
    {
        return RichInt.of(this.i + other.i);
    }

    @Override
    public RichInt mod(RichInt other)
    {
        return RichInt.of(this.i % other.i);
    }

    @Override
    public RichInt pow(RichInt other)
    {
        /* backwards because of stack poping */
        return RichInt.of((int)Math.pow(other.i, this.i));
    }

    @Override
    public RichInt pow2()
    {
        return RichInt.of((int)Math.pow(this.i, 2));
    }

    @Override
    public RichInt sqrt()
    {
        return RichInt.of((int)Math.sqrt(this.i));
    }

    @Override
    public RichInt toggleScale()
    {
        return RichInt.of(- this.i);
    }

    @Override
    public RichInt reciprocal()
    {
        return RichInt.of(1/this.i);
    }

    @Override
    public RichInt ln()
    {
        return RichInt.of((int)Math.log(this.i));
    }

    @Override
    public RichInt log()
    {
        return RichInt.of((int)Math.log10(this.i));
    }

    @Override
    public RichInt fact()
    {
        for (int i=this.i-1; i>0; i--)
            this.i *= i;

        return RichInt.of(this.i);
    }

    @Override
    public RichInt abs()
    {
        return RichInt.of(Math.abs(this.i));
    }

    @Override
    public RichInt sign()
    {
        return RichInt.of((int)Math.signum(this.i));
    }

    @Override
    public RichInt cot()
    {
        return RichInt.of((int)Math.cosh(this.i));
    }

    @Override
    public  RichInt sin()
    {
        return RichInt.of((int)Math.sin(this.i));
    }

    @Override
    public  RichInt sinDeg()
    {
        return RichInt.of((int)Math.sin(Math.toRadians(this.i)));
    }

    @Override
    public  RichInt sinGrad()
    {
        return RichInt.of((int)Math.sin(this.i*radToDeg));
    }

    @Override
    public  RichInt cos()
    {
        return RichInt.of((int)Math.cos(this.i));
    }

    @Override
    public  RichInt cosDeg()
    {
        return RichInt.of((int)Math.cos(Math.toRadians(this.i)));
    }

    @Override
    public  RichInt cosGrad()
    {
        return RichInt.of((int)Math.cos(this.i*radToDeg));
    }

    @Override
    public  RichInt tan()
    {
        return RichInt.of((int)Math.tan(this.i));
    }

    @Override
    public  RichInt tanDeg()
    {
        return RichInt.of((int)Math.tan(Math.toRadians(this.i)));
    }

    @Override
    public  RichInt tanGrad()
    {
        return RichInt.of((int)Math.tan(this.i*radToDeg));
    }

    @Override
    public String toString()
    {
        return String.format("%s", i);
    }
}
