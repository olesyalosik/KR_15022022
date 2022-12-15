//Лосик Олеси, 7 группа
import java.io.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;


public class SentenceBD {
    ArrayList<Tokens> SentenceList;
    SentenceBD(String input)
    {

        String delimiters1 = "?!.";
        String[] inputSplitted = input.split(delimiters1);
        SentenceList=new ArrayList<>();
        ArrayList<String> tmp = new ArrayList<>();
        tmp.addAll(Arrays.asList(inputSplitted));
        for( String a : tmp)
        {
           Tokens tmp1= new Tokens(a);
           SentenceList.add(tmp1);
        }
    }

    public void add(Tokens tokens){
        SentenceList.add(tokens);
    }

    public SentenceBD() {
        SentenceList=new ArrayList<>();
    }

    String ReadFromFile (String filename) throws FileNotFoundException
    {
        FileReader buf = new FileReader(filename);
        BufferedReader fileIn = new BufferedReader(buf);
        String input="", tmp;
        try
        {
            while(true)
            {
                tmp = fileIn.readLine();
                if (tmp == null)
                {break;}
                input+=tmp;
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        return input;
    }
    void FindBigDecimal(ArrayList <Tokens> List) throws ParseException, IOException {
        FileWriter file1txt = new FileWriter("rezult2.txt", true);
        BufferedWriter soutresult = new BufferedWriter(file1txt);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        String pattern = "#,##0.0#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);

            for (Tokens a : List)
            {
                for (String b : a.Leks)
                {
                try
                {
                        BigDecimal tmp = (BigDecimal) decimalFormat.parse(b);
                    System.out.println(b + "\n");
                }
                catch (ParseException e)
                {
                    continue;
                }
            }

        BigDecimal bigDecimal = (BigDecimal) decimalFormat.parse("10,692,467,440,017.120");
        System.out.println(bigDecimal);
    }
}
public void MySort()
{
    Comparator<Tokens> compare;
    compare = new Tokens.SentenceComparator();
    SentenceList.sort(compare);
}
public void ToXML(ArrayList<Tokens> sentences) throws FileNotFoundException {
        SentenceBD a=new SentenceBD();
        a.SentenceList=sentences;
        FileOutputStream fos1 = new FileOutputStream("rezultxml.xml");
        java.beans.XMLEncoder xe1 = new java.beans.XMLEncoder(fos1);
        xe1.writeObject(a);
        xe1.close();
    }

}
