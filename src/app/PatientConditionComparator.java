package app;

import java.util.Comparator;

public class PatientConditionComparator implements Comparator<Patient> {

  /**
   * The compare method returns positive values if the condition of pt1
   * is more severe than the condition of pt2. If the severity is the same, it returns
   * positive values if the age of pt1 is greater than the age of pt2.
   * The Condition levels in increasing severity are: LIGHT, MILD, SEVERE, CRITICAL
   * These are modeled by an Enum Object, which encapsulates data types that model a 
   * set of discrete values.
   * 
   * @param pt1 first patient to be compared
   * @param pt2 second patient to be compared
   * @return positive int if {@code pt1 > pt2}, 0 if {@code pt1 == pt1}, negative int otherwise
   */
  public int compare(Patient pt1, Patient pt2) {
    int result = -100;  
    if (pt1.getCondition() == pt2.getCondition())
       result =  pt1.getAge() - pt2.getAge();
    else
        result = pt1.getCondition().ordinal() - pt2.getCondition().ordinal();
     return result;
  }
}
