/**
 * TODO: Java docs
 *
 * @author Igor Mitin
 */
public class FactoryMyTaskImpl implements  FactoryTask
{
    @Override
    public Task createTask()
    {
        return new MyTask();
    }
}
