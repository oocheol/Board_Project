package com.smart.project.web.home.act;

import com.smart.project.proc.Test;
import com.smart.project.util.CookieUtil;
import com.smart.project.web.home.biz.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Slf4j
@Controller
@RequiredArgsConstructor
public class LoginAct {
    private final MemberService ms;
    public final Test test;


    @RequestMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response){

        Cookie[] cookies = request.getCookies();
        if (cookies.length > 0 && cookies != null) {
            if (cookies[0].getValue().equals("kakao")){
                // 쿠키가 한개라도 있으면 실행

                for(int i=0; i< cookies.length; i++){
                    cookies[i].setMaxAge(0); // 유효시간을 0으로 설정
                    response.addCookie(cookies[i]); // 응답 헤더에 추가
                }
                return "redirect:kakaoLogout";
            }
            if(cookies != null){ // 쿠키가 한개라도 있으면 실행

                for(int i=0; i< cookies.length; i++){
                    cookies[i].setMaxAge(0); // 유효시간을 0으로 설정
                    response.addCookie(cookies[i]); // 응답 헤더에 추가
                }
            }
        }
        return "redirect:main";

    }

    @RequestMapping("/kakao")
    public String kakao(){
        return "redirect:https://kauth.kakao.com/oauth/authorize?client_id=d063d1ad6b1c07a4bd10a0c8fa990556&redirect_uri=http://localhost/kakaoLogin&response_type=code";
    }

    @RequestMapping("/kakaoLogin")
    public String kakaoLogin(@RequestParam("code") String code, HttpServletResponse res, HttpSession session) throws Exception {
        CookieUtil.createCookie(res, "id", "kakao");
        log.error("token==>{}", code);
        String access_Token = ms.getAccessToken(code);
        session.setAttribute("token", access_Token);
        log.error("token2==>{}", access_Token);

        HashMap<String, Object> userInfo = ms.getUserInfo(access_Token);
        log.error("###access_Token#### : " + access_Token);
        log.error("###nickname#### : " + userInfo.get("nickname"));
        log.error("###email#### : " + userInfo.get("email"));

        return "redirect:/main";

    }

    @RequestMapping("/kakaoLogout")
    public String kakaoLogout(){

        return "redirect:https://kauth.kakao.com/oauth/logout?client_id=d063d1ad6b1c07a4bd10a0c8fa990556&logout_redirect_uri=http://localhost/main";

    }

}