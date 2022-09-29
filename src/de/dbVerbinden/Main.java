package de.dbVerbinden;

public class Main {
	
	private static String name = "Omran";
	private static int age = 34;

	public static void main(String[] args)throws ClassNotFoundException{
		MySQL.connect();
		MySQL.update("INSERT INTO `user`(`name`, `age`) VALUES ('" + name + "','" + age+ "')");
		MySQL.disconnected();

	}

}
