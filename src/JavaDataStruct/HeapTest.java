package JavaDataStruct;



/**
 * 类名：BinaryHeap 说明：建立一个最小堆
 */
class MinHeap<AnyType extends Comparable<? super AnyType>> {
    private int currentSize;
    private static final int DEFAULT_CAPACITY = 10;
    private AnyType[] array;

    public MinHeap(AnyType[] items) {
        currentSize = items.length;
        array = (AnyType[]) new Comparable[currentSize + 1];
        int i = 1;
        for (AnyType item : items)
            array[i++] = item;
        buildHeap();
    }
    /**
     * 方法名：buildHeap
     * 说明：下滤的顺序很关键 从中间开始不断向上依次下滤
     */
    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }
    /**
     * 方法名：percolateDown
     * 说明：
     */
    private void percolateDown(int position) {
        AnyType temp = array[position];
        int child;
        for (; position * 2 <= currentSize; position = child) {
            child = 2 * position;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0)
                child++;
            if (array[child].compareTo(temp) < 0)
                array[position] = array[child];

            else
                break;
        }
        array[position] = temp;
    }



    public void insert(AnyType x) {
        if (currentSize >= array.length - 1)
            enlargeArray(array.length * 2 + 1);
        int hole = ++currentSize;
        while (hole > 1 && x.compareTo(array[hole / 2]) < 0) {
            array[hole] = array[hole / 2];
            hole /= 2;
        }
        array[hole] = x;
    }

    private void enlargeArray(int capacity) {
        AnyType[] oldArr = array;
        AnyType[] newArr = (AnyType[]) new Comparable[capacity];
        for (int i = 1; i < array.length; i++)
            newArr[i] = oldArr[i];
        array = newArr;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public AnyType deleMin() {
        if (!isEmpty()) {
            AnyType min = array[1];
            array[1] = array[currentSize--];
            percolateDown(1);
            return min;
        }
        return null;

    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= currentSize; i++)
            sb.append(array[i] + " ");
        return new String(sb);
    }
}

/**
 * 类名：MaxHeap 说明：最大堆操作与建堆
 */
class MaxHeap<AnyType extends Comparable<? super AnyType>> {
    private AnyType[] array;
    private int currentSize;

    public MaxHeap(AnyType[] arr) {
        currentSize = arr.length;
        array = (AnyType[]) new Comparable[currentSize + 1];
        int i = 1;
        for (int j = 0; j < arr.length; j++)
            array[i++] = arr[j];
        buildHeap();
    }

    /**
     * 方法名：buildHeap
     * 说明：从中间开始到结束 不断上滤
     */
    private void buildHeap() {
        for (int i = currentSize /2; i <= currentSize; i++)
            percolateUp(i);
    }

    private void percolateUp(int position) {
        AnyType temp = array[position];
        while (position > 1) {
            if (array[position / 2].compareTo(temp) < 0) {
                array[position] = array[position / 2];
                position /= 2;
            } else
                break;
        }
        array[position] = temp;
    }
    private boolean isEmpty(){
        return currentSize == 0;
    }
    public AnyType deleMax(){
        AnyType max = array[1];
        AnyType temp = array[currentSize--];
        int position = 1;
        int child;
        while(position *2 <= currentSize){
            child = 2 * position;
            if(child!=currentSize&&array[child].compareTo(array[child + 1]) < 0)
                child++;
            if(array[child].compareTo(temp) > 0)
                array[position] = array[child];
            else
                break;
            position = child;
        }
        array[position] = temp;
        return max;
    }
    public void insert(AnyType x){
        if(currentSize == array.length -1)
            enlargeArray( 2* currentSize +1);
        array[++currentSize] = x;
        percolateUp(currentSize);
    }
    private void enlargeArray(int capacity) {
        AnyType[] oldArr = array;
        AnyType[] newArr = (AnyType[]) new Comparable[capacity];
        for (int i = 1; i < array.length; i++)
            newArr[i] = oldArr[i];
        array = newArr;
    }
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i <= currentSize; i++)
            sb.append(array[i] + " ");
        return new String(sb);
    }

}

public class HeapTest {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer[] arr = new Integer[] { 9,8,7,6,5, 4, 3, 2};
        MinHeap min = new MinHeap(arr);
        min.insert(10);
        min.deleMin();
        System.out.println(min);
        Integer[] arr2 = new Integer[] { 1, 2, 3, 4, 5,6,7,8,9,10};
        MaxHeap max = new MaxHeap(arr2);
        max.deleMax();
        max.insert(10);
        System.out.println(max);

    }
}
