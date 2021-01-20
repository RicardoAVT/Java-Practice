import java.util.Scanner;
/*
Work on project. Stage 5/6: Keep track of the supplies

Description
        But just one action isn’t interesting. Let's improve the program so it can do multiple actions, one after another. The program should repeatedly ask what the user wants to do. If the user types "buy", "fill" or "take", then just do what the program did in the previous step. However, if the user wants to switch off the coffee machine, he should type "exit". Then the program should terminate. Also, when the user types "remaining", the program should output all the resources that the coffee machine has.

        Also, do not forget that you can be out of resources for making coffee. If the coffee machine doesn’t have enough resources to make coffee, the program should output a message that says it can't make a cup of coffee.

        And the last improvement to the program at this step—if the user types "buy" to buy a cup of coffee and then changes his mind, he should be able to type "back" to return into the main cycle.

        Remember, that:

        For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
        For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
        And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.
        Instruction
        Write a program that will work endlessly to make coffee for all interested persons until the shutdown signal is given.

Example
        Your coffee machine should have the same initial resources as in the example (400 ml of water, 540 ml of milk, 120 g of coffee beans, 9 disposable cups, $550 in cash).
        The symbol > represents the user input. Note that it's not part of the input.

        Write action (buy, fill, take, remaining, exit):
        > remaining

        The coffee machine has:
        400 of water
        540 of milk
        120 of coffee beans
        9 of disposable cups
        $550 of money

        Write action (buy, fill, take, remaining, exit):
        > buy

        What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
        > 2
        I have enough resources, making you a coffee!

        Write action (buy, fill, take, remaining, exit):
        > remaining

        The coffee machine has:
        50 of water
        465 of milk
        100 of coffee beans
        8 of disposable cups
        $557 of money

        Write action (buy, fill, take, remaining, exit):
        > buy

        What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
        > 2
        Sorry, not enough water!

        Write action (buy, fill, take, remaining, exit):
        > fill

        Write how many ml of water do you want to add:
        > 1000
        Write how many ml of milk do you want to add:
        > 0
        Write how many grams of coffee beans do you want to add:
        > 0
        Write how many disposable cups of coffee do you want to add:
        > 0

        Write action (buy, fill, take, remaining, exit):
        > remaining

        The coffee machine has:
        1050 of water
        465 of milk
        100 of coffee beans
        8 of disposable cups
        $557 of money

        Write action (buy, fill, take, remaining, exit):
        > buy

        What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:
        > 2
        I have enough resources, making you a coffee!

        Write action (buy, fill, take, remaining, exit):
        > remaining

        The coffee machine has:
        700 of water
        390 of milk
        80 of coffee beans
        7 of disposable cups
        $564 of money

        Write action (buy, fill, take, remaining, exit):
        > take

        I gave you $564

        Write action (buy, fill, take, remaining, exit):
        > remaining

        The coffee machine has:
        700 of water
        390 of milk
        80 of coffee beans
        7 of disposable cups
        0 of money

        Write action (buy, fill, take, remaining, exit):
        > exit
         */
public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int water = 400;
        int milk = 540;
        int coffeeBeans = 120;
        int cups = 9;
        int money = 550;

        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = sc.next();

        while (!action.equals("exit")){
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    String option = sc.next();
                    boolean canBUy = buy(option,water, milk, coffeeBeans);
                    if (option.equals("1") && canBUy){
                        water -= 250;
                        coffeeBeans -= 16;
                        cups --;
                        money += 4;
                    }
                    if (option.equals("2") && canBUy){
                        water -= 350;
                        milk -= 75;
                        coffeeBeans -= 20;
                        cups --;
                        money += 7;
                    }
                    if (option.equals("3") && canBUy){
                        water -= 200;
                        milk -= 100;
                        coffeeBeans -= 12;
                        cups --;
                        money += 6;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add:");
                    int waterToAdd = sc.nextInt();
                    water += waterToAdd;
                    System.out.println("Write how many ml of milk do you want to add: ");
                    int milkToAdd = sc.nextInt();
                    milk += milkToAdd;
                    System.out.println("Write how many grams of coffee beans do you want to add:");
                    int beansToAdd = sc.nextInt();
                    coffeeBeans += beansToAdd;
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    int cupsToAdd = sc.nextInt();
                    cups += cupsToAdd;
                    break;
                case "take":
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;
                case "remaining":
                    displayMachineState(water,milk,coffeeBeans,cups,money);
                    break;
                case "exit":
                    break;
            }
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = sc.next();
        }
    }

    public static void displayMachineState(int water, int milk, int coffeeBeans, int cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static boolean buy(String option,int water,int milk, int coffeeBeans) {

        switch (option) {
            case "1":
                if (water > 250 && coffeeBeans > 16){
                    System.out.println("I have enough resources, making you a coffee!");
                    return true;
                }else {
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case "2":
                if (water > 350 && milk > 75 && coffeeBeans > 20){
                    System.out.println("I have enough resources, making you a coffee!");
                    return true;
                }else {
                    System.out.println("Sorry, not enough water!");
                }

                break;
            case "3":
                if (water > 200 && milk > 100 && coffeeBeans > 12){
                    System.out.println("I have enough resources, making you a coffee!");
                    return true;
                }else {
                    System.out.println("Sorry, not enough water!");
                }
                break;
            case "back":
                break;
        }
        return false;
    }
}
