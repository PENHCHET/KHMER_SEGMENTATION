package gov.bid.chhuonnat.models;

import java.util.*;

/**
 * Created by HP1 on 5/12/2017.
 */
public class KhmerWordBreakHelper {

    public static List<String> wordBreak(String s, Set<String> dict) {
        //create an array of ArrayList<String>
        List<String> dp[] = new ArrayList[s.length() + 1];
        dp[0] = new ArrayList<String>();

        for (int i = 0; i < s.length(); i++) {
            if (dp[i] == null)
                continue;

            for (String word : dict) {
                int len = word.length();
                int end = i + len;
                if (end > s.length())
                    continue;

                if (s.substring(i, end).equals(word)) {
                    //System.out.println(end);
                    if (dp[end] == null) {
                        dp[end] = new ArrayList<String>();
                    }
                    dp[end].add(word);
                }
            }
        }

        System.out.println();

        List<String> result = new LinkedList<String>();
        if (dp[s.length()] == null)
            return result;

        ArrayList<String> temp = new ArrayList<String>();
        dfs(dp, s.length(), result, temp);

        return result;
    }

    public static void dfs(List<String> dp[], int end, List<String> result, ArrayList<String> tmp) {
        if (end <= 0) {
            String path = tmp.get(tmp.size() - 1);
            for (int i = tmp.size() - 2; i >= 0; i--) {
                path += " " + tmp.get(i);
            }

            result.add(path);
            return;
        }

        for (String str : dp[end]) {
            tmp.add(str);
            dfs(dp, end - str.length(), result, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String args[]) {
        String s = "ប្រទេសចិនបានបើកការដ្ឋាន";
        Set<String> dict = new HashSet<String>();

        dict.add("ប្រទេស");
        dict.add("ចិន");
        dict.add("បាន");
        dict.add("បើក");
        dict.add("ការ");
        dict.add("ដ្ឋាន");
        dict.add("ការដ្ឋាន");

        String dicts[] = "អ្នក\u200Bផលិត\u200Bវីដេអូ\u200Bឈ្មោះ\u200B Jamie Scott \u200Bធ្លាប់\u200Bទទួល\u200Bបាន\u200Bភាព\u200B\u200B\u200B\u200Bល្បី\u200Bល្បាញ\u200Bតាម\u200Bរយៈ\u200Bវីដេអូ\u200B Timelapse នៃ\u200B Central Park ដែល\u200Bប្រើ\u200Bពេល\u200B ៦ ខែ\u200Bដើម្បី\u200Bថត\u200Bបាន។ ឥឡូវ\u200Bនេះ\u200B\u200Bគាត់\u200Bបាន\u200B\u200Bបង្ហាញស្នាដៃ\u200Bថ្មី\u200B\u200Bមួយ\u200Bទៀត\u200Bដែល\u200Bជា\u200Bវីដេអូ\u200B Timelapse មាន\u200Bចំណង\u200Bជើង\u200Bថា\u200B \"Spring”".replaceAll("។ ", "។ \n").split("\u200B");
        for (String str : dicts) {
            if (str.trim().equals("")) {
                continue;
            }
            System.out.println(str);
            dict.add(str.trim());
        }

        System.out.println(dict);

        KhmerWordBreakHelper wordBreakHelper = new KhmerWordBreakHelper();
        List<String> strs = wordBreakHelper.wordBreak(s, dict);
        System.out.println(strs);

    }

}
