package com.campusnav.view;

import com.campusnav.controller.*;
import com.campusnav.model.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import com.formdev.flatlaf.FlatLightLaf;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class CampusGUI extends JFrame {

    private JComboBox<String> startDropdown;
    private JComboBox<String> endDropdown;
    private JTextArea resultArea;
    private CampusTree campusTree;
    private MapPanel mapPanel;

    public CampusGUI(CampusTree campusTree) {
        this.campusTree = campusTree;

        try {
            FlatLightLaf.setup();
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            System.err.println("FlatLaf initialization failed.");
        }

        setTitle("Amrita Campus Navigation System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 850);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 15, 10, 15));

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        startDropdown = new JComboBox<>();
        endDropdown = new JComboBox<>();
        for (TreeNode node : campusTree.getAllBuildings()) {
            startDropdown.addItem(node.getName());
            endDropdown.addItem(node.getName());
        }

        inputPanel.add(new JLabel("Start Location:"));
        inputPanel.add(startDropdown);
        inputPanel.add(new JLabel("End Location:"));
        inputPanel.add(endDropdown);

        JButton findButton = new JButton("Find Path");

        resultArea = new JTextArea(18, 60);
        resultArea.setEditable(false);
        resultArea.setLineWrap(true);
        resultArea.setWrapStyleWord(true);
        resultArea.setBorder(BorderFactory.createTitledBorder("Results"));
        JScrollPane resultScroll = new JScrollPane(resultArea);

        // Pass all buildings to MapPanel
        mapPanel = new MapPanel(campusTree.getAllBuildings());
        mapPanel.setPreferredSize(new Dimension(1200, 500));
        JScrollPane mapScroll = new JScrollPane(mapPanel);
        mapScroll.setBorder(BorderFactory.createTitledBorder("Campus Map"));

        // Enable zooming
        mapScroll.getViewport().setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
        mapScroll.setWheelScrollingEnabled(true);
        mapScroll.addMouseWheelListener(mapPanel::handleZoom);

        // Enable panning
        mapPanel.addMouseListener(mapPanel.getPanMouseListener());
        mapPanel.addMouseMotionListener(mapPanel.getPanMouseMotionListener());

        findButton.addActionListener(this::handleFindPath);

        JPanel topPanel = new JPanel(new BorderLayout(10, 10));
        topPanel.add(inputPanel, BorderLayout.CENTER);
        topPanel.add(findButton, BorderLayout.EAST);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(resultScroll, BorderLayout.CENTER);
        mainPanel.add(mapScroll, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private void handleFindPath(ActionEvent e) {
        String startName = (String) startDropdown.getSelectedItem();
        String endName = (String) endDropdown.getSelectedItem();

        if (startName.equals(endName)) {
            resultArea.setText("Start and end locations are the same!");
            mapPanel.setPath(null, 0.0);
            return;
        }

        TreeNode startNode = null, endNode = null;
        for (TreeNode node : campusTree.getAllBuildings()) {
            if (node.getName().equals(startName)) startNode = node;
            if (node.getName().equals(endName)) endNode = node;
        }

        if (startNode == null || endNode == null) {
            resultArea.setText("Invalid locations selected.");
            mapPanel.setPath(null, 0.0);
            return;
        }

        RouteFinder finder = new RouteFinder();
        List<TreeNode> shortestPath = finder.findPath(startNode, endNode);
        double shortestDistance = calculateTotalDistance(shortestPath);
        List<List<TreeNode>> allPaths = finder.findAllPaths(startNode, endNode);

        StringBuilder output = new StringBuilder();
        output.append("Shortest Path (Dijkstra):\n");
        for (TreeNode node : shortestPath) {
            output.append(" → ").append(node.getName());
        }
        output.append("\nTotal Distance: ").append(shortestDistance).append(" units\n\n");

        output.append("All Possible Paths (DFS):\n");
        int count = 1;
        for (List<TreeNode> path : allPaths) {
            double dist = calculateTotalDistance(path);
            output.append(count++).append(". ");
            for (TreeNode n : path) {
                output.append(" → ").append(n.getName());
            }
            output.append("\n   Distance: ").append(dist).append(" units\n");
        }

        resultArea.setText(output.toString());
        mapPanel.setPath(shortestPath, shortestDistance);
    }

    private double calculateTotalDistance(List<TreeNode> path) {
        double total = 0.0;
        for (int i = 0; i < path.size() - 1; i++) {
            TreeNode from = path.get(i);
            TreeNode to = path.get(i + 1);
            Double dist = from.children.get(to);
            if (dist != null) total += dist;
        }
        return total;
    }
}
