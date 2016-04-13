package dstring;

/**
 * dstring.DChar Library
 * D = Doug, Char = character. I am doug. Nice to meet you.
 *
 * This library will hopefully do cool shit and help you make
 * more dope programs yo.
 *
 * I designed this class to create a method that takes a seed
 * to randomize the shuffling of a deck. It felt out of place
 * in a 'Card' library so I gave it its own.
 */
public class DChar {
    public enum Type{
        VOWEL, CONSONANT, SYMBOL, SPACE, NUMBER
    }
    /**
     * Determine whether a character is a vowel or not.
     * @param c the character being checkd
     * @return true if it is a vowel, false otherwise.
     */
    public static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    /**
     * Determine whether a character is a number or not
     * @param c the character being checked
     * @return true if the character is a number, false otherwise.
     */
    public static boolean isNumber(char c) {
        return "1234567890".indexOf(c) != -1;
    }

    /**
     * Determine whether a character is a consonant or not.
     * @param c the character being checked
     * @return true if the character is a consonant, false otherwise.
     */
    public static boolean isConsonant(char c) {
        return "bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ".indexOf(c) != -1;
    }

    /**
     * Determine whether a character is a symbol or not.
     * @param c the character being checked
     * @return true of the character is a symbol, false otherwise.
     */
    public static boolean isSymbol (char c){
        return (!isVowel(c) && !isConsonant(c) && !isNumber(c));
    }

    /**
     * Determine whether a character is a space or not.
     * It's just as easy to write "return c==' '", but for the sake of it,
     * here it is.
     * @param c the character being checked
     * @return true of the character is a space, false otherwise.
     */
    public static boolean isSpaceChar (char c){
        return c == ' ';
    }

    /**
     * Determine whether a character is a capital letter or not.
     * @param c the character being checked
     * @return true of the character is a space, false otherwise.
     */
    public static boolean isCapital (char c){
        return "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(c) != -1;
    }

    /**
     * Determine whether a character is a lowercase letter or not.
     * (literally the inverse of isCapital, but it's here just in case.)
     * @param c the character being checked
     * @return true of the character is a space, false otherwise.
     */
    public static boolean isLowercase(char c) {
        return !isCapital(c);
    }

    /**
     * Determine what type of character this is.
     * This version of the method assumes spaces are symbols
     * @param c the character being checked
     * @return a string describing the character.
     */
    public static String getCharDescription(char c){
        String s = "\'" + c + "\'";
        if (DChar.isVowel(c)){
            s += "is a vowel.";
        }
        else if (DChar.isConsonant(c)){
            s += "is a consonant.";
        }
        else if (DChar.isNumber(c)){
            s += "is a number.";
        }
        else if (DChar.isSymbol(c)){
            s += "is a symbol.";
        }

        return s;
    }

    /**
     * Determine what type of character this is.
     * This version of the method asks whether or not
     * a space is considered a symbol.
     * @param c the character being checked
     * @param treatSpaceAsSymbol whether or not a space is treated as a symbol.
     * @return a string describing the character.
     */
    public static String getCharDescription(char c, boolean treatSpaceAsSymbol){
        String s = "\'" + c + "\'";
        if (DChar.isVowel(c)){
            s += "is a vowel.";
        }
        else if (DChar.isConsonant(c)){
            s += "is a consonant.";
        }
        else if (DChar.isNumber(c)){
            s += "is a number.";
        }
        //Lazy check - if the flag is false, don't bother checking if it's a space or not.
        else if (!treatSpaceAsSymbol && DChar.isSpaceChar(c)){
            s += "is a space.";
        }
        else if (DChar.isSymbol(c)){
            s += "is a symbol.";
        }

        return s;
    }

    /**
     * Determine what type of character this is.
     * This version of the method assumes spaces are symbols
     * @param c the character being checked
     * @return dstring.DChar.Type corresponding to the character's type.
     */
    public static Type getCharType(char c){
        if (DChar.isVowel(c)){
            return Type.VOWEL;
        }
        else if (DChar.isConsonant(c)){
            return Type.CONSONANT;
        }
        else if (DChar.isNumber(c)){
            return Type.NUMBER;
        }
        else {
            return Type.SYMBOL;
        }
    }
    /**
     * Determine what type of character this is.
     * This version of the method assumes spaces are symbols
     * @param c the character being checked
     * @param treatSpaceAsSymbol whether or not to treat space as a symbol
     * @return dstring.DChar.Type corresponding to the character's type.
     */
    public static Type getCharType(char c, boolean treatSpaceAsSymbol){
        if (DChar.isVowel(c)){
            return Type.VOWEL;
        }
        else if (DChar.isConsonant(c)){
            return Type.CONSONANT;
        }
        else if (DChar.isNumber(c)){
            return Type.NUMBER;
        }
        else if (!treatSpaceAsSymbol && DChar.isSpaceChar(c)){
            return Type.SPACE;
        }
        else {
            return Type.SYMBOL;
        }
    }
}
