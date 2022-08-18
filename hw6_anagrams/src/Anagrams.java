//CS570 hw6 Alden Park 

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Anagrams {

    //prime numbers initialized
    final Integer[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
        67, 71, 73, 79, 83, 89, 97, 101};

    Map<Character, Integer> letterTable;
    Map<Long, ArrayList<String>> anagramTable;

    //constructors

    public Anagrams() {
        letterTable = new HashMap<Character, Integer>();
        buildLetterTable();
        anagramTable = new HashMap<Long, ArrayList<String>>();

    }

    private void buildLetterTable() {
        Character[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't','u','v','w','x','y','z'};
        //iterate through each letter and links them to the corresponding prime number
        for (int i = 0; i<26; i++) {
            letterTable.put(alphabet[i], primes[i]);
        }
    }

    //compute hascode of the string and add to hastable
    private void addWord(String s) {
        if (anagramTable.containsKey(myHashCode(s))) {
            ArrayList<String> temp = anagramTable.get(myHashCode(s));
            temp.add(s);
            anagramTable.replace(myHashCode(s), temp);
        } else {
            ArrayList<String> temp = new ArrayList<String>();
            temp.add(s);
            anagramTable.put(myHashCode(s), temp);
        }
    }

    //get the unique hascode number 
    private Long myHashCode(String s) {
        int i = 0;
        long value = 1;
        while (i < s.length()) {
            Character a = s.charAt(i);
            value = value * letterTable.get(a);
            i++;
        }
        return value;
    }
    
    //get the input from external file and read
    public void processFile(String s) throws IOException {
        //grab the file for input
        FileInputStream fstream = new FileInputStream(s);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;

        //reads through file 
        while ((strLine = br.readLine()) != null) {
            this.addWord(strLine);
        }
        br.close();
    }

    //get the max amount of entries
    private ArrayList<Map.Entry<Long, ArrayList<String>>> getMaxEntries() {
        ArrayList<Map.Entry<Long, ArrayList<String>>> entries = new ArrayList<Map.Entry<Long, ArrayList<String>>>();
        int max = 0;

        for (Map.Entry<Long, ArrayList<String>> entry : anagramTable.entrySet()) {
            if (entry.getValue().size() > max) {
                entries.clear();
                entries.add(entry);
                max = entry.getValue().size();
        } 
        else if(entry.getValue().size() < max) {
            continue;
        } else {
            if (entry.getValue().size() == max) {
                entries.add(entry);
                }
            }
        }
        return entries;
    }

    //main 
    public static void main(String[] args) {
        Anagrams a = new Anagrams();

        final long startTime = System.nanoTime();
        try {
            a.processFile("words_alpha.txt");
        } catch (IOException e1) {
            e1.printStackTrace();
        }

        ArrayList <Map.Entry<Long, ArrayList<String>>> maxEntries = a.getMaxEntries();
        final long estimatedTime = System.nanoTime() - startTime;
        final double seconds = ((double)estimatedTime / 1000000000);
        long key = maxEntries.get(0).getKey();
        int length = maxEntries.get(0).getValue().size();

        //note to the teacher: output variables differ from the "expected" output and the code given on the assignment sheet.
        System.out.println("Elapsed Time: " + seconds);
        System.out.println("Key of max anagrams: " + key);
        System.out.println("List of max anagrams: " + maxEntries);
        System.out.println("Length of list of max anagrams: " + length);
    }
}
