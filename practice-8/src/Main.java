import com.sun.security.jgss.GSSUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        IWaitList<String> waitList = new WaitList<>();
        String ivan = "ivan", petr = "Petr";
        waitList.add(ivan);
        waitList.add(petr);
        waitList.add("Vladimir");
        System.out.println(waitList.contains(ivan));
        System.out.println(waitList.contains("Nikolay"));
        System.out.println(waitList.containsAll(Arrays.asList(ivan, petr)));
        System.out.println(waitList.containsAll(Arrays.asList(ivan, "Nikolay")));
        System.out.println(waitList);
        waitList.remove();
        System.out.println(waitList);
        System.out.println(waitList.remove());
        System.out.println("---------------");
        BoundedWaitList<String> boundedWaitList = new BoundedWaitList<>(2);
        boundedWaitList.add("Ivan");
        boundedWaitList.add("Petr");
        System.out.println(boundedWaitList);
        boundedWaitList.add("Vladimir");
        System.out.println(boundedWaitList);
        System.out.println("---------------");
        UnfairWaitList<String> unfairWaitList = new UnfairWaitList<>();
        unfairWaitList.add(ivan);
        unfairWaitList.add(petr);
        unfairWaitList.add("Vladimir");
        System.out.println(unfairWaitList);
        unfairWaitList.remove(ivan);
        System.out.println(unfairWaitList);
        unfairWaitList.moveToBack(petr);
        System.out.println(unfairWaitList);
    }
}