/*
  Copyright © 2019 Pasqual K. | All rights reserved
 */

package systems.reformcloud.examples.event;

import systems.reformcloud.ReformCloudController;
import systems.reformcloud.event.annotation.Handler;
import systems.reformcloud.event.utility.Cancellable;
import systems.reformcloud.event.utility.Event;
import systems.reformcloud.event.utility.Listener;

import java.beans.ConstructorProperties;
import java.io.Serializable;

/**
 * @author _Klaro | Pasqual K. / created on 19.05.2019
 */

public final class EventExample implements Serializable {
    public EventExample() {
        //Creates the new event
        TestEvent testEvent = new TestEvent(false);

        //Calls the event
        ReformCloudController.getInstance().getEventManager().fire(testEvent);

        //The event got cancelled by one of the listener
        if (testEvent.isCancelled()) {
            System.out.println("Event got cancelled");
            return;
        }

        //Prints the value of the event
        System.out.println(testEvent.isTested());
    }

    private class ListenerExample implements Listener {
        @Handler //Needed for the cloud to check if the method is an event method or not
        //The method have to be public and the return type has to be void
        public void handle(TestEvent event) {
            //This method got called when the event ('TestEvent' in this case) got called
            System.out.println(event.isTested());
        }
    }

    private class TestEvent extends Event implements Cancellable {
        private boolean tested;

        private boolean cancelled;

        @ConstructorProperties({"tested"})
        public TestEvent(boolean tested) {
            this.tested = tested;
        }

        public boolean isTested() {
            return tested;
        }

        @Override
        public void setCancelled(boolean b) {
            cancelled = b;
        }

        @Override
        public boolean isCancelled() {
            return cancelled;
        }
    }
}
