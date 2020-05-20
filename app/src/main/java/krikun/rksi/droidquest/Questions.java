package krikun.rksi.droidquest;

public class Questions {
    private int mTextResId;
    private boolean mAnswerTrue;
    public Questions(int mTextResId, boolean mAnswerTrue){
        this.mAnswerTrue = mAnswerTrue;
        this.mTextResId = mTextResId;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setAnswerTrue(boolean mAnswerTrue) {
        this.mAnswerTrue = mAnswerTrue;
    }
}
