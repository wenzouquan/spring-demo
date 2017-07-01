package demo.test.m;
import demo.test.m.Users;  
import org.springframework.data.repository.CrudRepository;  
import javax.transaction.Transactional;  
import java.math.BigDecimal;  
import java.util.Date;  
import java.util.List;  
  

@Transactional  
public interface UsersDao extends CrudRepository<Users, Integer> {  
    public List<Users> findByName(String name);  
    public List<Users> findById(int id);  
    public Users save(Users user);  
   public void delete(Users user);  
    public List<Users> findAll();
        
}  