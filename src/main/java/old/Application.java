package old;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class Application {

    private final static Logger LOG =
            LogManager.getLogger("Первый исполняемый класс");

    int a = 7;
    static int b = 6;

    public static void main(String[] args) {

        int h =90;
        short s = 0;
        double d = 0.7145;
        float f = 0;
        long l = 81261242741284L;

        Calc calc = new Calc();
//
//        if (100 >= calc.sum(h, d) && calc.sum(h, d) >= 70){
//            System.out.println("Больше!");
//        } else if (calc.sum(h, d) == 70){
//            System.out.println("Равно!");
//        } else {
//            System.out.println("Меньше!");
//        }
//
//        switch (calc.sum(h, 14)){
//            case 50:
//                System.out.println("Меньше!");
//                break;
//            case 70:
//                System.out.println("Равно!");
//                break;
//            default:
//                System.out.println("Больше!");
//                break;
//        }
//
//        switch (h){
//            case 50 -> System.out.println("Меньше!");
//            case 70 -> System.out.println("Равно!");
//            default -> System.out.println("Больше!");
//        }
//
//        int i = 0;

//        while (i < 6){
//            i++;
//            if(i==3){
//                continue;
//            }
//            System.out.println("Help: " + i);
//        }

//        do{
//            i++;
//            if(i==3){
//                continue;
//            }
//            System.out.println("Help: " + i);
//        } while (i < 6);
//
        String[] strings = new String[]{ "one", "two", "three", "four" };
        int[] ints = new int[]{1, 2, 4, 7, 10};
        List<Integer> integers = new ArrayList<>();

        integers.add(1);
        integers.add(2);
        integers.add(4);
        integers.add(7);
        integers.add(10);

        List<Integer> integers1 = integers;

        integers.remove(1);

        List<String> testList = new ArrayList<>();
        testList.add("Abracadabra");

        Arrays.asList(strings).forEach(sting ->
            Arrays.asList(sting.split("")).forEach(LOG::info));


        try {
            integers.get(20);
            calc.arrayChange(new ArrayList<>());
            ints[10] = 1;
        } catch (NullPointerException | ArrayIndexOutOfBoundsException n){
            LOG.error("Тест упал: " + n.getMessage());
        } catch (Throwable a){
            LOG.error(a);
        } finally {
            LOG.info("Finally Here!");
        }

    //    calc.arrayChange(testList);

       List<String> result = Arrays.stream(strings)
                .map(number -> "-> "+ number)
                .filter(number -> number.contains("o"))
                .collect(Collectors.toList());


        for(String number: strings){
            if(number.contains("o")){
                result.add("-> "+ number);
            }
        }

     //   System.out.println(result);

      //  ints[0] = 60;




//        int b = 1;
//        for(Integer number : integers) {
//            System.out.println(b + " is " + number);
//            b++;
//        }

//        System.out.println((int) d);
//
//        System.out.println(h++);
//        System.out.println(++h);
//
//        h = Integer.parseInt("45");
//        System.out.println(h);
////
//        old.Application application = new old.Application();
//        application.a = 9;
//        application.test(
//                h + "",
//                ": ",
//                "test");
//
//
//        System.out.println(application.a);
//        old.Application application1 = new old.Application();
//        System.out.println(application1.a);

        Map<Integer, String> numbers = new HashMap<>(){
            {
                put(1, "one");
                put(2, "two");
                put(3, "one");
                put(4, "one");
                put(5, "one");
            }
        };



      //  System.out.println(numbers.get(5));

//        System.out.println(numbers.entrySet()
//                .stream()
//                .filter(entry -> entry.getValue().contains("*"))
//                .map(entry -> "-> "+ entry.getValue())
//                .findFirst()
//                .orElse("Nothing"));
//                .collect(Collectors.toList()));
//
//
//        calc.arrayChange(new ArrayList<>(){
//            {
//                add("Test1");
//                add("Test2");
//                add("Test3");
//            }
//        });

//        numbers.forEach((key, value) -> {
//            System.out.println(key+". "+value);
//        });
//
//        for(int i: numbers.keySet()){
//            System.out.println(i+". "+numbers.get(i));
//        }
    }


    public void test(String name, String name1, String name2){
        LOG.info(name + name1 + name2);
    }



}
