package com.MBASE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.MBASE.model.Role;
import com.MBASE.model.RoleName;
import com.MBASE.model.User;
import com.MBASE.repository.RoleRepository;
import com.MBASE.repository.UserRepository;
import com.MBASE.requests.SignUpForm;

@Component
public class DbSeeder {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    Logger logger;
    
    SignUpForm signUpForm = new SignUpForm();
    
	
	@EventListener
	 public void seed(ContextRefreshedEvent event) {
	    seedUser();
	    }
	
	
	public void seedUser() {
		
		//create roles
		Set<String> strRoles = new HashSet<>(Arrays.asList("admin"));
		Set<Role> roles = new HashSet<>();
		String username = "admin";
	    String query = "SELECT top 1 email, username  FROM users U WHERE U.username ='"+username +"'";
	    		//+ "\"admin\" OR " + "U.email = \"admin@admin.com\"";

	    strRoles.forEach(role -> {
        	switch(role) {
	    		case "admin":
	    			Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
	                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
	    			roles.add(adminRole);
	    			
	    			break;			
        	}
        });
	    
	    List<User> u = jdbcTemplate.query(query, (resultSet, rowNum) -> null);
	    if(u == null || u.size() <= 0) {
	    	User user = new User();
	    	user.setName("Sir James");
	    	user.setEmail("admin@admin.com");
	    	user.setUsername("admin");
	    	user.setPassword(new BCryptPasswordEncoder().encode("123456789"));
	    	user.setRoles(roles);
	    	
	         userRepository.save(user);
	         //logger.info("User Seeded");
	    } else {
	        //logger.info("User Seeding is Not Required");
	    }
	}

}
