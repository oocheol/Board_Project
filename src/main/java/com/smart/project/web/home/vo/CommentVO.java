package com.smart.project.web.home.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CommentVO {
    private int commNum;
    private int boardNum;
    private String commName;
    private String commContent;
}
