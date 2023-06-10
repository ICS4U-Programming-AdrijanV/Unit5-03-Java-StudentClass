// Importing
import java.io.PrintWriter;

public class Student {
  // Initialize Fields/Properties
  private String _firstName;
  private String _midInit;
  private String _lastName;
  private int _grade;
  private boolean _iep;

  // Constructor with middle initial
  public Student(String firstName, String midInit, String lastName, int grade, boolean iep) {
    // Initializing variables
    _firstName = firstName;
    _midInit = midInit;
    _lastName = lastName;
    _grade = grade;
    _iep = iep;
  }

  // Constructor without middle initial
  public Student(String firstName, String lastName, int grade, boolean iep) {
    // Initializing variables
    _firstName = firstName;
    // Empty string for no middle initial
    _midInit = "";
    _lastName = lastName;
    _grade = grade;
    _iep = iep;
  }

  // Method that prints all the student info
  public void print(PrintWriter writer) {
    writer.print(_firstName + " " + _midInit + " " + _lastName + " is in grade " + _grade);
    // If the input was y.
    if (_iep) {
      writer.println(" and has an IEP.");
      // If the input was n.
    } else {
      writer.println(" and does not have an IEP.");
    }
  }
}
