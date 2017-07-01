package demo.test.m;
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.GenerationType;  
import javax.persistence.Id;  
import javax.persistence.Table;  
import javax.validation.constraints.NotNull;  

@Entity  
@Table(name = "users")  

public class Users {  
    @Id  
    @GeneratedValue(strategy = GenerationType.AUTO)  
    private int id;  
    @NotNull  
    private String name; 
    @NotNull  
    private int gender; 
    
    public int getId() {  
        return id;  
    }  
  
    public void setGender(int id) {  
        this.gender = gender;  
    }  
  
    public int getGender() {  
        return gender;  
    }  
  
    public void setId(int id) {  
        this.id = id;  
    }  
  
    
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
}  