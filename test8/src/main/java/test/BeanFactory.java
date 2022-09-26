package test;

public class BeanFactory {
	public Object getBean(String beanName) {
		if(beanName.equals("galaxy")) {
			return new Galaxy();
		}
		else if(beanName.equals("iphone")) {
			return new IPhone();
		}
		return null;
	}
}
