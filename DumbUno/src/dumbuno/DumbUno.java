//This is an Uno game simulation.
//Created by James Vanderhyde, 30 September 2024
//modified by Luis Villagomez, 30 September 2024

package dumbuno;

import java.util.Random;

public class DumbUno
{
    private static final Random rng = new Random();
    
    public static void main(String[] args) 
    {
        final int maxHandSize = 12;
        final int minHandSize = 3;
        
        //Put the players into a circular linked list
        IntNode startPlayer = new IntNode(0,null);
        IntNode current = startPlayer;
        current.setNext(new IntNode(0,null));
        current = current.getNext();
        current.setNext(new IntNode(0,null));
        current = current.getNext();
        current.setNext(new IntNode(0,null));
        current = current.getNext();
        current.setNext(new IntNode(0,null));
        current = current.getNext();
        current.setNext(startPlayer);
        
        //Deal every player a hand
        current = startPlayer;
        while (current.getNext() != startPlayer)
        {
            current.setData(rng.nextInt(minHandSize, maxHandSize+1));
            current = current.getNext();
        }
        
        printGame(startPlayer);
        System.out.println("");
        
        //Play the game
        System.out.println("Game starts:");
        current = startPlayer;
        while (current.getData() > 1)
        {
            System.out.println("Remove " + current.getData());
            
            current = current.getNext();
            startPlayer = current;
            printGame(startPlayer);
            System.out.println("");
        }
        System.out.println("I win!");
        
    }
    
    private static void printGame(IntNode startPlayer)
    {
        IntNode current = startPlayer;
        do{
            System.out.println(current.getData());
            current = current.getNext();
        } while(current != startPlayer);
    }
    
}
