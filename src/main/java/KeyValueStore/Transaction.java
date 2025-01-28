package KeyValueStore;

import java.util.HashMap;
import java.util.Map;

public class Transaction {

    private Map<String, String> currentState;

    public Transaction(Map<String, String> initialState) {
        this.currentState = new HashMap<>(initialState);
    }

    public void set(String key, String value) {
        currentState.put(key, value);
    }

    public String get(String key) {
        return currentState.getOrDefault(key, null);
    }

    public void delete(String key) {
        currentState.remove(key);
    }

    public Map<String, String> getCurrentState() {
        return currentState;
    }

    public void merge(Transaction other) {
        this.currentState.putAll(other.getCurrentState());
    }
}
