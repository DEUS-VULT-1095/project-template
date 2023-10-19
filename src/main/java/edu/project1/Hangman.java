package edu.project1;


public final class Hangman {
    private static final int MAX_ATTEMPTS = 5;

    private Hangman() {
    }

    public static void run(Dictionary dictionary, int numberOfAttempts) throws Exception {
        Session session = new Session(dictionary, numberOfAttempts);
        session.startGame();
    }

    // чекстайл ругался, как я понял не из за отсутствия комментариев, а, возможно, из за названия main
    @SuppressWarnings("UncommentedMain")
    public static void main(String[] args) throws Exception {
        // Создаём словарь
        Dictionary dictionary = new MyDictionary();
        // Запускаем игру
        run(dictionary, MAX_ATTEMPTS);
    }
}
