package test;

public class AppleWatch implements Watch {
	public AppleWatch() {
		System.out.println("局敲况摹 按眉积己肯丰");
	}
	@Override
	public void volumeUp() {
		System.out.println("局敲况摹 ++");
	}
	@Override
	public void volumeDown() {
		System.out.println("局敲况摹 --");
	}
}
