package util;

public class Cipher
{
    public static String encrypt(String text, int shift)
    {
        if (shift < 0)
        {
            throw new IllegalArgumentException("encrypt() error: invalid shift");
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); ++i)
        {
            char ch = text.charAt(i);
            sb.append((char)(ch + shift));
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
            sb.append((char)(ch - shift));
        }
        return sb.toString();
    }
}

