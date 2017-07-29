package stacks.utils;

import java.util.Arrays;

import stacks.LinkedStack;
import stacks.Stack;

public class ArrayReverse {

	/**
	 * Generic method for reversing an array
	 * 
	 * @param a
	 */

	public static <E> void reverse(E[] a) {
		Stack<E> buffer = new LinkedStack<E>();

		for (int i = 0; i < a.length; i++) {
			buffer.push(a[i]);
		}

		for (int i = 0; i < a.length; i++) {
			a[i] = buffer.pop();
		}
	}

	/**
	 * Tester program to reverse an array
	 */
	public static void main(String[] args) {
		Integer[] a = { 4, 8, 15, 16, 23, 42 };
		String[] s = { "Jack", "Kate", "Hurley", "Jin", "Michael" };
		
		System.out.println(" a = "+Arrays.toString(a));
		System.out.println(" s = "+Arrays.toString(s));
		System.out.println(" \nReversing...");
		reverse(a);
		reverse(s);
		
		System.out.println(" a = "+Arrays.toString(a));
		System.out.println(" s = "+Arrays.toString(s));

	}

}
