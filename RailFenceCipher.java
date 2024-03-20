public class RailFenceCipher {

    public static String railFenceEncrypt(String plaintext, int rails) {
        StringBuilder encryptedText = new StringBuilder();
        char[][] railMatrix = new char[rails][plaintext.length()];
        int row = 0;
        int direction = 1;

        for (int i = 0; i < plaintext.length(); i++) {
            railMatrix[row][i] = plaintext.charAt(i);
            row += direction;

            if (row == 0 || row == rails - 1) {
                direction *= -1; // Change direction at the top or bottom rail
            }
        }

        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < plaintext.length(); j++) {
                if (railMatrix[i][j] != 0) {
                    encryptedText.append(railMatrix[i][j]);
                }
            }
        }

        return encryptedText.toString();
    }
    
    public static String railFenceDecrypt(String ciphertext, int rails) {
        StringBuilder decryptedText = new StringBuilder();
        char[][] railMatrix = new char[rails][ciphertext.length()];
        int row = 0;
        int direction = 1;

        // Fill the rail matrix with placeholder characters
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < ciphertext.length(); j++) {
                railMatrix[i][j] = 0;
            }
        }

        // Populate the rail matrix with the ciphertext
        for (int i = 0; i < ciphertext.length(); i++) {
            railMatrix[row][i] = 'X'; // Use 'X' as a placeholder for the rail positions
            row += direction;

            if (row == 0 || row == rails - 1) {
                direction *= -1;
            }
        }

        // Replace 'X' with characters from the ciphertext
        int index = 0;
        for (int i = 0; i < rails; i++) {
            for (int j = 0; j < ciphertext.length(); j++) {
                if (railMatrix[i][j] == 'X') {
                    railMatrix[i][j] = ciphertext.charAt(index++);
                }
            }
        }

        // Read the rail matrix to get the decrypted text
        row = 0;
        direction = 1;
        for (int i = 0; i < ciphertext.length(); i++) {
            decryptedText.append(railMatrix[row][i]);
            row += direction;

            if (row == 0 || row == rails - 1) {
                direction *= -1;
            }
        }

        return decryptedText.toString();
    }


    
