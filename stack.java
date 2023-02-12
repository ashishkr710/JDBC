import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Stack;

public class stak {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(12);
        st.push(45);
        st.push(48);
        st.push(41);

        st.remove(3);
        st.peek();
        System.out.println(st.peek());

        System.out.println(st);

        System.out.println("-----------Hash Map---------");

        HashMap<String,Integer> hm = new HashMap<>();
        hm.put("a",5);
        hm.put("b",4);
        hm.put("c",3);
        hm.put("d",2);
        hm.put("f",55);
        hm.remove("b",4);
        hm.remove("a");
        System.out.println(hm.keySet());
        System.out.println(hm.values());
        System.out.println( hm.get("d"));


    }
}
