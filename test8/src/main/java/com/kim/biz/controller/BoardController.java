package com.kim.biz.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.kim.biz.board.BoardService;
import com.kim.biz.board.BoardVO;
import com.kim.biz.board.impl.BoardDAO;
import com.kim.biz.member.MemberVO;
import com.kim.biz.member.impl.MemberDAO;

@Controller
@SessionAttributes("data") // "data"라는 이름의 데이터가 Model 객체에 세팅이된다면, 그것을 session에 기억시키겠다.
public class BoardController {
	
	@Autowired
	private BoardService boardService; // 비즈니스 컴포넌트. DAO를 직접 이용 xxx

	@ModelAttribute("scMap")
	public Map<String,String> searchConditionMap(){
		Map<String,String> scMap=new HashMap<String,String>();
		scMap.put("제목", "TITLE");
		scMap.put("작성자", "WRITER");
		return scMap;
	}
	
	@RequestMapping("/main.do")
	public String selectAllBoard(
			@RequestParam(value="searchCondition",defaultValue="TITLE",required=false)String searchCondition,
			@RequestParam(value="searchContent",defaultValue="",required=false)String searchContent,
			BoardVO vo, Model model) {
		System.out.println("검색조건: "+searchCondition);
		System.out.println("검색어: "+searchContent);

		vo.setTitle(searchCondition);
		vo.setContent(searchContent);
		
		List<BoardVO> datas=boardService.selectAllBoard(vo);
		System.out.println("main.do 로그 datas :"+datas);
		model.addAttribute("datas", datas);
		
		return "main.jsp";
	}
	
	@RequestMapping("/board.do")
	public String board(BoardVO bVO,Model model) {
		bVO=boardService.selectOneBoard(bVO);

		model.addAttribute("data", bVO);
		return "board.jsp";
	}
	
	@RequestMapping("/update.do")
	public String update(@ModelAttribute("data")BoardVO bVO) {
		System.out.println("updateB.do 로그: "+bVO); // @SA,@MA 덕분에 writer 등의 값도 로그에 출력된다.
		boardService.updateBoard(bVO);
		return "redirect:main.do";
	}
	@RequestMapping("/insertB.do")
	public String insert(BoardVO bVO) {
		boardService.insertBoard(bVO);
		return "redirect:main.do";
	}
	@RequestMapping("/delete.do")
	public String delete(BoardVO bVO) {
		boardService.deleteBoard(bVO);
		return "redirect:main.do";
	}

	/*
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		BoardVO bVO=new BoardVO();
		bVO.setBid(Integer.parseInt(request.getParameter("bid")));
		
		BoardDAO bDAO=new BoardDAO();
		bVO=bDAO.selectOneBoard(bVO);
		
		HttpSession session=request.getSession();
		session.setAttribute("data", bVO);
	
		return "board";
	}
	 */
	
}
