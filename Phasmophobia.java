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
    public static void main(String[] args){
        ghosts();
        boolean leaveGame = false;
        printMap();
        do{
            playerInput();
            printMap();
        }while(leaveGame == false);
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
        System.out.println(playerX + " " + playerY);
        return tangleWood;
    }
    public static void printMap(){
        //receives map to print
        int[][] currentLocation = mainMap();
        //removes old map
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        //prints out new map
        for(int i = 0; i < currentLocation.length; i++){
            for(int j = 0; j < currentLocation[0].length; j++){
                switch (currentLocation[i][j]){
                    case 0:
                        System.out.print("  ");
                    break;
                    case 1:
                        System.out.print((char)9632);
                        System.out.print((char)9632);
                    break;
                    case 2:
                        System.out.print("HH");
                    break;
                    case 3:
                        System.out.print("XX");
                    break;
                    case 4:
                        System.out.print("()");
                    break;
                    case 5:
                        System.out.print("<>");
                    break;
                }
            }
            System.out.println();
        }
    }
    public static void playerInput(){
        int[][] map = mainMap();
        System.out.println("Enter a direction then press ENTER\nw)up\na)left\ns)down\nd)right");
        //receives input from player to move player
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
        }
    }
    public static void journal(){
        Scanner input = new Scanner(System.in);
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        if(!(freezing == true || writing == true || box == true || emf == true)) System.out.println("Banshee"); 
        if(!(box == true || emf == true || dots == true || orb == true)) System.out.println("Demon");
        if(!(emf == true || orb == true || freezing == true || uv == true)) System.out.println("Deogen");
        if(!(freezing == true || writing == true || uv == true || dots == true)) System.out.println("Dayan");
        if(!(freezing == true || writing == true || dots == true || box == true)) System.out.println("Gallu");
        if(!(freezing == true || writing == true || box == true || orb == true)) System.out.println("Goryo");
        if(!(writing == true || box == true || emf == true || dots == true)) System.out.println("Hantu");
        if(!(writing == true || box == true || orb == true || dots == true)) System.out.println("Jinn");
        if(!(dots == true || freezing == true || emf == true || uv == true)) System.out.println("Mare");
        if(!(dots == true || emf == true || uv == true || orb == true)) System.out.println("Moroi");
        if(!(dots == true || orb == true || freezing == true || box == true)) System.out.println("Myling");
        if(!(dots == true || freezing == true || box == true || writing == true)) System.out.println("Obake");
        if(!(freezing == true || box == true || emf == true || orb == true)) System.out.println("Obambo");
        if(!(box == true || orb == true || writing == true || uv == true)) System.out.println("Oni");
        if(!(writing == true || uv == true || dots == true || emf == true)) System.out.println("Onryo");
        if(!(writing == true || emf == true || orb == true || freezing == true)) System.out.println("Phantom");
        if(!(emf == true || orb == true || freezing == true || dots == true)) System.out.println("Poltergeist");
        if(!(writing == true || freezing == true || box == true || uv == true)) System.out.println("Raiju");
        if(!(emf == true || box == true || uv == true || dots == true)) System.out.println("Revenant");
        if(!(box == true || uv == true || dots == true || orb == true)) System.out.println("Shade");
        if(!(uv == true || dots == true || orb == true || freezing == true)) System.out.println("Spirit");
        if(!(uv == true || freezing == true || box == true || emf == true)) System.out.println("Thaye");
        if(!(emf == true || writing == true || orb == true || dots == true)) System.out.println("The Mimic");
        if(!(writing == true || orb == true || dots == true || uv == true)) System.out.println("The Twins");
        if(!(writing == true || orb == true || uv == true || freezing == true)) System.out.println("Wraith");
        if(!(writing == true || uv == true || emf == true || box == true)) System.out.println("Yurei");
        if(!(writing == true || uv == true || emf == true || freezing == true)) System.out.println("Yokai");
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
    }
}