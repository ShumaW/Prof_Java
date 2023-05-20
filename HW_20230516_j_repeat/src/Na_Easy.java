import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Na_Easy {
    public static void main(String[] args) {


        /**
         * Уровень сложности 1 из 10:
         *
         * Найти сумму всех элементов в массиве.
         * Найти наибольшее значение в массиве.
         * Посчитать количество четных чисел в массиве.
         *
         */

        System.out.println("-".repeat(25) + " Уровень сложности 1 из 10 " + "-".repeat(25));
        int[] arr1 = {2, 5, 6, 8, 2, 27, 9, 10};
        System.out.println(sumElementArray(arr1));
        System.out.println(findMaxElemInArr(arr1));
        System.out.println(quantityEvenNumbers(arr1));

        /**
         * Уровень сложности 2 из 10:
         * Проверить, содержит ли массив заданное значение.
         * Отсортировать массив по возрастанию.
         * Найти индекс первого вхождения заданного значения в массиве.
         */
        System.out.println("-".repeat(25) + " Уровень сложности 2 из 10 " + "-".repeat(25));
        System.out.println(findNumber(arr1, 5));
        System.out.println(findNumber(arr1, 11));
        System.out.println(Arrays.toString(arr1));
        System.out.println(findIndex(arr1, 5));
        sortArray(arr1);
        System.out.println(findIndex(arr1, 5));

        /**
         * Уровень сложности 3 из 10:
         * Найти среднее значение всех элементов в массиве.
         * Поменять порядок элементов массива на обратный.
         * Проверить, является ли массив палиндромом (элементы читаются одинаково с начала и с конца).
         */
        int[] arr2 = {25, 2, 11, 13, 45, 32, 0};
        System.out.println("-".repeat(25) + " Уровень сложности 3 из 10 " + "-".repeat(25));
        System.out.println(averageValue(arr2));
        replaceElem(arr2);
        int[] arr3 = {25, 22, 33, 36, 33, 22, 25};
        System.out.println(isPalindrome(arr2));
        System.out.println(isPalindrome(arr3));

        /**
         * Уровень сложности 4 из 10:
         * Найти наибольшую сумму подряд идущих элементов в массиве.
         * Удалить все дубликаты из массива.
         * Найти два наименьших значения в массиве.
         */
        int[] arr4 = {2, 5, 6, 8, 2, 27, 9, 10};
        System.out.println("-".repeat(25) + " Уровень сложности 4 из 10 " + "-".repeat(25));
        System.out.println(solve(arr4));
        System.out.println(removeDuplicate_v1(arr4));
        System.out.println(Arrays.toString(arr4));
        System.out.println(Arrays.toString(removeDuplicate_v2(arr4)));
        int[] arr5 = {10, -1, 5, 8, 10, 6, 3, 1, 10};
        System.out.println(Arrays.toString(twoMin(arr5)));

        /**
         * Уровень сложности 5 из 10:
         * Найти наибольшую возрастающую последовательность в массиве (элементы идут по порядку).
         * Найти наибольшую сумму подмассива с нечетным количеством элементов.
         */
        System.out.println("-".repeat(25) + " Уровень сложности 5 из 10 " + "-".repeat(25));


    }

    public static int sumElementArray(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int findMaxElemInArr(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int quantityEvenNumbers(int[] arr) {
        int count = 0;
        for (int x : arr) {
            if (x % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    public static boolean findNumber(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return true;
            }
        }
        return false;
    }

    public static void sortArray(int[] arr) {       // int[] arr = {2, 5, 6, 8, 2, 7, 9, 10};
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static int findIndex(int[] arr, int x) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                index = i;
            }
        }
        return index;
    }

    public static double averageValue(int[] arr) {
        double sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return sum / arr.length;
    }

    public static void replaceElem(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left != right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static boolean isPalindrome(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        boolean flag = false;
        while (left != right) {
            if (arr[left] == arr[right]) {
                flag = true;
            } else {
                flag = false;
            }
            left++;
            right--;
        }
        return flag;
    }

    public static int solve(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int maxSum = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                curSum += nums[i];
            } else {
                if (curSum > maxSum) {
                    maxSum = curSum;
                }
                curSum = nums[i];
            }
        }
        if (curSum > maxSum) {
            maxSum = curSum;
        }
        return maxSum;
    }

    public static Set removeDuplicate_v1(int[] arr) {
        Set set = new HashSet<>();
        if (arr != null) {
            for (int i = 0; i < arr.length; i++) {
                set.add(arr[i]);
            }
        }
        return set;
    }

    public static int[] removeDuplicate_v2(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    arr[j] = 0;
                    count++;
                }
            }
        }
        int[] res = new int[arr.length - count];
        int indexArr = 0;
        int indexRes = 0;
        while (indexArr < arr.length) {
            if (arr[indexArr] != 0) {
                res[indexRes] = arr[indexArr];
                indexArr++;
                indexRes++;
            } else {
                indexArr++;
            }
        }
        return res;
    }

    public static int[] twoMin(int[] arr) {  // int[] arr = {2, 5, 6, 8, 2, 1, 9, 10};
        int[] res = {arr[0],arr[1]};            // int[] res = {2, 5}
        for (int i = 1; i < arr.length; i++) {
            if ( res[0] > arr[i]) {
                res[1] = res[0];
                res[0] = arr[i];
            } else if (res[1] > arr[i]) {
                res[1] = arr[i];
            }
        }
        return res;
    }
}