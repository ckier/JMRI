package jmri.implementation.configurexml;

import jmri.InstanceManager;
import jmri.SignalMast;
import jmri.implementation.SignalHeadSignalMast;
import org.jdom.Element;

/**
 * Handle XML configuration for a DefaultSignalMastManager objects.
 *
 * @author Bob Jacobsen Copyright: Copyright (c) 2009
 * @version $Revision: 18102 $
 */
public class SignalHeadSignalMastXml 
            extends jmri.managers.configurexml.AbstractNamedBeanManagerConfigXML {

    public SignalHeadSignalMastXml() {}

    /**
     * Default implementation for storing the contents of a
     * DefaultSignalMastManager
     * @param o Object to store, of type TripleTurnoutSignalHead
     * @return Element containing the complete info
     */
    public Element store(Object o) {
        SignalHeadSignalMast p = (SignalHeadSignalMast)o;
        Element e = new Element("signalmast");
        e.setAttribute("class", this.getClass().getName());
        e.addContent(new Element("systemName").addContent(p.getSystemName()));
        storeCommon(p, e);
        return e;
    }

    /**
     * Create a DefaultSignalMastManager
     * @param element Top level Element to unpack.
     * @return true if successful
     */
    public boolean load(Element element) {
        SignalMast m;
        String sys = getSystemName(element);
        m = InstanceManager.signalMastManagerInstance()
                    .provideSignalMast(sys);
        
        if (getUserName(element) != null)
            m.setUserName(getUserName(element));
        
        loadCommon(m, element);
        return true;
    }

    public void load(Element element, Object o) {
        log.error("Invalid method called");
    }
    
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(SignalHeadSignalMastXml.class.getName());
}