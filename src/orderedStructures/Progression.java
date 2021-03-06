package orderedStructures;

import java.security.InvalidParameterException;

import interfaces.Combinable;
import interfaces.OrderedNumberStructure; 

public abstract class Progression implements OrderedNumberStructure, Combinable {
	private double first;       // the first value
	protected double current;   
	@SuppressWarnings("unused")
	private boolean start = false;
	// current is the current value of the object � it changes
	// to �the value of the next term� whenever method 
	// �nextValue� is applied to the object.

	public Progression(double first) { 
		this.first = first; 
		current = first; 
	}

	public double firstValue() { 
		start = true;
		current = first; 
		return current; 
	}

	public void printAllTerms(int n) throws InvalidParameterException {
		if (n <= 0) 
			throw new InvalidParameterException("printAllTerms: Invalid argument value = " + n);  

		System.out.println("Index\tTerm Value"); 
		for (int i=1; i<=n; i++) { 
			System.out.println((i) +  "\t" + this.getTerm(i));  
		}
	}

	public double getTerm(int n) throws IndexOutOfBoundsException { 
		if (n <= 0) 
			throw new IndexOutOfBoundsException("printAllTerms: Invalid argument value = " + n); 

		double value = this.firstValue(); 
		for (int i=1; i<n; i++) 
			value = this.nextValue(); 
		return value; 
	}

	public abstract double nextValue() throws IllegalStateException; {
		if (start = false) throw new IllegalStateException("begin with firstValue()");
	}
	
	public abstract String toString();
	
	public boolean equals(Progression p2) {
		return (this.toString().equals(p2.toString()));
	}
}