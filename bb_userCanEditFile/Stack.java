//Honor Pledge: I pledge that I have neither
//given nor received any undue help on this assignment.
//
//strangni

//CS 240 - Assignment 4 - Stacks Upon Stacks
//Created by: Nicholas Strange

public class Stack<E> {
		private int top;  //points to top of Stack
		private int size;  //size of the stack
		private E [] stack;  //array to emulate the Stack
		
		//default constructor:
		public Stack() {
			size = 10;
			stack = (E[]) new Object[size];  //initialize new integer array
			top = -1;  //initialize the value of the top position
		}
		
		//constructor with size parameter
		public Stack(int stackSize) {  
			if (stackSize > 0) {  //stack must have a physical size
				size = stackSize;
			}else{
				System.out.println("Invalid Stack size!");
				System.out.println("Using default size of 10");
				size = 10;
			}
			
			stack = (E[]) new Object[size];  //cast stack array, allowing for any type
			top = -1;
		}
		
		public boolean isEmpty() {  //returns T if Stack is empty, F if not
			return top == -1;  
		}
		
		public boolean isFull() {  //returns T if Stack is full, F if not
			return top == size-1;
		}
		
		public E getTop() {  //returns last element pushed to Stack
			return stack[top];
		}
		
		public int getSize(){  //returns size of Stack
			return size;
		}
		
		public void push(E dataElement) {  //one of the defining methods of the Stack ADT; "pushes" element onto the Stack
			if (isFull()){
				System.out.println("Cannot push; the Stack is full.");
			}else{
				stack[++top] = dataElement;  //moves the pointer to the next Stack space and stores the dataElement there
			}
		}
		
		public E pop() {  //one of the defining methods of the Stack ADT; "pops" element off of the Stack
			if (isEmpty()) {
				System.out.println("The Stack is empty - cannot pop!");
				return null;
			}else{
				return stack[top--];  //returns the current top and then moves the pointer to the next element
			}
		}
		
		public void displayStack() {  //uses loop to display all elements of the Stack
			for (int i = 0; i < top; i++) {
				System.out.print(stack[i] + ",");
			}
			System.out.println(stack[top]);
		}
}
