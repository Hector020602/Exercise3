public class Main {
    public static void main(String[] args) throws InterruptedException {
        if (args.length != 1) {
            System.err.println("Usage: Main<num seconds>");
            System.exit(1);
        }
        long miliseconds = Long.parseLong(args[0]) * 1000;
        MessageLog ml = new MessageLog("aaaa", "bbbb", "cccc", "dddd");
        Thread thread = new Thread(ml);
        thread.start();
        //thread.join();
        long acc = 0;
        while (thread.isAlive()) {
            Thread.sleep(100);
            acc += 100;
            if (acc >= miliseconds) {
                thread.interrupt();
            }
        }
        System.out.println("The end");
    }

}
