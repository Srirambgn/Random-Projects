public class TEST {
    public static void main(String[] args) {
    double[] motorSpeeds = new double[4];
    // Setting values
    motorSpeeds[0] = 12.0;
    motorSpeeds[1] = 15.0;
    motorSpeeds[2] = 20.0;
    motorSpeeds[3] = 25.0;
    // code for printing all the values
    System.out.println("Motor Speeds:");
    for (int i = 0; i <= 3; i++){
       System.out.println("Motor" + i + ":" + motorSpeeds[i]); 
    }
    // code for finding the average of the motor speeds
    double sumOfMotorSpeeds = motorSpeeds[0] + motorSpeeds[1] + motorSpeeds[2] + motorSpeeds[3];
    double average = sumOfMotorSpeeds/4;
    System.out.println("The average motor speed is:" + average);
    }
}
