import java.util.List;
import java.util.Set;

/**
 * TODO: Java docs
 *
 * @author Igor Mitin
 */
public class PooledThreadImpl extends Thread implements PooledThread
{
    private final List<Task> taskQueue;
    private int taskNumber;

    public PooledThreadImpl(final List<Task> taskQueue, final String name)
    {
        super(name);
        this.taskQueue = taskQueue;
    }

    public List<Task> getTaskQueue()
    {
        return taskQueue;
    }

    public int getTaskNumber()
    {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber)
    {
        this.taskNumber = taskNumber;
    }

    public void run()
    {
        Task currentTask = null;
        while (true)
        {
            synchronized(taskQueue)
            {
                if (taskQueue.isEmpty())
                {
                    try
                    {
                        System.out.println("=====================================\n");
                        System.out.printf("Thread %s is waiting a task\n", super.getName());
                        System.out.printf("Thread %s executes %d tasks\n", super.getName(), taskNumber);
                        taskQueue.wait();
                    }
                    catch(InterruptedException e)
                    {
                        System.out.println("interrupted thread\n");
                        e.printStackTrace();
                    }
                    continue;
                }
                else {
                    currentTask = (Task) taskQueue.remove(0);
                    taskNumber++;
                    System.out.printf("Thread %s execute the task %s\n", super.getName(), currentTask.toString());
                }
            }
        }
    }
}
