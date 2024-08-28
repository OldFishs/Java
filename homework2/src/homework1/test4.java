package homework1;

import java.io.FileWriter;
import java.io.IOException;

public class test4 {
    public static void main(String[] args) {
        String path = "d:\\note.txt";
        FileWriter fw = null;
        char chars[] = {'a','b','c'};

        try {
            /*
            1)write(int):写入单个字符
            2)write(char[]):写入指定数组
            3)write(char[],off,len):写入指定数组的指定部分
            4)write(string):写入指定字符串
            5)write(string,off,len):写入指定字符串指定部分
            */

            fw = new FileWriter(path);
            fw.write('H');
            fw.write(chars);
            fw.write("北京天津".toCharArray(),0,3);
            fw.write("write");
            fw.write("上海台南",0,2);

        } catch (IOException e) {
            e.printStackTrace();
        }finally{

            try {
                fw.close();

                //close等于flush + end
                /* private void writeBytes() throws IOException {
                        this.bb.flip();
                        int var1 = this.bb.limit();
                        int var2 = this.bb.position();

                        assert var2 <= var1;

                        int var3 = var2 <= var1 ? var1 - var2 : 0;
                        if (var3 > 0) {
                            if (this.ch != null) {
                                assert this.ch.write(this.bb) == var3 : var3;
                            } else {
                                this.out.write(this.bb.array(), this.bb.arrayOffset() + var2, var3);
                            }
                        }

                        this.bb.clear();
                    }*/

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
