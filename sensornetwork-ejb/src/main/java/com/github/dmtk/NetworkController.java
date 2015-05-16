package com.github.dmtk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.ejb.Singleton;

@Singleton
public class NetworkController {

    private static Map<Integer, SensorNode> activeNodePull = new HashMap<Integer, SensorNode>();

    @EJB
    private SensorNodeFacadeLocal sensorNodeFacade;
    @EJB
    private NetworkEventFacadeLocal networkEventFacade;

    public NetworkController() {

        try {
            List<SensorNode> list = sensorNodeFacade.findAll();
            Iterator i = list.iterator();
            while (i.hasNext()) {
                SensorNode temp = (SensorNode) i.next();
                Integer id = temp.getId();
                activeNodePull.put(id, temp);
            }
        } catch (NullPointerException e) {

        }

    }

    public void handle(int node, int value) {

        if (!activeNodePull.containsKey(node)) {
            SensorNode sensorNode = new SensorNode(node);
            sensorNode.setValue(value);
            activeNodePull.put(node, sensorNode);
            sensorNodeFacade.create(sensorNode);
            NetworkEvent n = new NetworkEvent();
            n.setSource(sensorNode);
            networkEventFacade.create(n);
        } else {
            activeNodePull.get(node).setValue(value);
            NetworkEvent n = new NetworkEvent();
            n.setSource(activeNodePull.get(node));
            networkEventFacade.edit(n);
        }

    }

    public static List getActiveNodePull() {

        return new ArrayList<SensorNode>(activeNodePull.values());
    }

}
