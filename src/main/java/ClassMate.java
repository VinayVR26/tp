/**
 * Serves as the main entry point for the ClassMate application.
 * <p>
 * ClassMate is an academic planning and tracking module designed to help
 * Computer Engineering (CEG) students manage their graduation requirements
 * and plan their upcoming semesters.
 * </p>
 *
 * @author AY2526S2-CS2113-W11-4
 * @version v1.0
 */
public class ClassMate {

    private static String listOfMajorRequirements = "MA1511 Engineering Calculus\n" +
            "MA1512 Differential Equations for Engineering\n" +
            "MA1508E Linear Algebra for Engineering\n" +
            "EG2401A Engineering Professionalism\n" +
            "CG1111A Engineering Principles and Practice I\n" +
            "CG2111A Engineering Principles and Practice II\n" +
            "CS1231 Discrete Structures\n" +
            "CG2023 Signals & Systems\n" +
            "CG2027 Transistor-level Digital Circuit\n" +
            "CG2028 Computer Organization\n" +
            "CG2271 Real-time Operating System\n" +
            "CG3201 Machine Learning and Deep Learning\n" +
            "CG3207 Computer Architecture\n" +
            "CS2040C Data Structures and Algorithms\n" +
            "CS2107 Introduction to Information Security\n" +
            "CS2113 Software Engineering & Object-Oriented Programming\n" +
            "EE2026 Digital Design\n" +
            "EE4204 Computer Networks";

    public static void main (String[] args) {
        System.out.println("Here is a list of modules required to fulfill the CEG Major: ");
        System.out.println(listOfMajorRequirements);
        System.out.println("\nNote: This list excludes Internship and FYP. ");
    }
}
