package ro.jademy.millionaire.model;

public class Answer {

    //----- Setting Answer properties -----//
    private String text; // every answer's text

    public Answer(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
