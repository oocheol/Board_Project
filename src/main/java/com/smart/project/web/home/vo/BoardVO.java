package com.smart.project.web.home.vo;

import lombok.*;

import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class BoardVO {
    private int boardNum;
    private String title;
    private String content;
    private int good;
    private int bad;
    private Timestamp created;
    private int photoNum;
}
