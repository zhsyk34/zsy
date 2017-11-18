import de.ailis.pherialize.*;

public class PhpUn {

    public static void main(String[] args) {
        String s = "a:4:{i:0;s:2:\"13\";i:1;s:2:\"12\";i:2;s:2:\"11\";i:3;s:1:\"9\";}";

//        {0=13, 1=12, 2=11, 3=9}
        Mixed mixed = Pherialize.unserialize(s);
        System.out.println(mixed);

        MixedArray mixedArray = mixed.toArray();
        mixedArray.forEach((key, value) -> {
            System.out.println("------------");

            System.out.println(key);
            System.out.println(value);
        });
    }
}
