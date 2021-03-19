package com.POkevat.AlbumList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.POkevat.AlbumList.domain.User;
import com.POkevat.AlbumList.domain.UserRepository;

@SpringBootApplication
public class AlbumListApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbumListApplication.class, args);
	}
	
	
	
	@Bean
	public CommandLineRunner runner(UserRepository urepository) {
		
		return(args) -> {
			//salasana
			User user = new User("user", "$2a$10$j.Ba5KtjH7hl.2kfAbhAweGJVgQiChYuWsZt/vxNaht50lQJqkJwi", "USER");
			//adminsalasana
			User admin = new User("admin", "$2a$10$bPr41DEBAkBKH1hXQh4G6ONTipI3CMHHrYnnKqqVwUwnBOwQPeEzO", "ADMIN");
			
			urepository.save(user);
			urepository.save(admin);
			
		};
		
	}

}
