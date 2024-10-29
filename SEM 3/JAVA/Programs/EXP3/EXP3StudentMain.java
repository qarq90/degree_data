class EXP3Student {
    private String name;
    private int rollNumber;
    private String course;

    public EXP3Student() {
        this.name = "Unknown";
        this.rollNumber = 0;
        this.course = "None";
    }

    public EXP3Student(String name, int rollNumber, String course) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
    }

    public void setInfo() {
        this.name = "Default Name";
        this.rollNumber = 1;
        this.course = "Default Course";
    }

    public void setInfo(String name, int rollNumber, String course) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
    }

    public void showStudent() {
        System.out.println("Name: " + name + ", Roll Number: " + rollNumber + ", Course: " + course);
    }
}

public class EXP3StudentMain {
    public static void main(String[] args) {
        EXP3Student student1 = new EXP3Student();
        student1.showStudent();

        EXP3Student student2 = new EXP3Student("Alice", 101, "Mathematics");
        student2.showStudent();

        EXP3Student student3 = new EXP3Student();
        student3.setInfo("Bob", 102, "Science");
        student3.showStudent();
    }
}
