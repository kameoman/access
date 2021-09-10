import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;

public class Sort {
  public static void main(String[] args){
  
    ArrayList<String> foo = new ArrayList<>();
        
    foo.add("12:/search/?c=Games+Computers");
    foo.add("5:/search/?c=Games+Computers");
    foo.add("1:/search/?c=Games+Computers");
    foo.add("13:/search/?c=Games+Computers");
    foo.add("130:/search/?c=Games+Computers");
     
    Collections.sort(foo, Comparator.comparingLong(str -> -1 * Long.parseLong(str.split(":")[0])));
    
    System.out.println(foo);
  }
}
