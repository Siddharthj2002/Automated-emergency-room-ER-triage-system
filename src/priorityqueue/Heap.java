package priorityqueue;

import java.util.Comparator;

public class Heap<T> implements PriorityQueueADT<T> {

  private T[] heap;
  private boolean isMaxHeap;
  private int numElements;
  private Comparator<T> comparator;
  private final static int INIT_SIZE = 5;

  @SuppressWarnings("unchecked")
  /**
   * Constructor for the heap.
   * 
   * @param comparator comparator object to define a sorting order for the heap
   *                   elements.
   * @param isMaxHeap  Flag to set if the heap should be a max heap or a min heap.
   */
  public Heap(Comparator<T> comparator, boolean isMaxHeap) {
    this.comparator = comparator;
    this.isMaxHeap = isMaxHeap;
    heap = (T[]) new Object[INIT_SIZE];
  }

  /**
   * This results in the entry at the specified index "bubbling up" to a location
   * such that the property of the heap are maintained. This method should run in
   * O(log(size)) time. Note: When enqueue is called, an entry is placed at the
   * next available index in the array and then this method is called on that
   * index.
   *
   * @param index the index to bubble up
   */
  public void bubbleUp(int index) {
    int parentIndex = getParentOf(index);
    if(isMaxHeap){
      if (index == 0 || comparator.compare(heap[parentIndex], heap[index]) >= 0) {
        return;
      }
      else {
        swap(parentIndex, index);
        bubbleUp(parentIndex);
      }
    }

    else if(!isMaxHeap){
      if (index == 0 || comparator.compare(heap[parentIndex], heap[index]) <= 0) {
        return;
      }
      else {
        swap(parentIndex, index);
        bubbleUp(parentIndex);
      }
    }
    
  }

  /**
   * This method results in the entry at the specified index "bubbling down" to a
   * location such that the property of the heap are maintained. This method
   * should run in O(log(size)) time. Note: When remove is called, if there are
   * elements remaining in this the bottom most element of the heap is placed at
   * the 0th index and bubbleDown(0) is called.
   * 
   * @param index
   */
  public void bubbleDown(int index) {
    int leftChild = getLeftChildOf(index);
    int rightChild = getRightChildOf(index);
    if(leftChild > size() - 1){
      return;
    }
    else if (heap[leftChild] == null && heap[rightChild] == null) {
      return;
    }
    
    if (!isMaxHeap) {
      int smallestChild = leftChild;
      if(rightChild > size() - 1 || heap[rightChild] == null);
      else if (comparator.compare(heap[rightChild], heap[leftChild]) < 0) {
        smallestChild = rightChild;
      }
      
      if (comparator.compare(heap[index], heap[smallestChild]) < 0) {
        return;
      }
      else{
        swap(index, smallestChild);
        bubbleDown(smallestChild);
      }
    }

    else if (isMaxHeap) {
      int largestChild = leftChild;
      if(rightChild > size() - 1 || heap[rightChild] == null);
      else if (comparator.compare(heap[leftChild], heap[rightChild]) < 0) {
        largestChild = rightChild;
      }

      if (comparator.compare(heap[index], heap[largestChild]) > 0) {
        return;
      }
      else{
        swap(largestChild, index);
        bubbleDown(largestChild);
      }
    }
  }

  /**
   * Test for if the queue is empty.
   * 
   * @return true if queue is empty, false otherwise.
   */
  public boolean isEmpty() {
    boolean isEmpty = false;
    if (size() == 0){
      isEmpty = true;
    }
    return isEmpty;
  }

  /**
   * Number of data elements in the queue.
   * 
   * @return the size
   */
  public int size() {
    int size = 0;
    for (int i = 0; i < heap.length; i++) {
      if (heap[i] != null)
        size++;
    }
    return size;
  }

  /**
   * Compare method to implement max/min heap behavior. It calls the compare
   * method from the comparator object and multiply its output by 1 and -1 if max
   * and min heap respectively.
   * 
   * @param element1 first element to be compared
   * @param element2 second element to be compared
   * @return positive int if {@code element1 > element2}, 0 if
   *         {@code element1 == element2}, negative int otherwise
   */
  public int compare(T element1, T element2) {
    int result = 0;
    int compareSign = -1;
    if (isMaxHeap) {
      compareSign = 1;
    }
    result = compareSign * comparator.compare(element1, element2);
    return result;
  }

  /**
   * Return the element with highest (or lowest if min heap) priority in the heap
   * without removing the element.
   * 
   * @return T, the top element
   * @throws QueueUnderflowException if empty
   */
  public T peek() throws QueueUnderflowException {
    if (isEmpty()) {
      throw new QueueUnderflowException("Queue is empty.");
    }
    T data = null;
    data = heap[0];
    return data;
  }

  /**
   * Removes and returns the element with highest (or lowest if min heap) priority
   * in the heap.
   * 
   * @return T, the top element
   * @throws QueueUnderflowException if empty
   */
  public T dequeue() throws QueueUnderflowException {
    T data = null;
    if (isEmpty()) {
      throw new QueueUnderflowException("Queue is empty.");
    }
    int lastIndex = size() - 1;
    data = heap[0];
    swap(0, lastIndex);
    heap[lastIndex] = null;
    bubbleDown(0);
    return data;
  }

  /**
   * Enqueue the element.
   * 
   * @param the new element
   */
  public void enqueue(T newElement) {
    if (numElements == heap.length) {
      expandCapacity();
    }
    heap[numElements] = newElement;
    bubbleUp(numElements);
    numElements++;
  }

  private int getLeftChildOf(int parentIndex) {
    return (2 * parentIndex) + 1;
  }

  private int getRightChildOf(int parentIndex) {
    return (2 * parentIndex) + 2;
  }

  private int getParentOf(int childIndex) {
    return (childIndex - 1) / 2;
  }

  private void swap(int index1, int index2) {
    T temp = heap[index1];
    heap[index1] = heap[index2];
    heap[index2] = temp;
  }

  @SuppressWarnings("unchecked")
  private void expandCapacity() {
    int origSize = heap.length;
    T[] tempArray = (T[]) new Object[origSize];
    for (int i = 0; i < origSize; i++) {
      tempArray[i] = heap[i];
    }
    heap = (T[]) new Object[origSize * 2];
    for (int i = 0; i < origSize; i++) {
      heap[i] = tempArray[i];
    }
  }

}