public class Customer {
    private String name;
    private int wallet;

    public Customer(String name, int wallet) {
        this.name = name;
        this.wallet = wallet;
    }

    public String getName() {
        return name;
    }

    public int getWallet() {
        return wallet;
    }

    public String purchaseArt(Gallery gallery, Artwork artwork) {
        String msg= "";
        if (wallet >= artwork.getPrice()) {
            wallet -= artwork.getPrice();
            gallery.sellArtwork(artwork);
  return msg = "SOLD";
        } else {
         return    msg= "Insufficient funds";
        }
    }
}