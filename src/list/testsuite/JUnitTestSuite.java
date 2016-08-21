package list.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import list.testsuite.linkedList.LinkedListAddTests;
import list.testsuite.linkedList.LinkedListEqualsAndHashCodeTests;
import list.testsuite.linkedList.LinkedListPushTests;
import list.testsuite.linkedList.LinkedListRemoveDuplicatesTests;
import list.testsuite.linkedList.LinkedListRemovingExceptionTests;
import list.testsuite.linkedList.LinkedListReverseTests;
import list.testsuite.linkedList.LinkedListSizeTests;
import list.testsuite.linkedList.LinkedListToStringTests;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	LinkedListAddTests.class,
	LinkedListSizeTests.class,
	LinkedListRemovingExceptionTests.class,
	LinkedListPushTests.class,
	LinkedListToStringTests.class,
	LinkedListReverseTests.class,
	LinkedListEqualsAndHashCodeTests.class,
	LinkedListRemoveDuplicatesTests.class
})

public class JUnitTestSuite {
}
