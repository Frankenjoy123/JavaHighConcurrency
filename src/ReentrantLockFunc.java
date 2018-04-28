import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/4/28.
 */
public class ReentrantLockFunc implements Runnable{

    public static ReentrantLock lock = new ReentrantLock();

    public static int j;


    @Override
    public void run() {



        for (int i =0 ; i<10000;i++){
            lock.lock();

            j++;

            lock.unlock();

        }


    }

    public static void main (String[] args){
        Thread t1 = new Thread(new ReentrantLockFunc(),"my-thread-1");
        Thread t2 = new Thread(new ReentrantLockFunc(),"my-thread-2");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(j);
    }
}
