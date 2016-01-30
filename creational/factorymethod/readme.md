#Factory Method

Creates objects hiding the instantiation logic to the client.<br>
refers to the newly created object through a common interface.<br>

Factory have **responsability** of object instantiation and also improve code **reusability**.

###Switch implementation

Canvas interface provides to concrete classes its behaviour, in this case provide **createCanvas()**.<br>
ScreenCanvas and PrinterCanvas are concrete classes, so override **createCanvas()**.

![Canvas and concrete Canvas logic](https://github.com/spino9330/DesignPattern/blob/master/imgs/FactoryBusiness.png)

Method **getCanvas()** of CanvasFactory return selected concrete Canvas by passing its name as String.

![CanvasFactory logic](https://github.com/spino9330/DesignPattern/blob/master/imgs/Factory.png)

Finally FactoryMethodClient create selected concrete Canvas with **createCanvas()**.

![FactoryMethodClient logic](https://github.com/spino9330/DesignPattern/blob/master/imgs/FactoryDemo.png)
