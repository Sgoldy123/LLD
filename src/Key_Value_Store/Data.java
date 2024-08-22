package Key_Value_Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {

    private static Data data = new Data();
    private Map<String,Attribute> dataKeyVal;
    private Data(){
        this.dataKeyVal = new HashMap<>();
    }
    public static Data getData(){
        return data;
    }
    public void putKey(String[] inputArray){
        String key = inputArray[1];
        Attribute attribute = new Attribute();
        for(int i=2;i<inputArray.length;i+=2){
            attribute.putAttribute(inputArray[i],inputArray[i+1]);
        }
        dataKeyVal.put(key,attribute);
    }

    public void getKey(String[] inputArray){
        String key = inputArray[1];
        Attribute temp = dataKeyVal.get(key);
        for(Map.Entry<String,Object> j : temp.getAttributeKeyVal().entrySet()){
            System.out.print(j.getKey() + ": " + j.getValue() + ",");
        }
        System.out.println();

    }
    public void deleteKey(String[] inputArray){
        if(!dataKeyVal.containsKey(inputArray[1])) System.out.println("key doesn't exist in store");
        dataKeyVal.remove(inputArray[1]);
    }

    public void searchKeyVal(String[] inputArray){
        String attrikey = inputArray[1];
        String attrival = inputArray[2];
        List<String> ans = new ArrayList<>();
        for(Map.Entry<String,Attribute> i : dataKeyVal.entrySet()){
            //System.out.print(i.getKey() + " ");
            Attribute temp = i.getValue();
            for(Map.Entry<String,Object> j : temp.getAttributeKeyVal().entrySet()) {
                //System.out.print(j.getKey() + ": " + j.getValue() + ",");
                if (j.getKey().equals(attrikey) && j.getValue().equals(attrival)) {
                    ans.add(i.getKey());
                    break;
                }
            }
        }
        for(String s : ans) System.out.print(s + ", ");
        System.out.println();
        return;
    }

    public void print(){
        for(Map.Entry<String,Attribute> i : dataKeyVal.entrySet()){
            System.out.print(i.getKey() + " ");
            Attribute temp = i.getValue();
            for(Map.Entry<String,Object> j : temp.getAttributeKeyVal().entrySet()){
                System.out.print(j.getKey() + ": " + j.getValue() + ",");
            }
            System.out.println();
        }
        return;
    }
}
