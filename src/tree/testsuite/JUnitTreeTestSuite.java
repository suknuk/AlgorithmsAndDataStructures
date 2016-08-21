package tree.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tree.testsuite.binaryTree.BinaryTreeInsertNodeTests;
import tree.testsuite.binaryTree.BinaryTreeRemoveTests;
import tree.testsuite.tree.TreeBFSTests;
import tree.testsuite.tree.TreeHeightTests;
import tree.testsuite.tree.TreeInOrderTests;
import tree.testsuite.tree.TreePostOrderTests;
import tree.testsuite.tree.TreePreOrderTests;
import tree.testsuite.tree.TreeRemoveTests;
import tree.testsuite.tree.TreeTopViewTests;

//JUnit Suite Test
@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	TreePreOrderTests.class,
	TreePostOrderTests.class,
	TreeInOrderTests.class,
	TreeHeightTests.class,
	TreeTopViewTests.class,
	TreeBFSTests.class,
	TreeRemoveTests.class,
	BinaryTreeInsertNodeTests.class,
	BinaryTreeRemoveTests.class
})

public class JUnitTreeTestSuite {
}