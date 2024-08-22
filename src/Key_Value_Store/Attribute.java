package Key_Value_Store;

import java.util.HashMap;
import java.util.Map;

public class Attribute {
  private Map<String , Object> attributeKeyVal;

  public Attribute(){
      this.attributeKeyVal = new HashMap<>();
  }

    public Map<String, Object> getAttributeKeyVal() {
        return attributeKeyVal;
    }

    public void putAttribute(String attributeKey , Object attributeValue){
      if(this.attributeKeyVal.containsKey(attributeKey)){
          if(!this.attributeKeyVal.get(attributeKey).getClass().equals(attributeValue.getClass())){
              System.out.println("Attributes Data types not matching");
              return;
          }
      }
      this.attributeKeyVal.put(attributeKey,attributeValue);
  }

}
