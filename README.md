### Clean architecture sample app 

### Project Summary

This project follows a three-tier architecture consisting of a data layer, presentation layer, and domain layer.

- Data Layer: This layer is responsible for accessing and processing the application's data. The BaseRepository class provides access to different data sources (e.g. API, database, cache) and includes methods for processing data from these sources.
- Presentation Layer: This layer is responsible for displaying data in the user interface. The BaseFragment class manages the lifecycle of a fragment and creates the user interface. The BaseAdapter class is used to display data in a list or grid, and the BaseViewHolder class creates a holder for each view item.
- Domain Layer: This layer includes the application's business logic and data transformation processes. The Mapper class transforms data from data sources into domain objects. The Usecases class performs specific functions of the application.

This project is designed to request data from the iTunes API, process the data, and display it in the user interface. The base classes are used to perform these functions, and application developers can customize these base classes to suit their own projects.

### Technologies

The following technologies were used in this project:
                  
-  Kotlin
-  MVVM architecture
-  Clean Architecture 
-  Navigation
-  Flow
-  Kotlin Coroutines
-  DI (Hilt)
-  Unit Test
-  Extension Functions
-  DiffUtil
-  Operator, infix funcitons
-  Generics


