package homework;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public class homework1 {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(new news("wdtttttfadsfsdfadsfsdfdsf","ewdsagas"));
        list.add(new news("wdtttttddddddddddddddd","eqwffdaf"));
        int size = list.size();
        for(int i = size-1; i >= 0; i--) {
            news news1 = (news)list.get(i);
            System.out.println(test(news1.getTitle()));

        }
    }
    public static String test(String a){
        if(a.length()>15){
            return a.substring(0,15) + "...";
        }else{
            return a;
        }

    }
}

class news{
    private String title;
    private String conment;

    public news(String title, String conment) {
        this.title = title;
        this.conment = conment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConment() {
        return conment;
    }

    public void setConment(String conment) {
        this.conment = conment;
    }

    @Override
    public String toString() {
        return "news{" +
                "title='" + title + "'";
    }
}
