package app;

import java.util.ArrayList;
import java.util.Comparator;
import java.io.IOException;
import priorityqueue.*;

public class AppMain {

  public static void main(String[] args) {

    /*
     *  Load info from small file to help debug. After you have the code working, use 'large_input.txt'
     *  in the line below to debug with more elements. 
     *  NOTE: do not run this until you have correctly implemented the isEmpty method!
     * */
    String fileName = "large_input.txt";
    TriageSystemParser triageFileParser = new TriageSystemParser();
    try {
      triageFileParser.readPatientFile(fileName);
    } catch (IOException e) {
      e.printStackTrace();
      return;
    }
    ArrayList<Patient> patients = triageFileParser.getPatients();

    Comparator<Patient> comparator = new PatientConditionComparator();
    // Swap in the PatientAgeComparator to prioritize on age rather than condition.
    // Comparator<Patient> comparator = new PatientAgeComparator();

    // Change priority from max to min.
    boolean isMaxHeap = true;
    
    PriorityQueueADT<Patient> queue = new Heap<Patient> (comparator, isMaxHeap);
    for (Patient patient : patients) {
      queue.enqueue(patient);
    }
    while(!queue.isEmpty()){
        System.out.println(queue.dequeue());
    }
  }
}
