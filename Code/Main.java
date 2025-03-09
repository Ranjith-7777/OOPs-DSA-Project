import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        CampusTree campusTree = new CampusTree();
        RouteFinder routeFinder = new RouteFinder();
        SearchPanel searchPanel = new SearchPanel();
        InputModule inputModule = new InputModule();
        MapAreaModule mapAreaModule = new MapAreaModule();
        GPSModule gpsModule = new GPSModule();

        //Here the dynamic adding part comes.(Only admin can)
        TreeNode library = new TreeNode("Library", 10, 10, true, true);
        TreeNode mba = new TreeNode("MBA", 20, 15, false, true);
        TreeNode ab4 = new TreeNode("AB4", 30, 25, true, true);
        TreeNode hostel = new TreeNode("Hostel", 40, 35, false, false);
        TreeNode MainCanteen = new TreeNode("MC",50,25,false,false);



        library.addChild(mba);
        library.addChild(ab4);
        mba.addChild(ab4);
        mba.addChild(hostel);
        ab4.addChild(hostel);
        MainCanteen.addChild(ab4);

        campusTree.setRoot(library);
        campusTree.addBuilding(library);
        campusTree.addBuilding(mba);
        campusTree.addBuilding(ab4);
        campusTree.addBuilding(hostel);
        campusTree.addBuilding(MainCanteen);

        // Getting the input locations from the user
        String startName = inputModule.getStartLocation();
        String endName = inputModule.getEndLocation();

        // Searching for Locations around the place entered by the user
        TreeNode start = searchPanel.performSearch(startName, campusTree.getAllBuildings());
        TreeNode end = searchPanel.performSearch(endName, campusTree.getAllBuildings());

        if (start == null || end == null)
        {
            System.out.println("Invalid locations entered. Please try again.");
            return;
        }

        // Finding and Displaying Path
        List<TreeNode> path = routeFinder.findPath(start, end);
        mapAreaModule.drawMap(path);

        // Simulating GPS (Currently a future work)
        gpsModule.getCurrentLocation();
    }
}
