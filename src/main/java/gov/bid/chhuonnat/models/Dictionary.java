package gov.bid.chhuonnat.models; /**
 * Created by HP1 on 5/13/2017.
 */
import com.sun.org.apache.xpath.internal.compiler.Keywords;

import java.io.Serializable;
import java.util.ArrayList;

public class Dictionary
        implements Serializable
{
    ArrayList<Word> dictionary = null;
    ArrayList<String> keywords = null;

    public Dictionary()
    {
        this.dictionary = new ArrayList();
        this.keywords = new ArrayList<String>();

    }

    public void setDictionary(ArrayList<Word> dictionary)
    {
        this.dictionary = dictionary;
    }

    public ArrayList<Word> getDictionary()
    {
        return this.dictionary;
    }

    public ArrayList<String> getKeywords(){
        for(Word word: dictionary){
            this.keywords.add(word.getKeyword());
        }
        return this.keywords;
    }

    public String toString()
    {
        String dictionary = "";
        for (int wordIndex = 0; wordIndex < this.dictionary.size(); wordIndex++) {
            dictionary = dictionary + ((Word)this.dictionary.get(wordIndex)).toString() + "\r";
        }
        return dictionary;
    }
}

