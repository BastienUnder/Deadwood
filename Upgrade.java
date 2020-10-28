public class Upgrade {
    private int rank;
    private String currency;
    private int amount;

    public Upgrade(int rank, String currency, int amount) {
        this.rank = rank;
        this.currency = currency;
        this.amount = amount;
    }

    public int getRank() {
        return rank;
    }

    public String getCurrency() {
        return currency;
    }

    public int getAmount() {
        return amount;
    }
}
