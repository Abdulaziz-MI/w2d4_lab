import java.util.ArrayList;
import java.util.List;

public class Gallery {
    private String name;
    private int till;
    private List<Artwork> stock;

    public Gallery(String name, int till) {
        this.name = name;
        this.till = till;
        this.stock = new ArrayList<>();
    }

    public String getName() {
        return    this.name;
    }

    public int getTill() {
        return    this.till;
    }

    //remove artwork and add money in till
    public void sellArtwork(Artwork artwork) {
        this.stock.remove(artwork);
        this.till += artwork.getPrice();
    }

    public void addArtwork(Artwork newArt) {
        this.stock.add(newArt);
    }

    public List<Artwork> getStock() {
        return this.stock;
    }
}