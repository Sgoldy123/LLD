package KeyValueStore;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class KeyValueStore {

    private Map<String, String> store; // Main data store
    private Stack<Transaction> transactions; // Stack to manage nested transactions

    public KeyValueStore() {
        this.store = new HashMap<>();
        this.transactions = new Stack<>();
    }

    public void set(String key, String value) {
        if (!transactions.isEmpty()) {
            transactions.peek().set(key, value);
        } else {
            store.put(key, value);
        }
    }

    public String get(String key) {
        if (!transactions.isEmpty()) {
            return transactions.peek().get(key);
        }
        return store.getOrDefault(key, null);
    }

    public void delete(String key) {
        if (!transactions.isEmpty()) {
            transactions.peek().delete(key);
        } else {
            store.remove(key);
        }
    }

    public void begin() {
        transactions.push(new Transaction(new HashMap<>(store)));
    }

    public void commit() {
        if (transactions.isEmpty()) {
            throw new IllegalStateException("No active transaction to commit.");
        }
        Transaction transaction = transactions.pop();
        if (transactions.isEmpty()) {
            store = transaction.getCurrentState();
        } else {
            transactions.peek().merge(transaction);
        }
    }

    public void rollback() {
        if (transactions.isEmpty()) {
            throw new IllegalStateException("No active transaction to rollback.");
        }
        transactions.pop();
    }

    public void printState() {
        System.out.println("Current store: " + store);
        System.out.println("Transactions: " + transactions.size());
    }
}
