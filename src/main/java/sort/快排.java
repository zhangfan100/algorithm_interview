package sort;

public class 快排 {

    // 哨兵
    public void sort(int[] arrays, int left, int right){
        if (left >= right){
            return;
        }
        int temp = 0;
        int l=left;
        int r=right;
        int data = arrays[left];
        // 6,1,9,2,8,4,7,3
        while (l<r){
            // 从右开始找比基准小的
            while(l < r && data <= arrays[r]){
                r--;
            }

            // 从左开始找比基准大的
            while(l < r && data >= arrays[l]){
                l++;
            }

            if (l <= r){
                temp = arrays[l];
                arrays[l]=arrays[r];
                arrays[r]=temp;
            }
        }
        arrays[left]=arrays[l];
        arrays[l]=data;

        sort(arrays,left,l-1);
        sort(arrays,l+1,right);
    }

    public static void main(String[] args) {
        快排 aa = new 快排();
        int[] sort = new int[]{6,11,9,2,8,4,7,3,3,0,34,-1,-2};
        aa.print(sort);
        aa.sort(sort,0,sort.length-1);
        aa.print(sort);
    }

    public void print(int[] sort){
        for (int i : sort) {
            System.out.print(i+",");
        }
        System.out.println();
    }
}
