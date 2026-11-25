import java.util.Arrays;

//linear = big O notation O(n)
//binary = big O notation O(log n)
//if if double the size of the input, the number of steps will increase by 1 for binary search

public class SearchExample {
    public static void main(String[] args) {
        // int n[] = new int[16];
        int n[] = { 3, 4, 6, 8, 10, 11, 24, 55, 67, 68, 90, 12, 22, 1, 8, 12, 51, 99, 2, 19 };
        int target = 19;

        int result = linearsearch(n, target);
        int result1 = binarysearch(n, target);

        int rsteps = 0;
        int result2 = recursiveBinarySearch(n, target, 0, n.length - 1, rsteps);

        if (result == -1) {
            System.out.println("Element not found for linear search");
        } else {
            System.out.println("Element found for linear search at index: " + result);
        }

        if (result1 == -1) {
            System.out.println("Element not found for binary search");
        } else {
            System.out.println("Element found for binary search at index: " + result1);
        }

        if (result2 == -1) {
            System.out.println("Element not found for recursive binary search");
        } else {
            System.out.println("Element found for recursive binary search at index: " + result2);
        }
    }

    public static int linearsearch(int[] nums, int t) {
        int steps = 0;
        for (int i = 0; i < nums.length; i++) {
            steps++;
            if (nums[i] == t) {

                System.out.println("Linear Search Steps: " + steps);
                return i;
            }

        }
        steps++;
        System.out.println("Linear Search Steps: " + steps);
        return -1;
    }

    public static int binarysearch(int[] nums, int t) {

        Arrays.sort(nums);
        // System.out.println("Sorted Array: " + Arrays.toString(nums));

        int l = 0;
        int r = nums.length - 1;
        int steps = 0;

        while (l <= r) {
            steps++;
            int m = (l + r) / 2;

            if (nums[m] == t) {

                System.out.println("Binary Search Steps: " + steps);
                return m;
            } else if (nums[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }

        }
        steps++;
        System.out.println("Binary Search Steps: " + steps);

        return -1;
    }

    public static int recursiveBinarySearch(int[] nums, int t, int l, int r, int steps) {

        // 3,5,6,7,8,9,61,89
        Arrays.sort(nums);
        System.out.println("Sorted array:" + nums);

        while (l <= r) {
            steps++;
            int m = (l + r) / 2;
            if (nums[m] == t)
                return m;
            else if (nums[m] < t) {
                return recursiveBinarySearch(nums, t, m + 1, r, steps);
            } else {
                return recursiveBinarySearch(nums, t, l, m - 1, steps);
            }
        }
        return -1;
    }

}
