#Factory Method

Define an interface for creating an object, but let subclasses decide which class to instantiate.\n
Hide creation logic to client and by a Factory class it create objects.<br>
There are entities that grant the division of **responsability** and code **reusability**.

###Implementation

This pattern utilize an interface and specialization classes, that implements the general interface.\n

- [ ] Create interface
- [ ] Create concrete classes that implement interface
- [ ] Create factory class used to instantiate objects of concrete classes
- [ ] Create client class

\n


Canvas interface provides to concrete classes its behaviour, in this case provide **createCanvas()**.
ScreenCanvas and PrinterCanvas are concrete classes, so override **createCanvas()**.

![Canvas and concrete Canvas logic](../imgs/FactoryBusiness.png)

Method **getCanvas()** of CanvasFactory return selected concrete Canvas by passing its name as String.

![CanvasFactory logic](../imgs/Factory.png)

Finally FactoryMethodClient create selected concrete Canvas with **createCanvas()**.

![FactoryMethodClient logic](../imgs/FactoryDemo.png)
