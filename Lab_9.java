/** Heading  **********************************************/
/*	Your name:
		Class block: 				Date Started:
		Lab Number:
		Title:
		Purpose:
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Lab_9{

  private static Scanner input;
  
  public Lab_9(){

    //create list of records for each letter
    Record[] record = new Record[26];
    char nextChar = 'A'; //counter variable
    for (int i = 0; i<26;i++,nextChar++){
      record[i]=new Record(nextChar,0);
      System.out.println(record[i].toString());
    }

    //set up scanner
    File file = new File("Cipher.txt");
    try{
      input=new Scanner(file);
    }catch(FileNotFoundException ex){
      System.out.println("Could not open "+file.getName()+".");
      System.exit(1);
    }

    while(input.hasNext()){
      String word = input.next();
      for (var i = 0; i<word.length();i++){
        int position = word.charAt(i)-'A';
        if (position>=0 && position<=25){
          record[position].setOrigLetterFreq(record[position].getOrigLetterFreq()+1);
        }
      }
    
    }
    input.close();
    
    Arrays.sort(record);
    
    for (int i = 0; i<26;i++,nextChar++){
      System.out.println(record[i].toString());
    }

    //add letters from freq chart into record 

    File replaceFile = new File("Replace.txt");
    try{
      input=new Scanner(replaceFile);
    }catch(FileNotFoundException ex){
      System.out.println("Could not open "+replaceFile.getName()+".");
      System.exit(1);
    }

   int x = 0; //counter variable
    while(input.hasNext()){
      record[x].setActLetter(input.next().charAt(0));
      x++;
    }
    input.close();  

    //use recordComparator to sort by origChar
    Arrays.sort(record, new RecordComparator("origChar"));
    
    for (int i = 0; i<26;i++,nextChar++){
      System.out.println(record[i].toString());
    }

    //read in Cipher.txt and print out replacement letter
    
    try{
      input=new Scanner(file);
    }catch(FileNotFoundException ex){
      System.out.println("Could not open "+file.getName()+".");
      System.exit(1);
    }

    while(input.hasNextLine()){
      String word = input.nextLine();
      for (var i = 0; i<word.length();i++){
        int position = word.charAt(i)-'A';
        if (position>=0 && position<=25){
          System.out.print(record[position].actLetter);
        }
        else{
          System.out.print(word.charAt(i));
        }
        System.out.println();
      }
    }
    input.close();

  }
}