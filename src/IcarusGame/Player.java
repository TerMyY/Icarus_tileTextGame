package IcarusGame;

public class Player {
    static int health = 100;
    static int armor = 0;
    static int numberOfHealthPotions = 3;
    static int coins = 0;
    static boolean isAlive = true;

    static void showInfo() {
        switch (Main.gameLanguage) {
            case "ru":
                System.out.println("У меня \u2764" + health + "\u2764 здоровья\nУ меня " + armor + " брони\nУ меня есть " + numberOfHealthPotions + " зелий здоровья\nУ меня есть " + coins + " монет");
                break;
            case "pl":
                System.out.println("Mam \u2764" + health + "\u2764 zdrowia\nMam " + armor + " zbroi\nMam " + numberOfHealthPotions + " mikstur zdrowia\nMam " + coins + " monet");
                break;
            case "en":
            default:
                System.out.println("My health is \u2764" + health + "\u2764\nMy armor is " + armor + "\nI have " + numberOfHealthPotions + " health potions\nI have " + coins + " coins");
                break;
        }
    }

    static void heal() {
        if (numberOfHealthPotions > 0) {
            health += 25;
            Player.numberOfHealthPotions--;
            if (Player.health > 100) {
                Player.health = 100;
            }
            switch (Main.gameLanguage) {
                case "ru":
                    System.out.println("Мне стало лучше! *25 здоровья восстановлено*\n*Текущее здоровье равно \u2764" + Player.health + "\u2764*");
                    break;
                case "pl":
                    System.out.println("Czuj\u0119 si\u0119 lepiej! *25 przywr\u00F3conych punkt\u00F3w zdrowia*\n*Obecny stan zdrowia to \u2764" + Player.health + "\u2764*");
                    break;
                case "en":
                default:
                    System.out.println("I feel better right now! *25 health restored*\n*Current health is \u2764" + Player.health + "\u2764*");
                    break;
            }
        } else {
            switch (Main.gameLanguage) {
                case "ru":
                    System.out.println("У меня нет зелий здоровья, чтобы их выпить!");
                    break;
                case "pl":
                    System.out.println("Nie mam \u017Cadnych mikstur zdrowotnych do picia!");
                    break;
                case "en":
                default:
                    System.out.println("I don't have potions to consume!");
                    break;
            }
        }

    }


}
