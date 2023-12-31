package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


//  EFFECTS : Represents a log of alarm system events.
public class EventLog implements Iterable<Event> {
    /**
     * the only EventLog in the system (Singleton Design Pattern)
     */
    private static EventLog theLog;
    private Collection<Event> events;


//  EFFECTS : Prevent external construction.
//            (Singleton Design Pattern).
    private EventLog() {
        events = new ArrayList<Event>();
    }


//  EFFECTS : Gets instance of EventLog - creates it
//            if it doesn't already exist.
    public static EventLog getInstance() {
        if (theLog == null) {
            theLog = new EventLog();
        }


        return theLog;
    }


//  EFFECTS : Adds an event to the event log.
    public void logEvent(Event e) {
        events.add(e);
    }


//   EFFECTS : Clears the event log and logs the event.
    public void clear() {
        events.clear();
        logEvent(new Event("Event log cleared."));
    }

    // EFFECTS : returns the events iterator
    @Override
    public Iterator<Event> iterator() {
        return events.iterator();
    }
}
