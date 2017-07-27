package signup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class MakeAcc {
	//public static CloseableHttpClient httpclient = HttpClients.createDefault();
	public static Scanner scanner = new Scanner(System.in);
	public static String word = "";
	public static Random generator = new Random();
	public static String[] genAccount() throws Exception {
		// TODO Auto-generated method stub
		Document doc = Jsoup.connect("https://store.steampowered.com/join")
				.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36")
				.get();
		Element capatcha = doc.getElementById("captchaImg");
		String capURL = capatcha.attr("src");
		String capGID = capURL.replace("https://store.steampowered.com/public/captcha.php?gid=", "");
		BufferedWriter out = new BufferedWriter(new FileWriter("link.html"));
				String pageData = "<html>\r\n" + 
				"<head>\r\n" + 
				"	<meta http-equiv=\"Cache-Control\" content=\"no-cache, no-store, must-revalidate\"/>\r\n" + 
				"	<meta http-equiv=\"Pragma\" content=\"no-cache\"/>\r\n" + 
				"	<meta http-equiv=\"Expires\" content=\"0\"/>\r\n" + 
				"	<title></title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"	\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<div id=\"diggg\"></div>\r\n" + 
				"<img id=\"pigly\" src=\"https://store.steampowered.com/public/captcha.php?gid="+capGID+"&e\"><br>\r\n" + 
				"<img id=\"pigly\" src=\"https://store.steampowered.com/public/captcha.php?gid="+capGID+"&ee\"><br>\r\n" + 
				"<img id=\"pigly\" src=\"https://store.steampowered.com/public/captcha.php?gid="+capGID+"&eee\">\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>";
		out.write(pageData);
		out.close();
		System.out.println("Capatcha Link>\n"+capURL);
		String capTXT = scanner.nextLine();
		String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		int letterLength = generator.nextInt(5)+5;
		for(int i=0;i<=letterLength;i++) {
			int randNum = generator.nextInt(26);
			word = word+letters[randNum];
			
		}

		
		
		int stuffAfter = generator.nextInt(9000)+1000;
		int randPwd = generator.nextInt(10);
		String[] pwds = {"The small cat123", "The large cat123", "I love dead animals123", "I hate dead animals123", "Broken Bottle321", "Amazing Fluffball 123", "G502 Master Race", "Glorius Must I say", "The ninety ninth nine", "Then ten ten ben 123"};
		String pswd = pwds[randPwd];
		String accName = word+stuffAfter;
		String emailURL = "@dispostable.com";
		String createURL = "https://store.steampowered.com/join/createaccount/";
		
		Response res = Jsoup.connect(createURL)
				.userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3071.115 Safari/537.36")
				.data("accountname", accName)
				.data("password", pswd)
				.data("email", accName+emailURL)
				.data("captchagid", capGID)
				.data("captcha_text", capTXT)
				.data("i_agree", "1")
				.data("ticket", "")
				.data("count", "6")
				.data("lt", "0")
				.header("x-requested-with", "XMLHttpRequest")
				.ignoreContentType(true)
				.header("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
			    .method(Method.POST)
			    .execute();
		Map<String, String> theCookies = res.cookies();
		main.Main.theCookies = theCookies;
		System.out.println(res.statusCode());
		if(res.body().contains("\"bSuccess\":true")) {
			System.out.println("Success!");
		}
		else {
			System.out.println("Something went wrong!");
		}
		//Document createPost = res.parse();
		System.out.println(accName+":"+pswd);
		String[] returnStatement = {accName, pswd};
		return returnStatement;
		
		
		
	}

}
