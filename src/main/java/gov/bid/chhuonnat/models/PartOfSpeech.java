package gov.bid.chhuonnat.models; /**
 * Created by HP1 on 5/13/2017.
 */

import java.io.Serializable;

public class PartOfSpeech
        implements Serializable
{
    private Integer id = null;
    private String pos = null;
    private String meanning = null;
    private boolean encrypted = false;

    public PartOfSpeech() {}

    public PartOfSpeech(Integer id, String pos, String meanning)
    {
        this.id = id;
        this.pos = pos;
        this.meanning = meanning;
    }

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getPos()
    {
        return this.pos;
    }

    public void setPos(String pos)
    {
        this.pos = pos;
    }

    public String getMeanning()
    {
        return this.meanning;
    }

    public void setMeanning(String meanning)
    {
        this.meanning = meanning;
    }

    public void decrypt()
    {
        this.encrypted = false;
        this.pos = Encryption.decryptToString(this.pos);
        this.meanning = Encryption.decryptToString(this.meanning);
    }

    public void encrypt()
    {
        this.encrypted = true;
        this.pos = Encryption.encryptToString(this.pos);
        this.meanning = Encryption.encryptToString(this.meanning);
    }

    public String toString()
    {
        return "gov.bid.chhuonnat.models.PartOfSpeech [id=" + this.id + ", pos=" + this.pos + ", meanning=" + this.meanning + "]";
    }
}

