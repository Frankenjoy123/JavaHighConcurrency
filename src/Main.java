public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        new StopThreadUnSafe.ReadObjectThread().start();

        while (true){
            StopThreadUnSafe.ChangeObjectThread t  = new StopThreadUnSafe.ChangeObjectThread();
            t.start();

            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            t.stopMe();

            //不要使用Thread stop方法
//            t.stop();

        }
    }
}
