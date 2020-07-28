package ro.jademy.millionaire.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {

    //----- Level list -----//
    private static final List<Level> LEVELS = Arrays.asList(
            new Level(1, 0, 100,0),
            new Level(2, 0, 200,0),
            new Level(3, 0, 300,0),
            new Level(4, 0, 500,0),
            new Level(5, 0, 1000,0),
            new Level(6, 1, 1500,1000),
            new Level(7, 1, 3000,1000),
            new Level(8, 1, 5000,1000),
            new Level(9, 1, 7500,1000),
            new Level(10, 1, 15000,1000),
            new Level(11, 2, 25000,15000),
            new Level(12, 2, 50000,15000),
            new Level(13, 2, 100000,15000),
            new Level(14, 2, 250000,150000),
            new Level(15, 3, 1000000,250000)


    ); // they will never change, so it can be put as constant

    //  Game properties
        // 15 questions
        // 4 breakpoints -> [lv. 1 - 5]   - difficulty 0
        //               -> [lv. 6 - 10]  - difficulty 1
        //               -> [lv. 11 - 14] - difficulty 2
        //               -> lv. 15        - difficulty 3

    //----- Difficulty lv. questions lists -----//
    private List<Question> difficultyZeroQuestion = new ArrayList<>();
    private List<Question> difficultyOneQuestion = new ArrayList<>();
    private List<Question> difficultyTwoQuestion = new ArrayList<>();
    private List<Question> difficultyThreeQuestion = new ArrayList<>();

    private Level currentLevel = LEVELS.get(0); // this will point towards every level

    // the game should know if the player used a lifeline or not
    // and how many of them have remain after using them

    //----- Setting a list of lifelines -----//
    private List<Lifeline> lifelines = new ArrayList<Lifeline>();

    public Game(List<Question> difficultyZeroQuestion, List<Question> difficultyOneQuestion, List<Question> difficultyTwoQuestion, List<Question> difficultyThreeQuestion) {
        this.difficultyZeroQuestion = difficultyZeroQuestion;
        this.difficultyOneQuestion = difficultyOneQuestion;
        this.difficultyTwoQuestion = difficultyTwoQuestion;
        this.difficultyThreeQuestion = difficultyThreeQuestion;

        //----- Initializing all lifelines -----//
            // as I mentioned in the Lifeline Class, I will only use 50-50 lifeline 3 times
            // until further changes
        lifelines.add(new Lifeline("50-50"));
        lifelines.add(new Lifeline("50-50"));
        lifelines.add(new Lifeline("50-50"));
    }
}
