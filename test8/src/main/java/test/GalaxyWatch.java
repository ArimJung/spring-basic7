package test;

public class GalaxyWatch implements Watch {
	
	@Override
	public void volumeUp() {
		System.out.println("갤럭시워치 ++");
	}

	@Override
	public void volumeDown() {
		System.out.println("갤럭시워치 --");
	}

}
