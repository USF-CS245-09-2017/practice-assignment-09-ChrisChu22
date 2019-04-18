public class BinaryHeap
{

    //instance data
    int[] data;
    int size = 0;

    //constructor
    public BinaryHeap()
    {
        size = 0;
        data = new int[10];
    }

    //add method
    void add(int num)
    {
        if(size >= data.length)
        {
            growArray();
        }
        data[size++] = num;
        int current = size-1;
        int parent = (current-1)/2;
        while (data[current] < data[parent] && current != 0)
        {
            swap(data,current,parent);
            current = parent;
            parent = (parent - 1)/2;
        } //while
    } //add

    void growArray()
    {
        int[] temp = new int[data.length * 2];
        for(int i = 0; i < data.length; i++)
        {
            temp[i] = data[i];
        }

        data = temp;
    } //growarray

    int remove()
    {
        swap(data,0,size-1);
        size--;
        if (size > 0)
            shiftdown(0);
        return data[size];
    } //remove

    void shiftdown(int i)
    {
        int leftChildIndex = leftChild(i);
        int rightChildIndex = rightChild(i);
        int minIndex;
        int temp;

        if (rightChildIndex >= size)
        {
            if (leftChildIndex >= size)
                return;
            else
                minIndex = leftChildIndex;
        } //if
        else
        {
            if (data[leftChildIndex] <= data[rightChildIndex])
                minIndex = leftChildIndex;
            else
                minIndex = rightChildIndex;
        }
        if (data[i] > data[minIndex])
        {
            temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
            shiftdown(minIndex);
        }
    } //shiftdown

    int leftChild(int i)
    {
        return i * 2 + 1;
    } //leftchild

    int rightChild(int i)
    {
        return i * 2 + 2;
    } //rightchild

    int parent(int i)
    {
        return (i - 1)/2;
    } //parent

    void swap(int[] b, int i, int j)
    {
        int temp = b[i];
        b[i] = b[j];
        b[j] = temp;
    } //swap
}
