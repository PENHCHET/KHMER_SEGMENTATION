package gov.bid.chhuonnat.models;

/**
 * Created by HP1 on 5/18/2017.
 */
public class Encryption {
    public static String encryptToString(String string)
    {
        String temp = "";
        for (int index = 0; index < string.length(); index++) {
            temp = temp + Character.reverseBytes(string.charAt(index));
        }
        return temp;
    }

    public static String decryptToString(String string)
    {
        String temp = "";
        for (int index = 0; index < string.length(); index++) {
            temp = temp + Character.reverseBytes(string.charAt(index));
        }
        return temp;
    }

    public static char encryptToChar(char ch)
    {
        return Character.reverseBytes(ch);
    }

    public static char decryptToChar(char ch)
    {
        return Character.reverseBytes(ch);
    }
}
