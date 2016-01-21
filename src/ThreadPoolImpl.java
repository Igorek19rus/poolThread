import java.util.*;

/**
 * TODO: Java docs
 *
 * @author Igor Mitin
 */
public class ThreadPoolImpl implements ThreadPool
{
    final int THREAD_COUNT;
    Set availableThreads = new HashSet<>();
    List<Task> taskQueue = new LinkedList<>();

    public ThreadPoolImpl(final int THREAD_COUNT)
    {
        this.THREAD_COUNT = THREAD_COUNT;
        for (int i= 0; i< THREAD_COUNT; i++)
        {
            availableThreads.add(new PooledThreadImpl(taskQueue, "thread-"+i));
        }

        for (Iterator<PooledThreadImpl> iter = availableThreads.iterator(); iter.hasNext(); )
        {
            iter.next().start();
        }
    }

    public void addTask(final Task task)
    {
        synchronized(taskQueue)
        {
            taskQueue.add(task);
            taskQueue.notifyAll();
        }
    }
}
