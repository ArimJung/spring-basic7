package test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("ip")
public class IPhone implements Phone{
	@Autowired
	private Watch watch; // 의존관계 -> 의존성 주입(DI)이 필요한 상태
	private int number;
	public IPhone() {
		System.out.println("아이폰 객체생성완료");
	}
	
	public Watch getWatch() {
		return watch;
	}

	public void setWatch(Watch watch) {
		this.watch = watch;
		System.out.println("setter 호출됨 - 1");
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
		System.out.println("setter 호출됨 - 2");
	}

	/*
	// DI: 생성자 인젝션
	public IPhone(Watch watch) {
		System.out.println("아이폰 객체생성완료22");
		this.watch=watch;
	}
	public IPhone(Watch watch,int number) {
		System.out.println("아이폰 객체생성완료333");
		this.watch=watch;
		this.number=number;
	}
	*/
	@Override
	public void powerOn() {
		System.out.println("아이폰 전원 ON : "+this.number);
	}
	@Override
	public void powerOff() {
		System.out.println("아이폰 전원 OFF");
	}
	@Override
	public void volumeUp() {
		watch.volumeUp();
	}
	@Override
	public void volumeDown() {
		watch.volumeDown();
	}
	
}
