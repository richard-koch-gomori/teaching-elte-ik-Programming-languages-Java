package study.planner;

// kivételek 2 típus:
// - ellenőrzött: például Exception-ből származik (nem RuntimeException/Error-ból származik)
// - nem ellenőrzött: RuntimeException/Error-ból származik


public class StudyException extends Exception
{
    public StudyException(String msg)
    {
        super(msg);
    }
}


