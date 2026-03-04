package workshop.animal.entity;

public abstract class Animal {
	protected int legs;
	
	public Animal() {  // 기본 생성자를 이렇게 생성하거나 Spider.java 에 super() 선언
		
	}
	
	protected Animal(int legs) {
		this.legs = legs;
	}
	
	public abstract void eat();
	
	public void walk() {
		System.out.println("동물은" + legs + "발로 걷는다.");
	}
	
}