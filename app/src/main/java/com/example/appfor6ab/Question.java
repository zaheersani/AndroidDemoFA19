package com.example.appfor6ab;

public class Question {
    private String _questionText;
    private boolean _correctAnswer;
    private String _hint;

    public Question(String question, boolean correctAnswer, String hint) {
        this._questionText = question;
        this._correctAnswer = correctAnswer;
        this._hint = hint;
    }

    public String getHint() {
        return this._hint;
    }

    public String getQuestionText() {
        return this._questionText;
    }

    public boolean getCorrectAnswer() {
        return this._correctAnswer;
    }
}
