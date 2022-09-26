package test;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.kim.biz.member.MemberService;
import com.kim.biz.member.MemberVO;

public class Client {
	public static void main(String[] args) {
		// Spring 컨테이너를 동작시킬수있도록 코드작성
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		Scanner sc=new Scanner(System.in);
		/*
		BoardService bs=(BoardService)factory.getBean("boardService");
		
		BoardVO vo=new BoardVO();
		System.out.print("내용작성 >> ");
		String msg=sc.nextLine();
		vo.setContent(msg);
		vo.setTitle("글 제목");
		vo.setWriter("작은 티모");
		bs.insertBoard(vo);
		
		List<BoardVO> datas=bs.selectAllBoard(vo);
		for(BoardVO v:datas) {
			System.out.println(v);
		}
		*/
		MemberService ms=(MemberService)factory.getBean("memberService"); // Lookup == 메모리에서 객체를 "찾는" 요청
		
		System.out.print("아이디 >> ");
		String mid=sc.next();
		System.out.print("비밀번호 >> ");
		String mpw=sc.next();
		MemberVO mvo=new MemberVO();
		mvo.setMid(mid);
		mvo.setMpw(mpw);
		mvo=ms.selectOneMember(mvo); // 핵심로직을 수행하려고한다!
		if(mvo==null) {
			System.out.println("로그인 실패...");
		}
		else {
			System.out.println(mvo.getName()+"님, 안녕하세요! :D");
		}
		
		factory.close();
		
		// Spring 컨테이너야, 나 폰 객체를 가지고싶어!
		// == Lookup == 객체요청: 컨테이너야, 가지고있는 객체중에서 이름이 "phone"인 객체를 줘!
		/*
		Phone phone=(Phone)factory.getBean("gp");
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		factory.close();
		*/
		
		/*
		BeanFactory bf=new BeanFactory();
		Phone phone=(Phone)bf.getBean(args[0]);
		phone.powerOn();
		phone.volumeUp();
		phone.volumeDown();
		phone.powerOff();
		*/
	}
}
