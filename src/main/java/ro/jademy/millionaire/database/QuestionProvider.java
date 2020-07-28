package ro.jademy.millionaire.database;

import ro.jademy.millionaire.model.Answer;
import ro.jademy.millionaire.model.Question;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuestionProvider {

    public static List<Question> ALL_QUESTIONS = Arrays.asList(
            new Question("How many Shrek movies are there in total?", Arrays.asList( // this is question's text
                    new Answer("Five"),   //
                    new Answer("Two"),   //  those are the wrong answers
                    new Answer("Six")  //
            ), new Answer("Four"), 0),       //  this is the correct answer
            new Question("Which is the closest star to the Earth??", Arrays.asList(
                    new Answer("Mars"),
                    new Answer("Alpha Centauri A"),
                    new Answer("Alpha Centauri B")
            ), new Answer("The Sun"), 0),
            new Question("What animal was Flipper from the popular 1964 children's show 'Flipper'?", Arrays.asList(
                    new Answer("Whale"),
                    new Answer("Seal"),
                    new Answer("Dog")
            ), new Answer("Dolphin"), 0),
            new Question("What are the names of the two main characters from the cartoon 'Gravity Falls'?", Arrays.asList(
                    new Answer("MaryAnn and Dylan"),
                    new Answer("Megan and Dylan"),
                    new Answer("Mabel and Skipper")
            ), new Answer("Mabel and Dipper"), 0),
            new Question("Which of these is not a book of the Bible?", Arrays.asList(
                    new Answer("Kings"),
                    new Answer("Judges"),
                    new Answer("Numbers")
            ), new Answer("Letters"), 0),
            new Question("?", Arrays.asList(
                    new Answer("One"),
                    new Answer("Two"),
                    new Answer("Three")
            ), new Answer("Four"), 0),
            new Question("What part of a chicken is commonly called the drumstick?", Arrays.asList(
                    new Answer("Breast"),
                    new Answer("Knee"),
                    new Answer("Ankle")
            ), new Answer("Leg"), 0),
            new Question("The British clay animation series featuring a man and his dog is called Wallace and who?", Arrays.asList(
                    new Answer("Timmy"),
                    new Answer("Wayne"),
                    new Answer("Thomas")
            ), new Answer("Gromit"), 1),
            new Question("What sound does a goose make?", Arrays.asList(
                    new Answer("Beep"),
                    new Answer("Snort"),
                    new Answer("Chirp")
            ), new Answer("Honk"), 1),
            new Question("In 'SpongeBob SquarePants,' what was the name of the Krusty Krab before Mr. Krabs bought it?", Arrays.asList(
                    new Answer("The Lusty Cab"),
                    new Answer("The Busty Dab"),
                    new Answer("The Chum Bucket")
            ), new Answer("The Rusty Krab"), 1),
            new Question("The lowest grossing movie ever, 'ZYZZYX Road,' made how much money at the box office?", Arrays.asList(
                    new Answer("$12,400"),
                    new Answer("$225"),
                    new Answer("$0")
            ), new Answer("$30"), 1),
            new Question("\"What year was the game 'Nintendogs' released for the Nintendo DS console?", Arrays.asList(
                    new Answer("2004"),
                    new Answer("2006"),
                    new Answer("2007")
            ), new Answer("2005"), 1),
            new Question("What was the most popular baby boy name in the year 1999?", Arrays.asList(
                    new Answer("Luke"),
                    new Answer("Nicholas"),
                    new Answer("Matthew")
            ), new Answer("Jacob"), 1),
            new Question("Who first figured out that the Earth is round?", Arrays.asList(
                    new Answer("Julius Caesar"),
                    new Answer("Abel Tasman"),
                    new Answer("Aristotle")
            ), new Answer("Pythagoras"), 1),
            new Question("Which is the most popularly used programming language in 2019?", Arrays.asList(
                    new Answer("Python"),
                    new Answer("C++"),
                    new Answer("JavaScript")
            ), new Answer("Java"), 2),
            new Question("In the context of computer displays, what does LCD stand for?", Arrays.asList(
                    new Answer("Light Colour Display"),
                    new Answer("Liquid Colour Display"),
                    new Answer("Light Cathode Display")
            ), new Answer("Liquid Crystal Display"), 2),
            new Question("\"Which one of these characters does not have a star in the Hollywood Walk of Fame?", Arrays.asList(
                    new Answer("Shrek"),
                    new Answer("Minnie Mouse"),
                    new Answer("Mickey Mouse")
            ), new Answer("SpongeBob SquarePants"), 2),
            new Question("What is the most visible colour in the dark for humans?", Arrays.asList(
                    new Answer("Red"),
                    new Answer("Green"),
                    new Answer("White")
            ), new Answer("Yellow"), 2),
            new Question("Which character does Asa Butterfield play in the Netflix original show 'Sex Education'?", Arrays.asList(
                    new Answer("Jackson"),
                    new Answer("Eric"),
                    new Answer("Jakob")
            ), new Answer("Otis"), 2),
            new Question("What year was the 'Burger King' restaurant chain founded?", Arrays.asList(
                    new Answer("1927"),
                    new Answer("1948"),
                    new Answer("1999")
            ), new Answer("1654"), 2),
            new Question("Which type of insect shorted out a supercomputer and inspired the term 'computer bug'?", Arrays.asList(
                    new Answer("Ant"),
                    new Answer("Cicada"),
                    new Answer("Cockroach")
            ), new Answer("Moth"), 2),
            new Question("Which was the first high-level programming language?", Arrays.asList(
                    new Answer("C"),
                    new Answer("BASIC"),
                    new Answer("Fortran")
            ), new Answer("COBOL"), 2),
            new Question("What was the highest grossing movie of the year 2000?", Arrays.asList(
                    new Answer("Iron Man 1"),
                    new Answer("Inception"),
                    new Answer("Shrek Forever After")
            ), new Answer("Toy Story 2"), 3),
            new Question("What is the highest grossing horror film ever?", Arrays.asList(
                    new Answer("The Grudge"),
                    new Answer("The Conjuring 1"),
                    new Answer("The Exorcist")
            ), new Answer("It"), 3),
            new Question("Which of the following car manufacturers competed in Google's 'Lunar XPRIZE,' a competition to land on the moon?", Arrays.asList(
                    new Answer("Mercedes"),
                    new Answer("Volkswagen"),
                    new Answer("Ford")
            ), new Answer("Suzuki"), 3)
    );

        //----- Method to return some random questions based on their difficulty -----//
        // this method will be parametrise with difficulty and nr of questions.
        public static List<Question> getRandomQuestions(int nrOfQuestions, int difficulty) {
                //  Algorithm:
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
