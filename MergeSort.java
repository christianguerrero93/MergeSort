
public class MergeSort {

	public static <T extends Comparable<? super T>> void mergeSort(T[] arr){
		if(arr.length >1){
			int halfLength = arr.length /2;
			T [] firstHalfArr = (T[])new Comparable<?>[halfLength];//create 1st empty array
			T [] lastHalfArr = (T[])new Comparable<?>[ arr.length - halfLength];//create 2nd empty array
			divide(arr, firstHalfArr, lastHalfArr);
			mergeSort(firstHalfArr); //recursive call left side
			mergeSort(lastHalfArr); //recursive call right side
			merge(arr,firstHalfArr,lastHalfArr); // comparisons and merging to sort
		}
	}
	private static <T extends Comparable<? super T>> void divide(T[] arr, T[] firstHalfArr, T[] lastHalfArr){
		for(int i=0; i<firstHalfArr.length; i++){
			firstHalfArr[i] = arr[i];
		}
		for(int i=0; i<lastHalfArr.length; i++){
			lastHalfArr[i] = arr[firstHalfArr.length + i];
		}
	}
	private static <T extends Comparable<? super T>> void merge (T[] arr, T[] firstHalfArr, T[] lastHalfArr){
		int fhIndex =0;
		int lhIndex =0;
		int bigIndex = 0;
		while( (fhIndex < firstHalfArr.length) && (lhIndex < lastHalfArr.length)) {
			if(firstHalfArr[fhIndex].compareTo(lastHalfArr[lhIndex])  < 0){//fh val is < lh val
				arr[bigIndex] = firstHalfArr[fhIndex];
				fhIndex++;
			}
			else{//fh val >= lh val
				arr[bigIndex] = lastHalfArr[lhIndex];
				lhIndex++;
			}
			bigIndex++;
		}
		while(fhIndex < firstHalfArr.length){
			arr[bigIndex] = firstHalfArr[fhIndex];
			fhIndex++;
			bigIndex++;
		}
		while(lhIndex < lastHalfArr.length){
			arr[bigIndex] = lastHalfArr[lhIndex];
			lhIndex++;
			bigIndex++;
		}
		
		
	}
	

}
