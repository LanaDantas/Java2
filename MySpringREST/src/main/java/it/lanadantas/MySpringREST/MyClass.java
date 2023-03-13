package it.lanadantas.MySpringREST;

public class MyClass {
	private String myString = "Giorgio";
	private int myInt = 1234;
	
	public MyClass() {
	}

	public MyClass(String myString, int myInt) {
		this.myString = myString;
		this.myInt = myInt;
	}

	public String getMyString() {
		return myString;
	}

	public void setMyString(String myString) {
		this.myString = myString;
	}

	public int getMyInt() {
		return myInt;
	}

	public void setMyInt(int myInt) {
		this.myInt = myInt;
	}
}
