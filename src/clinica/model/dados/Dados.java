package clinica.model.dados;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Dados {

	public static boolean cadastrar(Object obj, String path) {
		File dir = new File("./" + "\\database");
		
		if(!dir.exists()) {
			boolean sucesso = dir.mkdir();
			
			if(!sucesso) {
				return false;
			}
		} 
		
		try (ObjectOutputStream bw = new ObjectOutputStream(new FileOutputStream(path, true))) {
			bw.writeObject(obj);
			bw.flush();
			bw.close();
			
		} catch(Exception e) {
			return false;
		}
		return true;
	}
}
