import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Calc {

    private final static Logger LOG =
            LogManager.getLogger("Калькулятор");

    private final List<String> testCalc = new ArrayList<>();

    public int sum(int arg1, int arg2){
        return arg1 + arg2;
    }

    public double sum(double arg1, double arg2){
        return arg1+arg2;
    }

    public long sum(long arg1, long arg2){
        return arg1+arg2;
    }

    public String multiple(int arg1, int arg2){
        return arg1 * arg2 + "";
    }

    public String multiple(double arg1, double arg2){
        return arg1 * arg2 + "";
    }

    public String multiple(int arg1, long arg2){
        return arg1 * arg2 + "";
    }

    public void arrayChange (List<String> input) throws AssertionError{
        try {
            testCalc.addAll(input);
            input.add("Here!");
            input.forEach(LOG::info);
        } catch (IndexOutOfBoundsException n){
            throw new AssertionError("Тест упал: " + n.getMessage());
        }
    }

}
