package JavaDataStruct;

public class Queue {

    private int [] queArray;
    private int maxSize;
    public int front;   //存储队头元素的下标
    public int rear;    //存储队尾元素的下标
    private int length; //队列长度

    //构造方法，初始化队列
    public Queue(int maxSize){
        this.maxSize = maxSize;
        queArray = new int [maxSize];
        front = 0;
        rear = -1;
        length = 0;
    }

    //插入
    public void insert(int elem) throws Exception{
        if(isFull()){
            throw new Exception("队列已满，不能进行插入操作！");
        }
        //如果队尾指针已到达数组的末端，插入到数组的第一个位置
        if(rear == maxSize-1){
            rear = -1;
        }
        queArray[++rear] = elem;
        length++;
    }

    //移除
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("队列为空，不能进行移除操作！");
        }
        int elem = queArray[front++];
        //如果队头指针已到达数组末端，则移到数组第一个位置
        if(front == maxSize){
            front = 0;
        }
        length--;
        return elem;
    }

    //查看队头元素
    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("队列内没有元素！");
        }
        return queArray[front];
    }

    //获取队列长度
    public int size(){
        return length;
    }

    //判空
    public boolean isEmpty(){
        return (length == 0);
    }

    //判满
    public boolean isFull(){
        return (length == maxSize);
    }

}
class PriorityQueue {
    /*
    * 优先级队列中，数据项按关键字的值排序，数据项插入的时候会按照顺序插入到合适的位置
    * 除了可以快速访问优先级最高的数据项，优先级队列还应该可以实现相当快的插入，
    * 因此，优先级队列通常使用一种称为堆的数据结构来实现。
    * 在下例中，仍然使用数组来实现
    *
    * */
    private int [] queArray;
    private int maxSize;
    private int length; //队列长度
    private int referencePoint;  //基准点

    //构造方法，初始化队列
    public PriorityQueue(int maxSize,int referencePoint){
        this.maxSize= maxSize;
        this.referencePoint =referencePoint;
        queArray = new int [maxSize];
        length = 0;
    }

    //插入
    public void insert(int elem) throws Exception{
        if(isFull()){
            throw new Exception("队列已满，不能进行插入操作！");
        }

        //如果队列为空，插入到数组的第一个位置
        if(length == 0){
            queArray[length++] = elem;
        }else{
            int i;
            for(i=length;i>0;i--){

                int dis =Math.abs(elem-referencePoint);  //待插入元素的距离
                int curDis =Math.abs(queArray[i-1]-referencePoint); //当前元素的距离

                //将比插入元素优先级高的元素后移一位
                if(dis>= curDis){
                    queArray[i] =queArray[i-1];
                }else{
                    break;
                }
            }
            queArray[i] = elem;
            length++;
        }
    }

    //移除
    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("队列为空，不能进行移除操作！");
        }
        int elem = queArray[--length];
        return elem;
    }

    //查看队头元素
    public int peek() throws Exception{
        if(isEmpty()){
            throw new Exception("队列内没有元素！");
        }
        return queArray[length-1];
    }

    //返回队列长度
    public int size(){
        return length;
    }

    //判空
    public boolean isEmpty(){
        return (length == 0);
    }

    //判满
    public boolean isFull(){
        return (length == maxSize);
    }

}


