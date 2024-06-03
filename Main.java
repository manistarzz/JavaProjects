package calculator;
import java.util.*;

    public class Main {
        public static void main(String[] args) {

            HashMap<String,Double> menu= new HashMap<>();

            //all the comments are the way I did it
            menu.put("Bubblegum:",2.0);
            menu.put("Toffee:",0.2);
            menu.put("Ice Cream:",5.0);
            menu.put("Milk chocolate:",4.0);
            menu.put("Doughnut:",2.5);
            menu.put("Pancake:",3.2);

            System.out.println("Prices:");

            //This way of looping through the sets is fine but, you can save space by formatting
            /* *for (Map.Entry<String,Double> entry: menu.entrySet()){
                *String key=entry.getKey();
                *Double value=entry.getValue();
                *System.out.println(key + "  $" + value);
                }*/
            
            menu.forEach((key,value) -> System.out.println(key + "  $" + value));
            
        }
    }
