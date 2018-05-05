public class SingletonConnection {

    private static SingletonConnection singletonC = null;           ///There can be only one, that's why Static


    public static SingletonConnection getInstance() {
        try {
            if (singletonC == null) {
                singletonC = new SingletonConnection();
                System.out.println("All Cool");                     ///Message to acknowledge the user that the instance was created ok
            }

        } catch (Exception e) {
            System.out.println("Something Happened");
        }
        return singletonC;
    }
}
