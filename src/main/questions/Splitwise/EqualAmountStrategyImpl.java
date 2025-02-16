package Splitwise;

import java.util.ArrayList;
import java.util.List;

public class EqualAmountStrategyImpl implements SplitAmountStrategy {


    @Override
    public List<Double> split(int totalAmount, List<Double> shares, int size) {
        List<Double> splitList = new ArrayList<>();
        for(int i=0;i<size;i++)splitList.add((Double)(1.0*totalAmount/size));
        return splitList;
    }
}
