package com.smart.project.proc;

import com.smart.project.annotation.Master;
import com.smart.project.web.home.vo.PhotoVO;
import org.springframework.stereotype.Component;

@Master
@Component
public interface Board {
    /**********************************************************************************************
     * @Method 설명 : TestMapper 연결
     * @작성일 : 2022-08-04
     * @작성자 : 정우철
     * @변경이력 :
     **********************************************************************************************/

    int uploadPhoto(PhotoVO vo);

}