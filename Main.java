package calculator;
import java.util.*;

    public class Main {
        public static void main(String[] args) {
            //Create an instance of the Shop class
            Shop shop=new Shop();
            //Print the total income
            shop.printIncome();
            //Input and print the expenses, and calculate net income
            shop.printExpenses();
        }
        

    }

    class Shop{
        //HashMaps to store menu prices and income from items
    private HashMap<String,Double> menu;
    private HashMap<String,Double> income;

    //Constructor to initialize the menu and income HashMaps
    public Shop(){
        menu=new HashMap<>();
        income=new HashMap<>();

        //Initialize menu prices
        menu.put("Bubblegum:",2.0);
        menu.put("Toffee:",0.2);
        menu.put("Ice Cream:",5.0);
        menu.put("Milk chocolate:",4.0);
        menu.put("Doughnut:",2.5);
        menu.put("Pancake:",3.2);

        //Initialize income amounts
        income.put("Bubblegum:",202.0);
        income.put("Toffee:",118.0);
        income.put("Ice Cream:",2250.0);
        income.put("Milk chocolate:",1680.0);
        income.put("Doughnut:",1075.0);
        income.put("Pancake:",80.0);
    }

    //Method to print the menu prices
    public void printPrices(){
        System.out.println("Prices:");
        //Iterate through the menu map and print each item and its price
        menu.forEach((key,value)-> System.out.println(key+" $"+ value));

    }

    //Method to print the earned income from items
    public void printIncome(){
        System.out.println("Earned amount:");
        //Iterate through the income map and print each item and its earned amount
        income.forEach((key,value)->System.out.println(key+" $"+ value));

        //Calculate total income
        double totalIncome=0;
        for (double i:income.values()){
            totalIncome+=i;
        }
        System.out.println("Income: "+totalIncome);

    }

    //Method to input and print expenses, and calculate net income
    public void printExpenses(){
        Scanner sc=new Scanner(System.in);
        //Input staff expenses
        System.out.println("Staff expenses");
        double staff=sc.nextDouble();
        //Input other expenses
        System.out.println("Other expenses");
        double other= sc.nextDouble();

        //Calculate total income
        double totalIncome=0;
        for (double i:income.values()){
            totalIncome+=i;
        }
        System.out.println("Income: "+totalIncome);

        //Calculate net income by subtracting expenses from total income

        double net=totalIncome-(staff+other);
        //Print net income

        System.out.println("Net income: $"+net);
    }




}
