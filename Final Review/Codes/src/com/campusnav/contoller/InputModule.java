package com.campusnav.controller;

import java.util.Scanner;

public class InputModule
{
    Scanner scanner = new Scanner(System.in);

    public String getStartLocation()
    {
        System.out.println("Enter Start Location: "); //Later this can be modified when the GPS module comes into the picture
        return scanner.nextLine();
    }

    public String getEndLocation()
    {
        System.out.println("Enter End Location: ");
        return scanner.nextLine();
    }
}
