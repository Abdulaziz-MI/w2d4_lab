import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    Customer customer;
    Artwork artwork;
    Gallery gallery;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John Doe", 100);
        artwork = new Artwork("Mona Lisa", new Artist("DaVinci"), 30);
        gallery = new Gallery("Tower Hamlets", 0);
        gallery.addArtwork(artwork);
    }

    @Test
    public void canSetName() {
        assertThat(customer.getName()).isEqualTo("John Doe");
    }

    @Test
    public void canGetWallet() {
        customer.purchaseArt(gallery, artwork);
        assertEquals(customer.getWallet(), 70);
    }

    @Test
    public void canTill() {
        String actual = customer.getName();
        String expected = "John Doe";

        customer.purchaseArt(gallery, artwork);
        assertThat(gallery.getTill()).isEqualTo(30);

    }
    @Test
    public void CannotAffordArtworkTwo(){
        Artwork artwork2 = new Artwork("The Blind Man", new Artist("Carl"), 1000);
        gallery.addArtwork(artwork2);

        customer.purchaseArt(gallery,artwork);

        assertThat(customer.purchaseArt(gallery,artwork)).isEqualTo("SOLD");

        assertThat(customer.getArtCollection().contains(artwork)).isEqualTo(true);



        customer.purchaseArt(gallery,artwork2);

       assertThat(customer.purchaseArt(gallery,artwork2)).isEqualTo("Insufficient funds");

       assertThat(customer.getArtCollection().contains(artwork2)).isEqualTo(false);
    }


}