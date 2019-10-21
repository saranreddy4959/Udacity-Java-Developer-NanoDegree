public class Binary_Search {

    public static int findTarget(int[] arr, int target) {
        if (arr.length == 0) return -1;

        int start = 0;
        int end = arr.length;

        while (start <= end) {

            int mid = start + ((end - start) / 2);

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                end = mid - 1;

            } else {
                start = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {1, 5, 7, 8, 9, 11, 18, 19, 20, 25};
        int[] arr1 ={1, 2, 3, 4, 5};
        int result = findTarget(arr, 11);

        int res = findTarget(arr1, 10);

        System.out.println(res);
    }
}
