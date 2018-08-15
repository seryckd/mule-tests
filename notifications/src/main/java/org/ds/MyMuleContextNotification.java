package org.ds;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mule.runtime.core.api.context.notification.MuleContextNotification;
import org.mule.runtime.core.api.context.notification.MuleContextNotificationListener;

public class MyMuleContextNotification implements MuleContextNotificationListener<MuleContextNotification> {

    private Logger LOG = LogManager.getLogger(MyMuleContextNotification.class);

    public void onNotification(MuleContextNotification n) {
        LOG.info(String.format("MULE-CONTEXT Action:%s-%s",
                n.getAction().getIdentifier(), actionId(Integer.valueOf(n.getAction().getIdentifier()))));

    }

    private String actionId(int id) {
        switch(id) {
            case MuleContextNotification.CONTEXT_DISPOSED : return "CONTEXT_DISPOSED";
            case MuleContextNotification.CONTEXT_DISPOSING : return "CONTEXT_DISPOSING";
            case MuleContextNotification.CONTEXT_INITIALISED : return "CONTEXT_INITIALISED";
            case MuleContextNotification.CONTEXT_INITIALISING : return "CONTEXT_INITIALISING";
            case MuleContextNotification.CONTEXT_STARTED : return "CONTEXT_STARTED";
            case MuleContextNotification.CONTEXT_STARTING : return "CONTEXT_STARTING";
            case MuleContextNotification.CONTEXT_STOPPED : return "CONTEXT_STOPPED";
            case MuleContextNotification.CONTEXT_STOPPING : return "CONTEXT_STOPPING";
            default : return String.format("unknown:%s", id);
        }
    }

}
