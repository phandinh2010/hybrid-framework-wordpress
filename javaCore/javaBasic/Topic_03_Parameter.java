package javaBasic;

public class Topic_03_Parameter {

	public static String fullName = "Automation testing";
	public static int studentNumber = 100;
	public static boolean marriedStatus = true;

	public static void main(String[] args) {

		System.out.println(fullName);

		setFullname("");
		System.out.println(fullName);

		setFullname("Testing");
		System.out.println(fullName);
	}

	// hàm có Tham số /Đối số
	public static void setFullname(String name) {
		fullName = name;
	}

	public static String getFullname() {
		return fullName;
	}

	public static int getStudentNumber() {
		return studentNumber;
	}

	public static boolean getMerriedStatus() {
		return marriedStatus;
	}
}
