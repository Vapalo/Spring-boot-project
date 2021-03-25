package com.POkevat.AlbumList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.POkevat.AlbumList.domain.Album;
import com.POkevat.AlbumList.domain.AlbumRepository;
import com.POkevat.AlbumList.domain.Genre;
import com.POkevat.AlbumList.domain.GenreRepository;
import com.POkevat.AlbumList.domain.User;
import com.POkevat.AlbumList.domain.UserRepository;

@SpringBootApplication
public class AlbumListApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlbumListApplication.class, args);
	}
	
	
	
	@Bean
	public CommandLineRunner runner(UserRepository urepo, AlbumRepository arepo, GenreRepository grepo) {
		
		return(args) -> {
			//salasana
			User user = new User("user", "$2a$10$j.Ba5KtjH7hl.2kfAbhAweGJVgQiChYuWsZt/vxNaht50lQJqkJwi", "USER");
			//adminsalasana
			User admin = new User("admin", "$2a$10$bPr41DEBAkBKH1hXQh4G6ONTipI3CMHHrYnnKqqVwUwnBOwQPeEzO", "ADMIN");
			
			urepo.save(user);
			urepo.save(admin);
			
			grepo.save(new Genre("Rock"));
			grepo.save(new Genre("Hip-Hop"));
			grepo.save(new Genre("Rap"));
			grepo.save(new Genre("EDM"));
			grepo.save(new Genre("Metal"));
			grepo.save(new Genre("Blues"));
			
			arepo.save(new Album("Metallica", "Ride the Lightning", 1984, grepo.findByName("Metal").get(0)));
			arepo.save(new Album("The Notorious BIG", "Ready to Die", 1994, grepo.findByName("Hip-Hop").get(0)));
			
			
		};
		
	}

}
