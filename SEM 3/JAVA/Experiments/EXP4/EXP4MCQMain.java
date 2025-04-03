import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface EXP4Question {
    void displayQuestion();

    boolean checkAnswer(String answer);
}

abstract class EXP4AbstractMCQ implements EXP4Question {
    protected String questionText;
    protected List<String> options;
    protected String correctAnswer;

    public EXP4AbstractMCQ(String questionText, List<String> options, String correctAnswer) {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void displayQuestion() {
        System.out.println("Question: " + questionText);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }
}

class EXP4MCQ extends EXP4AbstractMCQ {

    public EXP4MCQ(String questionText, List<String> options, String correctAnswer) {
        super(questionText, options, correctAnswer);
    }

    public boolean checkAnswer(String answer) {
        return answer.equalsIgnoreCase(correctAnswer);
    }
}

public class EXP4MCQMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<EXP4MCQ> questions = new ArrayList<>();

        List<String> options1 = new ArrayList<>();
        options1.add("Java");
        options1.add("Python");
        options1.add("C++");
        options1.add("JavaScript");
        questions.add(new EXP4MCQ("Which programming language is platform-independent?", options1, "Java"));

        List<String> options2 = new ArrayList<>();
        options2.add("Hypertext Transfer Protocol");
        options2.add("Hyper Transfer Text Protocol");
        options2.add("Hyper Transfer Tool Protocol");
        options2.add("None of the above");
        questions.add(new EXP4MCQ("What does HTTP stand for?", options2, "Hypertext Transfer Protocol"));

        List<String> options3 = new ArrayList<>();
        options3.add("Alan Turing");
        options3.add("Tim Berners-Lee");
        options3.add("Linus Torvalds");
        options3.add("Dennis Ritchie");
        questions.add(new EXP4MCQ("Who is known as the father of the World Wide Web?", options3, "Tim Berners-Lee"));

        for (EXP4MCQ mcq : questions) {
            mcq.displayQuestion();
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine();

            if (mcq.checkAnswer(userAnswer)) {
                System.out.println("Correct answer!\n");
            } else {
                System.out.println("Incorrect answer. The correct answer is: " + mcq.correctAnswer + "\n");
            }
        }

        scanner.close();
    }
}
