package ro.jademy.millionaire.model;

import java.util.*;

public class Game {

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

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

    //----- Difficulty lv. questions lists -----//
    private List<Question> difficultyZeroQuestion = new ArrayList<>();
    private List<Question> difficultyOneQuestion = new ArrayList<>();
    private List<Question> difficultyTwoQuestion = new ArrayList<>();
    private List<Question> difficultyThreeQuestion = new ArrayList<>();

    private Level currentLevel = LEVELS.get(0); // this will point towards every level

    // the game should know if the player used a lifeline or not
    // and how many of them have remain after using them

    //----- Setting a list of lifelines -----//
    private List<Lifeline> lifelines = new ArrayList<>();
    int indexLevel = 0;

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

    public void start() {

        // show welcome screen
        // show rules & commands

        // show current level question
        // read input from player
            // if lifeline -> apply lifeline
            // if walk out -> end game
            // read answer -> check answer
                // if answer correct -> go to next level (set next level as current, etc.)
                // if answer incorrect -> end game -> show rewardBreakout -> ask if we want to play again

        boolean gameContinue = false;
        showWelcome();
        showRules(lifelines);

        do {
            currentLevel = LEVELS.get(indexLevel);
            if (currentLevel.getDifficultyLevel() == 0) {
                List<Answer> questionAnswers = askQuestion(difficultyZeroQuestion, currentLevel);
                gameContinue = answerQuestion(difficultyZeroQuestion, questionAnswers);

            } else if (currentLevel.getDifficultyLevel() == 1) {
                List<Answer> questionAnswers = askQuestion(difficultyOneQuestion, currentLevel);
                gameContinue = answerQuestion(difficultyOneQuestion, questionAnswers);

            } else if (currentLevel.getDifficultyLevel() == 2) {
                List<Answer> questionAnswers = askQuestion(difficultyTwoQuestion, currentLevel);
                gameContinue = answerQuestion(difficultyTwoQuestion, questionAnswers);
            } else if (currentLevel.getDifficultyLevel() == 3) {
                List<Answer> questionAnswers = askQuestion(difficultyThreeQuestion, currentLevel);
                gameContinue = answerQuestion(difficultyThreeQuestion, questionAnswers);
                if (gameContinue) {
                    System.out.println("Congrats, you've WON : " + currentLevel.getReward() + " !!");
                    gameContinue = false;
                    break;
                }
            } else {
                System.out.println("No difficulty found for currentLevel");
            }

            if (gameContinue) {
                indexLevel++;
                System.out.println("Proceeding to next level: " + currentLevel.getNumber());
            }
        } while (gameContinue);
    }

    private void showWelcome() {
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.println("|             WELCOME TO             |");
        System.out.println("|  'Who Wants To Be A Millionaire' ! |");
        System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.out.println();
    }

    private void showRules(List<Lifeline> lifelineList) {
        boolean validateInput = false;

        System.out.println("The game's rules are: ");
        System.out.println("You have 15 question to answer. Each question has 4 answer options" +
                "which only 1 of them is correct");
        System.out.println("The 50-50 lifeline offers you 2 potential correct answers out of 4." +
                "\nUse it wisely, you only benefit of " + lifelineList.size() + "50-50 lifeline.");
        System.out.println("The game has 4 reward checkpoints! If you answer incorrectly" +
                "before the checkpoint, you'll get nothing!" +
                "\nbut if you do it after the checkpoint, you will still get that level's prize reward");
        System.out.println("If by any means, you want to walk out, you will receive the last reward checkpoint" +
                "you've reached!");
        System.out.println("[To answer questions, type 1, 2, 3 ir 4] [L for Lifeline] [W to Walk away]");
        System.out.println();
    }

    private List<Answer> askQuestion(List<Question> questionList, Level currentLevel) {
        System.out.println("Prize: " + currentLevel.getReward() + ", \nCheckpoint reward: "
                + currentLevel.getRewardBreakout() + "\n");
        System.out.println(questionList.get(0).getText());

        List<Answer> allAnswers = new ArrayList<>();
        allAnswers.addAll(questionList.get(0).getWrongAnswers());
        allAnswers.add(random.nextInt(allAnswers.size()), questionList.get(0).getCorrectAnswer());
        printAnswers(allAnswers);

        return allAnswers;
    }

    private void printAnswers(List<Answer> answerList) {
        String middleEmptySpace = " ";
        int maxLength = 0;
        for (int i = 0; i < answerList.size(); i++) {
            if (answerList.get(i).getText().length() > maxLength) {
                maxLength = answerList.get(i).getText().length();
            }
        }
        for (int i = 0; i < answerList.size(); i++) {
            System.out.print((i + 1) + ". ");
            System.out.printf("%-" + maxLength + "s", answerList.get(i).getText());
            if (i % 2 == 0) {
                System.out.print(middleEmptySpace);
            } else {
                System.out.println();
            }
        }
    }

    private boolean answerQuestion(List<Question> questionList, List<Answer> allAnswers) {
        boolean isCorrectAnswer;
        String choice = validInputAnswer(false);
        isCorrectAnswer = inputSwitchCase(choice, false, allAnswers, questionList);

        return isCorrectAnswer;
    }

    private String validInputAnswer(boolean helpUsed) {
        String input = "";
        boolean isValid = false;
        do {
            if (helpUsed) {
                System.out.println("[To answer questions, type 1, 2, 3 or 4] [L for Lifeline] [W to Walk away]");
            } else {
                System.out.println("[Choose an option by typing 1, 2, 3, 4 ] [L for Lifeline: "
                        + lifelines.size() + "] [W to Walk away] ");
            }

            input = scanner.nextLine();
            switch (input) {
                case "1":
                    input = "1";
                    isValid = true;
                    break;
                case "2":
                    input = "2";
                    isValid = true;
                    break;
                case "3":
                    input = "3";
                    isValid = true;
                    break;
                case "4":
                    input = "4";
                    isValid = true;
                    break;
            }
            if (input.equalsIgnoreCase("L")) {
                if (helpUsed || lifelines.size() == 0) {
                    //empty code block
                } else {
                    input = "L";
                    isValid = true;
                }
            } else if (input.equalsIgnoreCase("W")) {
                input = "W";
                isValid = true;
            }
        } while (!isValid);
        return input;
    }

    private String validInputYesOrNo() {
        boolean isValid = false;
        String temp;
        do {
            System.out.println("[Type Y/N]");
            temp = scanner.nextLine();
            if (temp.equalsIgnoreCase("y")) {
                isValid = true;
            } else if (temp.equalsIgnoreCase("n")) {
                isValid = true;
            }
        } while (!isValid);
        return temp;
    }

    private boolean inputCase(int position, List<Answer> allAnswers, List<Question> questionList) {
        boolean isCorrectAnswer;
        if (allAnswers.get(position).getText().equals
                (questionList.get(0).getCorrectAnswer().getText())) {
            isCorrectAnswer = true;
            System.out.println("\nThat was CORRECT! \n");
            questionList.remove(0);
        } else {
            System.out.println("\nWRONG answer! \n" );
            System.out.println("Reward Checkpoint: " + currentLevel.getRewardBreakout());
            isCorrectAnswer = false;
        }
        return isCorrectAnswer;
    }

    private boolean inputSwitchCase(String choice, boolean helpUsed, List<Answer> allAnswers, List<Question> questionList) {
        boolean isCorrectAnswer = false;
        switch (choice) {
            case "1":
                isCorrectAnswer = inputCase(0, allAnswers, questionList);
                break;
            case "2":
                isCorrectAnswer = inputCase(1, allAnswers, questionList);
                break;
            case "3":
                isCorrectAnswer = inputCase(2, allAnswers, questionList);
                break;
            case "4":
                isCorrectAnswer = inputCase(3, allAnswers, questionList);
                break;
            case "L":
                if (!helpUsed && lifelines.size() > 0) {
                    lifelines.remove(0);
                    int wrongAnswerSize = questionList.get(0).getWrongAnswers().size();
                    String wrongAnswerString = questionList.get(0).getWrongAnswers().get(random.nextInt(wrongAnswerSize)).getText();

                    int indexCorrectAnswer = -1;
                    for (int i = 0; i < allAnswers.size(); i++) {
                        if (questionList.get(0).getCorrectAnswer().getText().equals(allAnswers.get(i).getText())) {
                            indexCorrectAnswer = i;
                        }
                    }

                    for (int i = 0; i < allAnswers.size(); i++) {
                        if (allAnswers.get(i).getText().equals(wrongAnswerString) || i == indexCorrectAnswer) {

                        } else {
                            allAnswers.set(i, new Answer(""));
                        }
                    }

                    System.out.println(questionList.get(0).getText());
                    printAnswers(allAnswers);

                    choice = validInputAnswer(true);
                    isCorrectAnswer = inputSwitchCase(choice, true, allAnswers, questionList);
                }
                break;

            case "W":
                System.out.println("Reward: " + currentLevel.getReward());
                isCorrectAnswer = false;
                break;
        }
        return isCorrectAnswer;
    }

}
