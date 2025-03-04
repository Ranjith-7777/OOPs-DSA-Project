import java.util.ArrayList;
import java.util.List;

class TreeNode {
    String name;
    double x, y;
    boolean hasElevator;
    boolean isAccessible;
    List<TreeNode> children;

    public TreeNode(String name, double x, double y, boolean hasElevator, boolean isAccessible) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.hasElevator = hasElevator;
        this.isAccessible = isAccessible;
        this.children = new ArrayList<>();
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public String getName() {
        return name;
    }
}
