/**
 * Created by lenovo on 2018/8/29.
 */


//大顶堆：父节点大于等于子节点
//    ki >= k2i
//    ki >= k2i+1
//下标i与2i就是父与子的关系
    //小顶堆：相反
//    Heap Sort
    //构建堆：是从下往上，从右往左进行构建
    //调整好的第一个元素就是最大的（或者最小的)
// ,所以要进行与最后一个进行调换
public class 堆排序 {
    public void swap(int[] k,int i,int n){
        int temp;
        temp = k[i];
        k[i] = k[n];
        k[n] = temp; // 实现将孩子与父节点交换
    }

    /**
     *
     * @param k
     * @param i 判断以第i个结点为父节点的子树
     * @param n
     */
    public void HeapAdjust(int[] k,int i,int n){

        int j;
        int temp = k[i];
        //j每一次都乘以2，实现对子树整个的遍历
        for(j=2*i;j<=n;j*=2){
            if(j < n &&k[j] < k[j+1]){
                j = j+1;//j指向最大的子节点
            }
            if(temp > k[j]){
                break;//这样就满足最大的为父节点，左孩子小于右孩子
            }
            //如果父节点小于孩子
            k[i] = k[j];
            i = j;
        }
        k[i] = temp;
        //相当于其实就是一直在进行对k[i]寻找一个合适的位置，用temp进行存储
        //所以上面只有对k[i]的赋值，没有对k[j] 的赋值。
    }
    public void HeapSort(int k[],int n){
        int i;
        //从下往上，从右往左
        for(i=n/2;i>0;i--){
            HeapAdjust(k,i,n);
        }
        for(i=n;i>1;i--){
            swap(k,1,i);
            HeapAdjust(k,1,i-1);
        }
    }

    public static void main(String[] args) {
        int i;
        int[] a = {-1,5,2,6,0,3,9,1,7,4};
        堆排序 heapSort = new 堆排序();
        heapSort.HeapSort(a,9);
        for(int s:a){
            System.out.println(s);
        }
    }
}
