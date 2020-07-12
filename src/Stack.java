import jdk.jshell.spi.ExecutionControlProvider;

import java.util.Arrays;

public class Stack<T> {
    private int top;
    private T[] array;
    public Stack(){
        this.top = 0;
        this.array = (T[]) new Object[1];
    }
    
    public void push(T value)
    {
        _growIfNeeded();
        array[top++] = value;
    }

    public T pop() throws Exception
    {
        if (top == 0)
            throw new Exception("No elements in stack");
        T value = array[--top];
        _shrinkIfNeeded();
        return value;
    }

    private void _shrinkIfNeeded()
    {
        if (top == array.length/4)
        {
            T[] newArray = (T[]) new Object[array.length/2];
            for (int i = 0; i < top; i++)
            {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    private void _growIfNeeded()
    {
        if (top == array.length)
        {
            T[] newArray =  (T[]) new Object[2*array.length];
            for (int i = 0; i < array.length; i++)
            {
                newArray[i] = array[i];
            }
            array = newArray;
        }
    }

    public String toString()
    {
        String retVal = "";
        for (int i = 0; i < top; i++)
        {
            retVal += String.valueOf(array[i]);
            if (i != top-1)
                retVal += ",";
        }
        return retVal;
    }

    public static void main(String[] args)
    { }
}
