/**
 * TODO: Java docs
 *
 * @author Igor Mitin
 */
public class MyTask implements Task
{
    private String name;
    private int sleepTime;
    private int sleepPointNumber;

    public MyTask()
    {
    }

    public MyTask(String name, int sleepTime, int sleepPointNumber)
    {
        this.name = name;
        this.sleepTime = sleepTime;
        this.sleepPointNumber = sleepPointNumber;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void performTask() throws InterruptedException
    {
        System.out.printf("Im a %s thread, Im going to sleep %d times for %d seconds", name, sleepPointNumber, sleepTime);
        for (int i = 0; i<sleepPointNumber;i++)
        {
            Thread.sleep(sleepTime*1000);
            System.out.printf("Im a %s thread, I slept %d time", name, i);
        }
    }
}
