package tree.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	TreePreOrderTests.class,
	TreePostOrderTests.class,
	TreeInOrderTests.class
})

public class JUnitTreeTestSuite {
}