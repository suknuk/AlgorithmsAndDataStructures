package linkedList.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	LinkedListAddTests.class,
	LinkedListSizeTests.class,
	LinkedListRemovingExceptionTests.class,
	LinkedListPushTests.class,
	LinkedListToStringTests.class,
	LinkedListReverseTests.class,
	LinkedListEqualsAndHashCodeTests.class
})

public class JUnitTestSuite {
}
