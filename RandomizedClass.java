import java.util.*;

public class RandomizedClass{

  private HashMap<Integer, Integer> map;
  private ArrayList<Integer> list;
  private Random rand;

  public RandomizedClass(){
    map = new HashMap<>();
    list = new ArrayList<>()
  }

  public boolean insert(int val) {

    if(map.containsKey(val)) return false; 
    map.put(val, list.size());
    return true;
  }

  public boolean remove(int val) {

    Integer index = map.get(val); // map is stored like {value1 => key(index), value2 => key(index)}
    if(index === null)  return false; 
 
    Collections.swap(list, index, list.size - 1);
    int swapVal = list.get(index);
    map.put(swapVal, index);
    list.remove(list.size() - 1);
    map.remove(val);
    return true;
    
  }
 
}
