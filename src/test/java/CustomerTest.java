import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    Customer customer;
    Artwork artwork;
    Artwork artwork2;
    Gallery gallery;

    @BeforeEach
    public void setUp() {
        customer = new Customer("John Doe", 100);
        artwork = new Artwork("Mona Lisa", new Artist("DaVinci"), 30);
        artwork2 = new Artwork("The Blind Man", new Artist("Carl"), 1000);
        gallery = new Gallery("Tower Hamlets", 0);
        gallery.addArtwork(artwork);
        gallery.addArtwork(artwork2);
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
    public void canAddArtToCollection(){
        customer.purchaseArt(gallery,artwork);

        int initialCollectionSize = customer.getArtCollection().size();
        int initialWalletSize = customer.getWallet();

        customer.purchaseArt(gallery,artwork);

        int finalCollectionSize = customer.getArtCollection().size();
        int finalWalletSize = customer.getWallet();

        assertEquals(initialWalletSize - artwork.getPrice(), finalWalletSize);

        assertEquals(initialCollectionSize + 1, finalCollectionSize);

        assertTrue(customer.getArtCollection().contains(artwork));
        assertThat(customer.purchaseArt(gallery,artwork)).isEqualTo("SOLD");
    }
    @Test
    public void cannotAffordArtwork(){
        customer.purchaseArt(gallery,artwork2);

        assertFalse(customer.getArtCollection().contains(artwork2));
        assertThat(customer.purchaseArt(gallery,artwork2)).isEqualTo("Insufficient funds");

    }




}