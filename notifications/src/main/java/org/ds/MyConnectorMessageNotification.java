package org.ds;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.mule.runtime.api.notification.ConnectorMessageNotification;
import org.mule.runtime.api.notification.ConnectorMessageNotificationListener;

/*
  Used to notify that a message was received or sent through a Connector
 */

class MyConnectorMessageNotification implements ConnectorMessageNotificationListener<ConnectorMessageNotification> {

   private Logger LOG = LogManager.getLogger(MyConnectorMessageNotification.class);
   
   public MyConnectorMessageNotification() {
      LOG.info("ConnectorMessageNotification starting");
   }
   
   public void onNotification(ConnectorMessageNotification n) {
               
      LOG.info(String.format("ConnectorMessage Action:%s Type:%s", 
               n.getAction().getIdentifier(),
               n.getType()));
      
   }
   
}
