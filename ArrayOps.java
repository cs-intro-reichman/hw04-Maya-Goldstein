public class ArrayOps {
    public static void main(String[] args) {
        int[] arr = new int[] {-202, 48, 13, 7, 8};
        //int[] arr2 = new int[] {1, 3, -4, 5};
        //System.out.println("Test of missing int: " + findMissingInt(arr));
        System.out.println("Test of second max value: " + secondMaxValue(arr));
        //System.out.println("Test of contains the same elements: " + containsTheSameElements(arr1, arr2));
        //System.out.println("Test of is sorted: " + isSorted(arr));
        
    }
    
    public static int findMissingInt (int [] array) {
        boolean[] newArr = new boolean[array.length + 1];
        int index = 0;
        int digit;

        for (int i = 0; i < array.length; i++) {
            digit = array[i];
            newArr[digit] = true;
        }

        for (int i = 0; i < newArr.length; i++) {
            if (newArr[i] == false)
                index = i;
        }
        return index;
    }

    public static int secondMaxValue(int [] array) {
        int max1 = array[0], max2 = array[0];
        int idxMax = 0;
        // finds thr maximum value in thr array
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max1) {
                max1 = array[i];
                idxMax = i;
            }

        }

        // finds the second maximum value in the array
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max2 && i != idxMax)
                max2 = array[i];
        }
        return max2;
    }

    // helper function of containsTheSameElements
    public static boolean contains(int[] array, int n) {
        boolean answer = false;

        for (int i = 0; i < array.length; i++) {
            if (n == array[i]) {
                answer = true;
                break;
            }
        }
        return answer;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        boolean flag = true;

        for (int i = 0; i < array1.length && flag == true ; i++) {
            flag = contains(array2, array1[i]);
        }
        return flag;
    }


    // helper function of isSorted
    public static boolean isSortedIncreasingly(int [] array) {
        int num1, num2;
        boolean flag = true;
        for (int i = 1; i < array.length && flag == true; i++) {
            num1 = array[i-1];
            num2 = array[i];
            flag = (num1 <= num2);
        }
        return flag;
    }

    // helper function of isSorted
    public static boolean isSortedDecreasingly(int [] array) {
        int num1, num2;
        boolean flag = true;
        for (int i = 1; i < array.length && flag == true; i++) {
            num1 = array[i-1];
            num2 = array[i];
            flag = (num1 >= num2);
        }
        return flag;
    } 

    public static boolean isSorted(int [] array) {
        return (isSortedIncreasingly(array) || isSortedDecreasingly(array));
    }

}

















