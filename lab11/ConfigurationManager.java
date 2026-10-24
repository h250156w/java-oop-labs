package lab11;

public class ConfigurationManager {
    private static ConfigurationManager instance;
    private String appName;
    private int maxBorrowLimit;

    private ConfigurationManager() {
        this.appName = "HIT Central Library System";
        this.maxBorrowLimit = 3;
    }

    public static synchronized ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }

    public String getAppName() { return appName; }
    public int getMaxBorrowLimit() { return maxBorrowLimit; }

    public static void main(String[] args) {
        ConfigurationManager config1 = ConfigurationManager.getInstance();
        ConfigurationManager config2 = ConfigurationManager.getInstance();

        System.out.println("App Name: " + config1.getAppName());
        System.out.println("Max Borrow Limit: " + config1.getMaxBorrowLimit());
        System.out.println("config1 and config2 point to exact same instance? " + (config1 == config2));
    }
}
