package com.campusnav.model;

import java.util.*;

public class TreeNode implements Comparable<TreeNode>
        //Tree Node class actually implements the Comparable interface for natural sorting of the objects or nodes this contributes to the Priority Queue
{
    private String name; //The name of the building
    private double x, y; //x,y coordinates
    private boolean hasElevator; //Just checking if it has for generic purpose.
    private boolean isAccessible; //A mandatory check for disabled people
    public Map<TreeNode, Double> children; //A hash map with weights is being created with building as Nodes
    //TreeNode is the place or building and the double defines the distance between the places

    public TreeNode(String name, double x, double y, boolean hasElevator, boolean isAccessible)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.hasElevator = hasElevator;
        this.isAccessible = isAccessible;
        this.children = new HashMap<>();//empty hash map for now since it yet to be
    }
    //This is basically the constructor.

    public void addChild(TreeNode child, double distance)
    {
        children.put(child, distance);
    }
    //Just adding another place. library.addChild(mba,4) means a child mba is created which is 4 distance away from library

    public String getName()
    {
        return name;
    }
    //getter method to get the name of the child being added

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override //Built in java function compareTo()
    public int compareTo(TreeNode other) //Just to sort out the objects in the TreeNode very important novelty since this implements the Priority Queue
    {
        //If x1<x2 returns negative, x1>x2 returns positive and x1=x2 returns 0.
        if (this.x != other.x) return Double.compare(this.x, other.x);
        return Double.compare(this.y, other.y);
    }

    @Override
    public boolean equals(Object obj) //Just to check the object if they are same or not
    {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        TreeNode treeNode = (TreeNode) obj;
        return Objects.equals(name, treeNode.name) && Double.compare(x, treeNode.x) == 0 && Double.compare(y, treeNode.y) == 0;
    }

    @Override //Another in built function
    public int hashCode()
    {
        return Objects.hash(name, x, y); //Using this we'll get a hash code for every objects.
    }


    //Why is this useful?
    //If not used then Java will allocate a code for everything based on the memory address and same nodes will get different codes for reference.
}

//In every case whenever we add some new child we actually work with the adjacency list.
//We are also working on how to imply data abstraction by defining the variables private and allowing only access
//to them by the getters.
