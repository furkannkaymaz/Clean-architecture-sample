### Clean architecture sample app 

##### A request was sent using https://itunes.apple.com api. You have to be a little patient as the service is a bit slow.

##### The project consists of Base Classes

##### Data Layer - BaseRepository -> for asynchronous service requests
##### Presentation Layer - BaseFragment-> compulsory or optional codes that should be in every fragment are collected here(ViewBinding, ViewModel)     
##### Presentation Layer - BaseAdapter,BaseViewHolder  -> recurring codes for each adapter are collected here. List adapter used for diffUtill class.
##### Domain Layer - Mapper, Usecases etc.
                  
##### -> StateFlow
##### -> Navigation
##### -> Kotlin Coroutines
##### -> Hilt
##### -> Unit Test
##### -> Extension Funcitons
##### -> DiffUtil
##### -> Operator, infix funcitons
##### -> Generics


##### -> There is only one fragment for now, just a sample request.

