import java.util.*;

class Stack
{
	private int arr[];
	private int top;
	private int capacity;

	Stack(int size)
	{
		arr = new int[size];
		capacity = size;
		top = -1;
	}
	
	public static Stack make(int size)
	{
		return new Stack(size);
	}

	public void push(int x)
	{
		arr[++top] = x;
	}

	public int pop()
	{
		if (isEmpty())
		{
			throw new NoSuchElementException();
		}

		return arr[top--];
	}

	public int size()
	{
		return top + 1;
	}

	public Boolean isEmpty()
	{
		return top == -1;
	}

	public Boolean isFull()
	{
		return top == capacity - 1;
	}
}
