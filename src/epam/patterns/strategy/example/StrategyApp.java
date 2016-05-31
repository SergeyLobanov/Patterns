package epam.patterns.strategy.examples;

import java.util.Arrays;

public class StrategyApp {
	public static void main(String[] args) {
		StrategyClient s = new StrategyClient();
		
		int arr0 = {1, 3, 2, 1};
		s.setStrategy(new BubbleSort();
		s.executeStrategy();
		
		int arr1 = {11, 4, 2, 8, 24};
		s.setStrategy(new InsertionSort();
		s.executeStrategy();
		
		int arr2 = {5, -8, 0, 14, 7};
		s.setStrategy(new SelectionSort();
		s.executeStrategy();
	}	
}

//Context
class StrategyClient {
	String strategy;
	public void setStrategy (Sorting stategy) {
		this.strategy = strategy;
	}
	public void executeStrategy(int[] arr) {
		strategy.sort(arr);
	}
}
//Strategy
interface Sorting {
	void sort(int[] arr);
}
//Bubble sortinng
class BubbleSort implements Sorting {
	System.out.println("Bubble sorting");
	System.out.println("Before " + Arrays.toString(arr);
	public void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
	}
	System.out.println("After " + Arrays.toString(arr);
}
//Insertion sortinng
class InsertionSort implements Sorting {
	System.out.println("Insertion sorting");
	System.out.println("Before " + Arrays.toString(arr);
	public void sort(int[] arr) {
		for (int i = 1; i < arr.length - 1; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j > -1 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
	}
	System.out.println("After " + Arrays.toString(arr);
}
//Selection sortinng
class SelectionSort implements Sorting {
	System.out.println("Selection sorting");
	System.out.println("Before " + Arrays.toString(arr);
	public void sort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
	}
	System.out.println("After " + Arrays.toString(arr);
}