package SrouceCode;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.reflect.Method;

/**
 * The Notification Center is designed
 * after the NSNotificationCenter in
 * Cocoa (MacOS)
 *
 * @author (Rodrigo A. Obando)
 * @version (Fall 2018)
 */
public class NotificationCenter
{
    private HashMap<String, ArrayList<ObserverEntry>> observers; // this contains the observers by Notification name
    private Queue<ObserverCommand> queue;
    private static NotificationCenter instance = null; // this is the only instance of the Notification Center (Singleton)

    /**
     * Default Constructor
     * It is private because it implements the Singleton pattern
     */
    private NotificationCenter()
    {
        observers = new HashMap<String, ArrayList<ObserverEntry>>();
        queue = new LinkedList<ObserverCommand>();
    }

    /**
     * This is the method to gain access
     * to the only instance of the class
     * It uses lazy instantiation
     */
    public static NotificationCenter getInstance()
    {
        if(instance == null)
        {
            instance = new NotificationCenter();
        }
        return instance;
    }

    /**
     * Inner class ObserverEntry
     * It is used to store information
     * about an observer.
     * It overrides the equals method to
     * be able to have the same observer
     * but for multiple 'callbacks'
     */
    private class ObserverEntry
    {
        Object observer;
        String method;

        ObserverEntry (Object observer, String method)
        {
            this.observer = observer;
            this.method = method;
        }

        public boolean equals(Object other)
        {
            return this.observer.equals(((ObserverEntry)other).observer) && this.method.equals(((ObserverEntry)other).method);
        }
    }

    /**
     * Adds an observer for a given notification name
     */
    public void addObserver(String notificationName, Object observer, String methodName)
    {
        ArrayList<ObserverEntry> entryList = observers.get(notificationName);
        if(entryList == null)
        {
            entryList = new ArrayList<ObserverEntry>();
            observers.put(notificationName, entryList);
        }
        entryList.add(new ObserverEntry(observer, methodName));
    }
    
    public void queueAddObserver(String notificationName, Object observer, String methodName)
    {
        queue.offer(new AddObserver(notificationName, observer, methodName));
    }

    /**
     * Removes an observer for a given notification name
     */
    public void removeObserver(String notificationName, Object observer, String methodName)
    {
        ArrayList<ObserverEntry> entryList = observers.get(notificationName);
        if(entryList != null)
        {
            boolean result = entryList.remove(new ObserverEntry(observer, methodName));
            if(entryList.size() == 0)
            {
                observers.remove(notificationName);
            }
        }

    }
    
    public void queueRemoveObserver(String notificationName, Object observer, String methodName)
    {
        queue.offer(new RemoveObserver(notificationName, observer, methodName));
    }
    
    public void processQueue()
    {
        while(!queue.isEmpty())
        {
            queue.poll().execute();
        }
    }
    
    /**
     * Posts a notification to the NotificationCenter
     * It sends notifications to all observers/subscribers
     * to this notification
     */
    public void postNotification(Notification notification)
    {
        ArrayList<ObserverEntry> entryList = observers.get(notification.getName());
        if(entryList != null)
        {
            for(ObserverEntry observerEntry : entryList)
            {
                sendNotification(notification, observerEntry);
            }
            processQueue();
        }
    }
    
    /**
     * Sends a notification to an observer
     * It uses Reflection to invoke the appropriate
     * method stored in the ObserverEntry object
     */
    private void sendNotification(Notification notification, ObserverEntry observerEntry)
    {
        Class cls = observerEntry.observer.getClass();
        Method method = null;
        try
        {
            method = cls.getDeclaredMethod(observerEntry.method, Class.forName("SrouceCode.Notification"));
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("sendNotification: " + e);
            return;
        }
        catch(NoSuchMethodException e)
        {
            System.out.println("sendNotification: " + e);
            return;
        }
        try
        {
            method.invoke(observerEntry.observer, notification);
        }
        catch(IllegalAccessException e)
        {
            System.out.println("sendNotification: " + e);
        }
        catch(java.lang.reflect.InvocationTargetException e)
        {
            System.out.println("sendNotification: " + e);
        }
    }

    private abstract class ObserverCommand
    {
        protected String notificationName;
        protected Object object;
        protected String methodName;
        ObserverCommand(String notificationName, Object object, String methodName)
        {
            this.notificationName = notificationName;
            this.object = object;
            this.methodName = methodName;
        }
        abstract void execute();
    }
    
    private class AddObserver extends ObserverCommand
    {
        AddObserver(String notificationName, Object object, String methodName)
        {
            super(notificationName, object, methodName);
        }
        void execute()
        {
            addObserver(notificationName, object, methodName);
        }
    }

    private class RemoveObserver extends ObserverCommand
    {
        RemoveObserver(String notificationName, Object object, String methodName)
        {
            super(notificationName, object, methodName);
        }
        void execute()
        {
            removeObserver(notificationName, object, methodName);
        }
    }
}
