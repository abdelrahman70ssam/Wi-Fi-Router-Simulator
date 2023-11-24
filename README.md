# Java Wi-Fi Router Simulator

This Java program simulates a Wi-Fi router with a limited number of connections using multithreading and semaphores.

## Problem Description

Routers can be designed to limit the number of open connections. In this simulation, a router is configured to have only N connections at any point in time. Once N connections are made, the router will not accept other incoming connections until an existing connection is released.

### Rules

- The Wi-Fi initially has no connected devices.
- When a client logs in and can be served (reach the internet), the client performs the following activities:
  - Connect
  - Perform online activity
  - Log out
- Actions are represented by printed messages with random waiting times between connecting, online activities, and logging out.
- If a client arrives and all connections are occupied, it must wait until an available connection is released.
- After a client finishes their service, they leave, and if waiting clients exist, one of them connects to the internet.

## Solution Design

Your program must contain the following classes:

1. **Router Class:** Contains a list of connections and methods to occupy and release a connection.
2. **Semaphore Class:** As given in the synchronization lab (Check Lab 3).
3. **Device Class:** Represents different devices (threads) that can be connected to the router. Each device has a name (e.g., C1) and type (e.g., mobile, PC, tablet) and can perform three activities: connect, perform online activity, and disconnect/logout.
4. **Network Class:** Contains the main method where the user is prompted for two inputs:
   - N: max number of connections a router can accept.
   - TC: total number of devices that wish to connect.
   - TC lines that contain: Name of each device and its Type.

## Program Output

The program prints the output logs in a file, simulating the execution order of the device threads and the printed messages of each device.

## How to Run

1. Clone the repository.
2. Compile the Java files.
3. Run the `Network` class.

## Example Usage

```bash
# Example commands to run the program
javac Router.java Semaphore.java Device.java Network.java
java Network
