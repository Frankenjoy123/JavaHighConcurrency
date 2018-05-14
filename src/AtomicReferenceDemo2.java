import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/5/3.
 */
public class AtomicReferenceDemo2 {

    private static Person person;

    private static AtomicReference<Person> personAtomicReference;


    public static void main(String[] args) throws InterruptedException {
        person = new Person("Tom", 18);
        personAtomicReference = new AtomicReference<>(person);

        System.out.println("Person is " + personAtomicReference.get().toString());

        Thread t1 = new Thread(new Task1());
        Thread t2 = new Thread(new Task2());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Now Person is " + personAtomicReference.get().toString());
    }

    static class Task1 implements Runnable {
        public void run() {
            //存在指令重排序

            personAtomicReference.getAndSet(new Person("Tom1",personAtomicReference.get().getAge()+1));

            System.out.println("Thread1 Values "
                    + personAtomicReference.get().toString());
        }
    }

    static class Task2 implements Runnable {
        public void run() {
            //存在指令重排序
            personAtomicReference.getAndSet(new Person("Tom2",personAtomicReference.get().getAge()+2));

            System.out.println("Thread2 Values "
                    + personAtomicReference.get().toString());
        }
    }

}
