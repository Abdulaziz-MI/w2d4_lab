import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class GalleryTest {
Customer customer;
Artwork artwork;
Gallery gallery;

@BeforeEach
public void setUp(){
     customer = new Customer("John Doe", 100);
     artwork= new Artwork("Mona Lisa", new Artist("DaVinci"),30);
     gallery = new Gallery("Tower Hamlets", 0);
    gallery.addArtwork(artwork);
}
@Test
     public void canGetName(){
     assertThat(gallery.getName()).isEqualTo("Tower Hamlets");}



@Test
    public void canGetTill(){
    assertThat(gallery.getTill()).isEqualTo(0);
}

    @Test
    public void testSellArtwork() {
        int initialTill = gallery.getTill();
        int initialStockSize = gallery.getStock().size();

        gallery.sellArtwork(artwork);

        int finalTill = gallery.getTill();
        int finalStockSize = gallery.getStock().size();

        assertEquals(initialTill + artwork.getPrice(), finalTill);
        assertEquals(initialStockSize - 1, finalStockSize);
        assertFalse(gallery.getStock().contains(artwork));
    }

    @Test
    public void canGetStockTake(){
    Artwork artwork2 = new Artwork("test",new Artist("tester"),50 );

    gallery.addArtwork(artwork2);
    int actual = gallery.getStockTake();

    int expected = artwork.getPrice()+artwork2.getPrice();
    assertThat(actual).isEqualTo(expected);
    
    }

}
