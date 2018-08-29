import java.util.Arrays;

/**
 * Created by lenovo on 2018/8/29.
 */
public class 希尔排序 {
    //希尔排序就是将直接插入排序的间隔值设置更大，然后相当于分组进行排序
    //实现部分有序，这样的直接插入排序就跟快了
    //O(nlogn)
    public void ShellSort(int[] k ,int n){
        int i,j,temp;
        int gap = n; //间隔
        do{
            gap = gap/3 +1; //每一次循环gap都变小
            for(i = gap ;i < n;i++){
                if(k[i] < k[i-gap]){
                    temp = k[i];
                    for(j = i-gap; j>=0 && k[j] >temp ;j-= gap){
                        k[j+gap] = k[j];
                    }
                    k[j+gap] = temp;
                }
            }
        }while(gap > 1);
    }

    public static void main(String[] args) {
        int i;
        int[] a = {5, 2, 6, 0, 3, 9, 1, 7, 4, 8};
        希尔排序 shell = new 希尔排序();
        shell.ShellSort(a,10);
        System.out.println(Arrays.toString(a));
    }
}
