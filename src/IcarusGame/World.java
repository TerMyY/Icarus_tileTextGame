package IcarusGame;

public class World {
    enum Direction {
        UP,
        RIGHT,
        DOWN,
        LEFT
    }

    static int height;
    static int width;
    static Tile[][] tiles;
    static Tile empty = new Tile(Tile.Type.EMPTY);
    static Tile hero = new Tile(Tile.Type.HERO);
    static int armorCost = 35;
    static int coinsToSaveThisLandNeeded = 100;

    static void addEntity(Tile tile, int x, int y) {
        tile.setX(x);
        tile.setY(y);
        tiles[tile.getX()][tile.getY()] = tile;
        tile.isEmpty = false;

    }

    static void removeEntity(int x, int y) {
        tiles[x][y] = new Tile(Tile.Type.EMPTY);
    }

    // i don't know where did i messed up, but x and y are reversed and i can't figure it out how to fix it
    static void moveEntity(Tile tile, Direction direction) {
        switch (direction) {
            case UP:
                if (tile.getX() != 0) {
                    if (!tiles[tile.getX() - 1][tile.getY()].isEmpty) {
                        Entity.interact(tiles[tile.getX() - 1][tile.getY()].type);
                    }
                    removeEntity(tile.getX(), tile.getY());
                    addEntity(tile, tile.getX() - 1, tile.getY());
                    break;


                }
                break;
            case RIGHT:
                if (tile.getY() < height - 1) {
                    if (!tiles[tile.getX()][tile.getY() + 1].isEmpty) {
                        Entity.interact(tiles[tile.getX()][tile.getY() + 1].type);
                    }
                    removeEntity(tile.getX(), tile.getY());
                    addEntity(tile, tile.getX(), tile.getY() + 1);
                    break;
                }
                break;
            case DOWN:
                if (tile.getX() < width - 1) {

                    if (tiles[tile.getX() + 1][tile.getY()] == tiles[width - 1][0] && Player.coins < armorCost) {
                        switch (Main.gameLanguage) {
                            case "ru":
                                System.out.println("Привет, путник. Меня зовут Мелентия, я торгую в этих опасных землях.\n" +
                                        "Обычно у меня много всего на продажу, но к сожалению в нынешние времена дела идут плохо.\n" +
                                        "Всё что я могу тебе предложить - стальной доспех, который поможет тебе выжить в этих местах.\n" +
                                        "Принеси мне " + armorCost + " золотых монет, и он твой.");
                                break;
                            case "pl":
                                System.out.println("Witaj, Podr\u00F3\u017Cniku. Jestem Melentia, sklepikarz. Sprzedaję towary na tych niebezpiecznych ziemiach.\n" +
                                        "Zwykle mam wiele rzeczy do sprzedania, ale obecnie nie s\u0105 najlepsze czasy.\n" +
                                        "Na razie mogę zaoferowa\u0107 tylko stalową zbroję, kt\u00F3ra pomo\u017Ae ci przetrwa\u0107 na tych ziemiach.\n" +
                                        "Znajd\u017A " + armorCost + " z\u0142ote monety dla mnie i jest twoje.");
                                break;
                            case "en":
                            default:
                                System.out.println("Hello, Traveler. I am Melentia, the shopkeeper. I sell goods in this dangerous lands.\n" +
                                        "Usually i have a lot of things for selling, but nowadays are not the best times.\n" +
                                        "All i can offer for now is steel armor that will help you survive in this lands.\n" +
                                        "Find " + armorCost + " golden coins for me, and it is yours.");
                                break;
                        }
                    } else {
                        if (!tiles[tile.getX() + 1][tile.getY()].isEmpty) {
                            Entity.interact(tiles[tile.getX() + 1][tile.getY()].type);
                        }
                        removeEntity(tile.getX(), tile.getY());
                        addEntity(tile, tile.getX() + 1, tile.getY());
                        break;
                    }
                }
                break;
            case LEFT:
                if (tile.getY() != 0) {

                    if (tiles[tile.getX()][tile.getY() - 1] == tiles[width - 1][0] && Player.coins < armorCost) {
                        switch (Main.gameLanguage) {
                            case "ru":
                                System.out.println("Привет, путник. Меня зовут Мелентия, я торгую в этих опасных землях.\n" +
                                        "Обычно у меня много всего на продажу, но к сожалению в нынешние времена дела идут плохо.\n" +
                                        "Всё что я могу тебе предложить - стальной доспех, который поможет тебе выжить в этих местах.\n" +
                                        "Принеси мне " + armorCost + " золотых монет, и он твой.");
                                break;
                            case "pl":
                                System.out.println("Witaj, Podr\u00F3\u017Cniku. Jestem Melentia, sklepikarz. Sprzedaję towary na tych niebezpiecznych ziemiach.\n" +
                                        "Zwykle mam wiele rzeczy do sprzedania, ale obecnie nie s\u0105 najlepsze czasy.\n" +
                                        "Na razie mogę zaoferowa\u0107 tylko stalową zbroję, kt\u00F3ra pomo\u017Ae ci przetrwa\u0107 na tych ziemiach.\n" +
                                        "Znajd\u017A " + armorCost + " z\u0142ote monety dla mnie i jest twoje.");
                                break;
                            case "en":
                            default:
                                System.out.println("Hello, Traveler. I am Melentia, the shopkeeper. I sell goods in this dangerous lands.\n" +
                                        "Usually i have a lot of things for selling, but nowadays are not the best times.\n" +
                                        "All i can offer for now is steel armor that will help you survive in this lands.\n" +
                                        "Find " + armorCost + " golden coins for me, and it is yours.");
                                break;
                        }
                    } else {
                        if (!tiles[tile.getX()][tile.getY() - 1].isEmpty) {
                            Entity.interact(tiles[tile.getX()][tile.getY() - 1].type);
                        }
                        removeEntity(tile.getX(), tile.getY());
                        addEntity(tile, tile.getX(), tile.getY() - 1);
                        break;
                    }
                }
                break;
        }
    }

    static void buildWorld() {
        for (int i = 0; i < tiles.length; i++) {
            System.out.println();
            for (int j = 0; j < tiles[i].length; j++) {
                System.out.print(tiles[i][j]);
            }
        }
        System.out.println("\n");
    }

    static void generateEnemies() {
        int quantity = (int) ((Math.random() * width) + 5);
        for (int i = 0; i < quantity; i++) {
            int x = (int) ((Math.random() * ((width - 1)) + 1));
            int y = (int) ((Math.random() * ((height - 1)) + 1));
            addEntity(new Tile(Tile.Type.ENEMY), x, y);

        }

    }

    static void generateTraps() {
        int quantity = (int) ((Math.random() * width) + 3);
        for (int i = 0; i < quantity; i++) {
            int x = (int) ((Math.random() * ((width - 1)) + 1));
            int y = (int) ((Math.random() * ((height - 1)) + 1));
            addEntity(new Tile(Tile.Type.TRAP), x, y);

        }
    }

    static void generateEnemy() {
        int x = (int) ((Math.random() * ((width - 1)) + 1));
        int y = (int) ((Math.random() * ((height - 1)) + 1));
        addEntity(new Tile(Tile.Type.ENEMY), x, y);
    }

    static void generateCoin() {
        int x = (int) ((Math.random() * ((width - 1)) + 1));
        ;
        int y = (int) ((Math.random() * ((height - 1)) + 1));
        ;
        addEntity(new Tile(Tile.Type.COIN), x, y);
    }

    World() {
        boolean niceValues = false;
        while (!niceValues) {
            try {
                height = Integer.parseInt(Main.sc.nextLine());
                width = Integer.parseInt(Main.sc.nextLine());
                if (height >= 6 && width >= 6 && height <= 64 && width <= 64) {
                    niceValues = true;
                } else {
                    throw new ArrayIndexOutOfBoundsException();
                }
            } catch (NumberFormatException nfe) {
                switch (Main.gameLanguage) {
                    case "ru":
                        System.out.println("Пожалуйста введите верные значения (не меньше 6 и не больше 64)");
                        break;
                    case "pl":
                        System.out.println("Wprowad\u017C prawid\u0142owe warto\u015Bci (co najmniej 6 i nie wi\u0119cej ni\u017A 64)");
                        break;
                    case "en":
                    default:
                        System.out.println("Please enter the right value (greater than 6 and less than 64)");
                        break;
                }
            } catch (ArrayIndexOutOfBoundsException aioobe) {
                switch (Main.gameLanguage) {
                    case "ru":
                        System.out.println("Пожалуйста введите верные значения (не меньше 6 и не больше 64)");
                        break;
                    case "pl":
                        System.out.println("Wprowad\u017C prawid\u0142owe warto\u015Bci (co najmniej 6 i nie wi\u0119cej ni\u017A 64)");
                        break;
                    case "en":
                    default:
                        System.out.println("Please enter the right value (greater than 6 and less than 64)");
                        break;
                }
            }

        }


        tiles = new Tile[width][height];
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                addEntity(empty, i, j);
            }
        }
        addEntity(hero, 0, 0);
        addEntity(new Tile(Tile.Type.SHOPKEEPER), width - 1, 0);
        generateEnemies();
        generateTraps();
    }


}
