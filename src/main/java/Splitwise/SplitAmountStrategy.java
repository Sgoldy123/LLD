package Splitwise;

import java.util.List;

public interface SplitAmountStrategy {
    public List<Double> split(int totalAmount, List<Double> shares ,int size);
}
