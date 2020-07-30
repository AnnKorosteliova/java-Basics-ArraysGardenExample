package main;

import java.util.Arrays;
import java.util.Scanner;

public class Garden {

	static final int SIZE = 10;
	static char[] garden = new char[SIZE];
	
	public static void main(String[] args) {

		////////////////////////////
		
		Scanner in = new Scanner(System.in);
		
		while(in.nextInt() == 0) {
		
		Arrays.fill(garden, '_');
		
		printGarden();
		
		System.out.println("Menu: " + "\n1. To put \n2. To take \n3. To swap"
				+ "\n4. Statistics \n0. Exit");
		
		int option = in.nextInt();
		
		if(option == 1) {
			System.out.println("Enter index");
			int index = in.nextInt();
			putInGarden(index, 'Y');
			printGarden();
		}
		
		if(option == 2) {
			System.out.println("Enter index");
			int index = in.nextInt();
			takeFromGarden(index);
		}
		
		if(option == 3) {
			swapInGarden(0, 1);
		}
		
		if(option == 4) {
			printGarden();
		}
		
		}
		/////////////////////////////////////////
		
		//Legend:
		//'_' - nothing
		//'o' - potato 
		//'v' - carrot
		//'Y' - corn
		
		
	}

	public static void putInGarden(int index, char value) {
		if(checkIndex(index) && garden[index] == '_' && (value == 'o' || value == 'v' || value == 'Y')) {
			garden[index] = value;
		} 	
	}
	
	public static char takeFromGarden(int index) {
		if(checkIndex(index)) {
			char temp = garden[index];
			garden[index] = '_';
			return temp;
		} else {
			return ' ';
		}
	}
	
	public static boolean swapInGarden( int index1, int index2) {
		if(garden[index1] != '_' && garden[index2] != '_') {
			char first = garden[index1];
			char second = garden[index2];
			garden[index2] = first;
			garden[index1] = second;
			return true;
		} else 
			return false;
	}
	
	public static int countInGarden(char value) {
		int count = 0;
		for (int i = 0; i < garden.length; i++) {
			if(garden[i] == value) 
				count++;
		}
		return count;
	}
	
	public static void printGarden() {
		System.out.println("######################");
		for (int i = 0; i < garden.length; i++) {
			System.out.print( garden[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < garden.length; i++) {
			System.out.print( i + " ");
		}
		System.out.println("\n######################\n");
	}
	
	public static boolean checkIndex( int index ) {
		if( index > SIZE || index < 0 ) { 
			System.out.println( "UNCORRECT INDEX" );
			return false;
		} else
			return true;
	}
}
