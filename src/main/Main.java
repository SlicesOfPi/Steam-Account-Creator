package main;

import java.util.Map;

import groupSpam.joinGroup;

public class Main {
	public static Map<String, String> theCookies;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String[] accountInfo = signup.MakeGroup.genAccount();
		boolean theThing = groupSpam.joinGroup.userJoinGroup(theCookies);
		System.out.println(accountInfo+"\n"+theThing);
	}

}
