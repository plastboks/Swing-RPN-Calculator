/**
 * Created by alex on 10/12/14.
 *
 * A simple stack implementation, a stackend...
 */

package model;

import types.Numeric;

import java.util.Iterator;

public class Stackend<Item extends Numeric> implements Iterable<Item>
{
    private Node first;
    private int N;

    private class Node
    {
        Item item;
        Node next;
    }

    public boolean isEmpty()
    {
        return first == null;
    }

    public boolean hasTwo()
    {
        return first.next != null;
    }

    public int size()
    {
        return N;
    }

    public int getTos()
    {
        return size();
    }

    public void push(Item item)
    {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Iterator<Item> iterator()
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>
    {
        private Node current = first;

        public boolean hasNext()
        {
            return current != null;
        }

        public void remove() {}

        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }

    }
}
