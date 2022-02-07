import java.nio.MappedByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class hash2 {
    public static void main(String[] args) {
        HashMap<Integer, String> h = new HashMap<>(10);

        h.put(12, "zak");
        h.put(13, "aabid");
        h.put(15, "hif");
        h.put(14, "aquib");
        h.put(16, "hamza");

        //Set interfac is a Collection of non repeated 
        //below Set reference s store all the enter element of h 
        // by using generic Map.Entry we can store all the key and value pair ins Set

        Set<Map.Entry<Integer, String>> e = h.entrySet();
        for (Map.Entry<Integer, String> entry : e) {
            System.out.println("key =" + entry.getKey() + "  " + "vlaue =" + entry.getValue());

        }


        // h.clear()
        // h.remove(12, 7);

        // System.out.println(h);
        // System.out.println(h.isEmpty());
        // HashSet<Integer> h=new HashSet<>(10);


        // h.add(12);
        // h.add(13);
        // h.add(14);
        // h.add(15);
        // h.add(16);
        // h.add(17);
        // h.add(18);
        // h.add(19);
        // h.add(10);
        // h.add(11);
        // h.add(21);
        // h.add(22);


        // System.out.println(h);


    }
}
