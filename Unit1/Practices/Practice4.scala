//Exercise 3
def fib(n:Int):Int={
    a=0
    b=1
    
    for (k<- Range(0,n)){
    
        c=b+a
        a=b
        b=c
    }
        
     return a
    }

fib(10)
  
  
  //Exercise 4
  def fib(n:Int):Int={
    a=0
    b=1
    
    for (k<- Range(0,n)){
    
        b=b+a
        a=b-a
        
    }
        
    return a
    }


fib(10)

