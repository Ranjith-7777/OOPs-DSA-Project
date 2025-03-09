import java.util.*;

class TreeNode implements Comparable<TreeNode>
{
    String name;
    double x, y;
    boolean hasElevator;
    boolean isAccessible;
    Map<TreeNode, Double> children;

    public TreeNode(String name, double x, double y, boolean hasElevator, boolean isAccessible)
    {
        this.name = name;
        this.x = x;
        this.y = y;
        this.hasElevator = hasElevator;
        this.isAccessible = isAccessible;
        this.children = new HashMap<>();
    }

    public void addChild(TreeNode child, double distance)
    {
        children.put(child, distance);
    }

    public String getName()
    {
        return name;
    }

    @Override
    public int compareTo(TreeNode other)
    {
        int nameCompare = this.name.compareTo(other.name);
        if (nameCompare != 0) return nameCompare;

        // If names are same, compare based on x, then y coordinates
        if (this.x != other.x) return Double.compare(this.x, other.x);
        return Double.compare(this.y, other.y);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TreeNode treeNode = (TreeNode) obj;
        return Objects.equals(name, treeNode.name) && Double.compare(x, treeNode.x) == 0 && Double.compare(y, treeNode.y) == 0;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, x, y);
    }
}
