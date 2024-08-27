package homework;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"all"})
public class homework3 {
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        hm.put("jack",650);
        hm.put("tom",1600);
        hm.put("jack",2600);
        System.out.println(hm);
        Set set = hm.keySet();
        for(Object o : set) {
            hm.put(o,(Integer)hm.get(o)+100);
        }
        System.out.println(hm);

        Set set2 = hm.entrySet();
        Iterator it = set2.iterator();
        while(it.hasNext()) {
              Map.Entry map =(Map.Entry)it.next();
              System.out.println(map.getKey() + ":" + map.getValue());
        }
        for(Object o : hm.values()) {
            System.out.println(o);

        }
    }
}

