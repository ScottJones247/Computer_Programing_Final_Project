import java.util.Random;
import java.util.Scanner;
class Phasmophobia{
    public static void main(String[] args){
        System.out.println("Test");
        ghosts();
    }
    public static void ghosts(){
        Random r = new Random();
        String ghost[][] = {
             {"Banshee", "Demon", "Deogen", "Dayan", "Gallu", "Goryo", "Hantu", "Jinn", "Mare", "Moroi", "Myling", "Obake", "Obambo", "Oni", "Onryo", "Phamtom", "Poltergeist", "Raiju", "Revenant", "Shade", "Spirit", "Thaye", "The Mimic", "The Twins", "Wraith", "Yurei", "Yokai"}, //ghost types
            {"DOTS", "Freezing", "DOTS", "EMF 5", "EMF 5", "DOTS", "Freezing", "EMF 5", "Ghost Orb", "Freezing", "EMF 5", "EMF 5", "DOTS", "DOTS", "Freezing", "DOTS", "Ghost Writing", "DOTS", "Freezing", "EMF 5", "EMF 5", "DOTS", "Freezing", "EMF 5", "DOTS", "DOTS", "DOTS"}, //evidence 1
            {"Ghost Orb", "Ghost Writing", "Ghost Writing", "Ghost Orb", "Ghost Orb", "EMF 5", "Ghost Orb", "Freezing", "Ghost Writing", "Ghost Writing", "Ghost Writing", "Ghost Orb", "Ghost Writing", "EMF 5", "Ghost Orb", "Spirit Box", "Spirit Box", "EMF 5", "Ghost Orb", "Freezing", "Ghost Writing", "Ghost Orb", "Spirit Box", "Freezing", "EMF 5", "Freezing", "Ghost Orb"}, // evidence 2
            {"Ultraviolet", "Ultraviolet", "Spirit Box", "Spirit Box", "Ultraviolet", "Ultraviolet", "Ultraviolet", "Ultraviolet", "Spirit Box", "Spirit Box", "Ultraviolet", "Ultraviolet", "Ultraviolet", "Freezing", "Spirit Box", "Ultraviolet", "Ultraviolet", "Ghost Orb", "Ghost Writing", "Ghost Writing", "Spirit Box", "Ghost Writing", "Ultraviolet", "Spirit Box", "Spirit Box", "Ghost Orb", "Spirit Box"}, // evidence 3
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}, // ghost ability
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}, // hunting ability
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}, // event timer
            {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""} // hunt timer
        };
        int i = r.nextInt(28);
        System.out.println(ghost[0][i] + "\nEvidence: " + ghost[1][i] + ", " + ghost[2][i] + ", " + ghost[3][i] + "\nAbility: " + ghost[4][i] + "\nHunting Ability: " + ghost[5][i] + ", " + ghost[6][i] + ", " + ghost[7][i] + "\n");   

    }
}