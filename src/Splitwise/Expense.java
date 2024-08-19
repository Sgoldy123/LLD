package Splitwise;

import java.util.List;
import java.util.Map;

public class Expense {

    private User paidby;
    private int id;

    private int toatlAmount;
    private List<User> userList;

    private Type type;
    private List<Double> shares;

    private List<Double> amountShare;




    public Expense(User paidby, int id, int toatlAmount, List<User> userList, Type type, List<Double> shares) {
        this.paidby = paidby;
        this.id = id;
        this.toatlAmount = toatlAmount;
        this.userList = userList;
        this.type = type;
        this.shares = shares;
        this.amountShare = calculateShare(toatlAmount,shares,shares.size(),type);
    }

    public List<Double> calculateShare(int toatlAmount, List<Double>shares ,int size , Type type){
        SplitAmountStrategy strategy ;
        if(type == Type.EQUAL){
            strategy = new EqualAmountStrategyImpl();
        }
        else{
            strategy = new PercentAmountStrategyImpl();
        }
        return strategy.split(toatlAmount,shares,shares.size());
    }

    public void updatePassbook(User paidby,List<User> userList, List<Double> amountShare){
        //paidby getback
        int i=0;
        for(User user : userList){
            Map<User,Double> temp = paidby.getBalance().getGetback();
            Map<User,Double> temp2 = user.getBalance().getGive();
            if(paidby != user) {
                if (temp.containsKey(user)) {
                    temp.put(user, temp.get(user) + amountShare.get(i));
                }
                else{
                    temp.put(user,amountShare.get(i));
                }
                if (temp2.containsKey(paidby)) {
                    temp2.put(paidby, temp2.get(paidby) + amountShare.get(i));
                }
                else{
                    temp2.put(paidby,amountShare.get(i));
                }
            }
            i++;

        }
    }
    public User getPaidby() {
        return paidby;
    }

    public int getId() {
        return id;
    }

    public int getToatlAmount() {
        return toatlAmount;
    }

    public List<User> getUserList() {
        return userList;
    }

    public Type getType() {
        return type;
    }

    public List<Double> getAmountShare() {
        return amountShare;
    }

    public List<Double> getShares() {
        return shares;
    }
}
