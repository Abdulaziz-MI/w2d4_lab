import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class GalleryTest {
Customer customer;
Artwork artwork;
Artwork artwork2;
Gallery gallery;

@BeforeEach
public void setUp(){
     customer = new Customer("John Doe", 100);
     artwork= new Artwork("Mona Lisa", new Artist("DaVinci"),30);
    artwork2 = new Artwork("The Blind Man", new Artist("Carl"),1000);
     gallery = new Gallery("Tower Hamlets", 0);
    gallery.addArtwork(artwork);
    gallery.addArtwork(artwork2);
}
@Test
     public void canGetName(){
     assertThat(gallery.getName()).isEqualTo("Tower Hamlets");}


@Test
    public void canGetTill(){
    assertThat(gallery.getTill()).isEqualTo(0);
}

    @Test
    public void CanSellArtwork() {
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


    int actual = gallery.getStockTake();
    int expected = artwork.getPrice() + artwork2.getPrice();
    assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void canDeclineCustomerArtwork(){

        customer.purchaseArt(gallery,artwork2);

        assertFalse(customer.getArtCollection().contains(artwork2));
        assertTrue(gallery.getStock().contains(artwork2));
        assertThat(customer.purchaseArt(gallery,artwork2)).isEqualTo("Insufficient funds");

    }

}
