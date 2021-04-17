package app;

public class Patient {

    private String name;
    private String lastName;
    private int age;
    private Condition condition;

    public Patient() {}

    public Patient(String name, String lastName, int age, Condition condition) {
        setName(name);
        setLastName(lastName);
        setAge(age);
        setCondition(condition);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public Condition getCondition(){
        return this.condition;
    }

    public void setCondition (Condition condition) {
        this.condition = condition;
    }

    public String toString() {
        return "Patient: " + this.name + ", " + this.lastName + ", " + this.age + ", " + this.condition;
    }
}
