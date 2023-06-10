// Importing
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The main file.
 *
 * @author Adrijan Vranjkovic
 * @version 1.0
 * @since 2023-06-09
 */
public class Main {
  /**
   * For style checker.
   *
   * @exception IllegalStateException Utility class.
   * @see IllegalStateException
   */
  private Main() {
    throw new IllegalStateException("Utility class");
  }

  /**
   * Print messages.
   *
   * @param args Unused
   */
  public static void main(String[] args) {
    // Create a list to store student objects.
    List<Student> listOfStudents = new ArrayList<>();

    try {
      // Create the input file.
      File inputFile = new File("input.txt");
      // Create a Scanner to read the input file.
      Scanner scanner = new Scanner(inputFile);

      // Read each line from the input file.
      while (scanner.hasNextLine()) {

        String line = scanner.nextLine();

        // Skip blank lines.
        if (line.trim().isEmpty()) {

          // Display if a blank line is found.
          System.out.println("Blank line found. Skipping.");
          continue;
        }

        // Split the line into an array of strings on spaces.
        String[] data = line.split(" ");

        // Check if the input format is valid.
        if (data.length < 4 || data.length > 5) {
          // Display if input is invalid
          System.out.println("Invalid input format: " + line);
          continue;
        }

        // Initializing firstName, middleInitial, lastName
        // grade and iep.
        String firstName = data[0];
        String middleInitial = "";
        String lastName;
        int grade;
        boolean iep;

        try {
          // If there are 4 elements in the array parse the input.
          if (data.length == 4) {
            lastName = data[1];
            grade = Integer.parseInt(data[2]);
            iep = parseIEP(data[3]);
            // If there are 5 elements in the array parse the input.
          } else {
            middleInitial = data[1];
            lastName = data[2];
            grade = Integer.parseInt(data[3]);
            iep = parseIEP(data[4]);
          }

          // Create a student object with the parsed data.
          Student aStudent = new Student(firstName, middleInitial, lastName, grade, iep);

          // Add the student object to the list of students
          listOfStudents.add(aStudent);
        } catch (NumberFormatException e) {
          System.out.println("Invalid input format for grade: " + line);
        } catch (IllegalArgumentException e) {
          System.out.println(e.getMessage());
        }
      }

      // Close the scanner after reading the input file.
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Input file not found.");
    }

    try {
      // Create a File object to represent the output file.
      File outputFile = new File("output.txt");
      // Create a PrintWriter object to write to the output file.
      PrintWriter writer = new PrintWriter(outputFile);

      // Print the number of students to the output file.
      writer.println("There are " + listOfStudents.size() + " students in the student list.");
      writer.println("The students are:");

      // Go over the list of students and print each student info to the output file.
      for (Student student : listOfStudents) {
        student.print(writer);
        writer.println();
      }

      // Close the writer after writing to the output file.
      writer.close();
    } catch (FileNotFoundException e) {
      System.out.println("Output file cannot be created.");
    }
  }

  private static boolean parseIEP(String input) {
    // Check if the input is "y".
    if (input.equalsIgnoreCase("y")) return true;
    // Check if the input is "n".
    else if (input.equalsIgnoreCase("n")) return false;
    else
      // Throw an exception for invalid input format.
      throw new IllegalArgumentException("Invalid input format for IEP: " + input);
  }
}
