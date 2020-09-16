public class VignereCipher 
{
    //Benjamin Mai
    //CS4600.01
    // Total character in alphabet
    private static final int TOTAL_CHARACTER_ALPHABET = 26;

    /**
     * Encrypt with input text and key
     * @param inputText - string need to encrypt
     * @param keyText - key use to encrypt
     * @return Text result after encrypt
     */
    public static String encryptProcess(String inputText, final String keyText)
    {
        // The result after encrypt
        String textAfterEncrypt = "";

        // If the input text is not upper case, we need to uppercase it
        inputText = inputText.toUpperCase();

        for (int i = 0, j = 0; i < inputText.length(); i++)
        {
            // If the input text is not from A-Z, move to next character
            if (inputText.charAt(i) < 'A' || inputText.charAt(i) > 'Z')
                continue;

            // Follow the rule encrypt with alphabet character
            char characterDescrypt =  (char) ((inputText.charAt(i) + keyText.charAt(j) - 2 * 'A') % TOTAL_CHARACTER_ALPHABET + 'A');

            // Concat the text encrypt
            textAfterEncrypt = textAfterEncrypt + characterDescrypt;
            j = ++j % keyText.length();
        }
        return textAfterEncrypt;
    }

    /**
     * Decrypt with input text and key
     * @param inputText - string need to decrypt
     * @param keyText - key use to decrypt
     * @return Text result after decrypt
     */
    public static String decryptProcess(String inputText, final String keyText)
    {
        String textAfterDecrypt = "";

        // If the input text is not upper case, we need to uppercase it
        inputText = inputText.toUpperCase();

        for (int i = 0, j = 0; i < inputText.length(); i++)
        {
            // If the character is not from A-Z, skip it
            if (inputText.charAt(i) < 'A' || inputText.charAt(i) > 'Z')
                continue;

            // Follow the rule decrypt with alphabet character
            char characterDecrypt = (char) ((inputText.charAt(i) - keyText.charAt(j) + TOTAL_CHARACTER_ALPHABET) % TOTAL_CHARACTER_ALPHABET + 'A');
            textAfterDecrypt = textAfterDecrypt + characterDecrypt;
            j = ++j % keyText.length();
        }

        // The response text will lower case to make sure easy to look
        return textAfterDecrypt.toLowerCase();
    }

    public static void main(String[] args)
    {
        // Key and message text need to encrypt
        String keyText = "GODSAVETHEQUEEN";
        String message = "Ben Mai is majoring in Computer Science at Cal Poly Pomona.";

        // Message after encrypt
        String encryptedMsg = encryptProcess(message, keyText);
        System.out.println("String: " + message);
        System.out.println("Encrypted: " + encryptedMsg);

        // Decrypt process back
        System.out.println("Decrypted: " + decryptProcess(encryptedMsg, keyText));
    }
}