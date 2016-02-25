package exception;

public class RuntimeExceptionTest {

	public void math() {
		try {
			int i = 9 / 0;
		} catch (Exception e) {
			throw new RuntimeException(e);
			// e.printStackTrace();
		}
		System.out.println("abc");
	}

	public void say() {
		System.out.println("hello world");
	}

	public static void main(String[] args) {
		RuntimeExceptionTest ret = new RuntimeExceptionTest();
		ret.math();
		ret.say();

	}
}
