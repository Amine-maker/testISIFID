package com.example.springboot.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @RequestMapping(path="/{number}")
    public ResponseEntity <Integer> getMessage(@PathVariable("number") Integer x) {
        
      if(x<0){ // inf a 0
        return new ResponseEntity <> (HttpStatus.BAD_REQUEST);
      }
        else if(x%2 != 0) { // impair 
          StringBuilder sbd = new StringBuilder("01"); 
         Integer nbr1= 0, nbr2=1, nbr3=0;
              for(int i=2; i<10; i++)
              {
                  nbr3 = nbr1 + nbr2;       
                  nbr1 = nbr2;    
                  nbr2 = nbr3; 
                  
                  sbd.append(nbr3);
              }
              String str = sbd.toString();
              return new ResponseEntity <> (Integer.parseInt(str),HttpStatus.OK);
            }

            else if(x%2 == 0 && x <51){ // pair et inf a 51

              Integer fact = 1;
                for (int j = 2; j <= x; j++) {
                fact = fact *  j;
                }
                return new ResponseEntity <> (fact,HttpStatus.OK);
            }

                else if(x%2 == 0 && x >50){ // pair et sup a 50
                  return new ResponseEntity <> (x,HttpStatus.OK);
                }

          return new ResponseEntity <> (HttpStatus.OK);
    }
}
