# Java Network Monitor Utility

## Overview
The Java Network Monitor Utility is a project designed to monitor the status of networked machines. It consists of a main graphical user interface (GUI) that displays a list of computers on the network, allowing users to select a computer and view its status. The utility communicates with client programs running on each machine to gather status updates and respond to requests.

## Project Structure
```
java-network-monitor
├── src
│   ├── main
│   │   ├── NetworkMonitorGUI.java
│   │   └── utils
│   │       └── NetworkUtils.java
│   ├── client
│   │   └── NetworkClient.java
│   └── common
│       └── Constants.java
├── build.gradle
└── README.md
```

## Files Description
- **src/main/NetworkMonitorGUI.java**: Contains the main GUI for the network monitoring utility. It displays networked machines and their statuses, updating at regular intervals.
  
- **src/main/utils/NetworkUtils.java**: Provides utility functions for network operations, including machine discovery and status checking.

- **src/client/NetworkClient.java**: Implements the client program that runs on each machine, reporting its status back to the main utility.

- **src/common/Constants.java**: Contains constant values used throughout the project, such as port numbers and predefined messages.

- **build.gradle**: Configuration file for Gradle, specifying dependencies and build tasks.

## Setup Instructions
1. Clone the repository:
   ```
   git clone <repository-url>
   ```
2. Navigate to the project directory:
   ```
   cd java-network-monitor
   ```
3. Build the project using Gradle:
   ```
   ./gradlew build
   ```
4. Run the main utility:
   ```
   java -cp build/libs/java-network-monitor.jar src.main.NetworkMonitorGUI
   ```

## Usage Guidelines
- Start the main utility first to initialize the monitoring process.
- Ensure that the client program is running on each machine you wish to monitor.
- The GUI will automatically refresh the status of each machine at regular intervals.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.