
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Graph {
    String[] words;
    int numOfWords = 0;
    public Graph(){
        
    }
    public int makeGraph() throws IOException{
        String contents = readFile("words.txt");
        System.out.println(contents);
        if (contents == "-1"){
            return -1;
        }
        System.out.println(contents);
        return 0;
    }
    public void getLength() throws IOException{
        FileReader file2 = null;
        int counter = 0;
        String scan;
        try{
        file2 = new FileReader("words.txt");
        }catch(IOException e){
            System.out.println("gay");
        }
        BufferedReader br = new BufferedReader(file2);

        while((scan = br.readLine()) != null)
                {
                    
                    counter++;
            
                }
        words = new String[counter];
        numOfWords = counter;
        br.close();
    }
    public String readFile(String f) throws FileNotFoundException, IOException{
        String scan;
        int counter = 0;
        getLength();
        FileReader file;
        try{
        file = new FileReader("words.txt");
        }catch(IOException e){
            return "-1";
        }
        BufferedReader br = new BufferedReader(file);

        while((scan = br.readLine()) != null)
                {
                    words[counter] = scan;
                    counter++;
            //System.out.println(scan);
                }
        br.close();
        return " ";

    }
    public void printNodes(){
        for(int i=0;i<numOfWords;i++){
            System.out.println(words[i]);
        }
    }
}
