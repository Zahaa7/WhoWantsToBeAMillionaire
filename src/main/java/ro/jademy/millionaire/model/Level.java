package ro.jademy.millionaire.model;

public class Level {

    // I'll define all the properties as private 'cuz of ENCAPSULATION
        // the access will be managed with the help of getters / setters

    //----- Setting Level properties -----//
    private int number; // a number each level
    private int difficultyLevel; // a difficulty level of the questions from that level
    private int reward; // a reward that is received by the player based on current level
    private int rewardBreakout; // a reward that is received by the player when he walks away


    //----- This is a constructor -----//
    public Level(int number, int difficultyLevel, int reward, int rewardBreakout) {
        this.number = number;
        this.difficultyLevel = difficultyLevel;
        this.reward = reward;
        this.rewardBreakout = rewardBreakout;
    }

    //----- Getters & Setters -----//
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getRewardBreakout() {
        return rewardBreakout;
    }

    public void setRewardBreakout(int rewardBreakout) {
        this.rewardBreakout = rewardBreakout;
    }
}
