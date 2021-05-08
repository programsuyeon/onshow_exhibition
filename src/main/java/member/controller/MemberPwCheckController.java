package member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cate.model.Cate;
import cate.model.CateDao;
import exhibition.model.ExhibitionDao;
import member.model.Member;
import member.model.MemberDao;

@Controller
public class MemberPwCheckController {
   
   private final String command ="/pwcheck.me";
   private final String getPage = "pwCheck";
   
   @RequestMapping(value = command, method= RequestMethod.GET)
   public String doAction() {
      return getPage;
   }
   
   @RequestMapping(value=command, method=RequestMethod.POST)
   public void doAction(Member member,
                     HttpServletResponse response,
                     HttpSession session) throws IOException {
      
      PrintWriter pw = response.getWriter();
      response.setContentType("text/html; charset=UTF-8");
      
      System.out.println("POST doAction넘어옴");
      System.out.println("입력비번:"+member.getPassword());
      
      Member loginInfo = (Member) session.getAttribute("loginInfo");
      System.out.println("원래비번:"+loginInfo.getPassword());
      
      if(member.getPassword().equals(loginInfo.getPassword())) {
         System.out.println("비밀번호 일치.");
         int num = loginInfo.getNum();
         pw.print("<script type='text/javascript'>");
         pw.print("location.href='update.me?num="+num+"';");
         pw.print("</script>");
         pw.flush();
         
      }else {
         System.out.println("비밀번호가 틀림.");
         pw.print("<script type='text/javascript'>");
         pw.print("alert('비밀번호가 맞지 않습니다.');");
         pw.print("history.back();");
       pw.print("</script>");
         pw.flush();
      }
   }
}