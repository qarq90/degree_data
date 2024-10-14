package EXP3;

import java.util.Scanner;

class student {
    int age;
    String name, address;

    public void setInfo(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setInfo(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void showInfo() {
        System.out.println(name + " \t " + age + " \t " + address);
    }

    student() {
        this.name = "unknown";
        this.age = 0;
        this.address = "not available";
    }

    student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}

class EXP3b {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        student[] s = new student[10];
        System.out.println("Please enter the details of the students:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Student " + (i + 1));
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Address: ");
            String address = sc.next();
            System.out.print("Age: ");
            int age = sc.nextInt();
            s[i] = new student(name, age, address);
        }

        for (int i = 5; i < s.length; i++) {
            s[i] = new student();
        }
        for (int i = 5; i < 7; i++) {
            System.out.println("Student " + (i + 1));
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Address: ");
            String address = sc.next();
            System.out.print("Age: ");
            int age = sc.nextInt();
            s[i].setInfo(name, age, address);
        }
        for (int i = 8; i < s.length; i++) {
            System.out.println("Student " + (i + 1));
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Age: ");
            int age = sc.nextInt();
            s[i].setInfo(name, age);
        }
        for (int i = 5; i < s.length; i++) {
            System.out.print((i + 1) + ".\t");
            s[i].showInfo();
        }
    }
}

