public class Record implements Comparable<Record>{
  private char origLetter;
  private int origLetterFreq;
  private char actLetter;

  //constructors
  public Record(){
    this.origLetter='a';
  }

  public Record(char letter){
    this.origLetter=letter;
  }

  public Record(char letter, int freq){
    this.origLetter=letter;
    this.origLetterFreq=freq;
  }

  //helper methods
  public char getOrigLetter(){
    return this.origLetter;
  }
  
  public void setOrigLetter(char letter){
    this.origLetter=letter;
  }

  public int getOrigLetterFreq(){
    return this.origLetterFreq;
  }

  public void setOrigLetterFreq(int freq){
    this.origLetterFreq=freq;
  }

  public int getActLetter(){
    return this.actLetter;
  }

  public void setActLetter(char letter){
    this.actLetter=letter;
  }

  public String toString(){
    if (actLetter=='\0'){
      return "The original letter is "+origLetter+" has a frequency of "+origLetterFreq+" in Cipher.txt.";
    }
    return "The original letter is "+origLetter+", has a frequency of "+origLetterFreq+" in Cipher.txt, and the actual letter is "+actLetter+".";
  }


  public boolean equals(Record that)
  {
    return this.origLetterFreq == that.origLetterFreq;
  }

  public int compareTo(Record that){
    return that.origLetterFreq - this.origLetterFreq;
  }

}