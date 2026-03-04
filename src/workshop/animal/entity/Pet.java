package workshop.animal.entity;

public interface Pet {
	String getName();  // public abstract 이 생략되어있음 
	void setName(String name);
	public abstract void play();
}