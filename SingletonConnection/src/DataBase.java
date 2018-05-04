public class DataBase extends SingletonConnection {

    private SingletonConnection dataB;

    public DataBase(){
        this.dataB = SingletonConnection.getInstance();
    }

    public void Connect(){
        System.out.println("Nuclear lunch detected");
    } ///Simple message an String with the connection would go in here.

}
