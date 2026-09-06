package threads;

public class GateOpenThreadSyncTest  {

    private volatile boolean isGateOpen = false;


    public  synchronized void gateOperation(String threadName) throws InterruptedException {


        if(isGateOpen){
            Thread.sleep(1000);
            System.out.println("Thread "+threadName+" Now Gate is Opened");
        }else{
            Thread.sleep(1000);
            System.out.println("Thread "+threadName+" Now Gate is Closed");
        }

    }

    public synchronized boolean getGateStatus(){
        return this.isGateOpen;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main Starts");
        GateOpenThreadSyncTest g1 = new GateOpenThreadSyncTest();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1; i++){
                System.out.println("Gate Status Before accessing sync variable from Thread 1=>"+g1.getGateStatus());
                //extracted(g1,"Thread-1-outside"+" Iteration-"+i);
                if(g1.isGateOpen){
                    extracted(g1,"Thread-1-if"+" Iteration-"+i);
                    g1.isGateOpen = false;
                    //System.out.println("Gate Status After modifying isGateOpen=false from Thread 1=>"+g1.getGateStatus());

                }else{
                    extracted(g1,"Thread-1-else"+" Iteration-"+i);
                    g1.isGateOpen = true;
                    System.out.println("Gate Status After modifying isGateOpen=true from Thread 1=>"+g1.getGateStatus());

                }
                //extracted(g1,"Thread-1-outside"+" Iteration-"+i);

            }
        });
        t1.start();
        t1.setPriority(Thread.MAX_PRIORITY);
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1; i++){
                System.out.println("Gate Status Before accessing sync variable from Thread 2=>"+g1.getGateStatus());
                //extracted(g1,"Thread-2-outside"+" Iteration-"+i);
                if(g1.isGateOpen){
                    extracted(g1,"Thread-2-if"+" Iteration-"+i);
                    g1.isGateOpen = false;
                    //System.out.println("Gate Status After modifying isGateOpen=false from Thread 2=>"+g1.getGateStatus());

                }else{
                    extracted(g1,"Thread-2-else"+" Iteration-"+i);
                    g1.isGateOpen = true;
                    //System.out.println("Gate Status After modifying isGateOpen=true from Thread 2=>"+g1.getGateStatus());

                }
                //extracted(g1,"Thread-2-outside"+" Iteration-"+i);
            }
        });
        t2.start();

        try {
            t1.join();
            t2.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Main Ends");
    }

    private static void extracted(GateOpenThreadSyncTest g1,String threadName) {
        try {
            g1.gateOperation(threadName);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
