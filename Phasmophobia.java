import java.util.Random;
import java.util.Scanner;
class Phasmophobia{
    public static int playerX = 29;
    public static int playerY = 9;
    public static boolean dots = false;
    public static boolean emf = false;
    public static boolean freezing = false;
    public static boolean orb = false;
    public static boolean writing = false;
    public static boolean box = false;
    public static boolean uv = false;
    public static int ghostGuess = 0;
    public static int ghostType = 0;
    public static void main(String[] args){
        ghosts();
        boolean leaveGame = false;
        printMap();
        do{
            playerInput();
            printMap();
        }while(leaveGame == false);
    }
    public static void clear(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    public static void ghosts(){
        Random r = new Random();
        String ghostTypes[][] = {
            {"Banshee", "Demon", "Deogen", "Dayan", "Gallu", "Goryo", "Hantu", "Jinn", "Mare", "Moroi", "Myling", "Obake", "Obambo", "Oni", "Onryo", "Phamtom", "Poltergeist", "Raiju", "Revenant", "Shade", "Spirit", "Thaye", "The Mimic", "The Twins", "Wraith", "Yurei", "Yokai"}, //ghost types
            {"DOTS", "Freezing", "DOTS", "EMF 5", "EMF 5", "DOTS", "Freezing", "EMF 5", "Ghost Orb", "Freezing", "EMF 5", "EMF 5", "DOTS", "DOTS", "Freezing", "DOTS", "Ghost Writing", "DOTS", "Freezing", "EMF 5", "EMF 5", "DOTS", "Freezing", "EMF 5", "DOTS", "DOTS", "DOTS"}, //evidence 1
            {"Ghost Orb", "Ghost Writing", "Ghost Writing", "Ghost Orb", "Ghost Orb", "EMF 5", "Ghost Orb", "Freezing", "Ghost Writing", "Ghost Writing", "Ghost Writing", "Ghost Orb", "Ghost Writing", "EMF 5", "Ghost Orb", "Spirit Box", "Spirit Box", "EMF 5", "Ghost Orb", "Freezing", "Ghost Writing", "Ghost Orb", "Spirit Box", "Freezing", "EMF 5", "Freezing", "Ghost Orb"}, // evidence 2
            {"Ultraviolet", "Ultraviolet", "Spirit Box", "Spirit Box", "Ultraviolet", "Ultraviolet", "Ultraviolet", "Ultraviolet", "Spirit Box", "Spirit Box", "Ultraviolet", "Ultraviolet", "Ultraviolet", "Freezing", "Spirit Box", "Ultraviolet", "Ultraviolet", "Ghost Orb", "Ghost Writing", "Ghost Writing", "Spirit Box", "Ghost Writing", "Ultraviolet", "Spirit Box", "Spirit Box", "Ghost Orb", "Spirit Box"}, // evidence 3
            {"singing", "hunt", "location", "movement", "protection", "dots", "freezing", "fuse", "light", "sanity", "parabolic", "fingerprint", "agressive", "activity", "flame", "stalk", "throw", "electronic", "speed", "shy", "none", "age", "mimic", "interact", "salt", "door", "listen"}, // ghost ability
        };
        int i = r.nextInt(28);
        String[] ghost = new String[5];
        ghost[0] = ghostTypes[0][i];
        ghost[1] = ghostTypes[1][i];
        ghost[2] = ghostTypes[2][i];
        ghost[3] = ghostTypes[3][i];
        ghost[4] = ghostTypes[4][i];
        System.out.println(ghost[0] + " " + ghost[1] + " " + ghost[2] + " " + ghost[3] + " " + ghost[4]);
        for(int a = 0; a < ghostTypes[0].length; a++){
            if(ghostTypes[0][a].equals(ghost[0])){
                ghostType = a + 1;
                System.out.println(a);
            }
        }
    }
    public static int[][] mainMap(){
        //door (open / closed)
        //faucet (on / off)
        //light switch (on / off)
        //throwable
        //window
        int tangleWood[][] = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,3,0,1,0,0,1,3,3,0,0,3,1,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,3,1},
            {1,3,0,0,1,0,0,1,3,0,0,3,3,1,0,0,1,0,3,3,3,0,1,1,0,0,0,0,0,0,0,3,1},
            {1,3,0,0,1,0,0,1,3,0,0,0,3,1,0,0,1,0,3,3,3,0,1,1,0,0,0,0,0,0,0,3,1},
            {1,1,1,0,1,0,1,1,3,0,3,0,3,1,0,0,1,0,3,3,3,0,1,1,0,0,1,0,0,0,0,3,1},
            {1,3,3,0,0,0,0,1,3,0,0,0,3,1,0,0,1,0,0,0,0,0,1,1,0,0,1,3,3,0,0,3,1},
            {1,0,0,0,0,0,3,1,3,0,0,0,3,1,0,0,1,0,0,0,0,3,1,1,0,0,1,0,0,0,0,0,1},
            {1,0,3,3,0,0,3,1,3,0,0,0,3,1,1,0,1,0,0,0,0,3,1,1,0,0,1,3,3,0,3,3,1},
            {1,3,3,3,0,0,3,1,3,0,0,0,0,0,0,0,0,0,0,0,0,3,1,1,0,0,1,0,0,0,0,0,1},
            {1,1,1,1,1,0,0,1,3,0,0,0,0,0,0,0,0,0,3,3,0,3,1,1,1,0,1,3,3,0,3,3,1},
            {1,0,0,2,1,0,1,1,3,0,0,1,1,1,0,1,1,0,3,3,0,3,1,1,1,1,1,2,0,0,0,0,1},
            {1,3,0,3,1,0,0,0,0,0,0,1,3,0,0,0,1,0,3,3,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,3,1,0,0,0,0,0,0,1,3,0,0,0,1,0,3,3,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,1,1,1,1,0,0,1,1,3,0,0,0,1,0,0,0,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,0,0,0,0,0,1,0,0,2,1,3,0,0,0,1,3,3,3,3,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,3,3,1,0,0,1,0,0,2,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,0,0,1,0,0,1,1,3,0,0,0,0,0,0,0,3,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,2,0,0,1,0,0,1,1,3,0,0,0,0,0,0,0,0,2,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,2,0,0,1,0,3,1,1,3,0,0,0,0,0,0,0,0,2,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,0,0,0,0,3,1,1,3,0,0,3,3,3,3,0,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,3,3,1,0,0,0,0,3,1,1,3,0,0,3,3,3,3,0,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,0,0,1,0,0,1,0,0,1,1,3,0,0,3,3,3,3,0,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,0,0,0,0,0,1,0,0,1,1,3,0,0,3,3,3,3,0,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,0,1,1,1,0,1,1,3,0,0,3,3,3,3,0,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,3,3,0,0,0,1,2,2,2,1,3,0,0,0,0,0,0,0,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,0,0,0,0,0,1,2,2,2,1,3,0,0,0,0,0,0,0,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,0,0,0,1,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,3,3,0,2,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,3,3,0,2,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
        tangleWood[playerX][playerY] = 4;
        if(tangleWood[7][15] == 4){
            playerX = 8;
            playerY = 25;
        } 
        if(tangleWood[9][25] == 4){
            playerX = 8;
            playerY = 15;
        }
        //System.out.println(playerX + " " + playerY);
        return tangleWood;
    }
    public static void printMap(){
        //receives map to print
        int[][] currentLocation = mainMap();
        //removes old map
        clear();
        //prints out new map
        for(int i = 0; i < currentLocation.length; i++){
            for(int j = 0; j < currentLocation[0].length; j++){
                switch (currentLocation[i][j]){
                    case 0:
                        //walkable area
                        System.out.print("  ");
                    break;
                    case 1:
                        //wall
                        System.out.print((char)9632);
                        System.out.print((char)9632);
                    break;
                    case 2:
                        //hiding spot
                        System.out.print("[]");
                    break;
                    case 3:
                        //furniture
                        System.out.print("##");
                    break;
                    case 4:
                        //player
                        System.out.print("()");
                    break;
                    case 5:
                        //ghost
                        System.out.print("<>");
                    break;
                }
            }
            System.out.println();
        }
    }
    public static void playerInput(){
        int[][] map = mainMap();
        System.out.println("Press a letter then click enter");
        System.out.println("c for controls");
        //receives input from player
        Scanner input = new Scanner(System.in);
        String direction = input.nextLine();
        switch (direction){
            case "w":
                if(map[playerX - 1][playerY] == 0 || map[playerX - 1][playerY] == 2)
                playerX--;
            break;
            case "a":
                if(map[playerX][playerY - 1] == 0 || map[playerX][playerY - 1] == 2)
                playerY--;
            break;
            case "s":
                if(map[playerX + 1][playerY] == 0 || map[playerX + 1][playerY] == 2)
                playerX++;
            break;
            case "d":
                if(map[playerX][playerY + 1] == 0 || map[playerX][playerY + 1] == 2)
                playerY++;
            break;
            case "j":
                journal();
            break;
            case "e":

            break;
            case "r":

            break;
            case "f":

            break;
            case "c":
                System.out.println("w) move up");
                System.out.println("a) move left");
                System.out.println("s) move right");
                System.out.println("d) move down");
                System.out.println("j) open journal");
                System.out.println("e) grab item");
                System.out.println("r) drop item");
                System.out.println("f) interact");
                System.out.println("Press Enter to continue");
                input.nextLine();
                printMap();
            break;
        }
    }
    public static void journal(){
        Scanner input = new Scanner(System.in);
        clear();
        System.out.println("1) Select Ghost Type");
        System.out.println("2) Enter Evidence");
        System.out.println("3) Read about Ghosts");
        System.out.println("4) Finish game");
        switch(input.nextInt()){
            case 1:
                clear();
                if(!(freezing == true || writing == true || box == true || emf == true)) System.out.println("1) Banshee"); 
                if(!(box == true || emf == true || dots == true || orb == true)) System.out.println("2) Demon");
                if(!(emf == true || orb == true || freezing == true || uv == true)) System.out.println("3) Deogen");
                if(!(freezing == true || writing == true || uv == true || dots == true)) System.out.println("4) Dayan");
                if(!(freezing == true || writing == true || dots == true || box == true)) System.out.println("5) Gallu");
                if(!(freezing == true || writing == true || box == true || orb == true)) System.out.println("6) Goryo");
                if(!(writing == true || box == true || emf == true || dots == true)) System.out.println("7) Hantu");
                if(!(writing == true || box == true || orb == true || dots == true)) System.out.println("8) Jinn");
                if(!(dots == true || freezing == true || emf == true || uv == true)) System.out.println("9) Mare");
                if(!(dots == true || emf == true || uv == true || orb == true)) System.out.println("10) Moroi");
                if(!(dots == true || orb == true || freezing == true || box == true)) System.out.println("11) Myling");
                if(!(dots == true || freezing == true || box == true || writing == true)) System.out.println("12) Obake");
                if(!(freezing == true || box == true || emf == true || orb == true)) System.out.println("13) Obambo");
                if(!(box == true || orb == true || writing == true || uv == true)) System.out.println("14) Oni");
                if(!(writing == true || uv == true || dots == true || emf == true)) System.out.println("15) Onryo");
                if(!(writing == true || emf == true || orb == true || freezing == true)) System.out.println("16) Phantom");
                if(!(emf == true || orb == true || freezing == true || dots == true)) System.out.println("17) Poltergeist");
                if(!(writing == true || freezing == true || box == true || uv == true)) System.out.println("18) Raiju");
                if(!(emf == true || box == true || uv == true || dots == true)) System.out.println("19) Revenant");
                if(!(box == true || uv == true || dots == true || orb == true)) System.out.println("20) Shade");
                if(!(uv == true || dots == true || orb == true || freezing == true)) System.out.println("21) Spirit");
                if(!(uv == true || freezing == true || box == true || emf == true)) System.out.println("22) Thaye");
                if(!(emf == true || writing == true || orb == true || dots == true)) System.out.println("23) The Mimic");
                if(!(writing == true || orb == true || dots == true || uv == true)) System.out.println("24) The Twins");
                if(!(writing == true || orb == true || uv == true || freezing == true)) System.out.println("25) Wraith");
                if(!(writing == true || uv == true || emf == true || box == true)) System.out.println("26) Yurei");
                if(!(writing == true || uv == true || emf == true || freezing == true)) System.out.println("27) Yokai");
                System.out.println("Enter Ghost type");
                System.out.println("Current Ghost Selected: " + ghostGuess);
                ghostGuess = input.nextInt();
            break;
            case 2:
                clear();
                if(dots == true) System.out.println("[X]1) D.O.T.S."); 
                else System.out.println("[ ]1) D.O.T.S.");
                if(emf == true) System.out.println("[X]2) EMF Level 5");
                else System.out.println("[ ]2) EMF Level 5");
                if(freezing == true)System.out.println("[X]3) Freezing Tempratures");
                else System.out.println("[ ]3) Freezing Tempratures");
                if(orb == true) System.out.println("[X]4) Ghost Orb");
                else System.out.println("[ ]4) Ghost Orb");
                if(writing == true) System.out.println("[X]5) Ghost Writing");
                else System.out.println("[ ]5) Ghost Writing");
                if(box == true) System.out.println("[X]6) Spirit Box");
                else System.out.println("[ ]6) Spirit Box");
                if(uv == true) System.out.println("[X]7) Ultraviolet");
                else System.out.println("[ ]7) Ghost Orb");
                System.out.println("8) No evidence to enter");
                System.out.println("Enter Evidence");
                int evidence = input.nextInt();
                switch (evidence){
                    case 1:
                        if(dots == false) dots = true;
                        else dots = false;
                    break;
                    case 4:
                        if(orb == false) orb = true;
                        else orb = false;
                    break;
                    case 5:
                        if(writing == false) writing = true;
                        else writing = false;
                    break;
                    case 6:
                        if(box == false) box = true;
                        else box = false;
                    break;
                    case 7:
                        if(uv == false) uv = true;
                        else uv = false;
                    break;
                    case 3:
                        if(freezing == false) freezing = true;
                        else freezing = false;
                    break;
                    case 2:
                        if(emf == false) emf = true;
                        else emf = false;
                    break;
                }
            break;
            case 3:
                clear();
                System.out.println("Select Ghost to read about");
                System.out.println("1) Banshee"); 
                System.out.println("2) Demon");
                System.out.println("3) Deogen");
                System.out.println("4) Dayan");
                System.out.println("5) Gallu");
                System.out.println("6) Goryo");
                System.out.println("7) Hantu");
                System.out.println("8) Jinn");
                System.out.println("9) Mare");
                System.out.println("10) Moroi");
                System.out.println("11) Myling");
                System.out.println("12) Obake");
                System.out.println("13) Obambo");
                System.out.println("14) Oni");
                System.out.println("15) Onryo");
                System.out.println("16) Phantom");
                System.out.println("17) Poltergeist");
                System.out.println("18) Raiju");
                System.out.println("19) Revenant");
                System.out.println("20) Shade");
                System.out.println("21) Spirit");
                System.out.println("22) Thaye");
                System.out.println("23) The Mimic");
                System.out.println("24) The Twins");
                System.out.println("25) Wraith");
                System.out.println("26) Yurei");
                System.out.println("27) Yokai");
                switch (input.nextInt()){
                    case 1:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 2:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 3:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 4:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 5:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 6:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 7:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 8:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 9:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 10:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 11:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 12:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 13:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 14:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 15:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 16:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 17:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 18:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 19:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 20:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 21:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 22:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 23:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 24:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 25:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 26:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 27:
                        clear();
                        System.out.println("Ghost Name\nLore\n\nAbility\nEvidence:\nevidence1\nevidence2\nevidence3\n\nPress Enter to continue");
                        input.nextLine();
                        input.nextLine();
                    break;

                }
            break;
            case 4:
                clear();
                System.out.print("\nGhost slected: ");
                switch(ghostGuess){
                    case 1:
                        System.out.print("Banshee");
                    break;
                    case 2:
                        System.out.print("Demon");
                    break;
                    case 3:
                        System.out.print("Deogen");
                    break;
                    case 4:
                        System.out.print("Dayan");
                    break;
                    case 5:
                        System.out.print("Gallu");
                    break;
                    case 6:
                        System.out.print("Goryo");
                    break;
                    case 7:
                        System.out.print("Hantu");
                    break;
                    case 8:
                        System.out.print("Jinn");
                    break;
                    case 9:
                        System.out.print("Mare");
                    break;
                    case 10:
                        System.out.print("Moroi");
                    break;
                    case 11:
                        System.out.print("Myling");
                    break;
                    case 12:
                        System.out.print("Obake");
                    break;
                    case 13:
                        System.out.print("Obambo");
                    break;
                    case 14:
                        System.out.print("Oni");
                    break;
                    case 15:
                        System.out.print("Onyro");
                    break;
                    case 16:
                        System.out.print("Phantom");
                    break;
                    case 17:
                        System.out.print("Poltergist");
                    break;
                    case 18:
                        System.out.print("Rajiu");
                    break;
                    case 19:
                        System.out.print("Revenant");
                    break;
                    case 20:
                        System.out.print("Shade");
                    break;
                    case 21:
                        System.out.print("Spirit");
                    break;
                    case 22:
                        System.out.print("Thaye");
                    break;
                    case 23:
                        System.out.print("The Mimic");
                    break;
                    case 24:
                        System.out.print("The Twins");
                    break;
                    case 25:
                        System.out.print("Wraith");
                    break;
                    case 26:
                        System.out.print("Yurei");
                    break;
                    case 27:
                        System.out.print("Yokai");
                    break;
                }
                System.out.println("\nConfirm Guess");
                System.out.println("1) Yes");
                System.out.println("2) No");
                if(input.nextInt() == 1){
                   if(ghostGuess == ghostType){
                        clear();
                        System.out.println("You Win :)");
                        System.exit(0);
                   } else {
                    clear();
                    System.out.println("You lose :(");
                    System.exit(0);
                   }
                }
                break;
        }
    }
}