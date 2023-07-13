import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ArtworkTest {



Artwork artwork;
Artist artist;
        @BeforeEach
        public void setUp(){
            artist= new Artist("DaVinci");
            artwork = new Artwork("Mona Lisa",artist, 30 );
        }


        @Test
        public  void canGetTitle(){
            String actual = artwork.getTitle();
            String expected = "Mona Lisa";
            assertThat(actual).isEqualTo(expected);
        }
        @Test
        public  void canGetArtist(){
            String actual = artwork.getArtistName();
            String expected =  artist.getName();
            assertThat(actual).isEqualTo(expected);
        }
        @Test
        public  void canGetPrice(){
            int actual = artwork.getPrice();
            int expected = 30;
            assertThat(actual).isEqualTo(expected);
        }

    }

