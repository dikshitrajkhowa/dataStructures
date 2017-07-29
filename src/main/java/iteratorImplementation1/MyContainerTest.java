package iteratorImplementation1;

import org.apache.log4j.Logger;

public class MyContainerTest {

	final static Logger logger = Logger.getLogger(MyContainerTest.class);
	
	public static void main(String[] args) {

		MyContainer v = new MyContainer();
		v.add("1");
		v.add("3");
		v.add("4");
		v.add("3");
		v.add("4");

		logger.info("Container contents: ");

		MyContainerIterator itr = v.iterator();
		while (itr.hasNext()) {

			System.out.println(itr.next());

		}

	}

}
