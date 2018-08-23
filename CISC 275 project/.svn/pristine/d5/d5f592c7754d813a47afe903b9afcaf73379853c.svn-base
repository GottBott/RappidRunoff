package group2.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCodes {
	
	public static ArrayList<String> codes = new ArrayList<String>();
	
	public static void loadCodes(){
		File file = new File("src/group2/game/codeList.txt");
		BufferedReader reader = null;
		String text;
		
		try{
			reader = new BufferedReader(new FileReader(file));
			while((text = reader.readLine()) != null){
				codes.add(text);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(reader != null){
					reader.close();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		System.out.println(codes);
	}

	public static boolean checkCode(String code){
		if(codes.contains(code)){
			codes.remove(code);
			return true;
		}else{
			return false;
		}
	}
}
