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
        /*
        dots
        ghost orb
        ghost writing
        spirit box
        freezing temps
        emf 5
        ultravoilet */
        Scanner input = new Scanner(System.in);
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Enter evidence" + "\n1)D.O.T.S. " + dots + "\n2)Ghost Orb "+ orb + "\n3)Ghost Writing " + writing + "\n4)Spirit Box " + box + "\n5)Ultraviolet " + uv + "\n6)Freezing Tempratures " + freezing + "\n7)EMF Level 5 " + emf);
        int evidence = input.nextInt();
        switch (evidence){
            case 1:
                if(dots == false) dots = true;
                else dots = false;
            break;
            case 2:
                if(orb == false) orb = true;
                else orb = false;
            break;
            case 3:
                if(writing == false) writing = true;
                else writing = false;
            break;
            case 4:
                if(box == false) box = true;
                else box = false;
            break;
            case 5:
                if(uv == false) uv = true;
                else uv = false;
            break;
            case 6:
                if(freezing == false) freezing = true;
                else freezing = false;
            break;
            case 7:
                if(emf == false) emf = true;
                else emf = false;
            break;
        }
        if(dots == true || orb == true || uv == true){
            
        }
    }
}