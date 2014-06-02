import java.util.*;
import java.util.stream.Collectors;

public class PureImpure {
  
  //tag::impure[]
  public int bump(int[] value) {
    value[0] = value[0] + 1;
    return value[0];
  }
  //end::impure[]
  
  //tag::pure[]
  public int increment(int value) {
    return value + 1;
  }
  //end::pure[]

  //tag::mutation[]
  public void printSelection(List<String> names) {
    names = names.stream()
                 .filter(name -> name.startsWith("A"))
                 .collect(Collectors.toList());
    
    System.out.printf("From %d names, we've selected %s\n", 
      names.size(), String.join(", ", names));
  }
  //end::mutation[]

  //tag::immutability[]
  public void printSelected(final List<String> names) {
    List<String> selectedNames = 
            names.stream()
                 .filter(name -> name.startsWith("A"))
                 .collect(Collectors.toList());
    
    System.out.printf("From %d names, we've selected %s\n", 
      names.size(), String.join(", ", selectedNames));
  }
  //end::immutability[]

  //tag::sublist1[]
  public List<String> selectFirst3AndChangeCase1(final List<String> names) {
    List<String> selectedNames = names.subList(0, 3);
    for(int i = 0; i < selectedNames.size(); i++) {
      selectedNames.set(i, selectedNames.get(i).toUpperCase());
    }
    
    return selectedNames;
  }
  //end::sublist1[]

  //tag::sublist2[]
  public List<String> selectFirst3AndChangeCase2(final List<String> names) {
    return names.stream()
                .limit(3)
                .map(name -> name.toUpperCase())
                .collect(Collectors.toList());
  }
  //end::sublist2[]
  
  public int f1(int a) { return 0; }
  public int f2(int a) { return 0; }

  public static void main(String[] args) {
    PureImpure inst = new PureImpure();
    int[] arr = new int[] {1};
    System.out.println(inst.bump(arr));
    
    System.out.println(inst.increment(arr[0]));
    
    {
      List<String> names = Arrays.asList("Abe", "Bill", "Andy", "Babu");
      inst.printSelection(names);
      inst.printSelected(names);      
    }
    
    System.out.println("//" + "tag" + "::sublist1[]");
    {
      //tag::usesublist1[]
      List<String> names = Arrays.asList("Abe", "Bill", "Andy", "Babu");
      List<String> selected1 = inst.selectFirst3AndChangeCase1(names);
      System.out.println(selected1);
      System.out.println(names);      
      //end::usesublist1[]
    }
    System.out.println("//" + "end" + "::sublist1[]");

    System.out.println("//" + "tag" + "::sublist2[]");
    {
      //tag::usesublist2[]
      List<String> names = Arrays.asList("Abe", "Bill", "Andy", "Babu");
      List<String> selected1 = inst.selectFirst3AndChangeCase2(names);
      System.out.println(selected1);
      System.out.println(names);      
      //end::usesublist2[]
    }
    System.out.println("//" + "end" + "::sublist2[]");
    
    //tag::calls[]
    int result1 = inst.f1(5);
    int result2 = inst.f2(6);
    //...
    //end::calls[]
    
  }
}