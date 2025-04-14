package com.campusnav;

import com.campusnav.model.CampusTree;
import com.campusnav.view.CampusGUI;

public class CampusApp {
    public static void main(String[] args) {
        // Just launch model and GUI
        CampusTree campusTree = new CampusTree();
        new CampusGUI(campusTree);
    }
}
