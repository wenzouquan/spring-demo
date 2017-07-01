package demo.test.c;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import demo.test.m.Users; 
import demo.test.m.UsersDao; 

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 * 测试velocity;
 * @author Angel --守护天使
 * @version v.0.1
 * @date 2016年10月4日
 */
@Controller
public class HelloController {
	 @Autowired  
	 private UsersDao usersDao; 
	 @Autowired  
	 private JdbcTemplate jdbcTemplate; 
    @RequestMapping("/")
    public String hello(Map<String,Object> map){
//       map.put("name", "Angel -- wen! ");
//       map.put("hello", "hello");
//       map.put("gender",1);//gender:性别，1：男；0：女；
//       List<Map<String,Object>> friends =new ArrayList<Map<String,Object>>();
//       Map<String,Object> friend = new HashMap<String,Object>();
//       friend.put("name", "张三");
//       friends.add(friend);
//       friend = new HashMap<String,Object>();
//       friend.put("name", "李四");
//       friends.add(friend);
//       map.put("friends", friends);
    	List<Users> userList = usersDao.findAll();
    	map.put("friends", userList);
       return "/userList";
    }
    
    @RequestMapping("/info/{id}")
    public String users(Map<String,Object> map, @PathVariable int id){
    	List<Users> userList = usersDao.findById(id);
    	 if (userList != null && userList.size()!=0) {  
    		 map.put("info", userList.get(0));
    	 }else{
    		 map.put("info", new HashMap<String,Object>());
    	 }
      // System.out.print(getName(id));
    	// updateName("java",id);
       return "/hellopage";
    }
    
    
    
    /**
     * 根据id , 查用户名
     * @param a
     * @return
     */
    public String getName(int id) {
    	Users User = jdbcTemplate.queryForObject("select * from users where id=?", new Object[] {id },
                new BeanPropertyRowMapper<>(Users.class));
        return User.getName();
    }
    
    /**
     * 更新
     * 
     * @param ac
     */
    public int updateName(String name , int id) {

    	return jdbcTemplate.update("update  users set name=? where id=?",
                new Object[] { name,id });
    }
   
}
