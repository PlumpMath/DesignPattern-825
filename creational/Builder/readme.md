#Builder
Separate the construction of a complex object from its representation so that the same construction process can create different representations, based on minimal update on creation steps.<br>

###Implementation ()

We have considered a business case of fast-food restaurant where a typical meal could be a **burger** and a **cold drink**.<br>
**Burger** could be either a **Veg Burger** or **Chicken Burger** and will be packed by a **wrapper**.<br>
**Cold drink** could be either a **coke** or **pepsi** and will be packed in a **bottle**.<br><br>

We are going to create an **Item** *interface* representing food items such as **burgers** and **cold drinks** and concrete classes implementing the Item interface and a Packing interface representing packaging of food items and concrete classes implementing the Packing interface as *burger would be packed in wrapper* and *cold drink would be packed as bottle*.
<br><br>
We then create a Meal class having ArrayList of Item and a MealBuilder to build different types of Meal objects by combining Item.
