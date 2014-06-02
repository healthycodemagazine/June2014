import java.util.*;
import java.util.stream.Stream;

public class Primes {
  public static boolean isPrime(int number) {
    if(number < 2) return false;
    for(int i = 2; i < number; i++) {
      if (number % i == 0) return false;
    }
    
    return true;
  }
  
  //tag::impure[]
  public static long countPrimesImpure(int number) {
    long count = 0;
    for(int i = 2; i <= number; i++) {
      if(isPrime(i)) count++;
    }
    return count;
  }
  //end::impure[]

  //tag::pure[]
  public static long countPrimesPure(Stream<Integer> values) {
    return values.filter(value -> isPrime(value))
                 .count();
  }
  //end::pure[]
}