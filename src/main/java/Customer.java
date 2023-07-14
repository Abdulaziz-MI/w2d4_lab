import java.util.ArrayList;

public class Customer {
    private String name;
    private int wallet;
    private ArrayList<Artwork> artCollection;

    public Customer(String name, int wallet) {
        this.name = name;
        this.wallet = wallet;
        this.artCollection =new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getWallet() {
        return wallet;
    }

    public ArrayList<Artwork> getArtCollection() {
        return artCollection;
    }

    public String purchaseArt(Gallery gallery, Artwork artwork) {
        String msg= "";
        if (wallet >= artwork.getPrice()) {
            wallet -= artwork.getPrice();
            gallery.sellArtwork(artwork);
            this.artCollection.add(artwork);
            return msg = "SOLD";}
        else {
            return    msg= "Insufficient funds";}
    }
}