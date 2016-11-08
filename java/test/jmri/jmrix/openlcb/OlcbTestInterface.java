package jmri.jmrix.openlcb;

import org.openlcb.Connection;
import org.openlcb.NodeID;
import org.openlcb.OlcbInterface;
import org.openlcb.can.CanInterface;

import java.util.concurrent.Semaphore;

import jmri.jmrix.can.TestTrafficController;
import jmri.jmrix.can.TrafficController;

/**
 * Created by bracz on 11/7/16.
 */

public class OlcbTestInterface {
    public OlcbTestInterface() {
        tc = new TestTrafficController();
        nodeID = new NodeID("02.01.0D.00.00.01");
        canInterface = OlcbConfigurationManager.createOlcbCanInterface(nodeID, tc);
        iface = canInterface.getInterface();
    }

    public void waitForStartup() {
        final Semaphore s = new Semaphore(0);
        iface.getOutputConnection().registerStartNotification(new Connection.ConnectionListener() {
            @Override
            public void connectionActive(Connection c) {
                s.release();
            }
        });
        s.acquireUninterruptibly();
    }

    TestTrafficController tc;
    NodeID nodeID;
    CanInterface canInterface;
    OlcbInterface iface;
}