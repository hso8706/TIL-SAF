package org.example;

public class RecursiveCallTest1 {
	static int N=10;

	public static int sum(int n) {
		if(n == 1) {
			return 1;
		}else {
			return n + sum(n-1);
		} 
		
	}

	public static int sum2(int n) {
		if(n == N) {
			return N;
		}else {
			return n + sum2(n+1);
		} 
		
	}

	public static int sum3(int n) {
		if(n > 1) {
			return n + sum3(n-1);
			
		}else {
			return 1;
			
		} 
			
	}
	
	public static int sum4(int n) {
		if(n<N) {
			return n + sum4(n+1);
			
		}else {
			return N;
		}
				
	}	
	
	public static void main(String[] args) {
		System.out.println("sum :"+sum(10));
		System.out.println("sum :"+sum2(1));
		System.out.println("sum :"+sum3(10));
		System.out.println("sum :"+sum4(1));
	}
}
