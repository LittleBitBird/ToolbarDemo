package com.example.guanhuawu.toolbardemo.answersheet;

import com.example.guanhuawu.toolbardemo.R;

/**
 * Created by guanhua.wu on 2017/8/11.
 */

public class AnswerSheetItem implements AnswerSheetItemMessage {
    private int itemNo;
    private String type;
    private Boolean status;
    private int realScore;
    private int totalScore;

    @Override
    public String getItemNo() {
        return String.valueOf(itemNo);
    }

    @Override
    public String getRealScoreText() {
        return String.valueOf(realScore);
    }

    @Override
    public String getTotalScoreText() {
        return String.valueOf(totalScore);
    }

    @Override
    public int getItemBackground() {
        if (status) {
            return R.drawable.homework_answer_sheet_correct_item;
        } else {
            return R.drawable.homework_answer_sheet_correct_item;
        }
    }

    @Override
    public boolean getIsCommentVisible() {
        return status;
    }

    public AnswerSheetItem(int itemNo, String type, Boolean status, int realScore, int totalScore) {
        this.itemNo = itemNo;
        this.type = type;
        this.status = status;
        this.totalScore = totalScore;
        this.realScore = realScore;
    }
}
