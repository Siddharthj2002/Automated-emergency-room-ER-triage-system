package priorityqueue;

public interface PriorityQueueADT<T> {

  /**
   * Adds this elelment to the queue.  
   * It will be placed by order of its priority.
   */ 
   public void enqueue(T item);
   
  /**
   * Removes and returns the element with highest priority from the queue.  
   * @throws QueueUnderflowException if queue is empty.
   */ 
   public T dequeue() throws QueueUnderflowException;

  /**
   * Returns the element with highest priority without removing it from the queue.  
   * @throws QueueUnderflowException if queue is empty.
   */ 
   public T peek() throws QueueUnderflowException;

  /**
   * Returns true if queue is empty, false otherwise. 
   */ 
   public boolean isEmpty();
   
    /**
   * Returns the number of data elements in the queue. 
   */ 
   public int size();
}
