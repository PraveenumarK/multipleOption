package com.apexon.nest.multipleOption.vo;

import lombok.Data;

@Data
public class SubjectTopicVO {

    private String subject;

    public SubjectTopicVO(String subject) {
        this.subject = subject;
    }
}
