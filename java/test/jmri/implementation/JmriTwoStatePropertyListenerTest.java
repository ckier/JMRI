package jmri.implementation;

import jmri.Conditional;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class JmriTwoStatePropertyListenerTest {

    @Test
    public void testCTor() {
        JmriTwoStatePropertyListener t =
                new JmriTwoStatePropertyListener("foo",0,"bar",
                        Conditional.Type.getOperatorFromIntValue(1),new DefaultConditional("foo"));
        Assert.assertNotNull("exists",t);
    }

    // The minimal setup for log4J
    @Before
    public void setUp() {
        JUnitUtil.setUp();
    }

    @After
    public void tearDown() {
        JUnitUtil.tearDown();
    }

    // private final static Logger log = LoggerFactory.getLogger(JmriTwoStatePropertyListenerTest.class);

}
