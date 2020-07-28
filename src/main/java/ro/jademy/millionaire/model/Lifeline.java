package ro.jademy.millionaire.model;

public class Lifeline {

    // For the sake of programming, I will only use, as lifeline, the 50-50 option.
    // and because it's only one out of three, I will offer this lifeline to be used
    // for a number of three times.

    // TODO
    // Future implements:
    //  - Ask the audience lifeline -> this lifeline will 'ask' an AI audience for the
    // correct answer. Calling this lifeline will display all 4 answers with
    // a percent of truthiness, being displayed next to the answers.

    //----- Setting Lifeline properties -----//
    private String name; // a name of the lifeline (50-50, call a friend etc & ask the audience)
    private boolean used; // to check if a lifeline was used or not

    public Lifeline(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }
}
