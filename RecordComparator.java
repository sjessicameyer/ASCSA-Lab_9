import java.util.Comparator;

public class RecordComparator implements Comparator<Record>{

  private String sortType;

  public RecordComparator(){
    sortType = "Freq";
  }

  public RecordComparator(String sortBy){
    sortType = sortBy;
  }

  public int compare(Record A, Record B)
  {
    if(sortType.equals("Freq"))
      return B.getOrigLetterFreq()-A.getOrigLetterFreq();
    else if(sortType == "origChar")
      return A.getOrigLetter()-B.getOrigLetter();
    return 0;
  }
}