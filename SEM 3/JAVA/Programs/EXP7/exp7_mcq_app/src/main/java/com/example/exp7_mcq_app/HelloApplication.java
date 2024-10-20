package com.example.exp7_mcq_app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class HelloApplication extends JFrame {
    private static final String DB_URL = "jdbc:mysql://localhost:3307/dbms";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";
    private final JLabel questionLabel;
    private final JRadioButton option1;
    private final JRadioButton option2;
    private final JRadioButton option3;
    private final JRadioButton option4;
    private final ButtonGroup optionsGroup;
    private int currentQuestion = 0;
    private ResultSet resultSet;
    private Connection connection;
    private int score = 0;
    private int correctAnswer;

    public HelloApplication() {
        setTitle("Java MCQ Test");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        questionLabel = new JLabel("Question");
        option1 = new JRadioButton("Option 1");
        option2 = new JRadioButton("Option 2");
        option3 = new JRadioButton("Option 3");
        option4 = new JRadioButton("Option 4");

        optionsGroup = new ButtonGroup();
        optionsGroup.add(option1);
        optionsGroup.add(option2);
        optionsGroup.add(option3);
        optionsGroup.add(option4);

        JButton nextButton = new JButton("Next");

        add(questionLabel);
        add(option1);
        add(option2);
        add(option3);
        add(option4);
        add(nextButton);

        loadQuestion();
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkAnswer();
                loadNextQuestion();
            }
        });
    }

    private void loadQuestion() {
        try {
            if (resultSet == null) {
                connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM mcq");
            }

            if (resultSet.next()) {
                String question = resultSet.getString("question");
                String opt1 = resultSet.getString("option1");
                String opt2 = resultSet.getString("option2");
                String opt3 = resultSet.getString("option3");
                String opt4 = resultSet.getString("option4");
                correctAnswer = resultSet.getInt("correct_answer");

                questionLabel.setText(question);
                option1.setText(opt1);
                option2.setText(opt2);
                option3.setText(opt3);
                option4.setText(opt4);

                optionsGroup.clearSelection();
            } else {
                showResult();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadNextQuestion() {
        currentQuestion++;
        loadQuestion();
    }

    private void checkAnswer() {
        int selectedOption = -1;
        if (option1.isSelected()) {
            selectedOption = 1;
        } else if (option2.isSelected()) {
            selectedOption = 2;
        } else if (option3.isSelected()) {
            selectedOption = 3;
        } else if (option4.isSelected()) {
            selectedOption = 4;
        }

        if (selectedOption == correctAnswer) {
            score++;
        }
    }

    private void showResult() {
        JOptionPane.showMessageDialog(this, "Test completed! Your score: " + score);
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HelloApplication frame = new HelloApplication();
            frame.setVisible(true);
        });
    }
}
