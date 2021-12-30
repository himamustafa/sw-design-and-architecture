package com.example.uber;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController extends Person1 {
	
	@PostMapping("/userregister/{username}/{password}/{mobilenumber}/{email}")
	public void register(@PathVariable("username") String username,@PathVariable("password") String password,@PathVariable("mobilenumber") String mobile_number,@PathVariable("email") String email)
	{
		User user = new User();
		user.set_User(username,mobile_number,email,password);
		user.register(user);
		System.out.print("added");
	}
	@GetMapping("/userlogin/{username}/{password}")
	public Boolean user_login(@PathVariable("username") String username,@PathVariable("password") String password)
	{
		User user = new User();
		for(int i=0;i<all_users.size();i++) 
		{
			if(all_users.get(i).username.equals(username)) 
			{
				System.out.print(all_users.get(i).username);
				if(all_users.get(i).password.equals(password)) 
				{
					System.out.print(all_users.get(i).password);
					return true;
				}
				else 
					return false;
			}
		}
		return false;
	}
	
	@GetMapping("/listuserrides")
	public void list_rides()
	{
		User user = new User();
		user.print();
	}

}
