package com.smart.project.web.home.act;

import com.smart.project.component.CommonCodeComponent;
import com.smart.project.component.data.CodeObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Slf4j
@Controller
@RequiredArgsConstructor
public class HomeTestAct3 {

    private final CommonCodeComponent commonCodeComponent;

    /* 공통 영역*/
    @RequestMapping("/head")
    public String head(){
        return "fragment/head";
    }

    @RequestMapping("/admin_head")
    public String adminHead(){
        return "fragment/admin_head";
    }


    @RequestMapping("/login")
    public void login(){
    }


    /*========================================================================================*/

    /* 참고페이지*/
    @RequestMapping("/index")
    public void index() {
    }

    @RequestMapping("/buttons")
    public void buttons(){
    }

    @RequestMapping("/shop_checkout")
    public void shop_checkout(){

    }

    @RequestMapping("/layout-sidenav-light2")
    public void layoutSidenavLight2(){

    }
    @RequestMapping("/admin/layout-static2")
    public void layoutStatic2(){

    }

    @RequestMapping("/register2")
    public void register2(){

    }

    @RequestMapping("/icons")
    public void icons(){
    }



    /*========================================================================================*/

    /* 사용자 페이지 */
    @RequestMapping("/main")
    public void main(){

    }

    @RequestMapping("/service")
    public void service(){

    }

    // 동영상 업로드
    @RequestMapping("/upload")
    public void upload(HttpSession session, Model model){
        String token = (String) session.getAttribute("token");
        model.addAttribute("token", token);
    }


    // 분석결과 페이지
    @RequestMapping("/result")
    public void result(){

    }

    @RequestMapping("/result2")
    public void result2(){

    }

    // 회원정보수정
    @RequestMapping("/join_edit")
    public void join_edit(){

    }

    // 회원가입
    @RequestMapping("/join")
    public void join(){

    }

    // 커뮤니티
    @RequestMapping("/community")
    public void community(){

    }

    // 커뮤니티 글보기
    @RequestMapping("/write_view")
    public void write_view(){

    }

    // 마이게시판
    @RequestMapping("/myList")
    public void myList(){
    }

    // 글쓰기
    @RequestMapping("/write")
    public void write(){

    }


    /*========================================================================================*/

    /* 관리자 페이지*/

    // 메인
    @RequestMapping("admin/admin_main")
    public String adminMain(){
        return "admin/admin_main";
    }

    // 회원관리
    @RequestMapping("admin/member_tables")
    public String member_tables(){
        return "admin/member_tables";
    }

    // 동영상관리
    @RequestMapping("admin/video_tables")
    public String video_tables(){
        return "admin/video_tables";
    }



    @RequestMapping("portfolio_single_featured_slider2")
    public String portfolio(){
        return "portfolio_single_featured_slider2";
    }




}
