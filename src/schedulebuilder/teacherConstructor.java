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
public class teacherConstructor{
    
    String teachName;
    int teachDegree;
    int teachClassroom;
    int[] teachClasses = new int[8];
    
        teacherConstructor(String name, int classroom, int degree, int[] classes) {
            
            teachName = name;
            teachClassroom = classroom;
            teachDegree = degree;
            teachClasses = classes;
            
        }
    
}