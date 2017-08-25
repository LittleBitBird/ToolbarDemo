package com.example.guanhuawu.toolbardemo.answersheet;

/**
 * Created by guanhua.wu on 2017/8/11.
 */

public interface AnswerSheetItemMessage {
    String getItemNo();

    String getRealScoreText();

    String getTotalScoreText();

    int getItemBackground();

    boolean getIsCommentVisible();
}
