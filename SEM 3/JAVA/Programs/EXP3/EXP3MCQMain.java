import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class EXP3MCQ {
    private String question;
    private List<String> options;
    public String correctAnswer;

    public EXP3MCQ(String question, List<String> options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println("Question: " + question);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}

public class EXP3MCQMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> options = new ArrayList<>();
        options.add("Java");
        options.add("Python");
        options.add("C++");
        options.add("JavaScript");

        EXP3MCQ mcq = new EXP3MCQ("Which language is platform-independent?", options, "Java");

        mcq.displayQuestion();
        System.out.print("Your answer: ");
        String userAnswer = scanner.nextLine();

        if (mcq.checkAnswer(userAnswer)) {
            System.out.println("Correct answer!");
        } else {
            System.out.println("Incorrect answer. The correct answer is: " + mcq.correctAnswer);
        }

        scanner.close();
    }
}
