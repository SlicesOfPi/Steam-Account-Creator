package messanger;

/*
package messanger;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;

public class joinGroup {
	public static Scanner scanner = new Scanner(System.in);
	public static boolean userJoinGroup( Map<String, String> cookies) throws Exception {
		String groupID = scanner.nextLine();
		Document doc = Jsoup.connect("http://steamcommunity.com/groups/"+groupID)
				.cookies(cookies)
				.get();
		Elements sesID = doc.getElementsByAttribute("name");
		for(Element e:sesID) {
			if(e.attr("name")=="sessionID") {
				System.out.println(e.attr("name"));
			}
		}
		return false;
		
		
	}
	
	
}
*/
// This will be the future code for messaging people.