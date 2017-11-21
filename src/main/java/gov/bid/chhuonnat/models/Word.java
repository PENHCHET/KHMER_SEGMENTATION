package gov.bid.chhuonnat.models; /**
 * Created by HP1 on 5/13/2017.
 */
import java.io.Serializable;
import java.util.ArrayList;

public class Word
        implements Serializable
{
    private Integer Id = null;
    private String keyword = null;
    private ArrayList<PartOfSpeech> pos = null;
    private boolean encrypted = false;

    public Word() {}

    public Word(Integer id, String keyword)
    {
        this.Id = id;
        this.keyword = keyword;
        this.pos = new ArrayList();
    }

    public Word(Integer id, String keyword, ArrayList<PartOfSpeech> listPos)
    {
        this.Id = id;
        this.keyword = keyword;
        this.pos = listPos;
    }

    public Integer getId()
    {
        return this.Id;
    }

    public void setId(Integer id)
    {
        this.Id = id;
    }

    public String getKeyword()
    {
        return this.keyword;
    }

    public void setKeyword(String keyword)
    {
        this.keyword = keyword;
    }

    public ArrayList<PartOfSpeech> getListPos()
    {
        return this.pos;
    }

    public void setPos(ArrayList<PartOfSpeech> listPos)
    {
        this.pos = listPos;
    }

    public void decrypt()
    {
        this.encrypted = false;
        this.keyword = Encryption.decryptToString(this.keyword);
        //System.out.println(keyword);
        for (int index = 0; index < this.pos.size(); index++) {
            ((PartOfSpeech)this.pos.get(index)).decrypt();
        }
    }

    public void encrypt()
    {
        this.encrypted = true;
        this.keyword = Encryption.encryptToString(this.keyword);
        for (int index = 0; index < this.pos.size(); index++) {
            ((PartOfSpeech)this.pos.get(index)).encrypt();
        }
    }

    public void addPos(PartOfSpeech pos)
    {
        this.pos.add(pos);
    }

    public PartOfSpeech remove(PartOfSpeech pos)
    {
        for (int index = 0; index < this.pos.size(); index++) {
            if (((PartOfSpeech)this.pos.get(index)).equals(pos)) {
                return (PartOfSpeech)this.pos.remove(index);
            }
        }
        return null;
    }

    public String getDescription()
    {
        String temp = "";
        for (int index = 0; index < this.pos.size(); index++) {
            temp = temp + ((PartOfSpeech)this.pos.get(index)).getMeanning() + "<br/>";
        }
        return temp;
    }

    public String toString()
    {
        String temp = "gov.bid.chhuonnat.models.Word [Id=" + this.Id + ", keyword=" + this.keyword;
        for (int index = 0; index < this.pos.size(); index++) {
            temp = temp + "\r" + ((PartOfSpeech)this.pos.get(index)).toString() + "\r";
        }
        return temp + "];";
    }
}
