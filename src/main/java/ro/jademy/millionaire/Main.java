package ro.jademy.millionaire;

import ro.jademy.millionaire.database.QuestionProvider;
import ro.jademy.millionaire.model.Game;
import ro.jademy.millionaire.model.Question;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Step 1. Define objects
            // define properties
            // define methods

        // Step 2. Define interactions


        //----- Initialize questions -----//
        List<Question> difficultyZeroQuestion = getRandomQuestions(5, 0);
        List<Question> difficultyOneQuestion = getRandomQuestions( 5, 1);
        List<Question> difficultyTwoQuestion = getRandomQuestions(4, 2);
        List<Question> difficultyThreeQuestion = getRandomQuestions(1, 0);

        //----- Initialize game -----//
        Game game = new Game(difficultyZeroQuestion, difficultyOneQuestion, difficultyTwoQuestion, difficultyThreeQuestion);

        // TODO: Start the game
        //game.start();
    }

    //----- Method to return some random questions based on their difficulty -----//
        // this method will be parametrise with difficulty and nr of questions.
    private static List<Question> getRandomQuestions(int nrOfQuestions, int difficulty) {
        // TODO: Algorithm:
            // loop through all questions
            // get all questions of given difficulty
            // loop through sub-list until nrOfQuestions and select random items by index
            // return said list

        List<Question> questionsOfDiff = new ArrayList<>();
        List<Question> questionsRandom = new ArrayList<>();
        for (Question question: QuestionProvider.ALL_QUESTIONS) {
            if (question.getDifficulty() == difficulty) {
                questionsOfDiff.add(question);
            }
        }
        Random random = new Random();
        for (int i = 0; i < nrOfQuestions; i++) {
            int randomIndex = random.nextInt(questionsOfDiff.size());
            questionsRandom.add(questionsOfDiff.remove(randomIndex));
        }
        return questionsRandom;
    }
}
