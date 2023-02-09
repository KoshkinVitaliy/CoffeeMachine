import java.util.InputMismatchException;
import java.util.Scanner;

public class CoffeeMachine {
    private final int [] price = {100, 150, 200, 250, 300};
    private final String[] nameOfDrinks = {"Espresso", "Americano", "Latte", "Cappucchino",
            "Flat White"};

    private int amountOfDrinks = 0;

    private void checkPrice(int amountOfMoney) {
       if(amountOfMoney < 100) {
           System.out.println("You have not enough money for the drinks.");
           System.out.println("-----------------------");
           System.out.println("Write your amount of money: ");

           Scanner scanner = new Scanner(System.in);
           amountOfMoney = scanner.nextInt();

           checkPrice(amountOfMoney);
       }
       else {
           for (int i : price) {
               if (amountOfMoney >= i) {
                   amountOfDrinks++;
               }
           }
           makeDrink();
       }
    }

    private void makeDrink() {
        showDrinks(amountOfDrinks);

        System.out.println("Write your choice with a number: ");

        try {
            Scanner scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();

            if((userChoice > amountOfDrinks) || (userChoice < 0)) {
                System.out.println("Wrong choice, try again!");
                makeDrink();
            }
            else {
                switch (userChoice) {
                    case 1 -> System.out.println("Your " + nameOfDrinks[0] + " is ready!");
                    case 2 -> System.out.println("Your " + nameOfDrinks[1] + " is ready!");
                    case 3 -> System.out.println("Your " + nameOfDrinks[2] + " is ready!");
                    case 4 -> System.out.println("Your " + nameOfDrinks[3] + " is ready!");
                    case 5 -> System.out.println("Your " + nameOfDrinks[4] + " is ready!");
                    default -> {
                        System.out.println("Wrong choice or incorrect number, try again!");
                        makeDrink();
                    }
                }
            }
        }
        catch(InputMismatchException exception) {
            System.out.println("Write a number, not a word. " + exception);

            makeDrink();
        }

    }
    public void chooseDrinks() {
        System.out.println("Write your amount of money: ");

        try {
            Scanner scanner = new Scanner(System.in);
            int amountOfMoney = scanner.nextInt();

            checkPrice(amountOfMoney);
        }
        catch (InputMismatchException exception) {
            System.out.println("Write a number, not a word. " + exception);

            chooseDrinks();
        }
    }

    private void showDrinks(int amountOfDrinks) {
        System.out.println("Choose your drink: ");

        for (int i=0; i < amountOfDrinks; i++) {
            System.out.print(nameOfDrinks[i] + " ");
        }
        System.out.println(" ");
    }
}
