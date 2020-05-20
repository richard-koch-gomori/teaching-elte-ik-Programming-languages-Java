//Készítette: Lukács Dávid István
public class AlreadyContainedException extends Exception
{
    private static final long serialVersionUID = 1L;

    public AlreadyContainedException(String errorMessage)
    {
        super(errorMessage);
    }
}
