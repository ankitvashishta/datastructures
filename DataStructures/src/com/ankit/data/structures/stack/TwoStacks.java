package com.ankit.data.structures.stack;

/**
 * Implement two stacks using a single array.
 * 
 * In this problem, using a single array to store elements, you have to
 * implement the class TwoStacks<V>, having the following methods to generate
 * two stacks.
 * 
 * void push1(V value)
 * 
 * void push2(V value)
 * 
 * public V pop1()
 * 
 * public V pop2()
 * 
 * In the below solution, we start at extreme ends for both the stacks - start
 * and end of array.
 * 
 * All the operations take constant time, i.e., O(1)O(1) because the array is
 * being indexed and not resized.
 * 
 * @author ankit
 *
 * @param <V>
 */
public class TwoStacks<V> {
	private int maxSize;
	private V[] array;
	private int top1;
	private int top2;

	@SuppressWarnings("unchecked")
	public TwoStacks(int max_size) {
		this.maxSize = max_size;
		array = (V[]) new Object[max_size];// type casting Object[] to V[]
		top1 = -1;
		top2 = max_size;
	}

	// insert at top of first stack
	public void push1(V value) {
		if (top1 < top2 - 1)
			array[++top1] = value;
	}

	// insert at top of second stack
	public void push2(V value) {
		if (top1 < top2 - 1)
			array[--top2] = value;
	}

	// remove and return value from top of first stack
	public V pop1() {
		if (top1 > -1)
			return array[top1--];
		return null;
	}

	// remove and return value from top of second stack
	public V pop2() {
		if (top2 < maxSize)
			return array[top2++];
		return null;
	}

	public static void main(String args[]) {
		TwoStacks<Integer> tS = new TwoStacks<Integer>(5);
		tS.push1(11);
		tS.push1(3);
		tS.push1(7);
		tS.push2(1);
		tS.push2(9);

		System.out.println(tS.pop1());
		System.out.println(tS.pop2());
		System.out.println(tS.pop2());
		System.out.println(tS.pop2());
		System.out.println(tS.pop1());
	}
}
