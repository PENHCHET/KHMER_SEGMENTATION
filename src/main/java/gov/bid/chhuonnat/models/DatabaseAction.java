package gov.bid.chhuonnat.models;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by HP1 on 5/13/2017.
 */
public class DatabaseAction
{
    private String currentDatabase = null;

    public DatabaseAction()
    {
        this.currentDatabase = "/gov/bid/chhuonnat/libs/dbs/dictionary";
    }

    public Dictionary dbReader()
    {
        Dictionary dictionary = new Dictionary();
        ArrayList<Word> list = new ArrayList();
        try
        {
            InputStream is = getClass().getResourceAsStream("/dictionary");
            ObjectInputStream ois = new ObjectInputStream(is);
            Word temp = null;
            while ((temp = (Word) ois.readObject()) != null)
            {
                temp.decrypt();
                list.add(temp);
            }
            ois.close();
            ois = null;
            dictionary.setDictionary(list);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return dictionary;
    }

    public int dbWriter(Dictionary dictionary)
    {
        try
        {
            URL url = getClass().getResource("/gov/bid/chhuonnat/libs/dbs/dictionary");

            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(url.getFile()));

            ArrayList<Word> list = dictionary.getDictionary();
            Word temp = null;
            for (int index = 0; index < list.size(); index++)
            {
                temp = (Word)list.get(index);
                temp.encrypt();
                writer.writeObject(temp);
            }
            writer.writeObject(null);
            writer.flush();
            writer.close();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            return 0;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public static void main(String[] args)
    {
        DatabaseAction da = new DatabaseAction();
        Dictionary dictionary = da.dbReader();

        System.out.println(dictionary.getDictionary().size());

        for(Word word: dictionary.getDictionary()){
            System.out.println(word.getKeyword());
        }

        System.out.println(dictionary.getDictionary().get(dictionary.getDictionary().size()-1).getKeyword());
    }
}
