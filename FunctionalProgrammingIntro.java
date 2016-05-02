import java.util.function.Function;

public class FunctionalProgrammingIntro {
/*
Function that checks whether a given student is John Smith with ID js123.
*/
  public static Function<Student, Boolean> f = p -> p.getFullName().equals("John Smith") && p.studentNumber == "js123";
}