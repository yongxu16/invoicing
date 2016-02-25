package proxy;

public class BookServiceImpl implements IBookService {

	@Override
	public void getBookName(String name) {
		System.out.println("book name: " + name);
	}

	@Override
	public void getPrice() {
		System.out.println("book price: " + 33.3);
	}

}
