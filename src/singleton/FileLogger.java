package singleton;

// Singleton
public class FileLogger {
    private static FileLogger logger = new FileLogger();

    public static FileLogger getDefault() {
        return logger;
    }

    public void log(String message){
        System.out.println(message);
    }
}
