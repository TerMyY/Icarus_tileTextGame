package IcarusGame;

import java.util.Scanner;

public class Main {
    static boolean gameIsOn;
    static Scanner sc = new Scanner(System.in);
    static String input;
    static Tile hero = World.hero;
    static World.Direction UP = World.Direction.UP;
    static World.Direction RIGHT = World.Direction.RIGHT;
    static World.Direction LEFT = World.Direction.LEFT;
    static World.Direction DOWN = World.Direction.DOWN;
    static String gameLanguage;

    public static void main(String[] args) {
        System.out.println("Please select game language | Wybierz j\u0119zyk gry | Выберите язык игры \n" +
                "(en - English, pl - Polski, ru - Русский)");
        switch (sc.nextLine()) {
            case "pl":
                gameLanguage = "pl";
                break;
            case "ru":
                gameLanguage = "ru";
                break;
            case "en":
            default:
                gameLanguage = "en";
        }
        switch (gameLanguage) {
            case "pl":
                System.out.println("Wprowad\u017C warto\u015Bci szeroko\u015Bci i wysoko\u015Bci\n" +
                        "(Numer *Enter*, Numer *Enter*)\n" +
                        "(*Numery musz\u0105 mie\u0107 co najmniej 6 i nie wi\u0119cej ni\u017C 64*)");
                break;
            case "ru":
                System.out.println("Введите значения высоты и ширины поля\n" +
                        "(Число *Enter*, Число *Enter*)\n" +
                        "(*Числа должны быть не меньше 6 и не больше 64*)");
                break;
            case "en":
            default:
                System.out.println("Enter width and height values\n" +
                        "(Number *Enter*, Number *Enter*)\n" +
                        "(*Numbers must be at least 6 and less than 64*)");
                break;
        }
        new World();
        World.buildWorld();
        gameIsOn = true;
        input = sc.nextLine();
        while (gameIsOn) {
            switch (input) {
                case "up":
                case "w":
                    World.moveEntity(hero, UP);
                    World.buildWorld();
                    input = sc.nextLine();
                    break;
                case "right":
                case "d":
                    World.moveEntity(hero, RIGHT);
                    World.buildWorld();
                    input = sc.nextLine();
                    break;
                case "down":
                case "s":
                    World.moveEntity(hero, DOWN);
                    World.buildWorld();
                    input = sc.nextLine();
                    break;
                case "left":
                case "a":
                    World.moveEntity(hero, LEFT);
                    World.buildWorld();
                    input = sc.nextLine();
                    break;
                case "info":
                case "i":
                    Player.showInfo();
                    World.buildWorld();
                    input = sc.nextLine();
                    break;
                case "heal":
                case "h":
                    Player.heal();
                    World.buildWorld();
                    input = sc.nextLine();
                    break;
                case "exit":
                case "quit":
                case "end":
                    gameIsOn = false;
                    break;
                default:
                    World.buildWorld();
                    input = sc.nextLine();
                    break;

            }
        }
    }
}
