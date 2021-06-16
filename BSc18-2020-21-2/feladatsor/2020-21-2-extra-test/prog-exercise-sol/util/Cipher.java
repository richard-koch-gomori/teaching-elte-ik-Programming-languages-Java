package util;

public class Cipher
{
    public static String encrypt(String text, int shift)
    {
        if (shift < 0) // 0.5 pont
        {
            throw new IllegalArgumentException("encrypt() error: invalid shift");
        }
        StringBuilder sb = new StringBuilder(); // 0.5 pont
        for (int i = 0; i < text.length(); ++i) // 0.5 pont
        {
            char ch = text.charAt(i); // 0.5 pont
            sb.append((char)(ch + shift)); // 0.5 pont
        }
        return sb.toString();
    }

    public static String decrypt(String cipher, int shift)
    {
        if (shift < 0)
        {
            throw new IllegalArgumentException("decrypt() error: invalid shift");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cipher.length(); ++i)
        {
            char ch = cipher.charAt(i);
            sb.append((char)(ch - shift)); // 0.5 pont
        }
        return sb.toString();
    }
}

