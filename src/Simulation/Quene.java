package Simulation;

public class Quene<T> {

	/* Instance variable for the head of the queue */
	private Node<T> head;

	/* Instance variable for the tail of the queue */
	private Node<T> tail;

	/* Instance variable for the size of the queue */
	private int size;

	/*
     * Instructor for the Queue, insitializes instance variables
     */
	public Quene(){
		head = null;
		tail = null;
		size = 0;
	}

	/* Node class */
	private class Node<T>{
		protected T element;
		protected Node<T> next;

		// sets element
		protected Node(T element){
			this.element = element;
		}
	}

	/*
     * Adds element to the queue, changes head and tail references
     *
     * @param T
     */
	public void enQ(T element){
		Node<T> t = new Node<T>(element);
		if(size==0){
			head = t;
			head.next = t;
			tail = t;
		} else {
			tail.next = t;
			tail = t;
		}
		// increases size of queue
		size++;
	}

	/*
     * Removes element from the Q
     *
     * @returns T
     * @throws EmptyQException
     */
	public T deQ() throws EmptyQException{
		if(size == 0){
			throw new EmptyQException("The Q is empty");
		}
		Node<T> temp = head;
		head = head.next;
		size--;
		return temp.element;
	}

	/*
     * Returns the size of the queue
     *
     * @returns int
     */
	public int size(){
		return size;
	}

}
