package com.POkevat.AlbumList;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


import com.POkevat.AlbumList.domain.Album;
import com.POkevat.AlbumList.domain.AlbumRepository;
import com.POkevat.AlbumList.domain.GenreRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
class AlbumListApplicationTests {
	
	@Autowired
	private AlbumRepository arepo;
	
	@Autowired
	private GenreRepository grepo;
	

	@Test
	public void findAlbum() {
		
		List<Album> albums = arepo.findByName("Ride the Lightning");
		assertThat(albums).hasSize(1);
		assertThat(albums.get(0).getArtist().equals("Metallica"));
	}
	
	@Test
	public void addAlbum() {
		Album album = new Album("Suomalainen Sisu", "Kake Randelin", 2014, grepo.findByName("Iskelmä").get(0));
		arepo.save(album);
		
		assertThat(album.getId()).isNotNull();
		assertThat(album.getArtist().equals("Kake Randelin"));
		assertThat(arepo.findByName("Kake Randelin").get(0)).isNotNull();
		
		
	}
	
	@Test
	public void editAndDeleteAlbum() {
		Album album = new Album("Suomalainen Sisu", "Kake Randelin", 2014, grepo.findByName("Rock").get(0));
		arepo.save(album);
		
		
		
		album.setGenre(grepo.findByName("Iskelmä").get(0));;
		
		assertThat(album.getArtist().equals("Kake Randelin"));
		assertThat(album.getGenre().equals("Iskelmä"));
		assertThat(arepo.findByName("Kake Randelin").get(0)).isNotNull();
		
		arepo.delete(album);
		
		assertThat(arepo.findByName("Suomalainen Sisu").isEmpty());
	}

}
