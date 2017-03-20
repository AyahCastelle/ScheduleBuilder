/*
 * 
 * 
 * 
 */
package schedulebuilder;

/**
 *
 * @author aabel0785
 */
public class studentConstructor{
    
    String studentName;
    int studentGrade;
    int[] studentClasses = new int[8];
    int[] studentChoices = new int[8];
    int[] studentBackupChoice = new int[3];

    studentConstructor(String name, int grade, int[] classes, int[] choices, int[] backupChoice) {
        
        studentName = name;
        studentGrade = grade;
        studentClasses = classes;
        studentChoices = choices;
        studentBackupChoice = backupChoice;
        
    }    

}