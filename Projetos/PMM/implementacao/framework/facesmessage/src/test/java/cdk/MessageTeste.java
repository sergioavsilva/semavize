package cdk;

import junit.framework.Assert;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.junit.Test;

public class MessageTeste extends TestCase {

	public MessageTeste(String a) {
		super(a);
	}

	public static Test suite() {
		return (Test) new TestSuite(MessageTeste.class);
	}

	@Test
	public void test() {
		Assert.assertNotNull(null);
	}

}
