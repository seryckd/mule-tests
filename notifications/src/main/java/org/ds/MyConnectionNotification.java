package org.ds;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.mule.runtime.api.notification.ConnectionNotification;
import org.mule.runtime.api.notification.ConnectionNotificationListener;

/*
  http://www.mulesoft.org/docs/site/4.1.1/apidocs/
  Is fired by a connector when a connection is made or disconnected. A disconnection can be caused by network failure, JMX, or the server shutting down.
  
  Examples
  action:MULE-701-CONNECTION_CONNECTED resourceId:Testing connectivity for config 'HTTP_Listener_config'
  action:MULE-701-CONNECTION_CONNECTED resourceId:Message Source Reconnection
 */

class MyConnectionNotification implements ConnectionNotificationListener<ConnectionNotification> {

   private Logger LOG = LogManager.getLogger(MyConnectionNotification.class);
   
   public MyConnectionNotification() {
      LOG.info("ConnectionNotification starting");
   }
   
   public void onNotification(ConnectionNotification n) {

      
      LOG.info(String.format("Connection# action:%s-%s-%s actionName:%s eventName:%s type:%s resourceId:%s",
                             n.getAction().getNamespace(), n.getAction().getIdentifier(), actionId(Integer.valueOf(n.getAction().getIdentifier())),
                             n.getActionName(), n.getEventName(), n.getType(), n.getResourceIdentifier())); 
 
   }
 
   
   private String actionId(int id) {
      switch(id) {
         case ConnectionNotification.CONNECTION_CONNECTED : return "CONNECTION_CONNECTED";
         case ConnectionNotification.CONNECTION_DISCONNECTED : return "";
         case ConnectionNotification.CONNECTION_FAILED : return "";
         default : return String.format("unknown:%s", id);
      }
   }
}
