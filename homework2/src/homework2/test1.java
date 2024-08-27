package homework2;

import java.io.FileWriter;

public class test1 {
    public static void main(String[] args) {
        bufferedreader bufferedreader = new bufferedreader(new filereader()) ;
        bufferedreader.readfiles(10);

        bufferedreader bufferedreader1 = new bufferedreader(new Stringreader()) ;
        bufferedreader1.readString(10);
    }
}
