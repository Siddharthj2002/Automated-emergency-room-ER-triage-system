package app;

import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.lang.Integer;

public class TriageSystemParser {

    private ArrayList<Patient> patients;

    public void readPatientFile(String pathString) throws IOException {

        File triageFile = new File (pathString);
        FileReader fReader = new FileReader (triageFile);
        BufferedReader bfReader = new BufferedReader(fReader);
        
        this.patients = new ArrayList<Patient> (); 
        String line;
        while ((line = bfReader.readLine()) != null) {
            String name = line;
            String lastName = bfReader.readLine();
            String age = bfReader.readLine();
            String condStr = bfReader.readLine();

            Condition condition = Condition.valueOf(condStr.toUpperCase());
            this.patients.add(
                new Patient(name, lastName, Integer.parseInt(age), condition));
        }
        bfReader.close();
        fReader.close();
    }

    public ArrayList<Patient> getPatients() {
        return this.patients;
    }

}
