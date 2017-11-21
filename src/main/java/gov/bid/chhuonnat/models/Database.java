package gov.bid.chhuonnat.models;

/**
 * Created by HP1 on 5/13/2017.
 */
public class Database
{
    private String database;

    public Database()
    {
        this.database = "/gov/bid/chhuonnat/libs/dbs/dictionary";
    }

    public String getDatabaseFile()
    {
        return this.database;
    }

    public void setDatabaseFile(String database)
    {
        this.database = database;
    }

    public String toString()
    {
        return "gov.bid.chhuonnat.models.Database [database=" + this.database + "]";
    }
}