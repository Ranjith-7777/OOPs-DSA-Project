# Campus Navigation System

### "Finding your way around a big campus can be tough, right? Well, here's our solution!"

## Introduction
Our **Campus Navigation System (CNS)** is designed to simplify navigation in large campuses (Here we are demostrting using our campus as a base). By combining dynamic graph structures, efficient pathfinding algorithms(Dijkstra algorithm), and an interactive UI, our solution helps students, faculty, and visitors find their way in the campus easily.

## Key Features
- **Graph-Based Modeling:** Buildings are nodes, and pathways are edges.
- **Shortest Path Algorithm:** Utilizes **Dijkstra's Algorithm** for optimal route calculation.
- **Dynamic Graph Updates:** Real-time addition or removal of buildings and pathways can be done by the admin.
- **Interactive Web UI:** Developed using **HTML**, **CSS** and basic **JAVASCRIPT** for a seamless experience.
- **Future Enhancements:** Plans for GPS integration, AI-based route optimization, better web interface using **FLASK** and **REACT** and a mobile app using **Flutter**.

## Installation
Follow these steps to get the CNS up and running:
1. Clone the repository:
   ```bash
   git clone git@github.com:Ranjith-7777/OOPs-DSA-Project.git
   cd Campus-Navigation-System
   ```
 

## Project Structure
```
|-- backend
|   |-- CampusTree.java        # Tree-based structure to manage campus layout
|   |-- InputModule.java       # Handles user input processing
|   |-- Main.java              # Main entry point for backend logic
|   |-- MapAreaModule.java     # Manages different map areas
|   |-- RouteFinder.java       # Logic to compute optimal routes
|   |-- SearchPanel.java       # UI panel for search functionality
|   |-- TreeNode.java          # Data structure for tree nodes
|
|-- frontend
|   |-- index.html            # Main UI interface
|   |-- style.css             # Styling for the web UI
|   |-- script.js             # JavaScript logic for UI handling
|
|-- README.md
```

## Usage
1. **Search for Locations:** Enter your starting and ending points to view the shortest path.
2. **View Dynamic Changes:** The system can dynamically adapt to newly added or removed buildings.
3. **Interactive Map:** The visual interface allows you to explore campus layouts efficiently.

## Future Plans
✅ **GPS Integration** — Real-time location updates.<br>
✅ **AI-Based Route Optimization** — Intelligent path adjustments based on congestion.<br>
✅ Better web interface using **FLASK** and **REACT**.<br>
✅ **Mobile App Development** — Future migration to **Flutter** for improved accessibility.<br>


We look forward to enhancing campus navigation with this efficient and user-friendly solution. Feel free to contribute and share your feedback!

