import java.util.function.Predicate;

public class CustomPredicateExample {
    public static void main(String[] args) {
        String s = " this string is null or not";
        Predicate<String> iPredicate = s1-> {
            System.out.println("s1->"+s);
            return s1 == null?true:false;
        };

        Predicate<String> iPredicate2 = s2-> {
            System.out.println("s2->"+s2);
            return s2.contains("Test");
        };

        //System.out.println(iPredicate.test(s));
        System.out.println(iPredicate.and(iPredicate2).test(s));

}
}
