package EXP4;

import java.util.Scanner;

interface Question {
    void displayQuestion();

    boolean checkAnswer(int userAnswer);
}

abstract class AbstractMCQ implements Question {
    String question;
    String[] options;
    int correctAnswer;

    public AbstractMCQ(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    @Override
    public boolean checkAnswer(int userAnswer) {
        return userAnswer == correctAnswer;
    }
}

class SimpleMCQ extends AbstractMCQ {
    public SimpleMCQ(String question, String[] options, int correctAnswer) {
        super(question, options, correctAnswer);
    }
}

public class MCQ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] options1 = {"7 - 1", "4 - 2", "5 - 3", "6 - 4"};
        SimpleMCQ mcq1 = new SimpleMCQ("What is 2 + 2?", options1, 2);

        String[] options2 = {"Paris - 1", "Hell - 2", "Toilet - 3", "Fire - 4"};
        SimpleMCQ mcq2 = new SimpleMCQ("What is the capital of France?", options2, 1);

        int score = 0;

        mcq1.displayQuestion();
        System.out.print("Your answer (1-4): ");
        int userAnswer1 = scanner.nextInt();
        if (mcq1.checkAnswer(userAnswer1)) {
            System.out.println("Correct Answer!");
            score++;
        } else {
            System.out.println("Wrong Answer!");
        }

        mcq2.displayQuestion();
        System.out.print("Your answer (1-4): ");
        int userAnswer2 = scanner.nextInt();
        if (mcq2.checkAnswer(userAnswer2)) {
            System.out.println("Correct Answer!");
            score++;
        } else {
            System.out.println("Wrong Answer!");
        }

        System.out.println("\nYour total score: " + score + "/" + 2);

        scanner.close();
    }
}
