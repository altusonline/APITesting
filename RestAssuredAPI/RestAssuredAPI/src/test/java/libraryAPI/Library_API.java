package libraryAPI;

import org.testng.annotations.Test;
import libraryAPI.Resource;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class Library_API {
	
	@Test(priority = 1)
	public void base1()
	    {
	        RestAssured.baseURI="http://216.10.245.166";
	        Response res=given().
	                body(Post_Book.create_new_book())
	                .when()
	                .post(Resource.get_post_json_data()). 
	                then().
	                extract().response();
	        String value=res.asString();
	        System.out.println(value);
	        res.prettyPrint();
	        System.out.println("the book is added");
	 
	 
	    }
	 
//getting the book by author name
	 
	@Test(priority = 2)
	   public void base2()
	   {
	       RestAssured.baseURI="http://216.10.245.166";
	       Response res=given().queryParam("AuthorName","hudson_1").
	               when().
	               get(Resource.get_auther_json()).	 
	               then().
	               extract().response();
	       String value=res.asString();
	       System.out.println(value);
	       res.prettyPrint();
	   }
}


