package singleton;

public class Service {
    public  FileLogger do_something_and_log(){
        FileLogger logger = FileLogger.getDefault();
        logger.log("Did the thing");
        return logger;
    }

    public FileLogger do_something_else_and_log(){
        FileLogger logger = FileLogger.getDefault();
        logger.log("Did the other thing");
        return logger;
    }
}
