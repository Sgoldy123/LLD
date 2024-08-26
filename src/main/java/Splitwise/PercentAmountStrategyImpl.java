package Splitwise;

import java.util.ArrayList;
import java.util.List;

public class PercentAmountStrategyImpl implements SplitAmountStrategy{
    @Override
    public List<Double> split(int totalAmount, List<Double> shares, int size) {
        return shares.stream().map(i->i*(totalAmount)).toList();
    }
}
