

package stringutils;


public class IterWord {
    private String str;
    private int counter;

    public IterWord(String str) {
        this.str = str;
        this.counter = 0;
    }

    public void restart() {
        counter = 0;
    }

    public boolean hasNext() {
        return counter < str.length();
    }

    public void printNext() {
        int len = str.length();
        String result = "";

        while (counter < len && str.charAt(counter) != ' ') {
            result += str.charAt(counter++);
        }

        System.out.println(result);
        ++counter;
    }
}

