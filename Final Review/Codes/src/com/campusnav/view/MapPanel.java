package com.campusnav.view;

import com.campusnav.model.TreeNode;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.util.List;

public class MapPanel extends JPanel {

    private Image backgroundImage;
    private List<TreeNode> path;
    private List<TreeNode> allNodes;
    private double totalDistance = 0;

    private double zoomFactor = 1.0;
    private Point panOffset = new Point(0, 0);
    private Point dragStart = null;

    public MapPanel(List<TreeNode> allNodes) {
        this.allNodes = allNodes;

        try {
            InputStream imgStream = getClass().getClassLoader().getResourceAsStream("map_with_coordinates.png");
            if (imgStream != null) {
                backgroundImage = ImageIO.read(imgStream);
            } else {
                System.out.println("Map image not found in resources.");
            }
        } catch (Exception e) {
            System.out.println("Could not load map image.");
            e.printStackTrace();
        }
    }

    public void setPath(List<TreeNode> path, double totalDistance) {
        this.path = path;
        this.totalDistance = totalDistance;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage == null) return;

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        int panelWidth = getWidth();
        int panelHeight = getHeight();
        int imgW = backgroundImage.getWidth(null);
        int imgH = backgroundImage.getHeight(null);

        double scaleX = zoomFactor * (double) panelWidth / imgW;
        double scaleY = zoomFactor * (double) panelHeight / imgH;

        g2.translate(panOffset.x, panOffset.y);
        g2.scale(scaleX, scaleY);

        // Draw background
        g2.drawImage(backgroundImage, 0, 0, imgW, imgH, this);

        // Gray nodes
        if (allNodes != null) {
            g2.setColor(new Color(120, 120, 120));
            for (TreeNode node : allNodes) {
                int x = (int) node.getX();
                int y = (int) node.getY();
                g2.fillOval(x - 3, y - 3, 6, 6);
            }
        }

        // Path
        if (path != null && !path.isEmpty()) {
            g2.setStroke(new BasicStroke(4)); // Thicker line
            g2.setFont(new Font("Segoe UI", Font.BOLD, 14));

            for (int i = 0; i < path.size(); i++) {
                TreeNode node = path.get(i);
                int x = (int) node.getX();
                int y = (int) node.getY();

                // Start/End node styling
                if (i == 0 || i == path.size() - 1) {
                    g2.setColor(Color.BLACK);
                    g2.fillOval(x - 6, y - 6, 12, 12);
                } else {
                    g2.setColor(Color.RED);
                    g2.fillOval(x - 5, y - 5, 10, 10);
                }

                // Label
                g2.setColor(Color.BLACK);
                g2.drawString(node.getName(), x + 8, y - 8);

                // Red line and edge label
                if (i < path.size() - 1) {
                    TreeNode next = path.get(i + 1);
                    int x2 = (int) next.getX();
                    int y2 = (int) next.getY();
                    g2.setColor(Color.RED);
                    g2.drawLine(x, y, x2, y2);

                    double dist = node.children.get(next);
                    int midX = (x + x2) / 2;
                    int midY = (y + y2) / 2;
                    g2.setColor(Color.DARK_GRAY);
                    g2.drawString(String.format("%.1f", dist), midX + 5, midY - 5);
                }
            }

            // Distance display box (unscaled and unpanned)
            g2.scale(1 / scaleX, 1 / scaleY);
            g2.translate(-panOffset.x, -panOffset.y);
            g2.setColor(new Color(255, 255, 255, 180));
            g2.fillRoundRect(getWidth() - 210, getHeight() - 50, 190, 30, 10, 10);
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("SansSerif", Font.BOLD, 14));
            g2.drawString("Total Distance: " + totalDistance + " units", getWidth() - 200, getHeight() - 30);
        }
    }

    // Zoom handler
    public void handleZoom(MouseWheelEvent e) {
        if (e.getPreciseWheelRotation() < 0) zoomFactor *= 1.1;
        else zoomFactor /= 1.1;
        repaint();
    }

    // Pan support
    public MouseAdapter getPanMouseListener() {
        return new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                dragStart = e.getPoint();
            }
        };
    }

    public MouseMotionAdapter getPanMouseMotionListener() {
        return new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                if (dragStart != null) {
                    int dx = e.getX() - dragStart.x;
                    int dy = e.getY() - dragStart.y;
                    panOffset.translate(dx, dy);
                    dragStart = e.getPoint();
                    repaint();
                }
            }
        };
    }
}
