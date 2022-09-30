package de.dbVerbinden;

public class RestApitest {

	public static void main(String[] args) throws Exception {
		
		AudioTrans trans = new AudioTrans();
		
		trans.setAudio_url("https://bit.ly/3yxKEIY");
		Gson gson  = new Gson();
		//Gson gson = new Gson();
		String jsonRequest = gson.toJson(trans);
		
		System.out.println(jsonRequest);
	}

}
