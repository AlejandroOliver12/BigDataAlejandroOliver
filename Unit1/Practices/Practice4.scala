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

////
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

    
        
    
    




