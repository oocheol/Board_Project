package com.smart.project.web.home.act;

import com.smart.project.proc.Board;
import com.smart.project.web.home.vo.BoardVO;
import com.smart.project.web.home.vo.PhotoVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.UUID;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardAct {
    private static final String ROOTPATH = "C:/photo/";
    private final Board board;


    /* 공통 영역*/
//    @RequestMapping("/head")
//    public String head(){
//        return "fragment/head";
//    }

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


    // 동영상 업로드
//    @RequestMapping("/upload")
//    public void upload(HttpSession session, Model model){
//        String token = (String) session.getAttribute("token");
//        model.addAttribute("token", token);
//    }

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



    // 업로드
    @RequestMapping("/upload")
    public String saveFile(BoardVO vo, @RequestParam("file") MultipartFile file, HttpServletRequest request, HttpSession session) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Calendar c1 = Calendar.getInstance();

        log.error("vo.title==>{}", vo.getTitle());
        log.error("vo.content==>{}", vo.getContent());

        String strToday = sdf.format(c1.getTime());
        String fileRealName = file.getOriginalFilename();
        String fileExtension = fileRealName.substring(fileRealName.lastIndexOf("."));
        String date = File.separator + strToday.substring(0,4) + File.separator + strToday.substring(4, 6) + File.separator + strToday.substring(6, 8);

        log.error("file name : " + file.getOriginalFilename());
        log.error("file size : " + file.getSize());

        String userName = "defalut";
        if (session.getAttribute("id") != null) {
            String fullId = (String) session.getAttribute("id");
            log.error("fullEmail==>{}", fullId);
            userName = fullId.substring(0, fullId.lastIndexOf("@"));
            log.error("userName==>{}", userName);
        }

        String path = ROOTPATH + date + "/"; // 경로설정
        log.error("path==>{}", path);

        String uuid = UUID.randomUUID().toString();

        String uploadFileName = strToday + "_" + userName + "_" + uuid.split("-")[0];

        System.out.println("파일 이름 : " + uploadFileName);
        System.out.println("확장자명 : " + fileExtension);


        File Folder = new File(path);

        if (!Folder.exists()) {
            try{
                Folder.mkdirs(); //폴더 생성
                log.error("폴더 생성");
            }
            catch(Exception e){
                e.getStackTrace();
            }

        }else {
            log.error("이미 폴더 존재");
        }

        // 원본 저장
        try(
                FileOutputStream fos = new FileOutputStream(path + uploadFileName + fileExtension);
                InputStream is = file.getInputStream();
        ){

            String originFilename = file.getOriginalFilename();
            String extName = originFilename.substring(originFilename.lastIndexOf("."));
            int readCount = 0; // 읽음 성공 여부 저장용
            byte[] buffer = new byte[1024]; // 1024 바이트씩 읽어서 파일 저장

            while((readCount = is.read(buffer))!=-1){
                fos.write(buffer,0,readCount);
            }


        }catch(Exception ex){
            throw new RuntimeException("file Save Error");
        }
        PhotoVO pvo = new PhotoVO(uploadFileName);
        board.uploadPhoto(pvo);
        PhotoVO pvoSelect = board.selectPhotoNum();
        log.error("photoNum==>{}", pvoSelect.getPhotoNum());
        vo.setContent(vo.getContent().substring(1));
        vo.setPhotoNum(pvoSelect.getPhotoNum());
        int cnt = board.insertBoard(vo);
        log.error("boardCnt==>{}", cnt);

        return "redirect:/main";
    }


}
