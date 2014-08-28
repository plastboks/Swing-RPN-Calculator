package Model;

/**
 * Created by alex on 8/28/14.
 */
public class Stack {

    private int stack[];
    private int tos;

    public Stack(int size)
    {
        this.stack = new int[size];
        this.tos = -1;
    }

    public void push(int item)
    {
        if (tos != stack.length)
            stack[++tos] = item;
    }

    public int pop()
    {
        if (tos < 0)
            return 0;
        else
            return stack[tos--];
    }
}
