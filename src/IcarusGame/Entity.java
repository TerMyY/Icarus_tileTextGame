package IcarusGame;

public class Entity {
    static String[] enemies = {
            "Rat", "Void Stalker", "Forsaken", "Zombie", "Skeleton"
    };

    static void interact(Tile.Type type) {
        switch (type) {
            case ENEMY:
                Player.health -= ((int) ((Math.random() * 20) + 10)) - Player.armor;
                if (Player.health < 1) {
                    Player.isAlive = false;
                    switch (Main.gameLanguage) {
                        case "ru":
                            System.out.println("Ааааргхх *Вы погибли*\n*Нажмите Enter что бы закончить игру*");
                            break;
                        case "pl":
                            System.out.println("Aaaarrrg *Umar\u0142e\u015B*\n" +
                                    "*Naci\u015Bnij Enter, aby zako\u0144czy\u0107 gr\u0119*");
                            break;
                        case "en":
                        default:
                            System.out.println("Uuugh *You died*\n*Press Enter to end the game*");
                    }

                    Player.showInfo();
                    Main.gameIsOn = false;
                    break;
                }
                switch (Main.gameLanguage) {
                    case "ru":
                        enemies[0] = "Крыса";
                        enemies[1] = "Сталкер Пустоты";
                        enemies[2] = "Отрекшийся";
                        enemies[3] = "Зомби";
                        enemies[4] = "Скелет";
                        System.out.println("Это был(а) " + enemies[(int) (Math.random() * enemies.length)] + "!\n" +
                                "Я убил это существо, но оно ранило меня! *\u2764" + Player.health + "\u2764 здоровья осталось*");
                        break;
                    case "pl":
                        enemies[0] = "Szczur";
                        enemies[1] = "Pustka Prze\u015Bladowca";
                        enemies[2] = "Opuszczony";
                        enemies[3] = "Zambi";
                        enemies[4] = "Szkielet";
                        System.out.println("To by\u0142 " + enemies[(int) (Math.random() * enemies.length)] + "!\n" +
                                "Zabi\u0142em go, ale zada\u0142 mi troch\u0119 obra\u017Ce\u0144! *\u2764" + Player.health + "\u2764 zdrowia pozosta\u0142o*");
                        break;
                    case "en":
                    default:
                        System.out.println("It was a " + enemies[(int) (Math.random() * enemies.length)] + "!\n" +
                                "I killed it, but it dealt some damage to me!  *\u2764" + Player.health + "\u2764 hp remains*");
                        break;
                }
                if (Math.random() <= 0.35) {
                    Player.numberOfHealthPotions++;
                    switch (Main.gameLanguage) {
                        case "ru":
                            System.out.println("Этот монстр выронил зелье здоровья! *Всего зелий здоровья: " + Player.numberOfHealthPotions + "*");
                            break;
                        case "pl":
                            System.out.println("Upu\u015Bci\u0142 mikstur\u0119 zdrowia! *Mikstury ca\u0142kowitego zdrowia:  " + Player.numberOfHealthPotions + "*");
                            break;
                        case "en":
                        default:
                            System.out.println("It dropped a health potion! *Total amount of health potions: " + Player.numberOfHealthPotions);
                            break;
                    }

                }
                World.generateCoin();
                World.generateEnemy();
                break;

            case COIN:
                Player.coins++;
                if (Player.coins >= World.coinsToSaveThisLandNeeded) {
                    switch (Main.gameLanguage) {
                        case "ru":
                            System.out.println("Наконец я собрал достаточно золота, что бы спасти эти земли от последствий катастрофы\n" +
                                    "*Вы победили!*\n");
                            System.out.println("Программист: Артём Сергеев\n" +
                                    "Сценарист: Артём Сергеев\n" +
                                    "Локализатор: Артём Сергеев\n" +
                                    "Арт-Дизайнер: Артём Сергеев\n" +
                                    "Спасибо за ваше время :)\n" +
                                    "*Нажмите Enter, что бы закончить игру*");
                            break;
                        case "pl":
                            System.out.println("Wreszcie mam wystarczająco du\u017Co monet, aby uratowa\u0107 te ziemie przed konsekwencjami katastrofy\n" +
                                    "*Wygra\u0142e\u015B!*\n");
                            System.out.println("Scenarzysta: Artsiom Siarheyeu\n" +
                                    "Koder: Artsiom Siarheyeu\n" +
                                    "Projektant sztuki: Artsiom Siarheyeu\n" +
                                    "Lokalizacja: Artsiom Siarheyeu\n" +
                                    "Dyrektor ideologiczny: Artsiom Siarheyeu\n" +
                                    "Dzi\u0119kuję za Tw\u00F3j czas :)\n" +
                                    "*Naci\u015Bnij Enter, aby zako\u0144czy\u0107 gr\u0119*");
                            break;
                        case "en":
                        default:
                            System.out.println("Finally i have enough coins to save this lands from the consequences of the disaster\n" +
                                    "*You win!*\n");
                            System.out.println("Scenarist: Artsiom Siarheyeu\n" +
                                    "Coder: Artsiom Siarheyeu\n" +
                                    "Art-Designer: Artsiom Siarheyeu\n" +
                                    "Localisation: Artsiom Siarheyeu\n" +
                                    "Ideological Director: Artsiom Siarheyeu\n" +
                                    "Thanks for your time :)\n" +
                                    "*Press Enter to end the game*");
                            break;
                    }
                    Main.gameIsOn = false;
                } else {
                    switch (Main.gameLanguage) {
                        case "ru":
                            System.out.println("Монета! *Всего монет: " + Player.coins + "*");
                            break;
                        case "pl":
                            System.out.println("Moneta! *Suma monet: " + Player.coins + "*");
                            break;
                        case "en":
                        default:
                            System.out.println("A coin! *Total coins: " + Player.coins + "*");
                            break;
                    }
                }

                break;
            case SHOPKEEPER:
                Player.coins -= World.armorCost;
                Player.armor += 10;
                switch (Main.gameLanguage) {
                    case "ru":
                        System.out.println("Спасибо за покупку!\n" +
                                "Пусть этот доспех поможет тебе достичь твоих целей, какими бы они ни были\n" +
                                "Как я и говорила, дела в наше время идут не очень, мне пора найти новое место обитания потенциального товара и покупателей, удачи, странник");

                        break;
                    case "pl":
                        System.out.println("Dzi\u0119kujemy za zakupy!\n" +
                                "Niech ta zbroja pomo\u017Ce ci osi\u0105gną\u0107 twoje cele, jakiekolwiek by one nie by\u0142y\n" +
                                "Jak powiedzia\u0142am, w naszych czasach sprawy nie uk\u0142adaj\u0105 si\u0119 zbyt dobrze, czas bym znale\u017A\u0107 nowe siedlisko dla potencjalnych towar\u00F3w i kupuj\u0105cych, powodzenia, wędrowcze");
                        break;
                    case "en":
                    default:
                        System.out.println("Thanks for buying!\n" +
                                "Let this armor help you in your journey!\n" +
                                "As i said it's not the best times nowadays, so it's time to go on and find a new place for potential supply and customers. Good luck and bye, traveler");

                }
                break;
            case TRAP:
                Player.health = (Player.health / 2) - 10;
                if (Player.health < 1) {
                    Player.isAlive = false;
                    switch (Main.gameLanguage) {
                        case "ru":
                            System.out.println("Ааааргхх *Вы погибли*\n*Нажмите Enter что бы закончить игру*");
                            break;
                        case "pl":
                            System.out.println("Aaaarrrg *Umar\u0142e\u015B*\n" +
                                    "*Naci\u015Bnij Enter, aby zako\u0144czy\u0107 gr\u0119*");
                            break;
                        case "en":
                        default:
                            System.out.println("Uuugh *You died*\n*Press Enter to end the game*");
                    }

                    Player.showInfo();
                    Main.gameIsOn = false;
                    break;
                }
                switch (Main.gameLanguage) {
                    case "ru":
                        System.out.println("Черт, я угодил в ловушку! *Ваше текущее здоровье \u2764" + Player.health + "\u2764*");
                        break;
                    case "pl":
                        System.out.println("Bzdury! Wpad\u0142em w pu\u0142apkę * Twoje obecne zdrowie to \u2764" + Player.health + "\u2764");
                        break;
                    case "en":
                    default:
                        System.out.println("Crap! I've got into trap *Your current health is \u2764" + Player.health + "\u2764");
                        break;
                }
                break;

        }
    }


}

