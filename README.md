# abstract-dashboard
An abstraction of NetworkTables, Shuffleboard, SmartDashboard, and LiveWindow

### Why use this?
This library has no global state, meaning that you are free to use NetworkTables how you want to.

Although this library was heavily influenced by NetworkTables, Shuffleboard, etc, this library gives
your program a layer of abstraction that allows you to change how different things work later.

### Why was this created
While working on [robo-sim](https://github.com/frc1444/robo-sim), I needed to be able to completely
clear the shuffleboard state and restart NetworkTables. Because the Shuffleboard API in WPILib is
lots and lots of static variables, I was unable to clear that global state. 

In an attempt to be able to restart a robot simulation without restarting the JVM, 
I over-engineered this beast while (in my opinion) improving on some tightly coupled aspects 
of the NetworkTable/Sendable/Shuffleboard library in WPILib. Some people won't like the change that this
library brings, and that's OK. I needed this library to be very loosely coupled to work in my simulation
and it won't fit everyone's needs.

### How to use this?
See [robot2019-sim](https://github.com/frc1444/robot2019-sim) for an example.

### Who should use this?
Until this has been used for a full year, it is not recommended for public use. However, if you are
an advanced team and are OK with using libraries outside of WPILib

### TODO
* Nothing right now!
