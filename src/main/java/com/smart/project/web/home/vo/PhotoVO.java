package com.smart.project.web.home.vo;

import lombok.*;

import java.sql.Timestamp;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class PhotoVO {
    private int photoNum;
    @NonNull
    private String innerPath;
    private String outPath;
    private Timestamp photoCreated;
}
