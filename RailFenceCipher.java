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

    
