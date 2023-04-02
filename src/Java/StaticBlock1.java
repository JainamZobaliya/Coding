package Java;

public class StaticBlock1 {
	
	public static void main(String[] args) {
		System.out.println("From Main!!");
	}
	
	static {
		System.out.println("From Static!!");
		// System.exit(0);
	}

}
