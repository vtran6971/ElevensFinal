import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 */
public class ElevensBoard extends Board {

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 9;

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
            {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
            {"spades", "hearts", "diamonds", "clubs"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0};

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;


    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
    public ElevensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
    }

    /**
     * Determines if the selected cards form a valid group for removal.
     * In Elevens, the legal groups are (1) a pair of non-face cards
     * whose values add to 11, and (2) a group of three cards consisting of
     * a jack, a queen, and a king in some order.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */
    @Override
    public boolean isLegal(List<Integer> selectedCards) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
        boolean remove = false;
        int cardOneValue = cardAt(selectedCards.get(0)).pointValue();
        int cardTwoValue = cardAt(selectedCards.get(1)).pointValue();
        int kingcounter = 0;
        int queencounter = 0;
        int jackcounter = 0;

        //If the first two cards selected add up to 11 then it is a legal removal
        if(cardOneValue + cardTwoValue == 11)
        {
          remove = true;
        }

        //checks through the selected cards up to 3
        //increments each king/queen/jack counter if it is detected
        for(int i = 0; i < 2; i++)
        {
            if(cardAt(selectedCards.get(i)).rank().compareTo("king") == 0)
            {
                kingcounter++;
            }

            if(cardAt(selectedCards.get(i)).rank().compareTo("queen") == 0)
            {
                queencounter++;
            }

            if (cardAt(selectedCards.get(i)).rank().compareTo("jack") == 0)
            {
                jackcounter++;
            }
        }

        //if there is only one jack, queen, and king detected then it is a legal removal
        if(jackcounter == 1 && queencounter == 1 && kingcounter == 1)
        {
            remove = true;
        }
        
        return remove;
    }

    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 11, or (2) a group
     * of three cards consisting of a jack, a queen, and a king in some order.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    @Override
    public boolean anotherPlayIsPossible() {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
        boolean valid = false;
        int kingcounter = 0;
        int queencounter = 0;
        int jackcounter = 0;

        //compares every single card on the board with every other card to see if they add up to 11
        for (int i = 0 ; i < BOARD_SIZE; i++) {
            for(int j = 0; j < BOARD_SIZE; j++) {
                if (cardAt(i).pointValue() + cardAt(j).pointValue() == 11) {
                 valid = true;
                }
            }
        }

        //checks through the board to see if there is a jack, queen, or king
        for (int i = 0 ; i < BOARD_SIZE; i++) {
            if(cardAt(i).rank().compareTo("king") == 0)
            {
                kingcounter++;
            }
            if(cardAt(i).rank().compareTo("queen") == 0)
            {
                queencounter++;
            }
            if(cardAt(i).rank().compareTo("jack") == 0)
            {
                jackcounter++;
            }
        }

        //if there is at least one of each then another play is possible
        if(kingcounter > 0 && queencounter > 0 && jackcounter > 0)
        {
            valid = true;
        }

        return valid;
    }

    /**
     * Check for an 11-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 11-pair.
     * @return true if the board entries in selectedCards
     *              contain an 11-pair; false otherwise.
     */
    private boolean containsPairSum11(List<Integer> selectedCards) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
        boolean remove = false;
        int cardOneValue = cardAt(selectedCards.get(0)).pointValue();
        int cardTwoValue = cardAt(selectedCards.get(1)).pointValue();

        //If the first two cards selected add up to 11 then it is a legal removal
        if(cardOneValue + cardTwoValue == 11)
        {
            remove = true;
        }

        return remove;
    }

    /**
     * Check for a JQK in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a JQK group.
     * @return true if the board entries in selectedCards
     *              include a jack, a queen, and a king; false otherwise.
     */
    private boolean containsJQK(List<Integer> selectedCards) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
        boolean remove = false;
        int kingcounter = 0;
        int queencounter = 0;
        int jackcounter = 0;

        //checks through the selected cards up to 3
        //increments each king/queen/jack counter if it is detected
        for(int i = 0; i < 2; i++)
        {
            if(cardAt(selectedCards.get(i)).rank().compareTo("king") == 0)
            {
                kingcounter++;
            }

            if(cardAt(selectedCards.get(i)).rank().compareTo("queen") == 0)
            {
                queencounter++;
            }

            if (cardAt(selectedCards.get(i)).rank().compareTo("jack") == 0)
            {
                jackcounter++;
            }
        }

        //if there is only one jack, queen, and king detected then it is a legal removal
        if(jackcounter == 1 && queencounter == 1 && kingcounter == 1)
        {
            remove = true;
        }

        return remove;
    }
}