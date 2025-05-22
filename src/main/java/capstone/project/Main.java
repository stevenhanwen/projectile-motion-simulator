package capstone.project;


public class Main 
{
    public static void main( String[] args )
    {
       
        PhysicalObject testObject = new PhysicalObject(10, 90, 20); 
        System.out.println(testObject.getMaxHeight());
        System.out.println(testObject.getHorizontalDistanceTravelled());

        // testObject.show();
    }               



}
