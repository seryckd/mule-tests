package org.ds;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.mule.runtime.api.notification.ManagementNotification;
import org.mule.runtime.api.notification.ManagementNotificationListener;


class MyManagementNotification implements ManagementNotificationListener<ManagementNotification> {

   private Logger LOG = LogManager.getLogger(MyManagementNotification.class);
   
   public MyManagementNotification() {
      LOG.info("XXX starting");
   }
   
   public void onNotification(ManagementNotification n) {
               
      LOG.info(String.format("Action:%s", 
               n.getAction().getIdentifier()));
      
   }
   
}
