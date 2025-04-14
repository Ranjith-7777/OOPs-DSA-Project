package com.campusnav.model;

import java.util.ArrayList;
import java.util.List;

public class CampusTree {

    private List<TreeNode> buildings;

    public CampusTree() {
        buildings = new ArrayList<>();

        //  Updated coordinates from pixel positions on the map image
        TreeNode ab1     = new TreeNode("AB1", 260, 312, true, true);
        TreeNode ab2     = new TreeNode("AB2", 742, 286, true, true);
        TreeNode library = new TreeNode("Library", 1356, 264, true, true);
        TreeNode mba     = new TreeNode("MBA", 1582, 433, false, true);
        TreeNode ab4     = new TreeNode("AB4", 1582, 911, true, true);
        TreeNode hostel  = new TreeNode("Boys Hostel", 1045, 1089, false, true);
        TreeNode mc      = new TreeNode("MC", 167, 975, true, true);
        TreeNode ground  = new TreeNode("Ground", 983, 616, true, true);

        // Add buildings to the list
        buildings.add(ab1);
        buildings.add(ab2);
        buildings.add(library);
        buildings.add(mba);
        buildings.add(ab4);
        buildings.add(hostel);
        buildings.add(mc);
        buildings.add(ground);

        // Define bidirectional edges (with weights)
        ab1.addChild(ab2, 4);         ab2.addChild(ab1, 4);
        ab2.addChild(library, 5);     library.addChild(ab2, 5);
        library.addChild(mba, 5);     mba.addChild(library, 5);
        mba.addChild(ab4, 12);        ab4.addChild(mba, 12);
        ab4.addChild(hostel, 5);      hostel.addChild(ab4, 5);
        hostel.addChild(mc, 10);      mc.addChild(hostel, 10);
        mc.addChild(ab1, 5);          ab1.addChild(mc, 5);

        ab1.addChild(ground, 7);      ground.addChild(ab1, 7);
        ab2.addChild(ground, 5);      ground.addChild(ab2, 5);
        library.addChild(ground, 4);  ground.addChild(library, 4);
        mba.addChild(ground, 7);      ground.addChild(mba, 7);
        ab4.addChild(ground, 7);      ground.addChild(ab4, 7);
        hostel.addChild(ground, 2);   ground.addChild(hostel, 2);
        mc.addChild(ground, 7);       ground.addChild(mc, 7);
    }

    public List<TreeNode> getAllBuildings() {
        return buildings;
    }
}
