import java.util.Random;
import java.util.Scanner;
class Phasmophobia{
    public static void main(String[] args){
        ghosts();
        map();
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
    public static int[][] interactionMap(){
    int mainMap[][] = {
            {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,0,1,0,0,1,1,1,0,0,1,1,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,1},
            {1,1,0,0,1,0,0,1,1,0,0,1,1,1,0,0,1,0,1,1,1,0,1,1,0,0,0,0,0,0,0,1,1},
            {1,1,0,0,1,0,0,1,1,0,0,0,1,1,0,0,1,0,1,1,1,0,1,1,0,0,0,0,0,0,0,1,1},
            {1,1,1,0,1,0,1,1,1,0,1,0,1,1,0,0,1,0,1,1,1,0,1,1,0,0,1,0,0,0,0,1,1},
            {1,1,1,0,0,0,0,1,1,0,0,0,1,1,0,0,1,0,0,0,0,0,1,1,0,0,1,1,1,0,0,1,1},
            {1,0,0,0,0,0,1,1,1,0,0,0,1,1,0,0,1,0,0,0,0,1,1,1,0,0,1,0,0,0,0,0,1},
            {1,0,1,1,0,0,1,1,1,0,0,0,1,1,1,0,1,0,0,0,0,1,1,1,0,0,1,1,1,0,1,1,1},
            {1,1,1,1,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,1,0,0,0,0,0,1},
            {1,1,1,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,1,1,0,1,1,1,1,0,1,1,1,0,1,1,1},
            {1,0,0,2,1,0,1,1,1,0,0,1,1,1,0,1,1,0,1,1,0,1,1,1,1,1,1,2,0,0,0,0,1},
            {1,1,0,1,1,0,0,0,0,0,0,1,1,0,0,0,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,1,1,1,1,0,0,1,1,1,0,0,0,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,0,0,0,0,0,1,0,0,2,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,0,0,1,0,0,2,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,0,0,1,0,0,1,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,2,0,0,1,0,0,1,1,1,0,0,0,0,0,0,0,0,2,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,2,0,0,1,0,1,1,1,1,0,0,0,0,0,0,0,0,2,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,0,0,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,0,0,0,0,1,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,0,0,1,0,0,1,0,0,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,0,0,0,0,0,1,0,0,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,0,1,1,1,0,1,1,1,0,0,1,1,1,1,0,0,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,0,0,0,1,2,2,2,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,0,0,0,0,0,1,2,2,2,1,1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,0,0,0,1,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,0,2,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,0,2,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,2,3,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
        return mainMap;
    }
    public static void map(){
        // 1 = wall
        // 2 = player can enter ghost cant
        // 3 = player
        // 4 = ghost
        int[][] currentLocation = interactionMap();
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
                        System.out.print("  ");
                    break;
                    case 3:
                        System.out.print("()");
                    break;
                    case 4:
                        System.out.print("{}");
                    break;
                }
            }
            System.out.println();
        }
        move();
    }
    public static int[][] move(){
        System.out.println("Enter a direction then press ENTER\nw)up\na)left\ns)down\nd)right");
        int playerX = 0;
        int playerY = 0;
        int[][] playerLocation = interactionMap();
        for(int i = 0; i < playerLocation.length; i++){
            for(int j = 0; j < playerLocation[0].length; j++){
                if(playerLocation[i][j] == 3){
                    playerX = i;
                    playerY = j;
                    break;
                }
            }
        }
        Scanner input = new Scanner(System.in);
        String direction = input.nextLine();
        switch (direction){
            case "w":
                playerY = playerY - 1;
            break;
            case "a":
                playerX = playerX - 1;
            break;
            case "s":
                playerY = playerY + 1;
            break;
            case "d":
                playerX = playerX + 1;
            break;
        }
        playerLocation[1][0] = playerX;
        playerLocation[2][0] = playerY;
        return playerLocation;
    }
    
}