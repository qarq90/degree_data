package EXP3;

import java.util.Scanner;

class User {
    int score = 0, id;
    String name;

    public void showResult() {
        System.out.println(id + "\t" + name + "\t" + score);
    }

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class MCQ {
    String question;
    String[] option;
    String topic;
    int answer;

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setOption(String[] option) {
        this.option = option;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public void dispMCQ() {
        System.out.println(question);
        for (int i = 0; i < 4; i++) {
            System.out.print((i + 1) + ". " + option[i] + "\t");
        }
        System.out.println("\n");
    }

    MCQ(String topic, String question, String[] option, int answer) {
        this.topic = topic;
        this.question = question;
        this.option = option;
        this.answer = answer;
    }
}

class EXP3d {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String topic1 = "Java";
        String[] question1 = {
                "Which of these is not a feature of Java?",
                "Which component of Java is responsible for running the compiled Java bytecode?",
                "Which feature of Java makes it possible to run a Java program on different platforms?",
                "In Java, how should class names be written?",
                "Which keyword is used to define a constant variable in Java?"
        };
        String[][] options1 = {
                {"Object-oriented", "Platform-independent", "Compiled", "Interpreted Language"},
                {"JDK", "JVM", "JRE", "JIT"},
                {"Object-oriented", "Platform-independent", "Syntax", "Memory Management"},
                {"camelCase", "snake_case", "PascalCase", "kebab-case"},
                {"final", "static", "const", "immutable"}
        };
        int[] answers1 = {3, 2, 2, 3, 1};

        String topic2 = "C++";
        String[] question2 = {
                "Identify the incorrect constructor type",
                "Identify the logical AND operator.",
                "Under which pillar of OOPS does base class and derived class relationship come?",
                "Using which of the following keywords can an exception be generated?",
                "What does a C++ class hold?"
        };
        String[][] options2 = {
                {"Friend constructor", "Default constructor", "Parameterized constructor", "Copy constructor"},
                {"||", "&&", "&", "!"},
                {"Polymorphism", "Inheritance", "Encapsulation", "Abstraction"},
                {"threw", "throws", "throw", "catch"},
                {"Function", "Data", "Arrays", "Both a and b"}
        };
        int[] answers2 = {1, 2, 2, 3, 4};

        MCQ[] mcqJava = new MCQ[5];
        MCQ[] mcqCpp = new MCQ[5];

        for (int i = 0; i < mcqJava.length; i++) {
            mcqJava[i] = new MCQ(topic1, question1[i], options1[i], answers1[i]);
        }

        for (int i = 0; i < mcqCpp.length; i++) {
            mcqCpp[i] = new MCQ(topic2, question2[i], options2[i], answers2[i]);
        }

        System.out.print("Please enter your ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Please enter your name: ");
        String name = sc.nextLine();

        System.out.println("Please choose your test topic: \n1. Java \t 2. C++");
        int choice = sc.nextInt();

        User user = new User(id, name); // renamed to User

        switch (choice) {
            case 1:
                for (int i = 0; i < mcqJava.length; i++) {
                    System.out.print("\n" + (i + 1) + ". ");
                    mcqJava[i].dispMCQ();
                    System.out.print("Your answer: ");
                    int answer = sc.nextInt();
                    if (answer == mcqJava[i].answer) {
                        user.score++;
                    }
                }
                break;

            case 2:
                for (int i = 0; i < mcqCpp.length; i++) {
                    System.out.print("\n" + (i + 1) + ". ");
                    mcqCpp[i].dispMCQ();
                    System.out.print("Your answer: ");
                    int answer = sc.nextInt();
                    if (answer == mcqCpp[i].answer) {
                        user.score++;
                    }
                }
                break;

            default:
                System.out.println("Invalid choice entered!\nExiting...");
                break;
        }

        System.out.println("\nID\tName\tScore");
        user.showResult();
    }
}
