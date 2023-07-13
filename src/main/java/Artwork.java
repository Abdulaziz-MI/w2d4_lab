public class Artwork {
    private String title;
    private Artist artist;
    private int price;

    public Artwork(String title, Artist artist, int price) {
        this.title = title;
        this.artist = artist;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public String getArtistName() {
        return this.artist.getName();
    }

    public int getPrice() {
        return price;
    }
}