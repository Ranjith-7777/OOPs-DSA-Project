import java.util.ArrayList;
import java.util.List;

class CampusTree
{
    private TreeNode root;
    private List<TreeNode> buildings;

    public CampusTree()
    {
        buildings = new ArrayList<>();
    }

    public void setRoot(TreeNode root)
    {
        this.root = root;
    }

    public TreeNode getRoot()
    {
        return root;
    }

    public void addBuilding(TreeNode building)
    {
        buildings.add(building);
    }

    public List<TreeNode> getAllBuildings()
    {
        return buildings;
    }
}
