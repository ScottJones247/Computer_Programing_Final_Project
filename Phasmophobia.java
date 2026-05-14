import java.util.Random;
import java.util.Scanner;
class Phasmophobia{
    public static int playerX = 29;
    public static int playerY = 9;
    public static int sanity = 100;
    public static int ghostX = 0;
    public static int ghostY = 0;
    public static int ghostType = 0;
    public static String ghostroom = "";
    public static String currentRoom = "";
    public static boolean gEvent = false;
    public static boolean gInteract = false;
    public static boolean appear = false;
    public static String ghostTypes[][] = {
            {"Banshee", "Demon", "Deogen", "Dayan", "Gallu", "Goryo", "Hantu", "Jinn", "Mare", "Moroi", "Myling", "Obake", "Obambo", "Oni", "Onryo", "Phamtom", "Poltergeist", "Raiju", "Revenant", "Shade", "Spirit", "Thaye", "The Mimic", "The Twins", "Wraith", "Yurei", "Yokai"}, //ghost types
            {"DOTS", "Freezing", "DOTS", "EMF 5", "EMF 5", "DOTS", "Freezing", "EMF 5", "Ghost Orb", "Freezing", "EMF 5", "EMF 5", "DOTS", "DOTS", "Freezing", "DOTS", "Ghost Writing", "DOTS", "Freezing", "EMF 5", "EMF 5", "DOTS", "Freezing", "EMF 5", "DOTS", "DOTS", "DOTS"}, //evidence 1
            {"Ghost Orb", "Ghost Writing", "Ghost Writing", "Ghost Orb", "Ghost Orb", "EMF 5", "Ghost Orb", "Freezing", "Ghost Writing", "Ghost Writing", "Ghost Writing", "Ghost Orb", "Ghost Writing", "EMF 5", "Ghost Orb", "Spirit Box", "Spirit Box", "EMF 5", "Ghost Orb", "Freezing", "Ghost Writing", "Ghost Orb", "Spirit Box", "Freezing", "EMF 5", "Freezing", "Ghost Orb"}, // evidence 2
            {"Ultraviolet", "Ultraviolet", "Spirit Box", "Spirit Box", "Ultraviolet", "Ultraviolet", "Ultraviolet", "Ultraviolet", "Spirit Box", "Spirit Box", "Ultraviolet", "Ultraviolet", "Ultraviolet", "Freezing", "Spirit Box", "Ultraviolet", "Ultraviolet", "Ghost Orb", "Ghost Writing", "Ghost Writing", "Spirit Box", "Ghost Writing", "Ultraviolet", "Spirit Box", "Spirit Box", "Ghost Orb", "Spirit Box"}, // evidence 3
            {"singing", "hunt", "location", "movement", "protection", "dots", "freezing", "fuse", "light", "sanity", "parabolic", "fingerprint", "agressive", "activity", "flame", "stalk", "throw", "electronic", "speed", "shy", "none", "age", "mimic", "interact", "salt", "door", "listen"}, // ghost ability
        };
    public static String playerInventory[] = {"Spirit Box","Video camera","Ultraviolet","Thermometer","EMF Reader","D.O.T.S. Pen","Spirit Book",""};
    public static String playerHolding = playerInventory[7];
    //main, boys, mainbath, nursery, masterbed, mastercloset, masterbath, basement, utility, garage
    public static boolean doors[] = {true, true, true, true, true, true, true, true, true, true};
    public static void main(String[] args){
        ghosts();
        boolean leaveGame = false;
        printMap();
        do{
            playerInput();
            ghostActive();
            printMap();
        }while(leaveGame == false);
    }
    public static void clear(){
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    public static void ghosts(){
        Random r = new Random();
        int i = r.nextInt(28);
        String[] ghost = new String[5];
        ghost[0] = ghostTypes[0][i];
        ghost[1] = ghostTypes[1][i]; // evidence 1
        ghost[2] = ghostTypes[2][i]; // evidence 2
        ghost[3] = ghostTypes[3][i]; // evidence 3
        ghost[4] = ghostTypes[4][i];
        int froom = r.nextInt(11);
        switch(froom + 1){
            case 1:
                ghostroom = "Foyer";
                ghostX = 19;
                ghostY = 7;
            break;
            case 2:
                ghostroom = "Bathroom";
                ghostX = 21;
                ghostY = 2;
            break;
            case 3:
                ghostroom = "Boy's Bedroom";
                ghostX = 26;
                ghostY = 3;
            break;
            case 4:
                ghostroom = "Nursery";
                ghostX = 12;
                ghostY = 2;
            break;
            case 5:
                ghostroom = "Master Bedroom";
                ghostX = 5;
                ghostY = 4;
            break;
            case 6:
                ghostroom = "Living Room";
                ghostX = 5;
                ghostY = 10;
            break;
            case 7:
                ghostroom = "Utility Room";
                ghostX = 12;
                ghostY = 14;
            break;
            case 8:
                ghostroom = "Kitchen";
                ghostX = 13;
                ghostY = 18;
            break;
            case 9:
                ghostroom = "Dining Room";
                ghostX = 5;
                ghostY = 19;
            break;
            case 10:
                ghostroom = "Basement";
                ghostX = 6;
                ghostY = 29;
            break;
            case 11:
                ghostroom = "Garage";
                ghostX = 18;
                ghostY = 17;
            break;
        }
        System.out.println(ghostroom + " " + froom);
        System.out.println(ghost[0] + " " + ghost[1] + " " + ghost[2] + " " + ghost[3] + " " + ghost[4]);
        for(int a = 0; a < ghostTypes[0].length; a++){
            if(ghostTypes[0][a].equals(ghost[0])){
                ghostType = a + 1;
            }
        }
        System.out.println("ghost type: " + ghostType);
    }
    public static void ghostActive(){
        Random r = new Random();
        if((r.nextInt(130) + 1) < sanity){
            
        } else {

        }
    }
    public static void ghostEvent(){
        Random r = new Random();
        int chance = r.nextInt(100) + 1;
        switch(ghostType){
            case 1: //banshee
                if(chance <= 47){
                switch (r.nextInt(5)){
                    case 0:
                        System.out.println("A eerie humming can he heard, soft and familliar");
                        System.out.println("It becons you to come and join it in the life beyond");
                    break;
                    case 1:
                        System.out.println("Where is that humming coming from?");
                    break;
                    case 2:
                        System.out.println("That's a creepy song...");
                    break;
                    case 3:
                        System.out.println("Do I hear... singing?");
                    break;
                    case 4:
                        System.out.println("Ring around the rosey...");
                    break;
                }
                } 
                if(chance > 47 && chance <= 60){
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("Somewhere in the house, you hear a lightbulb shatter");
                    break;
                    case 1:
                        System.out.println("Where did the lights go?");
                    break;
                    case 2:
                        System.out.println("THE LIGHTS JUST WENT RED!");
                    break;
                    case 3:
                        System.out.println("You hear a soft click as the lights in the room fade to black");
                    break;
                    case 4:
                        System.out.println("I can't see anything...");
                    break;
                }
                }
                if(chance > 60 && chance <= 80){
                    appear = true;
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("A figure dances across the walls, shadowy in form");
                    break;
                    case 1:
                        System.out.println("Hello there!");
                    break;
                    case 2:
                        System.out.println("What is that?");
                    break;
                    case 3:
                        System.out.println("Did thar shadow just move?");
                    break;
                    case 4:
                        System.out.println("A shiver runs down your spine as a hollowed form of the Ghost crosses your vision");
                    break;
                }
                }
                if(chance > 80){
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("Did it just scream?!");
                    break;
                    case 1:
                        System.out.println("Am I hearing things?");
                    break;
                    case 2:
                        System.out.println("The silent whispers from the dead fill the room");
                    break;
                    case 3:
                        System.out.println("Is it... talking?");
                    break;
                    case 4:
                        System.out.println("The room echos with melodius shrieks");
                    break;
                }
                }
            break;
            case 9: //mare
                if(chance <= 20){
                switch (r.nextInt(5)){
                    case 0:
                        System.out.println("A eerie humming can he heard, soft and familliar");
                        System.out.println("It becons you to come and join it in the life beyond");
                    break;
                    case 1:
                        System.out.println("Where is that humming coming from?");
                    break;
                    case 2:
                        System.out.println("That's a creepy song...");
                    break;
                    case 3:
                        System.out.println("Do I hear... singing?");
                    break;
                    case 4:
                        System.out.println("Ring around the rosey...");
                    break;
                }
                } 
                if(chance > 20 && chance <= 36){
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("Somewhere in the house, you hear a lightbulb shatter");
                    break;
                    case 1:
                        System.out.println("Where did the lights go?");
                    break;
                    case 2:
                        System.out.println("THE LIGHTS JUST WENT RED!");
                    break;
                    case 3:
                        System.out.println("You hear a soft click as the lights in the room fade to black");
                    break;
                    case 4:
                        System.out.println("I can't see anything...");
                    break;
                }
                }
                if(chance > 36 && chance <= 80){
                    appear = true;
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("A figure dances across the walls, shadowy in form");
                    break;
                    case 1:
                        System.out.println("Hello there!");
                    break;
                    case 2:
                        System.out.println("What is that?");
                    break;
                    case 3:
                        System.out.println("Did thar shadow just move?");
                    break;
                    case 4:
                        System.out.println("A shiver runs down your spine as a hollowed form of the Ghost crosses your vision");
                    break;
                }
                }
                if(chance > 80){
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("Did it just scream?!");
                    break;
                    case 1:
                        System.out.println("Am I hearing things?");
                    break;
                    case 2:
                        System.out.println("The silent whispers from the dead fill the room");
                    break;
                    case 3:
                        System.out.println("Is it... talking?");
                    break;
                    case 4:
                        System.out.println("The room echos with melodius shrieks");
                    break;
                }
                }
            break;
            case 11://myling
                if(chance <= 0){
                switch (r.nextInt(5)){
                    case 0:
                        System.out.println("A eerie humming can he heard, soft and familliar");
                        System.out.println("It becons you to come and join it in the life beyond");
                    break;
                    case 1:
                        System.out.println("Where is that humming coming from?");
                    break;
                    case 2:
                        System.out.println("That's a creepy song...");
                    break;
                    case 3:
                        System.out.println("Do I hear... singing?");
                    break;
                    case 4:
                        System.out.println("Ring around the rosey...");
                    break;
                }
                } 
                if(chance > 0 && chance <= 13){
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("Somewhere in the house, you hear a lightbulb shatter");
                    break;
                    case 1:
                        System.out.println("Where did the lights go?");
                    break;
                    case 2:
                        System.out.println("THE LIGHTS JUST WENT RED!");
                    break;
                    case 3:
                        System.out.println("You hear a soft click as the lights in the room fade to black");
                    break;
                    case 4:
                        System.out.println("I can't see anything...");
                    break;
                }
                }
                if(chance > 13 && chance <= 60){
                    appear = true;
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("A figure dances across the walls, shadowy in form");
                    break;
                    case 1:
                        System.out.println("Hello there!");
                    break;
                    case 2:
                        System.out.println("What is that?");
                    break;
                    case 3:
                        System.out.println("Did thar shadow just move?");
                    break;
                    case 4:
                        System.out.println("A shiver runs down your spine as a hollowed form of the Ghost crosses your vision");
                    break;
                }
                }
                if(chance > 60){
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("Did it just scream?!");
                    break;
                    case 1:
                        System.out.println("Am I hearing things?");
                    break;
                    case 2:
                        System.out.println("The silent whispers from the dead fill the room");
                    break;
                    case 3:
                        System.out.println("Is it... talking?");
                    break;
                    case 4:
                        System.out.println("The room echos with melodius shrieks");
                    break;
                }
                }
            break;
            case 14://oni
                if(chance <= 20){
                switch (r.nextInt(5)){
                    case 0:
                        System.out.println("A eerie humming can he heard, soft and familliar");
                        System.out.println("It becons you to come and join it in the life beyond");
                    break;
                    case 1:
                        System.out.println("Where is that humming coming from?");
                    break;
                    case 2:
                        System.out.println("That's a creepy song...");
                    break;
                    case 3:
                        System.out.println("Do I hear... singing?");
                    break;
                    case 4:
                        System.out.println("Ring around the rosey...");
                    break;
                }
                } 
                if(chance > 20 && chance <= 33){
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("Somewhere in the house, you hear a lightbulb shatter");
                    break;
                    case 1:
                        System.out.println("Where did the lights go?");
                    break;
                    case 2:
                        System.out.println("THE LIGHTS JUST WENT RED!");
                    break;
                    case 3:
                        System.out.println("You hear a soft click as the lights in the room fade to black");
                    break;
                    case 4:
                        System.out.println("I can't see anything...");
                    break;
                }
                }
                if(chance > 33 && chance <= 100){
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("A figure dances across the walls, shadowy in form");
                    break;
                    case 1:
                        System.out.println("Hello there!");
                    break;
                    case 2:
                        System.out.println("What is that?");
                    break;
                    case 3:
                        System.out.println("Did thar shadow just move?");
                    break;
                    case 4:
                        System.out.println("A shiver runs down your spine as a hollowed form of the Ghost crosses your vision");
                    break;
                }
                }
                if(chance > 100){
                    appear = true;
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("Did it just scream?!");
                    break;
                    case 1:
                        System.out.println("Am I hearing things?");
                    break;
                    case 2:
                        System.out.println("The silent whispers from the dead fill the room");
                    break;
                    case 3:
                        System.out.println("Is it... talking?");
                    break;
                    case 4:
                        System.out.println("The room echos with melodius shrieks");
                    break;
                }
                }
            break;
            case 20://shade
                if(chance <= 0){
                switch (r.nextInt(5)){
                    case 0:
                        System.out.println("A eerie humming can he heard, soft and familliar");
                        System.out.println("It becons you to come and join it in the life beyond");
                    break;
                    case 1:
                        System.out.println("Where is that humming coming from?");
                    break;
                    case 2:
                        System.out.println("That's a creepy song...");
                    break;
                    case 3:
                        System.out.println("Do I hear... singing?");
                    break;
                    case 4:
                        System.out.println("Ring around the rosey...");
                    break;
                }
                } 
                if(chance > 0 && chance <= 13){
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("Somewhere in the house, you hear a lightbulb shatter");
                    break;
                    case 1:
                        System.out.println("Where did the lights go?");
                    break;
                    case 2:
                        System.out.println("THE LIGHTS JUST WENT RED!");
                    break;
                    case 3:
                        System.out.println("You hear a soft click as the lights in the room fade to black");
                    break;
                    case 4:
                        System.out.println("I can't see anything...");
                    break;
                }
                }
                if(chance > 13 && chance <= 40){
                    appear = true;
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("A figure dances across the walls, shadowy in form");
                    break;
                    case 1:
                        System.out.println("Hello there!");
                    break;
                    case 2:
                        System.out.println("What is that?");
                    break;
                    case 3:
                        System.out.println("Did thar shadow just move?");
                    break;
                    case 4:
                        System.out.println("A shiver runs down your spine as a hollowed form of the Ghost crosses your vision");
                    break;
                }
                }
                if(chance > 40){
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("Did it just scream?!");
                    break;
                    case 1:
                        System.out.println("Am I hearing things?");
                    break;
                    case 2:
                        System.out.println("The silent whispers from the dead fill the room");
                    break;
                    case 3:
                        System.out.println("Is it... talking?");
                    break;
                    case 4:
                        System.out.println("The room echos with melodius shrieks");
                    break;
                }
                }
            break;
            default://normal ghost
                if(chance <= 20){
                switch (r.nextInt(5)){
                    case 0:
                        System.out.println("A eerie humming can he heard, soft and familliar");
                        System.out.println("It becons you to come and join it in the life beyond");
                    break;
                    case 1:
                        System.out.println("Where is that humming coming from?");
                    break;
                    case 2:
                        System.out.println("That's a creepy song...");
                    break;
                    case 3:
                        System.out.println("Do I hear... singing?");
                    break;
                    case 4:
                        System.out.println("Ring around the rosey...");
                    break;
                }
                } 
                if(chance > 20 && chance <= 33){
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("Somewhere in the house, you hear a lightbulb shatter");
                    break;
                    case 1:
                        System.out.println("Where did the lights go?");
                    break;
                    case 2:
                        System.out.println("THE LIGHTS JUST WENT RED!");
                    break;
                    case 3:
                        System.out.println("You hear a soft click as the lights in the room fade to black");
                    break;
                    case 4:
                        System.out.println("I can't see anything...");
                    break;
                }
                }
                if(chance > 33 && chance <= 80){
                    appear = true;
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("A figure dances across the walls, shadowy in form");
                    break;
                    case 1:
                        System.out.println("Hello there!");
                    break;
                    case 2:
                        System.out.println("What is that?");
                    break;
                    case 3:
                        System.out.println("Did thar shadow just move?");
                    break;
                    case 4:
                        System.out.println("A shiver runs down your spine as a hollowed form of the Ghost crosses your vision");
                    break;
                }
                }
                if(chance > 80){
                    switch (r.nextInt(5)){
                    case 0:
                        System.out.println("Did it just scream?!");
                    break;
                    case 1:
                        System.out.println("Am I hearing things?");
                    break;
                    case 2:
                        System.out.println("The silent whispers from the dead fill the room");
                    break;
                    case 3:
                        System.out.println("Is it... talking?");
                    break;
                    case 4:
                        System.out.println("The room echos with melodius shrieks");
                    break;
                }
                }
            break;
        }
    }
    public static void ghostInteraction(){

    }
    public static int roomTemp = 20;
    public static void ghostEvidence(){
        Random r = new Random();
        if(currentRoom == ghostroom){
            roomTemp = 10;
        }else{
            roomTemp = 20;
        }
        if(playerHolding.equals("Thermometer")) System.out.println("Room Temp: " + roomTemp);
        int ghostdistance = (int)(Math.sqrt((Math.pow((playerX - ghostX) , 2)) + (Math.pow((playerY - ghostY) , 2))));
        System.out.println(ghostdistance);
        if(currentRoom == ghostroom){
            switch (playerHolding){
                case "Spirit Box":
                    if(ghostTypes[1][ghostType].equals("Spirit Box") || ghostTypes[2][ghostType].equals("Spirit Box") || ghostTypes[3][ghostType].equals("Spirit Box")){
                        if(ghostdistance <= 5){
                            if((r.nextInt(10)+1)>=5)
                                System.out.println("I heard Spirit Box!");
                        }    
                    }
                break;
                case "Video camera":
                    if(ghostTypes[1][ghostType].equals("Ghost Orb") || ghostTypes[2][ghostType].equals("Ghost Orb") || ghostTypes[3][ghostType].equals("Ghost Orb")){
                            if((r.nextInt(10)+1)>=5){
                                System.out.println("I saw a Ghost Orb!");
                            }
                    }
                break;
                case "Ultraviolet":
                    if(ghostTypes[1][ghostType].equals("Ultraviolet") || ghostTypes[2][ghostType].equals("Ultraviolet") || ghostTypes[3][ghostType].equals("Ultraviolet")){
                        if(ghostdistance <= 5){
                            if((r.nextInt(10)+1)>=5)
                                System.out.println("I saw a hand print!");
                        }    
                    }
                break;
                case "Thermometer":
                    if(ghostTypes[1][ghostType].equals("freezing") || ghostTypes[2][ghostType].equals("freezing") || ghostTypes[3][ghostType].equals("freezing")){
                            roomTemp = roomTemp - r.nextInt(20);    
                    }
                break;
                case "EMF Reader":
                    if(ghostTypes[1][ghostType].equals("EMF 5") || ghostTypes[2][ghostType].equals("EMF 5") || ghostTypes[3][ghostType].equals("EMF 5")){
                            if((r.nextInt(10)+1)>=5){
                                System.out.println("Ghost activity is a 5!");
                            }
                    }
                break;
                case "D.O.T.S. Pen":
                    if(ghostTypes[1][ghostType].equals("dots") || ghostTypes[2][ghostType].equals("dots") || ghostTypes[3][ghostType].equals("dots")){
                            if((r.nextInt(10)+1)>=5){
                                System.out.println("I saw a D.O.T.S.!");
                            }
                    }
                break;
                case "Spirit Book":
                    if(ghostTypes[1][ghostType].equals("Ghost Writing") || ghostTypes[2][ghostType].equals("Ghost Writing") || ghostTypes[3][ghostType].equals("Ghost Writing")){
                        if(ghostdistance <= 5){
                            if((r.nextInt(10)+1)>=5)
                                System.out.println("The Ghost wrote in the book!");
                        }    
                    }
                break;
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
            {1,1,1,7,1,7,1,1,3,0,3,0,3,1,0,0,1,0,3,3,3,0,1,1,0,0,1,0,0,0,0,3,1},
            {1,3,3,0,0,0,0,1,3,0,0,0,3,1,0,0,1,0,0,0,0,0,1,1,0,0,1,3,3,0,0,3,1},
            {1,0,0,0,0,0,3,1,3,0,0,0,3,1,0,0,1,0,0,0,0,3,1,1,0,0,1,0,0,0,0,0,1},
            {1,0,3,3,0,0,3,1,3,0,0,0,3,1,1,7,1,0,0,0,0,3,1,1,0,0,1,3,3,0,3,3,1},
            {1,3,3,3,0,0,3,1,3,0,0,0,0,0,0,0,0,0,0,0,0,3,1,1,0,0,1,0,0,0,0,0,1},
            {1,1,1,1,1,0,0,1,3,0,0,0,0,0,0,0,0,0,3,3,0,3,1,1,1,7,1,3,3,0,3,3,1},
            {1,0,0,2,1,7,1,1,3,0,0,1,1,1,7,1,1,0,3,3,0,3,1,1,1,1,1,2,0,0,0,0,1},
            {1,3,0,3,1,0,0,0,0,0,0,1,3,0,0,0,1,0,3,3,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,3,1,0,0,0,0,0,0,1,3,0,0,0,1,0,3,3,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,0,0,0,1,1,1,1,0,0,1,1,3,0,0,0,1,0,0,0,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,0,0,7,0,0,1,0,0,2,1,3,0,0,0,1,3,3,3,3,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,3,3,1,0,0,1,0,0,2,1,1,1,7,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,0,0,1,0,0,1,1,3,0,0,0,0,0,0,0,3,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,2,0,0,1,0,0,1,1,3,0,0,0,0,0,0,0,0,2,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,2,0,0,1,0,3,1,1,3,0,0,0,0,0,0,0,0,2,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,0,0,0,0,3,1,1,3,0,0,3,3,3,3,0,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,3,3,1,0,0,0,0,3,1,1,3,0,0,3,3,3,3,0,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,0,0,1,0,0,1,0,0,1,1,3,0,0,3,3,3,3,0,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,0,0,7,0,0,1,0,0,1,1,3,0,0,3,3,3,3,0,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,7,1,1,1,7,1,1,3,0,0,3,3,3,3,0,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,3,3,0,0,0,1,2,2,2,1,3,0,0,0,0,0,0,0,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,0,0,0,0,0,1,2,2,2,1,3,0,0,0,0,0,0,0,0,3,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,0,0,0,1,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,3,3,0,2,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,3,3,3,0,2,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1,2,2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
        };
        tangleWood[playerX][playerY] = 4;
        if(appear){
            tangleWood[ghostX][ghostY] = 5;
        }
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
                        appear = false;
                    break;
                    case 6:
                        //closed door
                        System.out.print("==");
                    break;
                    case 7:
                        //Open door
                        System.out.print("||");
                    break;
                }
            }
            System.out.println();
        }
        hud();
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
                if(map[playerX - 1][playerY] == 0 || map[playerX - 1][playerY] == 2 || map[playerX - 1][playerY] == 7) playerX--;
            break;
            case "a":
                if(map[playerX][playerY - 1] == 0 || map[playerX][playerY - 1] == 2 || map[playerX][playerY - 1] == 7) playerY--;
            break;
            case "s":
                if(map[playerX + 1][playerY] == 0 || map[playerX + 1][playerY] == 2 || map[playerX + 1][playerY] == 7) playerX++;
            break;
            case "d":
                if(map[playerX][playerY + 1] == 0 || map[playerX][playerY + 1] == 2 || map[playerX][playerY + 1] == 7) playerY++;
            break;
            case "j":
                journal();
            break;
            case "q":
                switch(playerHolding){
                    case "Spirit Box":
                        playerHolding = "Video camera";
                    break;
                    case "Video camera":
                        playerHolding = "Ultraviolet";
                    break;
                    case "Ultraviolet":
                        playerHolding = "Thermometer";
                    break;
                    case "Thermometer":
                        playerHolding = "EMF Reader";
                    break;
                    case "EMF Reader":
                        playerHolding = "D.O.T.S. Pen";
                    break;
                    case "D.O.T.S. Pen":
                        playerHolding = "Spirit Book";
                    break;
                    case "Spirit Book":
                        playerHolding = "";
                    break;
                    case "":
                        playerHolding = "Spirit Box";
                    break;
                }
            break;
            case "c":
                System.out.println("w) move up");
                System.out.println("a) move left");
                System.out.println("s) move right");
                System.out.println("d) move down");
                System.out.println("j) open journal");
                System.out.println("q) cycle items");
                System.out.println("Press Enter to continue");
                input.nextLine();
                printMap();
            break;
        }
    }
    public static void room(){
        if((playerX > 0 && playerY > 0) && (playerY < 7 && playerX < 9)) currentRoom = "Master Bedroom";
        else if((playerY > 8 && playerX > 0) && (playerY < 13 && playerX < 10)) currentRoom = "Living Room";
        else if((playerY > 23 && playerX > 0) && (playerY < 32 && playerX < 11)) currentRoom = "Basement";
        else if((playerY > 11 && playerX > 16) && (playerY < 22 && playerX < 26)) currentRoom = "Garage";
        else if((playerY > 16 && playerX > 0) && (playerY < 22 && playerX < 7)) currentRoom = "Dining Room";
        else if((playerY > 16 && playerX > 8) && (playerY < 22 && playerX < 15)) currentRoom = "Kitchen";
        else if((playerY > 4 && playerX > 13) && (playerY < 10 && playerX < 23)) currentRoom = "Foyer";
        else if((playerY > 0 && playerX > 24) && (playerY < 7 && playerX < 29)) currentRoom = "Boy's Bedroom";
        else if((playerY > 0 && playerX > 10) && (playerY < 3 && playerX < 16)) currentRoom = "Nursery";
        else if((playerY > 11 && playerX > 11) && (playerY < 15 && playerX < 15)) currentRoom = "Utility Room";
        else if((playerY > 0 && playerX > 19) && (playerY < 3 && playerX < 23)) currentRoom = "Bathroom";
        else currentRoom = "";
    }
    public static void playerSanity(){
        Random r = new Random();
        if(r.nextInt(10)+1 >=5 ){
        if(currentRoom == ghostroom) sanity--;
        }
        System.out.println("Current Sanity: "+sanity);
    }
    public static void hud(){
        room();
        //System.out.println("Current Room: " + currentRoom);
        playerSanity();
        System.out.println("Holding: " + playerHolding);
        ghostEvidence();
        if(gEvent){
            ghostEvent();
            gEvent = false;
        }
        if(gInteract){
            ghostInteraction();
            gInteract = false;
        }
        
        
    }
    public static boolean dots = false;
    public static boolean emf = false;
    public static boolean freezing = false;
    public static boolean orb = false;
    public static boolean writing = false;
    public static boolean box = false;
    public static boolean uv = false;
    public static int ghostGuess = 0;
    public static void journal(){
        Scanner input = new Scanner(System.in);
        clear();
        System.out.println("1) Select Ghost Type");
        System.out.println("2) Enter Evidence");
        System.out.println("3) Read about Ghosts");
        System.out.println("4) Finish game");
        switch(input.nextInt()){
            case 1: //ghost selection
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
            case 2://evidence selection
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
            case 3://read about ghost
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
                    case 1://banshee
                        clear();
                        System.out.println("Banshee");
                        System.out.println("The singing siren, known for attracting its victims through song.\nIt has been known to single out its prey before making a killing blow.");
                        System.out.println("\nAbility:\nIncreased chance of performing a singing event.");
                        System.out.println("\nEvidence:\nD.O.T.S.\nGhost Orb\nUltraviolet");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 2://demon
                        clear();
                        System.out.println("Demon");
                        System.out.println("A Demon is one of the worst ghosts you can encounter.\nIt has been known to attack without reason.");
                        System.out.println("\nAbility:\nCan rarely initiate a hunt at any sanity level.");
                        System.out.println("\nEvidence:\nFreezing Tempratures\nGhost Writing\nUltraviolet");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 3://deogen
                        clear();
                        System.out.println("Deogen");
                        System.out.println("Sometimes surrounded by an endless fog, Deogen have been eluding ghost hunters for years.\nThese ghosts have been reported to find even the most hidden prey, before stalking them into exhaustion.");
                        System.out.println("\nAbility:\nAlways knows the location of the player during a hunt.");
                        System.out.println("\nEvidence:\nD.O.T.S.\nGhost Writing\nSpirit Box");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 4://dayan
                        clear();
                        System.out.println("Dayan");
                        System.out.println("The Dayan is born from the soul of someone who suffered immense cruelty in life.\nNow, in death, she is hyper-vigilant of anyone who 'dances' too close.");
                        System.out.println("\nAbility:\nMoves faster if the player is moving.");
                        System.out.println("\nEvidence:\nEMF Level 5\nGhost Orb\nSpirit Box");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 5://gallu
                        clear();
                        System.out.println("Gallu");
                        System.out.println("Another form of demon, the Gallu is a reminder that death comes for us all.\nUsing protective equipment provokes the ghost until it's no longer effective.");
                        System.out.println("\nAbility:\nBecomes aggressive when protective equipment is used.");
                        System.out.println("\nEvidence:\nEMF Level 5\nGhost Orb\nUltraviolet");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 6://goryo
                        clear();
                        System.out.println("Goryo");
                        System.out.println("When a Goryo passes through a DOTS projector, using a video camera is the only way to see it.");
                        System.out.println("\nAbility:\nIts D.O.T.S. silhouette can only be seen through a video camera");
                        System.out.println("\nEvidence:\nD.O.T.S.\nEMF Level 5\nUltraviolet");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 7://hantu
                        clear();
                        System.out.println("Hantu");
                        System.out.println("Hantu is a rare ghost that thrives in the coldest climates.\nThe cold seems to make them more aggressive and empowered.");
                        System.out.println("\nAbility:\nMoves faster in lower tempratures");
                        System.out.println("\nEvidence:\nFreezing Tempratures\nGhost Orb\nUltraviolet");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 8://jinn
                        clear();
                        System.out.println("Jinn");
                        System.out.println("A Jinn is a territorial ghost that will attack when threatened.\nIt has also been known to be able to travel at significant speed.");
                        System.out.println("\nAbility:\nMoves faster if the player is far away");
                        System.out.println("\nEvidence:\nEMF Level 5\nFreezing Tempatures\nUltraviolet");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 9://mare
                        clear();
                        System.out.println("Mare");
                        System.out.println("A Mare is the source of all nightmares, making it most powerful in the dark.");
                        System.out.println("\nAbility:\nWill never turn a light on.");
                        System.out.println("\nEvidence:\nGhost Orb\nGhost Writing\nSpirit Box");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 10://moroi
                        clear();
                        System.out.println("Moroi");
                        System.out.println("Moroi have risen from the grave to drain energy from the living.\nThey have been known to place curses on their victims, curable only by antidotes or moving very far away.");
                        System.out.println("\nAbility:\nMoves faster based on player sanity");
                        System.out.println("\nEvidence:\nFreezing Tempratures\nGhost Writing\nSpirit Box");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 11://myling
                        clear();
                        System.out.println("Myling");
                        System.out.println("A Myling is a very vocal and active ghost.\nThey are rumoured to be quiet when hunting their prey.");
                        System.out.println("\nAbility:\nProduced paranormal sounds more frequently");
                        System.out.println("\nEvidence:\nEMF Level 5\nGhost Writing\nUltraviolet");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 12://obake
                        clear();
                        System.out.println("Obake");
                        System.out.println("Obake are terrifying shape-shifters, capable of taking on many forms.\nThey have been seen taking on humanoid shapes to attract their prey.");
                        System.out.println("\nAbility:\nHas a small chance of leaving special fingerprints.");
                        System.out.println("\nEvidence:\nEMF Level 5\nGhost Orb\nUltraviolet");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 13://obambo
                        clear();
                        System.out.println("Obambo");
                        System.out.println("The Obambo is the ghost of someone never properly laid to rest.\nFickle and defensive, it flickers between states of calm and aggression.");
                        System.out.println("\nAbility:\nHunts earlier and moves faster in its aggressive state.");
                        System.out.println("\nEvidence:\nD.O.T.S.\nGhost Writing\nUltraviolet");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 14://oni
                        clear();
                        System.out.println("Oni");
                        System.out.println("Onis love to scare their victims as much as possible before attacking.\nThey are often seen in their physical form, guarding their place of death.");
                        System.out.println("\nAbility:\nIncreased activity when players are nearby.");
                        System.out.println("\nEvidence:\nD.O.T.S.\nEMF Level 5\nFreezing Tempratures");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 15://onyro
                        clear();
                        System.out.println("Onyro");
                        System.out.println("The Onryo is often referred to as \"The Wrathful Spirit\".\nIt steals souls from dying victims' bodies to seek revenge.\nThis ghost has been known to fear any form of fire, and will do anything to be far from it.");
                        System.out.println("\nAbility:\nWill attempt to hunt after it has extinguished three flames regardless of average sanity.");
                        System.out.println("\nEvidence:\nFreexing Tempatures\nGhost Orb\nSpirit Box");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 16://phantom
                        clear();
                        System.out.println("Phantom");
                        System.out.println("A Phantom is a ghost that can possess the living, inducing fear into those around it.\nThey are most commonly summoned from Ouija Boards.");
                        System.out.println("\nAbility:\nWill walk to players location, despite there location in the house");
                        System.out.println("\nEvidence:\nD.O.T.S.\nSpirit Box\nUltraviolet");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 17://poltergist
                        clear();
                        System.out.println("Poltergist");
                        System.out.println("One of the most famous ghosts, the Poltergeist.\nKnown to manipulate objects around it to spread fear into its victims.");
                        System.out.println("\nAbility:\nCapable of throwing multiple objects at once.");
                        System.out.println("\nEvidence:\nGhost Writing\nSpirit Box\nUltraviolet");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 18://raiju
                        clear();
                        System.out.println("Raiju");
                        System.out.println("A Raiju is a demon that thrives on electrical current.\nWhile generally calm, they can become agitated when overwhelmed with power.");
                        System.out.println("\nAbility:\nMoves faster near active electronic equipment.");
                        System.out.println("\nEvidence:\nD.O.T.S.\nEMF Level 5\nGhost Orb");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 19://revenant
                        clear();
                        System.out.println("Revenant");
                        System.out.println("A Revenant is a violent ghost that will attack indiscriminately.\nTheir speed can be deceiving, as they are slow while dormant; however, as soon as they hunt they can move incredibly fast.");
                        System.out.println("\nAbility:\nMoves significantly faster when a player is detected during a hunt.");
                        System.out.println("\nEvidence:\nFreezing Tempratures\nGhost Orb\nGhost Writing");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 20://shade
                        clear();
                        System.out.println("Shade");
                        System.out.println("A Shade is known to be very shy.\nThere is evidence to suggest that a Shade will stop all paranormal activity if there are people nearby.");
                        System.out.println("\nAbility:\nCannot hunt, interact, or event if people are nearby");
                        System.out.println("\nEvidence:\nEMF Level 5\nFreezing Tempratures\nGhost Writing");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 21://spirit
                        clear();
                        System.out.println("Spirit");
                        System.out.println("Spirits are very common ghosts.\nThey are very powerful, but passive, only attacking when they need to.\nThey defend their place of death to the utmost degree, killing anyone that is caught overstaying their welcome.");
                        System.out.println("\nAbility:\nNone");
                        System.out.println("\nEvidence:\nEMF Level 5\nGhost Writing\nSpirit Box");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 22://thaye
                        clear();
                        System.out.println("Thaye");
                        System.out.println("Thaye have been known to rapidly age over time, even in the afterlife.\nFrom what we've learned, they seem to deteriorate faster while within the presence of the living.");
                        System.out.println("\nAbility:\nBecomes slower and less active over time when players are nearby.");
                        System.out.println("\nEvidence:\nD.O.T.S.\nGhost Orb\nGhost Writing");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 23://mimic
                        clear();
                        System.out.println("The Mimic");
                        System.out.println("The Mimic is an elusive, mysterious, copycat ghost that mirrors traits and behaviours from others, including other ghost types.");
                        System.out.println("\nAbility:\nCan mimic the abilities and traits of other ghosts.");
                        System.out.println("\nEvidence:\nFreezing\nSpirit Box\nUltraviolet");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 24://twins
                        clear();
                        System.out.println("The Twins");
                        System.out.println("These ghosts have been reported to mimic each other's actions.\nThey alternate their attacks to confuse their prey.");
                        System.out.println("\nAbility:\nAlternates speed bettween hunts.");
                        System.out.println("\nEvidence:\nEMF Level 5\nFreezing Tempatures\nSpirit Box");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 25://wraith
                        clear();
                        System.out.println("Wraith");
                        System.out.println("Wraiths are one of the most dangerous ghosts you will find.\nIt is also the only known ghost that has the ability of flight and has sometimes been known to travel through walls.");
                        System.out.println("\nAbility:\nWill always event near the player.");
                        System.out.println("\nEvidence:\nD.O.T.S.\nEMF Level 5\nSpirit Box");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 26://yurei
                        clear();
                        System.out.println("Yurei");
                        System.out.println("A Yurei is a ghost that has returned to the physical world, usually for the purpose of revenge or hatred.");
                        System.out.println("\nAbility:\nUsing its ability causes it to slam doors.");
                        System.out.println("\nEvidence:\nD.O.T.S.\nFreezong Tempratures\nGhost Orb");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;
                    case 27://yokai
                        clear();
                        System.out.println("Yokai");
                        System.out.println("Yokai are common ghosts that are attracted to human voices.\nThey can usually be found haunting family homes.");
                        System.out.println("\nAbility:\nCan only detect players within a short radius during a hunt.");
                        System.out.println("\nEvidence:\nD.O.T.S.\nGhost Orb\nSpirit Box");
                        System.out.println("\nPress Enter to Continue");
                        input.nextLine();
                        input.nextLine();
                    break;

                }
            break;
            case 4://end game
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
                        System.out.print("The Ghost was: ");
                        switch(ghostType){
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
                        System.exit(0);
                   } else {
                    clear();
                    System.out.println("You lose :(");
                    System.out.print("The Ghost was: ");
                        switch(ghostType){
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
                    System.exit(0);
                   }
                }
                break;
        }
    }
}