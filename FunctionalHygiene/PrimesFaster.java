import java.util.stream.Stream;

public class PrimesFaster {
  public static void main(String[] args) {
    //tag::pure[]
    System.out.printf("Found %d primes.\n", 
      Primes.countPrimesPure(
        Stream.iterate(1, e -> e + 1).limit(1000000).parallel()));
    //end::pure[]
  }
}