public class Box {
    final static int SLEEP = 5000;
    volatile static boolean toggleSwitch = true;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            new PlayerThread().start();
            new ToyTread().start();
        }
        Thread toy = new ToyTread();
        Thread player = new PlayerThread();
        player.start();
        toy.start();
        player.join();
        toy.interrupt();
    }
    static class ToyTread extends Thread {
        @Override
        public void run() {
            if (!toggleSwitch) {
                System.out.println("Тумблер выключился!");
            } if (isInterrupted()) return;
            toggleSwitch = true;
        }
    }
    static class PlayerThread extends Thread {
        @Override
        public void run() {
            if (toggleSwitch) {
                System.out.println("Тумблер включился!");
            }toggleSwitch = false;
                try {
                    Thread.sleep(SLEEP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



