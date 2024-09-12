import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class PasswordGenerator {
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    public static String generatePassword(int length) {
        String combinedChars = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // Ensure at least one character from each set
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        // Fill the rest of the password length
        for (int i = 4; i < length; i++) {
            password.append(combinedChars.charAt(random.nextInt(combinedChars.length())));
        }

        // Shuffle the password to remove any predictable patterns
        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        List<Character> characters = new ArrayList<>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }
        StringBuilder output = new StringBuilder(input.length());
        while (!characters.isEmpty()) {
            output.append(characters.remove((int) (Math.random() * characters.size())));
        }
        return output.toString();
    }

    public static void main(String[] args) {
        int passwordLength = 12; // You can set the desired password length
        String password = generatePassword(passwordLength);
        System.out.println("Generated Password: " + password);
    }
}
