package com.campusnav.controller;

import com.campusnav.model.TreeNode;
import java.util.*;

public class RouteFinder {

    // Dijkstra algorithm for shortest path
    public List<TreeNode> findPath(TreeNode start, TreeNode end) //After this you will get a list of nodes listed which your path
    {
        // Maps to store shortest distances and previous nodes
        Map<TreeNode, Double> distances = new HashMap<>();
        Map<TreeNode, TreeNode> previous = new HashMap<>();

        // Priority queue for Dijkstra's Algorithm
        PriorityQueue<TreeNode> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));
        //This ensures that only the shortest distance path will get stored out of all possible paths

        // Initialize distances for all nodes
        for (TreeNode node : getAllNodes(start))
        {
            distances.put(node, Double.MAX_VALUE); //all nodes have infinity as initial value
            previous.put(node, null); //all the previous nodes are defined null until they are traversed
        }

        // Set distance of start node to 0
        distances.put(start, 0.0); //Only the initial one will have a value 0
        queue.add(start); //First one to be added in the queue

        while (!queue.isEmpty()) //Using this part of code we just create the shortest path
        {
            TreeNode current = queue.poll();  // Get node with the shortest distance
            //poll() is defined in the interface itself.

            // Stop early if we reached the destination
            if (current.equals(end)) break; //if extracted one is the destination then pause

            for (Map.Entry<TreeNode, Double> neighborEntry : current.children.entrySet())
            {
                TreeNode neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();
                double newDist = distances.get(current) + weight; //This will store the shortest distance

                if (newDist < distances.get(neighbor)) //If a shorter path is found then update the distances map
                {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    queue.add(neighbor); //Change the queue
                }
            }
        }

        // Construct the shortest path
        List<TreeNode> path = new ArrayList<>();
        for (TreeNode at = end; at != null; at = previous.get(at)) //This loop runs backwards
        {
            path.add(at);
        }
        Collections.reverse(path); //Reverse the path so that start --> end order

        // If path is empty or start and end are disconnected, return "No Path Found"
        if (path.size() == 1 && !path.get(0).equals(start)) {
            System.out.println("No path found between " + start.getName() + " and " + end.getName());
            return Collections.emptyList();
        }

        return path;
    }

    // Helper function to get all connected nodes from the starting node
    private Set<TreeNode> getAllNodes(TreeNode root) //Why Set and not list?
    {
        Set<TreeNode> nodes = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (!nodes.contains(current)) {
                nodes.add(current);
                queue.addAll(current.children.keySet());
            }
        }

        return nodes; //all the nodes are being returned
    }

    // DFS implemented using Stack
    public void depthFirstSearch(TreeNode start)
    {
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> visited = new HashSet<>();
        stack.push(start);

        System.out.println("\n DFS Traversal:");

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (!visited.contains(current)) {
                System.out.println("Visited: " + current.getName());
                visited.add(current);
                for (TreeNode neighbor : current.children.keySet()) {
                    stack.push(neighbor);
                }
            }
        }
    }

    // BFS implemented using Queue
    public void breadthFirstSearch(TreeNode start)
    {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(start);

        System.out.println("\n BFS Traversal:");

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (!visited.contains(current)) {
                System.out.println("Visited: " + current.getName());
                visited.add(current);
                for (TreeNode neighbor : current.children.keySet()) {
                    queue.add(neighbor);
                }
            }
        }
    }

    // 🔁 DFS to find ALL paths from start to end
    public List<List<TreeNode>> findAllPaths(TreeNode start, TreeNode end)
    {
        List<List<TreeNode>> allPaths = new ArrayList<>(); //List of all paths
        LinkedList<TreeNode> currentPath = new LinkedList<>(); //Tracks current path being explored
        Set<TreeNode> visited = new HashSet<>(); //Tracks visited nodes

        dfsAllPaths(start, end, currentPath, allPaths, visited); //Recursive function call

        return allPaths;
    }

    // Recursive helper function for all paths
    private void dfsAllPaths(TreeNode current, TreeNode end, LinkedList<TreeNode> currentPath,
                             List<List<TreeNode>> allPaths, Set<TreeNode> visited)
    {
        currentPath.add(current);
        visited.add(current);

        if (current.equals(end)) {
            allPaths.add(new ArrayList<>(currentPath)); //Save copy of the path
        } else {
            for (TreeNode neighbor : current.children.keySet()) {
                if (!visited.contains(neighbor)) {
                    dfsAllPaths(neighbor, end, currentPath, allPaths, visited);
                }
            }
        }

        currentPath.removeLast(); //Backtrack
        visited.remove(current);
    }
}
