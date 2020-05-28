package study.planner;

// kivételek 2 típus:
// - ellenőrzött: Exception-ből származik
// - nem ellenőrzött: RuntimeException/Error-ból származik


public class StudyException extends Exception
{
    public StudyException(String msg)
    {
        super(msg);
    }
}

