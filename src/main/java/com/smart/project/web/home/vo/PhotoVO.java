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
public class PhotoVO {
    private int photoNum;
    private String innerPath;
    private String outPath;
    private Timestamp photoCreated;
}
