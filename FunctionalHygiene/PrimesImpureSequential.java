public class PrimesImpureSequential {
  public static void main(String[] args) {
    //tag::impure[]
    System.out.printf("Found %d primes.\n", Primes.countPrimesImpure(1000000));
    //end::impure[]
  }
}