Game Builder
====================

Showcase for an object-oriented Game Builder, demonstrating some OO concepts like
Encapsulation, Information Hiding, Dependency Inversion.

To run the game, just type:

```
 mvn clean package
 mvn exec:java
```


Code review guidelines:

4 major parts of Code review are as follows:
* Review The Architecture - Especially, **feature level reviews**. This should generally happen before PR review or implementation begins. Have a look at various points, such as:
    * * The choice of frameworks in the code base
    * * The way the code components communicate with other systems
      * REST(compute intensive, relational entities), webhooks event, Websockets(real-time), GraphQL(i/o, CRUD operations across lots of entities), 
    * * How testable the code is? unit, integration, e2e
    * * The architecture of the components themselves -
      * - serverless, event-driven, shared-nothing(stateless), 
    * * The extent of code reuse - Are common components are identified and abstracted away for use in other places?
* Review The Design - Review the following aspects:
    * * What is the nature of the interaction between the various classes? How loosely are the classes coupled, and what is the cohesion between them?
        * coffee crusher -> coffee filter -> water mixing -> milk mixing
        * coffee crusher = CoffeeCrushedObject -> water mixing(CoffeeFilterObject) -> milk mixing XXX BAD
    * * Have a look at the layer responsibilities, and see if the layers are clearly demarcated, and do not overlap in functionality.
      * Single responsibility principle - Class CoffeeCrusherAndFilter - Bad, Class CoffeeCrusher, Class CoffeeFilter
    * * How well are the core object oriented and functional principles followed in the code design?
    * * What is the nature of the unit tests? How easy or difficult is it to unit test the code under review?
* Review The Code
    * Will the code be scalable and performant?
        * no premature optimisations
        * no object creation in loops
        * close connections
        * Caching? - in-memory object, in-memory cache(redis/ memcached), Hibernate(ORM) 2nd level cache
        * DB related - aggregate queries
    * How does the code handle important security concerns? API security - JWT, OAuth2, don't store passwords as plaintext
    * How well are the unit tests written, and are they readable? - +ve/ -ve cases are tested, test exception handling too
    * Are language specific standards being adhered to? - for example
        * in Java, use of Generics and Collections.
        * Enums are preferred to strings wherever possible
* Review Engineering Practices
    * How often the code is committed? - avoid too much churn
    * Review how often builds are broken
    * Automated builds should be there
    * Review the entire continuous integration process
      * document CI changes as part of the feature in PR or ticket or README

---
**I/o intensive**
* asia
** 1m requests sec, create lobbies, register users, remove users, user badge, profile
* europe

**Compute intensive**
product + product_availabities + product_categories -> 10items, sort - compute

---

**object oriented** - functionality is driven by Object - you pass data to function,

**functional programming** - you pass function to an object, streams of object, you pass the logic to that stream

functional
```
getProducts().stream().map(DTO(productEntity))
.sort(when(sortByCriteria) popularity->PopularityComparator, lowToHigh->LowHighComparator)
```

OOPS
```
getProducts().convertToPopularitySortList()
getProducts().convertToLTHSortList()
```
-----
```
var csvRecords = csv.read()

csvRecords.getTop10Rows()
csv.close()
```
-----

Bad
```
for(product in getProducts()){
val productDTO = new ProductMapper().map(product)
}
```
Good
```
val mapper = new ProductMapper
for(product in getProducts()){
val productDTO = mapper.map(product)
}
```
-----
```
get products for mobile, TVs
DBCall(getElectronicProducts) - mobile
DBCall(getElectronicProducts) - TV

getRegion()->for each region, get sales, -> sales, get product().....
singleQuery - select product join sales join region group by, with(allregions as select * from region) select sales join allregions,
```
----
