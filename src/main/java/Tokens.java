//Лосик Олеси, 7 группа
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Tokens {
    ArrayList<String> Leks;
    Tokens(String input)
    {
        String delimiters2 = ";_-";
        String[] inputSplitted = input.split(delimiters2);
        Leks=new ArrayList<>();
        Leks.addAll(Arrays.asList(inputSplitted));
    }

    public Tokens() {
        Leks=new ArrayList<>();
    }

    @Override
    public String toString() {
        String result="";
        int count=1;
        for(String a : Leks)
        {
            result=result+" leks number:" + count + " " +a;
        }
        return result;
    }
    public int compareTo(Tokens cont) // CompareFirstLeks
    {
        return Leks.get(0).compareTo(cont.Leks.get(0));
    }
    static class SentenceComparator implements Comparator<Tokens>
    {

        public int compare(Tokens sentence1, Tokens sentence2)
        {
            return sentence1.Leks.get(0).compareTo(sentence2.Leks.get(0));
        }
    }
    public void ToXML(ArrayList<String> leks) throws FileNotFoundException {
        Tokens a=new Tokens();
        a.Leks=leks;
        FileOutputStream fos1 = new FileOutputStream("rezultxml.xml");
        java.beans.XMLEncoder xe1 = new java.beans.XMLEncoder(fos1);
        xe1.writeObject(a);
        xe1.close();
    }
}
