package threads;

public class ThreadRunnableTest implements Runnable{
    @Override
    public void run() {
        System.out.println("Child "+Thread.currentThread().getName() + " thread starts");
        System.out.println("Thread started by implementing Runnable interface");
        System.out.println("Child "+Thread.currentThread().getName() + " thread ends");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main "+Thread.currentThread().getName() + " thread starts");
        ThreadRunnableTest mainObject = new ThreadRunnableTest();
        Thread thread1 = new Thread(mainObject);
        thread1.start();

        thread1.join();

        System.out.println("Main "+Thread.currentThread().getName() + " thread ends");
    }
}
