/**
 * Created by xiaowu.zhou@tongdun.cn on 2018/4/22.
 */
public class StopThreadUnSafe {

    public static User user = new User();


    public static class User{
        private int id;
        private String name;

        public User() {
            id = 0;
            name ="0";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User [id=" + id  + ", name=" +name +"]";
        }
    }

    public static class ChangeObjectThread extends Thread{

        private volatile boolean stopme = false;

        //新增定义停止方法
        public void stopMe(){
            stopme = true;
        }

        @Override
        public void run() {

            while (true){

                if (stopme){
                    System.out.println("ChangeObjectThread stop by stopMe method");
                    break;
                }

                synchronized (user){

                    int v = (int) (System.currentTimeMillis()/1000);
                    user.setId(v);

                    //sleep , monitor long time operation
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    user.setName(String.valueOf(v));

                }
            }

        }
    }

    public static class ReadObjectThread extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized (user){
                    if (user.getId() != Integer.parseInt(user.getName())){
                        System.out.println(user.toString());
                    }
                }
            }
        }
    }


}
