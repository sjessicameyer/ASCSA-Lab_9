# Lab 9
### Cipher

#### Objective: 
Creating a Data Record Class, learn about comparing objects and decrypt a hidden message 

A coded message has been prepared using a standard, constant key replacement technique.  For every letter in the original, un-coded message a different letter is chosen and the replacement letter is substituted in every position the original letter appears.  For example, the message COMPUTER SCIENCE may be encoded as: MQWLDXZG YMUZKMZ.   
 
A solution to the code makes use of a feature of written English called "letter frequency."  The frequency with which certain letters appear is relatively constant, with the letter ‘E’ appearing most frequently and the letter ‘Z’ appearing least frequently.  

The frequency chart is given here:  E T A O N R I S H D L F C M U G Y P W B V K X J Q Z


**Part A:**
Write the code for a new class called ***Record*** to help you with this letter frequency cipher.  It should have private data members to hold the original letter, and the frequency of that letter.  Constructors to create an instance of a Record object, a default and at least one other are required.  You also must have appropriate helper methods to allow getting and setting all the data values.  Additionally write a toString method that returns in a reasonably descriptive format the orginal letter and the frequency.  We will use this for outputting in later steps. 

**Part B:**
In your main program create a built-in array of type ***Record*** and set it up with the alphabet and the appropriate frequency, hint:0.  Use one of your constructors.  Display the contents of your array using your toString method. Do NOT do this by writing out 26 statements for each Record in the array.


**Part C:**
Read in the text (“Cipher.txt”) count the number of times each letter occurs and track it using your array.  You should be able to accomplish this task in one pass through the file, and **without** looping through the array either.  

**Part D:**
We will now Sort the Record array by frequency and show that you have succeeded by printing out each letter alongside the appropriate frequency.  To do this efficiently we will use Arrays.sort(), but that requires making the Record class Comparable and adding a compareTo method and an equals method.  This will allow you to sort your Records by frequency in descending order. 

**Part E:**
The replacement letter sequence listed above is only accurate for much larger text documents.  The actual frequency chart for our coded message “Cipher.txt” is stored in “Replace.txt” and is this:  E T A H O S I N R D B L M W G U C Y F J K V P X Q Z

Modify your Record class once again by adding an additional data field so that each of the read-in letters would be associated with the above frequency list.  Remember to add the helper methods needed, and update your toString method.  

**Part F:**
Now we want to re-sort your Record array alphabetically by the original letter and show that it is correct by displaying the original letter, it’s frequency and it’s replacement letter.  Accomplishing this task requires us to create a couple of custom Comparators that will allow you to sort the Record array into alphabetical order.  These should be done for the originalLetter and the replacementLetter. Create your own RecordComparator class with constructors and appropriate compare method.

**Part G:**
Finally, using your Record array, read in Cipher.txt finding the original letter and printing out the replacement letter, therefore outputting the un-coded message.  Leave all punctuation as it is when outputting the text.  Uh, Oh. The text is not quite correct.  You probably have some duplicate frequencies.

**Part H:**
Handling the duplicate frequency occurrences.  Display several, in the four range, lines of the decrypted message and allow the user to select between their associated letters to create a valid message.  Repeat this process until the user is satisfied with the result.  Once the message is correctly decrypted, print it out and write the correct message to a text file.  Also print out the corrected Record array with the replacement letters swapped as necessary. 
Do NOT ask the user one letter at a time if they want the use letter R or letter T, rather give them a paragraph or a few lines of text to help them with the context of choosing one letter over the other. Each letter ALWAYS maps to the same letter so if you decide A becomes X it needs to be X everywhere there is no decision per letter.

### Scoring Guide

| Requirement | Possible Points |
| :---        |    :----:   | 
| On time submission | 4 | 
| Header filled in with name, block, etc. | 2 |
| Correctly uploaded zipped replit project to Google Classroom | 2 |
| Properly create the Record class meeting all specs | 5 |
| Properly create and fill the  built-in Array of Records | 5 |
| Properly read through the text file counting frequencies and updating your Array. | 5 |
| Properly print the alphabet from the Array with frequencies | 2 |
| Properly sort the Array of Records by frequency and display | 3 |
| Properly modify Record class by adding a field for replacement letter | 3 |
| Properly read in the replacement letters into the Array - and display the record array again sorted alphabetically | 2 |
| Properly output the decrypted text | 3 |
| Properly create a way to handle duplicate frequencies | 3 |
| Properly correct the Array and output the solution to a text file | 5 |
| Properly create ways to Compare your Record class and optimize your code to use them | 6 |
| **Total:** | **50** |

***  