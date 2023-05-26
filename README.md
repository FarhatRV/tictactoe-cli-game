Tic-Tac-Toe
====================

Showcase for an object-oriented Tic-Tac-Toe, demonstrating some OO concepts like
Encapsulation, Information Hiding, Dependency Inversion.

To run the game, just type:

```
 mvn clean package
 mvn exec:java
```

Code review guidelines:

4 major parts of Code review are as follows:
* Review The Architecture - Have a look at various points, such as:
    * * The choice of frameworks in the code base
    * * The way the code components communicate with other systems
    * * How testable the code is?
    * * The architecture of the components themselves
    * * The extent of code reuse - Are common components are identified and abstracted away for use in other places?
* Review The Design - Review the following aspects:
    * * What is the nature of the interaction between the various classes? How loosely are the classes coupled, and what is the cohesion between them?
    * * Have a look at the layer responsibilities, and see if the layers are clearly demarcated, and do not overlap in functionality.
    * * How well are the core object oriented principles followed in the code design?
    * * What is the nature of the unit tests? How easy or difficult is it to unit test the code under review?
* Review The Code
    * Will the code be scalable and performant?
        * no premature optimisations
        * no object creation in loops
        * close connections
        * Caching?
        * DB related
    * How does the code handle important security concerns?
    * How well are the unit tests written, and are they readable?
    * Are language specific standards being adhered to? - for example
        * in Java, use of Generics and Collections.
        * Enums are preferred to strings wherever possible
* Review Engineering Practices
    * How often the code is committed?
    * Review how often builds are broken
    * Review the entire continuous integration process