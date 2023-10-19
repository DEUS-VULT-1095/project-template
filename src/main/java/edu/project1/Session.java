package edu.project1;

import java.util.Arrays;
import java.util.Scanner;

public class Session {
    private final Dictionary dictionary;
    private final int numberOfAttempts;
    private int currentMistakes = 0;
    private String answer;
    private final Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("RegexpSinglelineJava")
    public Session(Dictionary dictionary, int numberOfAttempts) {
        this.dictionary = dictionary;
        this.numberOfAttempts = numberOfAttempts;
        System.out.println("Type 'exit' to terminate\n");
    }

    @SuppressWarnings({"RegexpSinglelineJava", "ReturnCount"})
    public void startGame() {
        String[] hiddenWordArray = dictionary.getWord().split("");

        if (hiddenWordArray.length < 2) {
            throw new RuntimeException("Incorrect riddle word");
        }

        String[] codedWordArray = new String[hiddenWordArray.length];
        Arrays.fill(codedWordArray, "*");

        while (currentMistakes < numberOfAttempts) {
            System.out.println("Guess a letter:");

            do {
                answer = scanner.next().toLowerCase();
                if (answer.equalsIgnoreCase("exit")) {
                    return;
                }
            } while (answer.length() != 1 || !answer.matches("[A-Za-z]"));

            if (Arrays.stream(hiddenWordArray).anyMatch(w -> w.equals(answer))) {

                for (int i = 0; i < hiddenWordArray.length; i++) {
                    if (hiddenWordArray[i].equals(answer)) {
                        codedWordArray[i] = hiddenWordArray[i];
                    }
                }

                System.out.println("Hit!\n");
                displayCodedWord(codedWordArray);

                if (Arrays.stream(codedWordArray).noneMatch(w -> w.equals("*"))) {
                    System.out.println("You won!\n");

                    repeatGameOrStop();
                    return;
                }
            } else {
                System.out.format("Missed, mistake %d out of %d", ++currentMistakes, numberOfAttempts);
                System.out.println("\n");
                displayCodedWord(codedWordArray);
            }
        }

        System.out.println("You lost!\n");

        // Закомментил часть своей логики(не требуется в задании), т.к. нужно было сделать хоть какой нибудь тест, а при
        // тестировании ввода - у меня виснет всё в ожидании ввода. Установка System.setIn() не помогает.
        //repeatGameOrStop();
    }

    @SuppressWarnings({"RegexpSinglelineJava", "ReturnCount"})
    private void repeatGameOrStop() {
        System.out.println("You want to play some more? Y/N?");

        while (true) {
            answer = scanner.next();

            if (answer.equalsIgnoreCase("Y")) {
                currentMistakes = 0;
                this.startGame();
                return;
            } else if (answer.equalsIgnoreCase("N")) {
                return;
            }
        }
    }

    @SuppressWarnings("RegexpSinglelineJava")
    private void displayCodedWord(String[] codedWordArray) {
        System.out.print("The word: ");
        Arrays.stream(codedWordArray).forEach(System.out::print);
        System.out.println("\n");
    }
}
