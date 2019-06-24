package clinica.model.dados;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

public class Dados extends ObjectOutputStream {

	public Dados(OutputStream out) throws IOException {
		super(out);
	}
	
	@Override
	protected void writeStreamHeader() throws IOException {
		reset();
	}
	
	public static ObjectOutputStream openStream(File f) throws Exception {
	   ObjectOutputStream oos = null;
	   if (f.exists()) {
	      FileOutputStream fos = new FileOutputStream(f, true);
	      oos = new Dados(fos);
	   } else {
	      FileOutputStream fos = new FileOutputStream(f);
	      oos = new ObjectOutputStream(fos);
	   }
	   return oos;
	}

	public static boolean cadastrar(List<Object> obj, String path) {
		File dir = new File("./" + "\\database");
		
		if(!dir.exists()) {
			boolean sucesso = dir.mkdir();
			
			if(!sucesso) {
				return false;
			}
		} 
		
		File arq = new File(path);
		
		try (ObjectOutputStream bw = openStream(arq)) {
			bw.writeObject(obj);
		} catch(Exception e) {
			return false;
		}
		return true;
	}
}
