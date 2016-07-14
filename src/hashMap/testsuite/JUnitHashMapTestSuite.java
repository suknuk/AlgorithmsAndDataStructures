package hashMap.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	HashMapChainedPutGetTests.class,
	HashMapChainedRemoveTests.class,
	HashMapChainedResizeTests.class
})

public class JUnitHashMapTestSuite {
}
