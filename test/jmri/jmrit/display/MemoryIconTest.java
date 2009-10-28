package jmri.jmrit.display;

import javax.swing.*;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import jmri.util.JUnitUtil;

/**
 * MemoryIconTest.java
 *
 * Description:
 * @author			Bob Jacobsen  Copyright 2007
 * @version			$Revision: 1.5 $
 */
public class MemoryIconTest extends TestCase {

    MemoryIcon to = null;

	public void testShowContent() {
        JFrame jf = new JFrame();
        jf.getContentPane().setLayout(new java.awt.FlowLayout());

        jf.getContentPane().add(new javax.swing.JLabel("Expect \"data\" text:"));
        
        to = new MemoryIcon();
        jf.getContentPane().add(to);
        
        jmri.InstanceManager i = new jmri.InstanceManager(){
            protected void init() {
                super.init();
                root = this;
            }
        };
        Assert.assertNotNull("Instance exists", i );
        jmri.InstanceManager.memoryManagerInstance().provideMemory("IM1").setValue("data");
        to.setMemory("IM1");

        jf.pack();
        jf.setVisible(true);

	}

	public void testShowBlank() {
        JFrame jf = new JFrame();
        jf.setTitle("Expect blank");
        jf.getContentPane().setLayout(new java.awt.FlowLayout());

        jf.getContentPane().add(new javax.swing.JLabel("Expect blank: "));
        
        to = new MemoryIcon();
        jf.getContentPane().add(to);
        
        jmri.InstanceManager i = new jmri.InstanceManager(){
            protected void init() {
                super.init();
                root = this;
            }
        };
        Assert.assertNotNull("Instance exists", i );
        jmri.InstanceManager.memoryManagerInstance().provideMemory("IM2").setValue("");
        to.setMemory("IM2");

        jf.pack();
        jf.setVisible(true);

	}

	public void testShowEmpty() {
        JFrame jf = new JFrame();
        jf.setTitle("Expect empty");
        jf.getContentPane().setLayout(new java.awt.FlowLayout());

        jf.getContentPane().add(new javax.swing.JLabel("Expect red X default icon: "));
        
        to = new MemoryIcon();
        jf.getContentPane().add(to);
        
        jmri.InstanceManager i = new jmri.InstanceManager(){
            protected void init() {
                super.init();
                root = this;
            }
        };
        Assert.assertNotNull("Instance exists", i );
        jmri.InstanceManager.memoryManagerInstance().provideMemory("IM3");
        to.setMemory("IM3");

        jf.pack();
        jf.setVisible(true);

	}

	// from here down is testing infrastructure

	public MemoryIconTest(String s) {
		super(s);
	}

	// Main entry point
	static public void main(String[] args) {
		String[] testCaseName = {"-noloading", MemoryIconTest.class.getName()};
		junit.swingui.TestRunner.main(testCaseName);
	}

	// test suite from all defined tests
	public static Test suite() {
		TestSuite suite = new TestSuite(MemoryIconTest.class);
		return suite;
	}

    // The minimal setup for log4J
    protected void setUp() throws Exception { 
        super.setUp();
        apps.tests.Log4JFixture.setUp(); 
        JUnitUtil.resetInstanceManager();
    }
    
    protected void tearDown() throws Exception { 
        super.tearDown();
        apps.tests.Log4JFixture.tearDown();
        JUnitUtil.resetInstanceManager();
    }

	// static private org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(TurnoutIconTest.class.getName());

}
