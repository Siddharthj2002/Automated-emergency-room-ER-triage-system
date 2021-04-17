# Priority-Queue

● Overview:

  The project implements a futuristic automated emergency room (ER) triage system.
  The system receives data in the form of patient and injury pairs over time and automatically
  assign patients to doctors as the resources become available depending on the severity of the
  patient’s injury. To accomplish this, we implement a data structure called a priority queue –
  more specifically, a heap-based priority queue. In this scenario, the priority of each patient is
  commensurate with the severity of their injury or age of the patient (depending on the
  comparator being used). Importantly, a priority queue accomplishes this task in an efficient way.
  Despite this specific setting, our implementation will be generic enough to work with all types of
  data and could be applied to other real world problems.

  _________________________________


● Project Goals:


  -> Implement an efficient abstract priority queue using an array-based heap.
  
  -> Write code adhering to the provided style guide.
  
  -> Use abstract comparators in a meaningful context.
  
  -> Demonstrate your ability to read and understand a specification by implementing it.
  
  -> Continue developing your ability to write JUnit test cases from a specification.
  
  _________________________________
  
  
● Project Background

  Essentially, a medical triage is a system in which patients come and go and its behavior is similar to a
  processor executing tasks following a priority schedule. Patients will arrive one at a time with
  varying severity of conditions. The system will also provide the possibility of ordering by patient
  age instead of their condition. With a finite number of doctors and ER beds, the program must decide which 
  patients get treated in which order automatically. Naturally, we want the system to have the patients with 
  the more severe conditions be treated first. 

  To accomplish this, we will implement a priority queue using an array-based heap.
  The main interface and data structure in this program is a priority queue. Patients are enqueued
  when they arrive and dequeued as they are treated and released. The priority is on the patient’s
  condition, which has these levels in increasing order of priority: LIGHT, MILD, SEVERE,
  CRITICAL. Thus, all CRITICAL patients would be treated first, SEVERE patients second, etc. To
  offer more flexibility, this application can also prioritize patients by age.
  The priority queue is implemented with a heap in this application. 

  Each element in the tree will represent a specific patient
  with priority commensurate with the severity of the injury (or their age if that is the chosen
  priority). We want the patients with worse conditions to be treated first, so our heap invariant is:
  every child node will have less than or equal severity (priority) than its parent. Therefore, it can
  be inferred that the root node will always have the highest priority of any element in the heap.
  This describes a max heap. We must maintain the heap-invariant as patients arrive, enqueued
  onto the priority queue (added to the heap) and are treated, dequeued from the priority queue
  (removed from the heap). 

  Note :  In this program, the heap can also be configured to function
  as a min heap. In that case, the root has the lowest priority, and child nodes have priority less
  than or equal to their parent.

  While there are many ways to store a binary tree in memory, we opt for the space efficient
  array-based allocation. The array implementation also provides a simple way to navigate the
  heap by calculating parent and child indexes.
  
  _________________________________
  
  
● Contributing

  If you want to contribute to this project and make it better with new ideas, your pull request is very welcomed. 
  If you find any issue just put it in the repository issue section, thank you.
