package Kafka;

public class Orchestrator {
    public static void main(String[] args) throws InterruptedException {
        MessageQueue messageQueue = MessageQueue.getInstance();
        messageQueue.buildArchitecture();

        Thread thread1 = new Thread(() -> {
            try {
                messageQueue.publishMessage(1, 1, "msg-1");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // Thread 2: Publish message 2 to topic 1
        Thread thread2 = new Thread(() -> {
            try {
                messageQueue.publishMessage(1, 1, "msg-2");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        // Start both threads
        thread1.start();
        thread2.start();

        // Ensure both threads have finished
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        messageQueue.publishMessage(2, 1, "msg-3");
        messageQueue.publishMessage(1, 2, "msg-4");
        messageQueue.publishMessage(2, 2, "msg-5");


    }
}
