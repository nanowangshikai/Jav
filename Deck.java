/** Represents a deck of cards, and operations that can be performed
 * on it.
 * 
 * Student name: Shi Kai Wang Student Number: 21938451
 *
 */
import java.util.Random;
public class Deck {
    /** The size of a deck of cards. Four suits of thirteen cards,
     * plus two jokers.
     */
    public final static int DEFAULT_DECK_SIZE = 13 * 4 + 2;

    /** The value given to the first joker
     **/
    public final static int JOKER1 = 13 * 4 + 1;

    /** The value given to the second joker
     **/
    public final static int JOKER2 = 13 * 4 + 2;

    // Array holding ints representing the cards. 
    // Card values should start from 1, and each int
    // should be unique within the array.
    private int[] cards;

    /** Create a deck of cards in the default order.
     */
    public Deck() {
        cards = new int[DEFAULT_DECK_SIZE];
        for (int i = 0; i < DEFAULT_DECK_SIZE; i++) {
            cards[i] = i + 1;
        }
    }

    /** Returns true when all values of the array arr are
     * different to each other; returns false otherwise.
     * 
     * @param arr An array of int values to be checked
     * @return Whether all values in the array are different
     */
    public static boolean allDifferent(int[] arr) {
        // TODO: fill in method body
        int first_value = arr[0];
        if(arr.length==0 || arr.length==1) return true;
        for(int i=1; i<arr.length-1; i++){
            if(arr[i]!=first_value) return true;
        }
        return false;
    }

    /** Construct a deck of cards from a String of comma-separated values.
     * 
     * @param s A string, consisting of comma-separated integers.
     */
    public Deck(String inputString) {
        if (inputString.equals("")) {
            cards = new int[0];
            return;
        }

        String[] strings = inputString.split(",");

        cards = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            cards[i] = Integer.parseInt( strings[i] );
        }
        validateCards();
    }

    /** This method should check whether all the
     * values in the "cards" instance variable
     * are different.
     *    If they are not, it should throw an
     * IllegalArgumentException exception.
     * 
     */
    private void validateCards() {
        // TODO: fill in method body

        if(!allDifferent(cards)){
            throw new IllegalArgumentException();
        }
    }

    public int size() {
        return cards.length;
    }

    public int getCard(int idx) {
        return cards[idx];
    }

    /** Shuffles elements of an array into a random permutation.
     * 
     * @param arr Array to be shuffled.
     */
    public static void shuffleArray(int[] arr) {
        // TODO: fill in method body
        Random rd = new Random();
        for(int i=0; i<arr.length; i++){
            int randomPosition = rd.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[randomPosition];
            arr[randomPosition] = temp;
        }
    }

    public void shuffle() {
        shuffleArray(cards);
    }

    /** Find the position in the deck of the card
     * with value cardVal.
     * 
     * @param cardVal The card to find
     * @return The position of the card to find, or -1
     *     if it wasn't in the deck. 
     */
    public int findCard(int cardVal) {
        // TODO: fill in method body
        for(int i=0; i<cards.length;i++){
            if(cards[i]==cardVal){
                return i;
            }
        }return -1;
    }

    /** Shift a particular card down the deck by one place,
     * and if this would take you past the end of the deck,
     * treat the end of the deck as joining onto the beginning.
     * 
     * In other words: for any card except the last card, 
     * the card is swapped with the card immediately 
     * after it. For the last card: it gets inserted after the
     * first card, and the second card and all subseq/uent cards
     * are "moved down one".  
     * 
     * If the argument passed is not found in the deck,
     * this method should throw an IllegalArgumentException 
     * exception.
     * 
     * @param cardVal The value of the card to be shifted.
     */
    public void shiftDownOne(int cardVal) {
        // TODO: fill in method body

        int x = findCard(cardVal);
        if(x== -1){
            throw new IllegalArgumentException();}
        if(x<cards.length-1){

            int agent = 0;
            agent = cards[x+1];
            cards[x+1] = cards[x];
            cards[x]= agent;}
        //swap last element and fist element
        if( cards.length-1==x){
            int last = cards[cards.length-1];
            cards[1]=last;
            for(int i=cards.length-2;i>=1;i--){

                cards[i+1] = cards[i];

            } 

        }

    }

    
    /** Perform a "triple cut": Given the positions of 2 cards in the deck,
     * divide the deck into three "chunks": 
     *  chunk "A", the "top" - cards before either position
     *  chunk "B", the "middle" - cards lying between the 2 positions
     *  chunk "C", the "bottom" - cards after either position.
     *  
     *  Reorder the deck by swapping the top and bottom chunks
     *  (chunks "A" and "C").
     *  
     * @param pos1 Position of a "fixed" card, counting from 0.
     * @param pos2 Position of another "fixed" card, counting from 0.
     */
    public void tripleCut(int pos1, int pos2) {
        // TODO: fill in method body
        int[] A = new int[]{};
        int[] B = new int[]{};
        int[] C = new int[]{};
        int[] All = 
        
        for(int i=0;i<cards.length;i++){
            if(i<pos1)  A[i] =cards[i];
            else if(i>pos2) C[i]=cards[i];
            else B[i]=cards[i];
            
        }
        
        

    }

    /** Perform a "count cut". Let n be a number of cards.
     * Remove n cards from the top of the deck, and place them
     * just above the last card.
     * 
     * @param numCards
     */
    public void countCut(int numCards) {
        // TODO: fill in method body
    }

}
