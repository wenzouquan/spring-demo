package demo.test.c;

/**
 * Hello world!
 *
 */

import java.util.List;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import demo.test.m.Users; 
import demo.test.m.UsersDao; 
import org.springframework.beans.factory.annotation.Autowired;  
import java.util.List;  
@RestController
@EnableAutoConfiguration
public class UsersC {
	 @Autowired  
	 private UsersDao usersDao; 

    String home(String name) { 
    	
    	 List<Users> userList = usersDao.findByName(name);
    	 if (userList != null && userList.size()!=0) {  
//    		 String names = "";
//    		 for (Users user : userList) {
//    			 names+=user.getName();
//    		 } 
    		 return "my name " + userList.get(0).getName();  
         }  
    	 
         return "user " + name + " is not exist."; 
    	//return name;
    }
    
    @RequestMapping("/hello/{myName}")  
    String index(@PathVariable String myName) {  
    	String name =home(myName);
        return "Hi ! "+name+"!";  
    }  
   

    
}