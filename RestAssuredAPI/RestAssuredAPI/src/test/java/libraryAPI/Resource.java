package libraryAPI;

public class Resource {
	
	public static String place_post_data()
    {
        String resource="/maps/api/place/add/json";
        return resource;
    }
 
    public static String find_places()
    {
        String res="/maps/api/place/nearbysearch/json";
        return res;
    }
    public static String get_post_json_data()
    {
        String resource="Library/Addbook.php";
        return resource;
    }
    public static String get_auther_json()
    {
        String resource="/Library/GetBook.php";
        return resource;
    }

}
