package com.steelrain.lilac.batch.datamodel;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
@Builder
public class SubjectBatchResultDTO {
    private int id;
    private String pageToken;
    private Timestamp updateTime;
}
