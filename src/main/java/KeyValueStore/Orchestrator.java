package KeyValueStore;

public class Orchestrator {
    public static void main(String[] args) {
        KeyValueStore store = new KeyValueStore();

        System.out.println("== Basic Operations ==");
        store.set("name", "Alice");
        System.out.println("Get name: " + store.get("name")); // Alice
        store.delete("name");
        System.out.println("Get name after delete: " + store.get("name")); // null

        System.out.println("\n== Transactions ==");
        store.set("age", "25");
        store.begin();
        store.set("age", "30");
        System.out.println("Age inside transaction: " + store.get("age")); // 30
        store.rollback();
        System.out.println("Age after rollback: " + store.get("age")); // 25

        System.out.println("\n== Nested Transactions ==");
        store.begin();
        store.set("city", "New York");
        store.begin();
        store.set("city", "San Francisco");
        System.out.println("City inside nested transaction: " + store.get("city")); // San Francisco
        store.commit();
        System.out.println("City after committing inner transaction: " + store.get("city")); // San Francisco
        store.rollback();
        System.out.println("City after rolling back outer transaction: " + store.get("city")); // null
    }
}
