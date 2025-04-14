package com.campusnav.controller;

import com.campusnav.model.TreeNode;
import java.util.List;

public class SearchPanel
{
    public TreeNode performSearch(String query, List<TreeNode> buildings)
    {
        for (TreeNode building : buildings)
        {
            if (building.getName().equalsIgnoreCase(query))
            {
                return building;
            }
        }
        return null;
    }
}
