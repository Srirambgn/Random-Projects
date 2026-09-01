public class homework6 {
    public static void main(String[] args){
        String robotState = "ACTIONS";
        switch (robotState) {
            case "IDLE":
                System.out.println("Robot is idle");
                break;
            case "DRIVING":
                System.out.println("Robot is moving");
                break;
            case "COLLECTING":
                System.out.println("Robot is collecting objects");
                break;
            case "SCORING":
                System.out.println("Robot is scoring points");
                break;
            default:
                System.out.println("Robot is in default mode, the current task it is performing is unknown");
        }
    }
}