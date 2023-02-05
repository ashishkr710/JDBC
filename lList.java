import java.util.*;

public class lList {
    public static void main(String[] args) {
        LinkedList<Integer> LL = new LinkedList<>();

        Scanner sc = new Scanner(System.in);


int Choice = sc.nextInt();
        switch(Choice){
            case 0 :
                System.out.println("ADD");

                break;
            case 1 :
                System.out.println("ADD First");
                break;
            case 2 :
                System.out.println("ADD Last");
                break;

        }

//        public void add(int x){
//
//
//        }

        LL.add(1122);
        LL.add(1242);
        LL.add(451);
        LL.addFirst(1542451);
        LL.addLast(451477);
        Collection<Integer> coll = new ArrayList<Integer>();
        coll.add(10);
        coll.add(20);
        coll.add(30);
        coll.add(40);
        coll.add(50);
        LL.addAll(coll);

//        LL.remove(1);
//        LL.removeFirst();
        LL.removeLast();
        LL.remove(2);

//        LL.size();
//        LL.retainAll(coll);


        for (Integer integer : LL) {
            System.out.println(integer);
        }
//        LL.retainAll(coll);

    }
}
