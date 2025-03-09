import java.util.Scanner;

class InputModule
{
    Scanner scanner = new Scanner(System.in);

    public String getStartLocation()
    {
        System.out.print("Enter Start Location: "); //Later this can be modified when the GPS module comes into the picture
        return scanner.nextLine();
    }

    public String getEndLocation()
    {
        System.out.print("Enter End Location: ");
        return scanner.nextLine();
    }
}
