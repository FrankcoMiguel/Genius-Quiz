package com.example.geniusquiz;

public class Question {

    private int mTextResId;
    private int mImgResId;
    private boolean mAnswer;
    private boolean selected;

    public Question(int mTextResId, int mImgResId, boolean mAnswer) {
        this.mTextResId = mTextResId;
        this.mImgResId = mImgResId;
        this.mAnswer = mAnswer;
        this.selected = false;
    }


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public int getmTextResId() {
        return mTextResId;
    }

    public void setmTextResId(int mTextResId) {
        this.mTextResId = mTextResId;
    }

    public int getmImgResId() {
        return mImgResId;
    }

    public void setmImgResId(int mImgResId) {
        this.mImgResId = mImgResId;
    }

    public boolean ismAnswer() {
        return mAnswer;
    }

    public void setmAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }
}


