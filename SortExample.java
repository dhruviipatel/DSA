// bubble sort : time complexity O(n^2) and space complexity O(1)
public class SortExample {
    public static void main(String[] args) {
        int n[] = { 4, 3, 8, 12, 40, 31, 22, 29, 90, 72, 44, 9, 17, 30 };
        // bubbleSortExample(n);
        // selectionSortExample(n);
        // insertionSortExample(n);

        // quickSortExample(n, 0, n.length - 1);

        // System.out.println("After Quick Sort ");
        // for (int n1 : n)
        // System.out.print(n1 + " ");

        mergeSortExample(n, 0, n.length - 1);

        System.out.println("After Merge Sort");

        for (int n1 : n)
            System.out.print(n1 + " ");

    }

    public static void bubbleSortExample(int[] nums) {
        int size = nums.length;
        int temp = 0;

        System.out.println("Before Bubble Sort ");
        for (int n : nums) {
            System.out.print(n + " ");
        }

        System.out.println();

        for (var i = 0; i < size; i++) {
            for (var j = 0; j < size - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                }

            }
        }

        System.out.println("After Bubble Sort ");
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public static void selectionSortExample(int[] nums) {
        int size = nums.length;
        int temp = 0;
        var minIndex = -1;

        System.out.println("Before Selection Sort ");
        for (int n1 : nums) {
            System.out.print(n1 + " ");
        }

        for (int i = 0; i < size - 1; i++) {
            minIndex = i;
            for (int j = i; j < size; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }

            temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }

        System.out.println();

        System.out.println("After Selection Sort ");
        for (int n1 : nums) {
            System.out.print(n1 + " ");
        }
    }

    public static void insertionSortExample(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;

            while (j >= 0 && nums[j] > key) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = key;
        }

        System.out.print("Data after sorting ");
        for (int n : nums) {
            System.out.print(n + " ");
        }
    }

    public static void quickSortExample(int[] nums, int low, int high) {
        if (low < high) {
            int pi = partition(nums, low, high);
            quickSortExample(nums, low, pi - 1);
            quickSortExample(nums, pi + 1, high);

        }
    }

    public static int partition(int[] nums, int low, int high) {
        int pi = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {

            if (nums[j] < pi) {
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }

        int temp = nums[i + 1];
        nums[i + 1] = nums[high];
        nums[high] = temp;

        return i + 1;
    }

    public static void mergeSortExample(int[] nums, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSortExample(nums, l, mid);
            mergeSortExample(nums, mid + 1, r);
            merge(nums, l, r, mid);
        }
    }

    public static void merge(int[] nums, int l, int r, int mid) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int lArray[] = new int[n1];
        int rArray[] = new int[n2];

        for (int x = 0; x < n1; x++) {
            lArray[x] = nums[l + x];
        }

        for (int x = 0; x < n2; x++) {
            rArray[x] = nums[mid + 1 + x];
        }

        int i = 0;
        int j = 0;
        int k = l;

        while (i < n1 && j < n2) {
            if (lArray[i] < rArray[j]) {
                nums[k] = lArray[i];
                i++;
            } else {
                nums[k] = rArray[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            nums[k] = lArray[i];
            i++;
            k++;
        }

        while (j < n2) {
            nums[k] = rArray[j];
            j++;
            k++;
        }

    }

}