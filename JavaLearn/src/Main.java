/**
 * ClassName:Main
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2021/12/14 14:28
 * @Author:qs@1.com
 */
public class Main {
    public static void main(String[] args) {
        // test ProblematicLock
        //ProlematicLock lock = new ProlematicLock();
//        CompareAndSwapLock lock = new CompareAndSwapLock();
//
//        for (int i = 0; i < 50; i++) {
//
//            MyThread myThread = new MyThread(lock, "thread" + i);
//            myThread.start();
//        }

        //  模拟乐观锁用于计数器
        OptimisticLockCounter optimisticLockCounter = new OptimisticLockCounter();
        for (int i = 0; i < 100; i++) {
            new Thread(){
                @Override
                public void run() {
                    optimisticLockCounter.inc();
                }
            }.start();
        }

    }
}
