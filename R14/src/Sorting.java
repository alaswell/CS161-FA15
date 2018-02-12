// javac -cp .:xchart-2.6.0.jar SortingComplete.java; java -cp .:xchart-2.6.0.jar SortingComplete

import java.util.Arrays;
import java.util.Random;
import org.knowm.xchart.*;

public class Sorting {

    public static void selectionSort(int[] data) {
	int min;
	for ( int i = 0; i < data.length-1; i++) 
	{
		min = i;
		for (int j = i+1; j < data.length; j++) 
			if (data[j] < data[min])
				min = j;
	swap (data, min, i);
	}
    }
    private static void swap(int[] array, int i, int j) {
	int temp = array[i];
	array[i] = array[j];
	array[j] = temp;
    }


    public static void insertionSort(int[] data) {
	for (int i = 1; i < data.length; i++)
	{
		int temp = data[i];
		int position = i;
	
		// shift
		while (position > 0 && (data[position-1] > temp))
		{
			data[position] = data[position-1];
			position--;
		}
		// insert current item
		data[position] = temp;
	}
    }

    public static void bubbleSort(int[] data) {
    
	for (int position = data.length-1; position >= 0; position--) 
	{
		for ( int i = 0; i < position; i++)
    		{
			if (data[i] > data[i+1])
				swap(data, i, i+1);
		}
	}
    }

    public static int[] mergeSort(int[] data) {
	if (data.length <=1)
		return data; // if empty do nothing

	// split in half
	int[] first = new int[data.length/2];
	int[] second = new int[data.length - first.length];
	System.arraycopy(data, 0, first, 0, first.length);
	System.arraycopy(data, first.length, second, 0, second.length);

	// recursively sort each half
	mergeSort(first);
	mergeSort(second);

	// merge the sorted halves together
	merge(first, second, data);
	return data;	
    }

    private static void merge(int[] first, int[] second, int[] result) 
    {
	// Index position in first array - starting with element 0
	int iFirst = 0;

	// Index position in second array - starting with element 0
	int iSecond = 0;

	// Index position in merged array - starting with 0
	int iMerged = 0;

	// Compare elemnts at iFirst and iSecond
	// move smaller element at iMerged
	while (iFirst < first.length && iSecond < second.length)
	{
		if (first[iFirst] < second[iSecond])
		{
			result[iMerged] = first[iFirst];
			iFirst++;
		}
		else
		{
			result[iMerged] = second[iSecond];
			iSecond++;
		}
		iMerged++;
	}
	//copy remaining elements from both halves - each half will have already sorted elements
	System.arraycopy(first, iFirst, result, iMerged, first.length - iFirst);
	System.arraycopy(second, iSecond, result, iMerged, second.length - iSecond);
    }

    public static boolean isOrdered(int[] data) {
	for (int i = 0; i < data.length-1; i++) 
	    if (data[i] > data[i+1])
		return false;
	return true;
    }

    public static void main(String[] args) {

	double[] sizes = {1,10,100,1000,10000};//,100000};  // Values should be in ascending order, for plot to look right.
	int maxSize = (int)sizes[sizes.length-1];  // Assumes largest value is last value.
	double[] selectionSort = new double[sizes.length];
	double[] insertionSort = new double[sizes.length];
	double[] bubbleSort = new double[sizes.length];
	double[] mergeSort = new double[sizes.length];

	Random rand = new Random();
	 
	int[] values = new int[maxSize];
	for (int i = 0; i < maxSize; i++)
	    values[i] = rand.nextInt();


	for (int sizei = 0; sizei < sizes.length; sizei++) {
	    int size = (int)sizes[sizei];
	    System.out.println("For array size " + size + ":");
	    int[] copyOfValues = new int[size];

	    for (int i = 0; i < size; i++)
		copyOfValues[i] = values[i];
	    long startTime = System.nanoTime();
	    selectionSort(copyOfValues);
	    long endTime = System.nanoTime();
	    selectionSort[sizei] = (endTime - startTime) / 1000000000.; // 1e9
	    System.out.println(" Selection sorted? " + isOrdered(copyOfValues) + ". time: " + selectionSort[sizei] + " seconds.");

	    for (int i = 0; i < size; i++)
		copyOfValues[i] = values[i];
	    startTime = System.nanoTime();
	    insertionSort(copyOfValues);
	    endTime = System.nanoTime();
	    insertionSort[sizei] = (endTime - startTime) / 1000000000.0; // 1e9
	    System.out.println(" Insertion sorted? " + isOrdered(copyOfValues) + ". time: " + insertionSort[sizei] + " seconds.");



	    for (int i = 0; i < size; i++)
		copyOfValues[i] = values[i];
	    startTime = System.nanoTime();
	    bubbleSort(copyOfValues);
	    endTime = System.nanoTime();
	    bubbleSort[sizei] = (endTime - startTime) / 1000000000.; // 1e9
	    System.out.println(" Bubble sorted? " + isOrdered(copyOfValues) + ". time: " + bubbleSort[sizei] + " seconds.");

	    for (int i = 0; i < size; i++)
		copyOfValues[i] = values[i];
	    startTime = System.nanoTime();
	    mergeSort(copyOfValues);
	    endTime = System.nanoTime();
	    mergeSort[sizei] = (endTime - startTime) / 1000000000.; // 1e9
	    System.out.println(" Merge sorted? " + isOrdered(copyOfValues) + ". time: " + mergeSort[sizei] + " seconds.");
	}

	double [][] allResults = new double[4][sizes.length];
	for (int i = 0; i < sizes.length; i++) {
	    allResults[0][i] = selectionSort[i];
	    allResults[1][i] = insertionSort[i];
	    allResults[2][i] = bubbleSort[i];
	    allResults[3][i] = mergeSort[i];
	}

	String[] names = {"Selection","Insertion","Bubble","Merge"};
	Chart chart = QuickChart.getChart("Sort Times", "Size", "Seconds", names,
					  sizes, allResults);
 
	new SwingWrapper(chart).displayChart();
    }


}
