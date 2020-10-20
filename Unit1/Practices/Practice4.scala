





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

