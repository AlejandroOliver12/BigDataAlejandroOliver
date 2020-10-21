# BigDataAlejandroOliver

# Unit 1

###  Instituto Tecnologico de Tijuana
### Semestre Septiembre-Enero 2020 
###  Carrera: Ingenieria en sistemas Computacionales
###  Materia: Datos Masivos
###  Maestro: Jose Christian Romero Hernandez
###   Oliver Cardenas Jesus Alejandro  16210561 



###  Index:
#### Practice1
#### Practice2
#### Practice3
#### Practice4
#### Pair Coding
#### Homework 

### Practice 1
#### Instructions
1. develop an algoritm in scala that calculates tha radius of a circle
2. develop an algorithm in scala that tells me if a number is a cousin
3. given the variable bird = "tweet" use string interpolation to print "i am writing a tweet"
4.  given the variable message = "hi luke, i'm your father!" use slilce to extract the  sequence "luke"*/
5.  what is the difference in value and a variable in scala?*/
6.  given the tuple ((2,4,5), (1,2,3), (3,116,23))) the number 3,141 returns
```scala
/*1.Develop an algorithm in scala that calculates the radius of a circle*/
var a=3
var r=math.sqrt(a/math.Pi)        
/*2. Develop an algorithm in scala that tells me if a number is a cousin*/
var t = ((2,4,5),(1,2,3),(3.1416,23))
t._3._1
/*3. Given the variable bird = "tweet", use string interpolation to print "I am writing a tweet"n*/
var bird="tweet"
printf(s"Estoy ecribiendo un %s",bird)
/*4. Given the variable message = "Hi Luke, I'm your father!" use slilce to extract the  sequence "Luke"*/
var mensaje = "Hola Luke yo soy tu padre!"
mensaje.slice(5,9)
/*5. What is the difference in value and a variable in scala?*/
Value (val) is immutable once assigned the value this cannot be changed
Variable (var) once assigned you can reassign the value, as long as the new value
sea of the same type
/*6. Given the tuple ((2,4,5), (1,2,3), (3,116,23))) the number 3,141 returns*/
var t = ((2,4,5),(1,2,3),(3.1416,23))
t._3._1
```




###  Practice 2
#### Instructions
1. Create a list called "list" with the elements "red", "white", "black"*/
2.  Add 5 more items to "list" "green", "yellow", "blue", "orange", "pearl"*/
3.  Bring the "list" "green", "yellow", "blue" items*/
4.  Create a number array in the 1-1000 range in 5-in-5 steps*/
5.   -What are the unique elements of the List list (1,3,3,4,6,7,3,7) use conversion to sets*/
6.   Create a mutable map called names containing the following"Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27*/
7.     Add the following value to the map ("Miguel", 23)
```scala
/*1.-Create a list called "list" with the elements "red", "white", "black"*/
         var lista = collection.mutable.MutableList("rojo","blanco","negro")      
         /*2.-Add 5 more items to "list" "green", "yellow", "blue", "orange", "pearl"*/
          lista += ("verde","amarillo", "azul", "naranja", "perla")
         /*3.-Bring the "list" "green", "yellow", "blue" items*/
             lista(3)
             lista(4)
             lista(5)
         /*4.-Create a number array in the 1-1000 range in 5-in-5 steps*/
               var v = Range(1,1000,5)
         /*5.-What are the unique elements of the List list (1,3,3,4,6,7,3,7) use conversion to sets*/
              var l = List(1,3,3,4,6,7,3,7)
               l.toSet
         /*6.-Create a mutable map called names containing the following"Jose", 20, "Luis", 24, "Ana", 23, "Susana", "27*/
          var map=collection.mutable.Map(("Jose", 20),("Luis", 24),("Ana", 23),("Susana", "27"))
         /*6.-a. Print all map keys*/
           map.keys
         /*7.-b. Add the following value to the map ("Miguel", 23)*/
          map += ("Miguel"->23)
```

### Practice 3
#### Instructions
1.  Analyse the following code with your own words
 
```scala
//Define list event
//cicle
// if n is a number divisible on 2 print is even
// else n is not a number divisible on 2  print is odd
def listEvens(list:List[Int]): String ={
    for(n <- list){
        if(n%2==0){
            println(s"$n is even")
        }else{
            println(s"$n is odd")
        }
    }
    return "Done"
}
// In this section of the code we declare 2 lists
// and 2 Lis Events
//Based on the elements of this list 
//returning messages of is even or is odd based on the list elements
val l = List(1,2,3,4,5,6,7,8)
val l2 = List(4,3,22,55,7,8)
listEvens(l)
listEvens(l2)

//3 7 afortunado
//List event
def afortunado(list:List[Int]): Int={
    var res=0
    for(n <- list){
        if(n==7){
            res = res + 14
        }else{
            res = res + n
        }
    }
    return res
}
//Values of afortunado
//Based of values of this list we gona to receive results based on the condictional of for cicle
val af= List(1,7,7)//
//Print the result afortunado 29
//1 = 1    7=14      7=14
//1+14+14 = 29
println(afortunado(af))
//Define event list Balance
def balance(list:List[Int]): Boolean={
    var primera = 0
    var segunda = 0

    segunda = list.sum
    //Primera Sum values to our list
    //Segunda rest values to our list

    for(i <- Range(0,list.length)){
        primera = primera + list(i)
        segunda = segunda - list(i)

        if(primera == segunda){
            return true
        }
    }
    return false 
}
//List ELements
val bl = List(3,2,1)
val bl2 = List(2,3,3,2)
val bl3 = List(10,30,90)
//run
balance(bl)
balance(bl2)
balance(bl3)
//Define palindromo
//Reverse Palabra(Word)
// if word dont are exactly the same word reverse
//return false
def palindromo(palabra:String):Boolean ={
    return (palabra == palabra.reverse)
}

val palabra = "OSO" 
val palabra2 = "ANNA" 
val palabra3 = "JUAN" 
//Return Boolean
//run
println(palindromo(palabra))
println(palindromo(palabra2))
println(palindromo(palabra3))
```


### Practice 4
#### Instructions

Fibonacci Programaming  diferent versions:
1. Recursive version descending
2. Fibonacci Explicit Version
3. Iterative Version
4. Iterative version with variables
5. Iterative vector version

```scala
///Exercise 1
//Recursive version descending.
/* Each of these calls, if it is greater than 1, will again be calling your previous    two.*/
    /* 1.- Recursive  descending.*/
def fib1( n : Int) : Int =
{
    if(n<2) n
    else fib1( n-1 ) + fib1( n-2 )
}

fib1(5)
///////////////
//Exercise 2
//Fibonacci sequence uch that each number is the sum of the two preceding ones, starting from 0 and 1. Fibonacci numbers have the generating function
    /* 2.- Version with explicit formula.*/
    def fib2( n : Int ) : Int = {
        if(n<2)n
        else
        {
            var y = ((1+math.sqrt(5))/2)
            var k = ((math.pow(y,n)-math.pow((1-y),n))/math.sqrt(5))      
            k.toInt
        }
}
        
//////////////////////////////    
  //Exercise3
//define fib
//Declare 2 variables type Int
def fib(n:Int):Int = {
    var a:Int = 0
    var b: Int = 1
   
    //Use for Cicle
    
    for (k<- Range(0,n)){
    //Declare variable C type int
       var c :Int = b+a
        a = b
        b = c
    }
     //Return a   
     return a
    }
//result
fib(9)  
/////////////////////
//Exercise 4
//Define fib4
//Declare 2 variables type int
def fib4(n:Int):Int = {
   var a:Int =0
    var b:Int =1
    // use for cicle
    for (k<- Range(0,n)){
    
        b = b+a
        a = b-a
        
    }
     //Return a   
    return a
    }

//result
fib4(9)

/////////////////
//Exercise5
/* 5.- Iterative vector version.*/
    def fib5(n:Int): Int={
    if(n<2)n    
    else{        
        var b = List.range(0,n+1)
        for(k<-Range(2,n+1)){            
            b = b.updated(k,(b(k-1)+b(k-2)))            
        }            
        b(n)
     }     
}
```




