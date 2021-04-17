package app;

import java.util.Comparator;

public class PatientAgeComparator implements Comparator<Patient> {

  /**
   * Compare patients by age, returning positive values if the age of pt1 is greater than the 
   * age of pt2. 
   * @param pt1 first patiend to be compared
   * @param pt2 second patient to be compared
   * @return positive int if {@code pt1 > pt2}, 0 if {@code pt1 == pt1}, negative int otherwise
   */
  public int compare(Patient pt1, Patient pt2) {
     return pt1.getAge() - pt2.getAge();
  }
}
