// imports used external files
package schedulebuilder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author AyahCastelle
 */
public class Index {
    
    // Creates a public Scanner for user response
    public static Scanner sc = new Scanner(System.in);
    // Creates a List to hold student info i.e studentList from studentConstructor
    public static ArrayList<studentConstructor> studentList = new ArrayList<studentConstructor>();
    public static ArrayList<teacherConstructor> teacherList = new ArrayList<teacherConstructor>();
    
    public static void main(String[] args) {      
    
        
        
//    studentList.add(new studentConstructor
//         ("Bob", 9, people.bobSchedule, people.bobChoice, people.bobBackup));
//    
//    studentList.add(new studentConstructor 
//         ("Athena", 9, people.athenaSchedule, people.athenaChoice, people.athenaBackup));
//    
//    studentList.add(new studentConstructor
//         ("Zeus", 9, people.zeusSchedule, people.zeusChoice, people.zeusBackup));

        initStudents();
        initTeachers();

        // Main menu and various choices
        System.out.println(" 1) Organize Students"
                + "\n 2) Search"
                + "\n 3) Build Student Array"
                + "\n 4) Quit");
        
        String indexIn = sc.next();
        int intIndex = Integer.parseInt(indexIn);
        // Evaluates indexIn and redricts to method
        switch (intIndex) {
            case 1:
                organizeStudents();
                break;
            case 2:
                search();
                break;
            case 3:
                buildStudents();
                break;
            case 4:
                quit();
                break;
            default:
                main(args);
        }
        
    }
    
    // Takes student list and organizes students
    // into classes based on choices[] and backupChoice[]
    public static void organizeStudents() {
        
        //TODO Write function
        throw new UnsupportedOperationException("Not supported yet.");
                
    }
    
    // Searches for Students, Teachers, or Classes and displays the information
    public static void search() {
        
        boolean found = false;
        System.out.println("\n1) Student"
                + "\n2) Teacher"
                + "\n3) Classes");
        // Menu input and redirection
        String searchIn = sc.next();
        int intSearch = Integer.parseInt(searchIn);
            
            // Searches for student info in studentInfo.txt and displays it 
            // using a Scanner
            if(intSearch == 1) {

                System.out.println("\nEnter name:");
                String nameIn = sc.next();
                            
                for (studentConstructor student: studentList) {
          
                    if (nameIn.equalsIgnoreCase(student.studentName)) {
                        
                        display(student);
                        found = true;
                        
                    }
                    
                }
                if (found == false) {
                    System.out.println("ERROR: Student not found");
                }
        
            } else if(intSearch == 2) {

                System.out.println("\nEnter name:");
                String nameIn = sc.next();
                            
                for (teacherConstructor teach: teacherList) {
          
                    if (nameIn.equalsIgnoreCase(teach.teachName)) {
                        
                        teachDisplay(teach);
                        found = true;
                        
                    }
                    
                }
                if (found == false) {
                    System.out.println("ERROR: Teacher not found");
                }
        
            }
            
    }
    
    // Adds students and info to the text file for refrence
    public static void buildStudents() {
        
        System.out.println("\nEnter Student Name:");
        String nameIn = sc.next();
        
        try{
        BufferedWriter bWrite = new BufferedWriter(new FileWriter("studentInfo.txt", true));
        bWrite.write(nameIn);
        bWrite.newLine();
        bWrite.close();
            } catch (IOException e) {
               if (e instanceof IOException) {
                   System.err.println("IO ERROR");
               } else {
                   System.err.println("End of stream");
               }
            }
        
        //throw new UnsupportedOperationException("Not supported yet.");
        
    }
    
    @SuppressWarnings("UnusedAssignment")
    public static void initStudents() {
        
        try {
            
            File studentInfo = new File("studentInfo.txt");
            Scanner scan = new Scanner(studentInfo);
            boolean breakOne = false;
            String curLine;
            String initName = null;
            int grade = 0;                    
            int[] initSchedule = new int[8];
            int[] initChoice = new int[8];
            int[] initBackup = new int[3];
            int count = 0;
            
            while (scan.hasNextLine()) {
                
                curLine = scan.nextLine();
                count = 0;
                
                while (breakOne == false) {

                    count += 1;
                    curLine = scan.nextLine();
                    //System.out.println(curLine);
                    
                    if (count == 1) {
                        
                        initName = curLine;
                        
                    } else if (count == 2) {
                     
                        grade = Integer.parseInt(curLine);
                        
                    } else if (count == 3) { 
                    
                        initSchedule = parseArray(curLine);
                        
                    } else if (count == 4) {
                    
                        initChoice = parseArray(curLine);
                    
                    } else if (count == 5) {
                        
                        initBackup = parseArray(curLine);
                        
                    } else if (curLine.equalsIgnoreCase("BREAK")) {
                        
                        breakOne = true;
                        
                    }
                    

                }
                
                breakOne = false;
                studentList.add(new studentConstructor
                (initName, grade, initSchedule, initChoice, initBackup));
                
            }

            
                        
        } catch (FileNotFoundException z) {
            
            System.err.println("ERROR FILE NOT FOUND. LINE: 221");
            
        }
        
    }
    
    public static void initTeachers() {
        
        try {
            
            File teacherInfo = new File("teacherInfo.txt");
            Scanner scan = new Scanner(teacherInfo);
            boolean breakOne = false;
            String curLine;
            String initName = null;
            int degree = 0;
            int classroom = 0;
            int[] initClass = new int[8];
            int count = 0;
            
            while (scan.hasNextLine()) {
                
                curLine = scan.nextLine();
                count = 0;
                
                while (breakOne == false) {

                    count += 1;
                    curLine = scan.nextLine();
                    //System.out.println(curLine);
                    
                    if (count == 1) {
                        
                        initName = curLine;
                        
                    } else if (count == 2) {
                     
                        classroom = Integer.parseInt(curLine);
                        
                    } else if (count == 3) { 
                    
                        degree = Integer.parseInt(curLine);
                        
                    } else if (count == 4) {
                    
                        initClass = parseArray(curLine);
                    
                    } else if (curLine.equalsIgnoreCase("BREAK")) {
                        
                        breakOne = true;
                        
                    }
                    

                }
                
                breakOne = false;
                teacherList.add(new teacherConstructor
                (initName, classroom, degree, initClass));
                
            }

            
                        
        } catch (FileNotFoundException z) {
            
            System.err.println("ERROR FILE NOT FOUND. LINE: 287");
            
        }
        
    }
    
    public static void display(studentConstructor student) {
          
            System.out.println("\nName: " + student.studentName);
            System.out.println("Grade: " + student.studentGrade);
            System.out.println("Classes: " + Arrays.toString(student.studentClasses));
            System.out.println("Choices: " + Arrays.toString(student.studentChoices));
            System.out.println("Backups: " + Arrays.toString(student.studentBackupChoice));
            
    }
    
    public static void teachDisplay(teacherConstructor teach) {
          
            System.out.println("\nName: " + teach.teachName);
            System.out.println("Degree: " + teach.teachDegree);
            System.out.println("Classroom: " + teach.teachClassroom);
            System.out.println("Classes: " + Arrays.toString(teach.teachClasses));
                       
    }
    
    // Parses given string and converts to integer array
    public static int[] parseArray(String parseMe) {
        
        String[] arr = parseMe.replaceAll("\\[", "").replaceAll("\\]", "")
                .replaceAll("\\s", "").split(",");
        
        int[] returnMe = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
        try {
            
            returnMe[i] = Integer.parseInt(arr[i]);
        
        } catch (NumberFormatException e) {System.err.println("ERROR");}
        
        }
        
        return returnMe;
    }
    
    // Kills the program
    public static void quit() {
        
        System.out.println("\nThank you for using \n***Failed State Software***");
            System.exit(0);
        
    }

           
}