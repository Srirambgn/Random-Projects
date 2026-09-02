public class homework6 {
    public static void main(String[] args){
        // This program simulates a robot's state and prints out the corresponding message based on the current state of the robot.
        String robotState = "ACTIONS";
        switch (robotState) {
            // Check the state of the robot and print the corresponding message
            case "IDLE":
                // If the robot is idle, print a message indicating that it is not performing any actions
                System.out.println("Robot is idle");
                break;
            case "DRIVING":
                System.out.println("Robot is moving");
                // If the robot is driving, print a message indicating that it is moving
                break;
            case "COLLECTING":
                // If the robot is collecting objects, print a message indicating that it is collecting objects
                System.out.println("Robot is collecting objects");
                break;
            case "SCORING":
                // If the robot is scoring points, print a message indicating that it is scoring points
                System.out.println("Robot is scoring points");
                break;
            default:
                // If the robot is in an unknown state, print a message indicating that the current task is unknown
                System.out.println("Robot is in default mode, the current task it is performing is unknown");
        }
    }
}
// buns