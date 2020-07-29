package ro.jademy.millionaire;

import ro.jademy.millionaire.database.QuestionProvider;
import ro.jademy.millionaire.model.Game;
import ro.jademy.millionaire.model.Question;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Step 1. Define objects
            // define properties
            // define methods

        // Step 2. Define interactions


        //----- Initialize questions -----//
        List<Question> difficultyZeroQuestion = QuestionProvider.getRandomQuestions(5, 0);
        List<Question> difficultyOneQuestion = QuestionProvider.getRandomQuestions( 5, 1);
        List<Question> difficultyTwoQuestion = QuestionProvider.getRandomQuestions(4, 2);
        List<Question> difficultyThreeQuestion = QuestionProvider.getRandomQuestions(1, 3);

        //----- Initialize game -----//
        Game game = new Game(difficultyZeroQuestion, difficultyOneQuestion, difficultyTwoQuestion, difficultyThreeQuestion);

        game.start();


    }
}
