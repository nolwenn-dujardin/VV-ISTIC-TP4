package fr.istic.vv;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Sorting {

    public static <T>  T[] bubblesort(T[] array, Comparator<T> comparator) {
        int n = array.length;

        boolean swapped = false;
        do {
            for(int i=1; i<n-1;i++){
                if(comparator.compare(array[i-1], array[i]) > 0){
                    T tmp = array[i-1];
                    array[i-1] = array[i];
                    array[i] = tmp;
                    swapped = true;
                }
            }
        } while(swapped);

        return array;
    }

    public static <T> T[] quicksort(T[] array, Comparator<T> comparator)  {
        //TODO
        return null;
    }

    public static <T> T[] mergesort(T[] array, Comparator<T> comparator) {
        if(array.length <= 1){
            return array;
        }

        int middle = array.length/2;

        T[] left = (T[]) new Object[middle];
        T[] right = (T[]) new Object[array.length - middle];

        System.arraycopy(array, 0, left, 0, middle);
        System.arraycopy(array, middle, right, 0, array.length - middle);

        left = mergesort(left, comparator);
        right = mergesort(right, comparator);

        return merge(left, right, comparator);
    }

    private static <T> T[] merge(T[] left, T[] right, Comparator<T> comparator) {
        int totalLength = left.length + right.length;
        T[] merged = (T[]) new Object[totalLength];

        int leftPt = 0;
        int rightPt = 0;
        int mergedPt = 0;

        while(leftPt < left.length && rightPt < right.length){
            if(comparator.compare(left[leftPt], right[rightPt]) <= 0){
                merged[mergedPt++] = left[leftPt++];
            }
            else {
                merged[mergedPt++] = right[rightPt++];
            }
        }

        //Soit left ou right à encore des éléments
        while(leftPt < left.length){
            merged[mergedPt++] = left[leftPt++];
        }

        while(rightPt < right.length){
            merged[mergedPt++] = right[rightPt++];
        }

        return merged;
    }

}
