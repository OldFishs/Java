package homework2;


//做成处理流（包装流）：高级操作
public class bufferedreader extends Reader{

    private Reader reader;

    public bufferedreader(Reader reader) {
        this.reader = reader;
    }

    //让方法更灵活 多次处理数据
    public void readfiles(int nums){

            for (int i = 0; i < nums; i++) {
                reader.readfile();
            }


    }

    public void readString(int nums){

        for (int i = 0; i < nums; i++) {
            reader.readstring();
        }


    }
}
