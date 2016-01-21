import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ThreadPool poolThread = new ThreadPoolImpl(5);
        for (int i = 0; i < 1000; i++)
        {
            poolThread.addTask(new MyTask(String.valueOf(i), i%10 *1000, (11-i%10) *1000));
        }
    }
}
