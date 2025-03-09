import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        CampusTree campusTree = new CampusTree();
        RouteFinder routeFinder = new RouteFinder();
        SearchPanel searchPanel = new SearchPanel();
        InputModule inputModule = new InputModule();
        MapAreaModule mapAreaModule = new MapAreaModule();
        GPSModule gpsModule = new GPSModule();

        // Creating buildings with weighted edges
        TreeNode library = new TreeNode("Library", 10, 10, true, true);
        TreeNode mba = new TreeNode("MBA", 20, 15, false, true);
        TreeNode ab4 = new TreeNode("AB4", 30, 25, true, true);
        TreeNode hostel = new TreeNode("Hostel", 40, 35, false, false);
        TreeNode mainCanteen = new TreeNode("MC", 50, 25, false, false);

        // Adding edges with distances
        library.addChild(mba, 5.0);
        library.addChild(ab4, 10.0);
        mba.addChild(ab4, 4.0);
        mba.addChild(hostel, 6.0);
        ab4.addChild(hostel, 3.5);
        mainCanteen.addChild(ab4, 7.0);

        campusTree.setRoot(library);
        campusTree.addBuilding(library);
        campusTree.addBuilding(mba);
        campusTree.addBuilding(ab4);
        campusTree.addBuilding(hostel);
        campusTree.addBuilding(mainCanteen);

        TreeNode start = null, end = null;

        // Keep asking until valid locations are entered
        while (start == null || end == null) {
            String startName = inputModule.getStartLocation();
            String endName = inputModule.getEndLocation();

            start = searchPanel.performSearch(startName, campusTree.getAllBuildings());
            end = searchPanel.performSearch(endName, campusTree.getAllBuildings());

            if (start == null || end == null) {
                System.out.println(" Invalid locations. Try again.");
            }
        }

        // Finding and Displaying Path
        List<TreeNode> path = routeFinder.findPath(start, end);
        mapAreaModule.drawMap(path);

        // Running DFS and BFS for testing
        System.out.println("\nDFS Traversal:");
        routeFinder.depthFirstSearch(start);

        System.out.println("\nBFS Traversal:");
        routeFinder.breadthFirstSearch(start);

        // Simulating GPS
        gpsModule.getCurrentLocation();
    }
}

