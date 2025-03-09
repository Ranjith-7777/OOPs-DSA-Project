import java.util.*;

class RouteFinder
{
    public List<TreeNode> findPath(TreeNode start, TreeNode end)
    {
        Map<TreeNode, Integer> distances = new HashMap<>();
        Map<TreeNode, TreeNode> previous = new HashMap<>();
        PriorityQueue<TreeNode> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get));

        for (TreeNode node : start.children)
        {
            distances.put(node, Integer.MAX_VALUE);
            previous.put(node, null);
        }
        distances.put(start, 0);
        queue.add(start);

        while (!queue.isEmpty()) //Just checking if the queue is empty or not
        {
            TreeNode current = queue.poll();

            if (current == end) break;

            for (TreeNode neighbor : current.children)
            {
                int newDist = distances.get(current) + 1;
                if (newDist < distances.getOrDefault(neighbor, Integer.MAX_VALUE))
                {
                    distances.put(neighbor, newDist);
                    previous.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }

        List<TreeNode> path = new ArrayList<>();
        for (TreeNode at = end; at != null; at = previous.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}
