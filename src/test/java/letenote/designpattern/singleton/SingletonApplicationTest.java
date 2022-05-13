package letenote.designpattern.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = SingletonApplication.class)
class SingletonApplicationTest {

	@Autowired
	private final ApplicationContext applicationContext;

	SingletonApplicationTest(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Test
	void singletonBasicTest() {
		/*
		  in this test, counter like count total hit in this application
		  this test case, Counter implemented in all endpoint controller for increment hit from clients
		 */
		Counter AuthController = applicationContext.getBean(Counter.class);
		Counter ArticleController = applicationContext.getBean(Counter.class);
		Counter CommentController = applicationContext.getBean(Counter.class);
		Counter AdvertiseController = applicationContext.getBean(Counter.class);
		Counter MediaController = applicationContext.getBean(Counter.class);

		/*
		  reset counter valur to 0
		 */
		AuthController.resetCounter();
		Assertions.assertEquals(AuthController.getValueCounter(), 0);
		System.err.println("singletonBasicTest -> reset value -> result:  " + CommentController.getValueCounter() + " expected: 0");
		/*
		 * in this case there is 5 hit in endpoint
		 * @Test expected actual value is 5
		 */
		int actualExpected = 5;
		AuthController.incrementCounter();
		CommentController.incrementCounter();
		ArticleController.incrementCounter();
		AdvertiseController.incrementCounter();
		MediaController.incrementCounter();

		Assertions.assertEquals(AuthController.getValueCounter(), actualExpected);
		Assertions.assertEquals(CommentController.getValueCounter(), actualExpected);
		Assertions.assertEquals(ArticleController.getValueCounter(), actualExpected);
		Assertions.assertEquals(AdvertiseController.getValueCounter(), actualExpected);
		Assertions.assertEquals(MediaController.getValueCounter(), actualExpected);
	}

	@Test
	void singletonMutableProblemTest() throws InterruptedException {
		/*
		 * - best practice in singleton object must be immutable (can't be change or set)
		 * - if implement singleton object mutable, make sure it doesn't happen "race condition"
		 *   if any change value in same time must be handler
		 */
		Counter CommentController = applicationContext.getBean(Counter.class);
		Counter AdvertiseController = applicationContext.getBean(Counter.class);

		incrementCounterAsync(CommentController,500_000);
		incrementCounterAsync(AdvertiseController, 500_000);
		/*
		 * @Test expected counter value is 100 + 100 = 200
		 * but in same time hit endpoint any miss, there must be a "race condition"
		 */
		int actualExpected = 1_000_000;
		Thread.sleep(5000L);

		System.err.println("singletonMutableProblemTest -> result: " + CommentController.getValueCounter() + " expected: " + actualExpected + " -> 'race condition'");
		Assertions.assertNotEquals(CommentController.getValueCounter(), actualExpected);
		Assertions.assertNotEquals(AdvertiseController.getValueCounter(), actualExpected);
	}

	@Test
	void singletonMutableProblemSolverTest() throws InterruptedException {
		/*
		  add "synchronized" for await thread -> handler same time for set counter
		 */
		Counter CommentController = applicationContext.getBean(Counter.class);
		Counter AdvertiseController = applicationContext.getBean(Counter.class);

		incrementCounterAsyncAwait(CommentController,500_000);
		incrementCounterAsyncAwait(AdvertiseController, 500_000);
		/*
		 * @Test expected counter value is 100 + 100 = 200;
		 * result should be same as expected value
		 */
		int actualExpected = 1_000_000;
		Thread.sleep(5000L);

		System.err.println("singletonMutableProblemSolverTest  -> result: " + CommentController.getValueCounter() + " expected: " + actualExpected );
		Assertions.assertEquals(CommentController.getValueCounter(), actualExpected);
		Assertions.assertEquals(AdvertiseController.getValueCounter(), actualExpected);
	}

	private void incrementCounterAsync(Counter counter, int loop){
		new Thread(() -> {
			for (int i = 0; i < loop; i++) {
				counter.incrementCounter();
			}
		}).start();
	}

	private void incrementCounterAsyncAwait(Counter counter, int loop){
		new Thread(() -> {
			for (int i = 0; i < loop; i++) {
				counter.incrementCounterMutableResolver();
			}
		}).start();
	}
}