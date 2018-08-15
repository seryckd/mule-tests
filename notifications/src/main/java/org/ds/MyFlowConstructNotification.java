package org.ds;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.mule.runtime.api.notification.FlowConstructNotification;
import org.mule.runtime.api.notification.FlowConstructNotificationListener;


/*
 get notifications for starting and stopping every flow
 */
class MyFlowConstructNotification implements FlowConstructNotificationListener<FlowConstructNotification> {

   private Logger LOG = LogManager.getLogger(MyFlowConstructNotification.class);
   
   public MyFlowConstructNotification() {
      LOG.info("FlowConstruct starting");
   }
   
   public void onNotification(FlowConstructNotification n) {
               
      LOG.info(String.format("FlowConstruct# action:%s-%s-%s actionName:%s eventName:%s type:%s resourceId:%s",
                             n.getAction().getNamespace(), n.getAction().getIdentifier(), actionId(Integer.valueOf(n.getAction().getIdentifier())),
                             n.getActionName(), n.getEventName(), n.getType(), n.getResourceIdentifier())); 
      
   }
   
   private String actionId(int id) {
      switch(id) {
         case FlowConstructNotification.FLOW_CONSTRUCT_DISPOSED : return "FLOW_CONSTRUCT_DISPOSED";
         case FlowConstructNotification.FLOW_CONSTRUCT_INITIALISED : return "FLOW_CONSTRUCT_INITIALISED";
         case FlowConstructNotification.FLOW_CONSTRUCT_PAUSED : return "FLOW_CONSTRUCT_PAUSED";
         case FlowConstructNotification.FLOW_CONSTRUCT_RESUMED : return "FLOW_CONSTRUCT_RESUMED";
         case FlowConstructNotification.FLOW_CONSTRUCT_STARTED : return "FLOW_CONSTRUCT_STARTED";
         case FlowConstructNotification.FLOW_CONSTRUCT_STOPPED : return "FLOW_CONSTRUCT_STOPPED";
         default : return String.format("unknown:%s", id);
      }
   }   
}
