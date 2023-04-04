import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class SerializationTest {


    // This method creates a student object and returns it.
    public static Student createStudentObject(String name, String dob, String city, String state, String pincode, String country){
        Address address = new Address(city, state, pincode, country);
        Student student = new Student(name, dob, address);
        return student;
    }


    public static void main(String[] args){
        Student student1 = createStudentObject("suyash", "11/09/1988", "Delhi", "Delhi", "110001", "India");
        Student student2 = createStudentObject("abhi", "14/1/1980", "Indore", "Madhya Pradesh", "110001", "India");
        Student student3 = createStudentObject("Amit", "21/03/2001", "Mumbai", "Maharashtra", "110001", "India");
        Student student4 = createStudentObject("Rishabh", "17/03/2002", "Pilani", "Goa", "110001", "India");
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        try{
            // FileOutputStream provide the file output stream to write the object to the file.
            FileOutputStream fileOut = new FileOutputStream("Serialization/src/output1.ser");

            // ObjectOutputStream is used to write the object to the file.
            ObjectOutputStream out = new ObjectOutputStream(fileOut);

            // Write the object to the file.
            out.writeObject(students);
            out.close();
            fileOut.close();
            System.out.println();
            System.out.println("Serialized data is saved in .ser file in the folder.");
            System.out.println();

        }catch(IOException exc){
            System.out.println("Not able to write in the file.");
        }

    }
    
}