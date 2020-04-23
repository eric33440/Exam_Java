import java.io.*;
import java.util.*;

class occurence {
    public static void main(String[] argv) throws IOException {
        Hashtable Hshtble = new Hashtable();
        BufferedReader test = new BufferedReader(new FileReader("test.txt"));
        String line, word;
        StringTokenizer tokenizer;
        int number;
        
        while ((line = test.readLine()) != null) {		

        	tokenizer = new StringTokenizer(line, "");
        	
            while (tokenizer.hasMoreTokens()) {
            	word = tokenizer.nextToken();
                if (Hshtble.containsKey(word)) {
                	number = ((Integer) Hshtble.get(word)).intValue();
                	number++;
                } else
                	number = 1;
                Hshtble.put(word, new Integer(number));
            }
        }

        Enumeration words = Hshtble.keys();
        while (words.hasMoreElements()) {
        	word = (String) words.nextElement();
            number = ((Integer) Hshtble.get(word)).intValue();
            System.out.println("Le mot " + word + " figure " + number + " fois");
        }
    }
}