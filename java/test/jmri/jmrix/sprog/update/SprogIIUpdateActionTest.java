package jmri.jmrix.sprog.update;

import jmri.jmrix.sprog.SprogSystemConnectionMemo;
import jmri.jmrix.sprog.SprogTrafficControlScaffold;
import jmri.util.JUnitUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Paul Bender Copyright (C) 2017	
 */
public class SprogIIUpdateActionTest {

    @Test
    public void testCTor() {
        SprogSystemConnectionMemo m = new SprogSystemConnectionMemo();
        m.setSprogTrafficController(new SprogTrafficControlScaffold(m));
        SprogIIUpdateAction t = new SprogIIUpdateAction("test",m);
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

    // private final static Logger log = LoggerFactory.getLogger(SprogIIUpdateActionTest.class);

}
