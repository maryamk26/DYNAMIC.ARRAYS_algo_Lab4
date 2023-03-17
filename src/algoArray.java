import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class algoArray {
    private int[] ARRAY;

    public algoArray(int size) {
        ARRAY = new int[size];
    }

    public algoArray(int[] ARRAY) {
        this.ARRAY = ARRAY;
    }

    public void INARR(int v) {
        Arrays.fill(ARRAY, v);
    }

    public void input() {
        try (Scanner scs = new Scanner(System.in)) {
            for (int i = 0; i < ARRAY.length; i++) {
                System.out.print("Enter element " + i + ": ");
                ARRAY[i] = scs.nextInt();
            }
        }
    }

    public void Frd(int min, int max) {
        Random RD = new Random();
        for (int i = 0; i < ARRAY.length; i++) {
            ARRAY[i] = RD.nextInt(max - min + 1) + min;
        }
    }

    public int getElement(int i) {
        return ARRAY[i];
    }

    public void setElement(int i, int VAL) {
        ARRAY[i] = VAL;
    }

    public int SUM() {
        int S = 0;
        for (int i = 0; i < ARRAY.length; i++) {
            S += ARRAY[i];
        }
        return S;
    }

    public int GLE() {
        int max = ARRAY[0];
        for (int i = 1; i < ARRAY.length; i++) {
            if (ARRAY[i] > max) {
                max = ARRAY[i];
            }
        }
        return max;
    }

    public int INDSE() {
        int minIndex = 0;
        for (int i = 1; i < ARRAY.length; i++) {
            if (ARRAY[i] < ARRAY[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public algoArray PTEL(){
        int count = 0;
        for (int i = 0; i < this.ARRAY.length; i++){
            if (this.ARRAY[i]> 0) count++; i++;
        }
        algoArray res = new algoArray(count);
        for (int i = 0,k =0; k<count; k++){
            if (this.ARRAY[k]>0){
                res.setElement(i, this.ARRAY[k]);
                i++;
            }
        }
        return res;
    }

    public int LSH(int element) {
        for (int i = 0; i < ARRAY.length; i++) {
            if (ARRAY[i] == element) {
                return i;
            }
        }
        return -1;
    }


    public boolean SORT() {
        for (int i = 1; i < ARRAY.length; i++) {
            if (ARRAY[i] < ARRAY[i-1]) {
                return false;
            }
        }
        return true;
    }


    public int BINSH(int element) {
        int L = 0;
        int H = ARRAY.length - 1;

        while (L <= H) {
            int mid = (L + H) / 2;
            if (ARRAY[mid] == element) {
                return mid;
            } else if (ARRAY[mid] < element) {
                L = mid + 1;
            } else {
                H = mid - 1;
            }
        }
        return -1;
    }

    public static algoArray sum(algoArray a1, algoArray a2) {
        if (a1.ARRAY.length != a2.ARRAY.length) {
            throw new IllegalArgumentException("Arrays must have the same length.");
        }
        int[] newArray = new int[a1.ARRAY.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = a1.ARRAY[i] + a2.ARRAY[i];
        }
        return new algoArray(newArray);
    }

    public static boolean equals(algoArray a1, algoArray a2) {
        if (a1.ARRAY.length != a2.ARRAY.length) {
            return false;
        }
        for (int i = 0; i < a1.ARRAY.length; i++) {
            if (a1.ARRAY[i] != a2.ARRAY[i]) {
                return false;
            }
        }
        return true;
    }

    public void LFT() {
        int t = ARRAY[0];
        for (int i = 0; i < ARRAY.length - 1; i++) {
            ARRAY[i] = ARRAY[i + 1];
        }
        ARRAY[ARRAY.length - 1] = t;
    }

    public boolean ZERO() {
        for (int i = 0; i < ARRAY.length - 1; i++) {
            if (ARRAY[i] == 0 && ARRAY[i + 1] == 0) {
                return true;
            }
        }
        return false;
    }
    //==========================================================
    public void shellSort() {
        int n = ARRAY.length;
        int g = n / 2;

        while (g > 0) {
            for (int i = g; i < n; i++) {
                int sub = ARRAY[i];
                int j = i;
                while (j >= g && ARRAY[j - g] > sub) {
                    ARRAY[j] = ARRAY[j - g];
                    j -= g;
                }
                ARRAY[j] = sub;
            }
            g /= 2;
        }
    }
    //==========================================================

    //==========================================================
    public void mergeSort() {
        mergeSortHelper(ARRAY, 0, ARRAY.length-1);
    }

    private void mergeSortHelper(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSortHelper(arr, l, mid);
            mergeSortHelper(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }

    private void merge(int[] arr, int l, int mid, int r) {
        int[] t = new int[r - l + 1];
        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] < arr[j]) {
                t[k++] = arr[i++];
            } else {
                t[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            t[k++] = arr[i++];
        }
        while (j <= r) {
            t[k++] = arr[j++];
        }
        for (i = l; i <= r; i++) {
            arr[i] = t[i - l];
        }
    }
    //==========================================================

    //==========================================================
    public void quickSort() {
        quickSortHelper(ARRAY, 0, ARRAY.length-1);
    }

    private void quickSortHelper(int[] arr, int L, int H) {
        if (L < H) {
            int pi = partition(arr, L, H);
            quickSortHelper(arr, L, pi-1);
            quickSortHelper(arr, pi+1, H);
        }
    }

    private int partition(int[] arr, int L, int H) {
        int p = arr[H];
        int i = L - 1;
        for (int j = L; j < H; j++) {
            if (arr[j] < p) {
                i++;
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        int t = arr[i+1];
        arr[i+1] = arr[H];
        arr[H] = t;
        return i+1;
    }

    //==========================================================

    @Override
    public String toString() {
        return Arrays.toString(ARRAY);
    }
}
