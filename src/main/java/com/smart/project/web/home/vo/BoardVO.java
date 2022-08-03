package com.smart.project.web.home.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
    private int boardNum;
    private String title;
    private String content;
    private int good;
    private int bad;
    private Timestamp created;
    private int photoNum;
}
