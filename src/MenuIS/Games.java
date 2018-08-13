package MenuIS;

/**
 *
 * @author Keyur Khadka, Darshana Karki, Avaya Baniya
 */
public class Games {
    public String gameId;
    public String gameName;
    public String platform;
    public String genre;
    public double price;
    public String rating;

    public Games(String gameId, String gameName, String platform, String genre, double price, String rating) {
        this.gameId = gameId;
        this.gameName = gameName;
        this.platform = platform;
        this.genre = genre;
        this.price = price;
        this.rating = rating;
    }

    public String getGameId()
    {
        return gameId;
    }

    public void setGameId(String gameId)
    {
        this.gameId = gameId;
    }

    public String getGameName() 
    {
        return gameName;
    }

    public void setGameName(String gameName)
    {
        this.gameName = gameName;
    }

    public String getPlatform()
    {
        return platform;
    }

    public void setPlatform(String platform)
    {
        this.platform = platform;
    }

    public String getGenre() 
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public String getRating()
    {
        return rating;
    }

    public void setRating(String rating)
    {
        this.rating = rating;
    }
        
}