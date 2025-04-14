# Campus Navigation System
<!-- ALL-CONTRIBUTORS-BADGE and License:START - Do not remove or modify this section -->
[![All Contributors](https://img.shields.io/badge/all_contributors-3-orange.svg?style=flat-square)](#contributors-)
![MIT License](https://img.shields.io/badge/license-MIT-blue)
<!-- ALL-CONTRIBUTORS-BADGE and License:END -->

### "Finding your way around a big campus can be tough, right? Well, here's our solution!"

## Introduction
Our **Campus Navigation System (CNS)** is designed to simplify navigation in large campuses (Here we are demostrting using our campus as a base). By combining dynamic graph structures, efficient pathfinding algorithms(Dijkstra algorithm), and an interactive UI, our solution helps students, faculty, and visitors find their way in the campus easily.

## Key Features
- **Graph-Based Modeling:** Buildings are nodes, and pathways are edges.
- **Shortest Path Algorithm:** Utilizes **Dijkstra's Algorithm** for optimal route calculation.
- **Dynamic Graph Updates:** Real-time addition or removal of buildings and pathways can be done by the admin.
- **Interactive UI:** Developed using **SWING** for a seamless experience.
- **Future Enhancements:** Plans for GPS integration, AI-based route optimization, better web interface using **FLASK** and **REACT** and a mobile app using **Flutter**.

## Installation
Follow these steps to get the CNS up and running:
1. Clone the repository:
   ```bash
   git clone git@github.com:Ranjith-7777/OOPs-DSA-Project.git
   cd Campus-Navigation-System
   ```
 

##  Project Structure
MVC design pattern has been followed while coding and is given as follows
```
|-- CampusNavigation
|   |-- CampusApp.java          # Main entry point for the application
|   |   |-- controller
|   |       |-- InputModule.java    # Handles user input processing
|   |       |-- RouteFinder.java    # Logic to compute optimal routes
|   |       |-- SearchPanel.java    # Search functionality for buildings
|   |   |-- model
|   |       |-- CampusTree.java     # Tree-based structure to manage campus layout
|   |       |-- TreeNode.java       # Data structure for tree nodes
|   |   |-- view
|   |       |-- CampusGUI.java      # Main graphical user interface
|   |       |-- GPSModule.java      # Module for GPS tracking (to be implemented)
|   |       |-- MapAreaModule.java  # Manages different map areas
|   |       |-- MapPanel.java       # Panel for displaying the campus map
|   |-- resources
|   |   |-- amrita_map.png                  # Base map image
|   |   |-- map_with_coordinates.png        # Map with coordinates overlay
|   |-- lib
|   |   |-- flatlaf-3.5.3.jar               # FlatLaf library for UI styling
|-- README.md
```

## Usage
1. **Search for Locations:** Enter your starting and ending points to view the shortest path.
2. **View Dynamic Changes:** The system can dynamically adapt to newly added or removed buildings.
3. **Interactive Map:** The visual interface allows you to explore campus layouts efficiently.

## Future Plans
 **GPS Integration** — Real-time location updates.<br>
 **AI-Based Route Optimization** — Intelligent path adjustments based on congestion.<br>
 Better web interface using **FLASK** and **REACT**.<br>
 **Mobile App Development** — Future migration to **Flutter** for improved accessibility.<br>

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more information.

## Contributors ✨

Thanks goes to these wonderful people ([emoji key](https://allcontributors.org/docs/en/emoji-key)):

<!-- ALL-CONTRIBUTORS-LIST:START - Do not remove or modify this section -->
<!-- prettier-ignore-start -->
<!-- markdownlint-disable -->
<table>
  <tbody>
    <tr>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/ADKA2006"><img src="https://avatars.githubusercontent.com/u/174895346?v=4?s=100" width="100px;" alt="Advaith Krishna"/><br /><sub><b>Advaith Krishna</b></sub></a><br /><a href="https://github.com/Ranjith-7777/OOPs-DSA-Project/commits?author=ADKA2006" title="Code">💻</a> <a href="https://github.com/Ranjith-7777/OOPs-DSA-Project/commits?author=ADKA2006" title="Documentation">📖</a> <a href="#design-ADKA2006" title="Design">🎨</a> <a href="#ideas-ADKA2006" title="Ideas, Planning, & Feedback">🤔</a> <a href="https://github.com/Ranjith-7777/OOPs-DSA-Project/commits?author=ADKA2006" title="Tests"></a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/Jashu1935"><img src="https://avatars.githubusercontent.com/u/192393118?v=4?s=100" width="100px;" alt="Jashu1935"/><br /><sub><b>Jashu1935</b></sub></a><br /><a href="https://github.com/Ranjith-7777/OOPs-DSA-Project/commits?author=Jashu1935" title="Code">💻</a> <a href="https://github.com/Ranjith-7777/OOPs-DSA-Project/commits?author=Jashu1935" title="Documentation">📖</a> <a href="#design-Jashu1935" title="Design">🎨</a> <a href="#ideas-Jashu1935" title="Ideas, Planning, & Feedback">🤔</a> <a href="https://github.com/Ranjith-7777/OOPs-DSA-Project/commits?author=Jashu1935" title="Tests"></a></td>
      <td align="center" valign="top" width="14.28%"><a href="https://github.com/Ranjith-7777"><img src="https://avatars.githubusercontent.com/u/197097767?v=4?s=100" width="100px;" alt="Ranjith-7777"/><br /><sub><b>Ranjith-7777</b></sub></a><br /><a href="https://github.com/Ranjith-7777/OOPs-DSA-Project/commits?author=Ranjith-7777" title="Code">💻</a> <a href="https://github.com/Ranjith-7777/OOPs-DSA-Project/commits?author=Ranjith-7777" title="Documentation">📖</a> <a href="#design-Ranjith-7777" title="Design">🎨</a> <a href="#ideas-Ranjith-7777" title="Ideas, Planning, & Feedback">🤔</a> <a href="https://github.com/Ranjith-7777/OOPs-DSA-Project/commits?author=Ranjith-7777" title="Tests"></a></td>
    </tr>
  </tbody>
</table>

<!-- markdownlint-restore -->
<!-- prettier-ignore-end -->

<!-- ALL-CONTRIBUTORS-LIST:END -->

This project follows the [all-contributors](https://github.com/all-contributors/all-contributors) specification.<br> 

We look forward to enhancing campus navigation with this efficient and user-friendly solution. Feel free to contribute and share your feedback!
