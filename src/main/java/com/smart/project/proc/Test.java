package com.smart.project.proc;

import com.smart.project.annotation.Master;
import com.smart.project.web.home.vo.MemberVO;
import org.springframework.stereotype.Component;

@Master
@Component
public interface Test {
	/**********************************************************************************************
	 * @Method 설명 : TestMapper 연결
	 * @작성일 : 2022-07-19
	 * @작성자 : 정우철
	 * @변경이력 :
	 **********************************************************************************************/
	MemberVO login(MemberVO vo);

	int joinComplete(MemberVO vo);


}