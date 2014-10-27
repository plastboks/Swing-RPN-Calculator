/**
 * Created by alex on 10/23/14.
 */

package type;

public interface Numeric<T>
{
    public double radToDeg = Math.PI/200;

    T div(T other);
    T mul(T other);
    T sub(T other);
    T add(T other);
    T mod(T other);
    T pow(T other);
    T pow2();
    T sqrt();
    T toggleScale();
    T reciprocal();
    T ln();
    T log();
    T fact();
    T abs();
    T sin();
    T sinDeg();
    T sinGrad();
    T cos();
    T cosDeg();
    T cosGrad();
    T tan();
    T tanDeg();
    T tanGrad();
    T sign();
    T cot();
}
