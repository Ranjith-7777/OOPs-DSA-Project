package com.campusnav.view;

import com.campusnav.model.TreeNode;
import java.util.List;

public class MapAreaModule
{
    public void drawMap(List<TreeNode> path)
    {
        System.out.println("\n Shortest Path:"); //Just giving the output to the user using the Dijkstra's algorithm
        for (TreeNode node : path)
        {
            System.out.print(" -> " + node.getName());
        }
        System.out.println(); //Just moving to the next line
    }
}
