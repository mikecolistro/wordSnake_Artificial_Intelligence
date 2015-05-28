
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Michael
 */
public class Wordsnake {
    
    public static void main(String[] args) throws IOException{
           
        ArrayList words = new ArrayList();
        String currentWord;
        int numOfWords = getLength();
        int Min = 0;
        int currentIndex = Min + (int)(Math.random() * ((numOfWords - 1 - Min) + 1));
        words = readFile(words);
        currentWord = (String) words.get(currentIndex);
       // currentWord = "invent";
        System.out.println(currentWord);
        System.out.println("Overlap\tScore\tTotal\tWords");
        scanList(currentWord,words,numOfWords,0);
        
        }
    
    public static void scanList(String currentWord,ArrayList words,int numOfWords,int score){
        int matchCount = 0;
        //currentWord = "lasting";
        ArrayList matches = new ArrayList();
        ArrayList matchesValue = new ArrayList();
        String newWord = "";
        boolean Flag =  false;
        int value = currentWord.length(),check = 0;
        if(!words.isEmpty()){
            //System.out.println(Flag);
            while (value != 0){
                for(int i = 0; i < numOfWords;i++){

                    if(value > words.get(i).toString().length()){
                        check = words.get(i).toString().length();
                    }
                    else{
                        check = value;
                    }
                    if((currentWord.substring(currentWord.length() - value).equals(words.get(i).toString().substring(0, check)))&&(matches.contains(words.get(i).toString()) == false)&&(!currentWord.equals(words.get(i).toString()))){

                        System.out.print(currentWord.substring(currentWord.length() - value).toUpperCase().length());
                        score = score + (currentWord.substring(currentWord.length() - value).toUpperCase().length() * currentWord.substring(currentWord.length() - value).toUpperCase().length());
                        System.out.print("\t" + currentWord.substring(currentWord.length() - value).toUpperCase().length() * currentWord.substring(currentWord.length() - value).toUpperCase().length());
                        System.out.print("\t" + score + "\t");

                        System.out.print(currentWord.substring(0,currentWord.length() - value));
                        System.out.print(" ");
                        System.out.print(currentWord.substring(currentWord.length() - value).toUpperCase());
                        System.out.print(" ");
                        System.out.print(words.get(i).toString().substring(check, words.get(i).toString().length()));

                        System.out.println();
                        matchesValue.add(currentWord.substring(currentWord.length() - value).toUpperCase().length());
                        matches.add(words.get(i));
                        newWord = words.get(i).toString();
                        words.remove(i);
                        Flag = true;
                        matchCount++;
                        value = 0;
                        break;
                    }
                }
                if(value == 0){
                    break;
                }
                value--;
            }
            //System.out.println("newWord is: " + newWord);
            if(Flag == false){
                return;
            }
            scanList(newWord,words,words.size(),score);
        }
        else{
            return;
        }
        //printNodes(words);
        
    }
    
   
    
    
    public static int getLength() throws IOException{
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
        
        br.close();
        return counter;
    }
    public static ArrayList readFile(ArrayList words) throws FileNotFoundException, IOException{
        String scan;
        int counter = 0;
        FileReader file;
        try{
        file = new FileReader("words.txt");
        }catch(IOException e){
            return null;
        }
        BufferedReader br = new BufferedReader(file);
        while((scan = br.readLine()) != null)
                {
                    words.add(scan);
                    counter++;
            //System.out.println(scan);
                }
        br.close();
        return words;

    }
    public static void printNodes(ArrayList words){
        for(int i=0;i<words.size();i++){
            System.out.println(words.get(i));
        }
    }
}
