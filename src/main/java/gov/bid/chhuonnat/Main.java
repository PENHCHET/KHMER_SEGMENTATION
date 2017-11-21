package gov.bid.chhuonnat;

/**
 * Created by HP1 on 5/18/2017.
 */
public class Main {

    public static void main(String args[]){
        String strs[] = "ការ\u200Bផ្សាយ\u200Bផ្ទាល់\u200Bកម្មវិធី\u200Bព័ត៌មាន\u200Bម៉ោង\u200B១\u200Bរសៀល\u200B\u200Bរបស់\u200Bវិទ្យុ\u200Bបារាំង\u200Bអន្ដរជាតិ".split("\u200B");
        for(String str: strs){
            System.out.println(str);
        }
    }
}
