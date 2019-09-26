package com.example.appfor6ab;

public class Question {
    private String _questionText;
    private boolean _correctAnswer;

    public Question(String question, boolean correctAnswer) {
        this._questionText = question;
        this._correctAnswer = correctAnswer;
    }

    public String getQuestionText() {
        return this._questionText;
    }

    public boolean getCorrectAnswer() {
        return this._correctAnswer;
    }
}
