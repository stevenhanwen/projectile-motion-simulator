package capstone.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create a Scanner to read from console
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the height of the launch: ");
        int height = scanner.nextInt();

        System.out.print("Enter the angle of the launch: ");
        int angle = scanner.nextInt();

        System.out.print("Enter the speed of the launch: ");
        int velocity = scanner.nextInt();

        scanner.close();

        PhysicalObject testObject = new PhysicalObject(height, angle, velocity);
        testObject.show();
    }

}
