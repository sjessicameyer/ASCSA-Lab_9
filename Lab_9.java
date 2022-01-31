/** Heading  Lab 9 **********************************************/
/*	Your name: Sarah Meyer
		Class block: 	G			Date Started: Jan ? 2022
		Lab Number: Lab 9
		Title: Cipher
		Purpose: Creating a Data Record Class, learn about comparing objects and decrypt a hidden message
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.io.PrintWriter;

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
    System.out.println();

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
      record[x].setRepLetter(input.next().charAt(0));
      x++;
    }
    input.close();  

    //use recordComparator to sort by origChar
    Arrays.sort(record, new RecordComparator("origChar"));
    
    for (int i = 0; i<26;i++,nextChar++){
      System.out.println(record[i].toString());
    }
    System.out.println();

    boolean keepPrompting = true;
    Scanner input2 = new Scanner(System.in);

    while (keepPrompting) {
      System.out.println();
      printDecrypted(record,4);
      System.out.println("Is the message correctly decrypted? y/n");
      if (input2.next().equals("y"))
        keepPrompting=false;
      else{
        System.out.println();
        System.out.println("What letter above would you like to swap?");
        char swapLetter = input2.next().charAt(0);
        int position = 0;
        while (record[position].getRepLetter()!=swapLetter)
          position++;
        System.out.println();
        System.out.print("Suggested letters to swap with are: ");
        for (Record letter : record){
          if (letter.getOrigLetterFreq() == record[position].getOrigLetterFreq()){
            System.out.print(letter.getRepLetter()+" ");
          }
        }
        System.out.println("\n");
        System.out.println("Which letter would you like to swap with?");
        char swapWithLetter = input2.next().charAt(0);
        
        int position2 = 0;
        while (record[position2].getRepLetter()!=swapWithLetter)
          position2++;
        
        record[position].setRepLetter(swapWithLetter);
        record[position2].setRepLetter(swapLetter);
      }
    }
    input2.close();

    System.out.println("\nFinal decrypted version: ");
    printDecrypted(record);
    saveDecrypted(record);
  }

  public void printDecrypted(Record[] record){
    //read in Cipher.txt and print out replacement letter

    Arrays.sort(record, new RecordComparator("origChar"));

    File file = new File("Cipher.txt");
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
          System.out.print(record[position].getRepLetter());
        }
        else{
          System.out.print(word.charAt(i));
        }
      }
      System.out.println();
    }
    System.out.println();
    input.close();
  }

  public void saveDecrypted(Record[] record){
    //read in Cipher.txt and write out replacement letter

    Arrays.sort(record, new RecordComparator("origChar"));

    File file = new File("Cipher.txt");
    try{
      input=new Scanner(file);
    }catch(FileNotFoundException ex){
      System.out.println("Could not open "+file.getName()+".");
      System.exit(1);
    }

    File file2= new File("Decrypted.txt");
    PrintWriter output = null;
	  try
	  {
		  output = new PrintWriter(file2);
	  }
	  catch (FileNotFoundException ex)
	  {
		  System.out.println("*** Cannot create " + "Decrypted.txt" + " ***");
		    System.exit(1);  // quit the program
	  }

    while(input.hasNextLine()){
      String word = input.nextLine();
      for (var i = 0; i<word.length();i++){
        int position = word.charAt(i)-'A';
        if (position>=0 && position<=25){
          output.print(record[position].getRepLetter());
        }
        else{
          output.print(word.charAt(i));
        }
      }
      output.println();
    }
    output.println();
    output.close();
    input.close();
  }

  public void printDecrypted(Record[] record, int numLines){
    //read in Cipher.txt and print out replacement letter

    Arrays.sort(record, new RecordComparator("origChar"));

    File file = new File("Cipher.txt");
    try{
      input=new Scanner(file);
    }catch(FileNotFoundException ex){
      System.out.println("Could not open "+file.getName()+".");
      System.exit(1);
    }
    int linesRead=0;
    while(input.hasNextLine()&&linesRead<numLines){
      String word = input.nextLine();
      for (var i = 0; i<word.length();i++){
        int position = word.charAt(i)-'A';
        if (position>=0 && position<=25){
          System.out.print(record[position].getRepLetter());
        }
        else{
          System.out.print(word.charAt(i));
        }
      }
      System.out.println();
      linesRead++;
    }
    System.out.println();
    input.close();
  }
}