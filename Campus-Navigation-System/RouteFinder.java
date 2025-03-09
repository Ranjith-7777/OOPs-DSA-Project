import java.util.*;

class RouteFinder
{
    public List<TreeNode> findPath(TreeNode start, TreeNode end)
    {
        // Maps to store distances and previous nodes
        Map<TreeNode, Double> distances = new HashMap<>();
        Map<TreeNode, TreeNode> previous = new HashMap<>();

        // Priority queue for Dijkstra's Algorithm
        PriorityQueue<TreeNode> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        // Initialize distances for all nodes
        for (TreeNode node : getAllNodes(start)) {
            distances.put(node, Double.MAX_VALUE);
            previous.put(node, null);
        }

        // Set distance of start node to 0
        distances.put(start, 0.0);
        queue.add(start);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();  // Get node with shortest distance

            // Stop early if we reached the destination
            if (current.equals(end)) break;

            for (Map.Entry<TreeNode, Double> neighborEntry : current.children.entrySet()) {
                TreeNode neighbor = neighborEntry.getKey();
                double weight = neighborEntry.getValue();
                double newDist = distances.get(current) + weight;

                if (newDist < distances.get(neighbor)) {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        // Construct the shortest path
        List<TreeNode> path = new ArrayList<>();
        for (TreeNode at = end; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);

        // If path is empty or start and end are disconnected, return "No Path Found"
        if (path.size() == 1 && !path.get(0).equals(start)) {
            System.out.println("No path found between " + start.getName() + " and " + end.getName());
            return Collections.emptyList();
        }

        return path;
    }

    // Helper function to get all connected nodes from the starting node
    private Set<TreeNode> getAllNodes(TreeNode root)
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

        return nodes;
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
}
