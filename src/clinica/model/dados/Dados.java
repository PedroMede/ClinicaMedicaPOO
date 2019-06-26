package clinica.model.dados;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
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

	public static boolean cadastrar(List<Object> objs, String path) {
		File dir = new File("./" + "\\database");
		
		if(!dir.exists()) {
			boolean sucesso = dir.mkdir();
			
			if(!sucesso) {
				return false;
			}
		} 
		
		File arq = new File(path);
		
		try (ObjectOutputStream bw = openStream(arq)) {
			for(Object obj : objs) {
				bw.writeObject(obj); 
			}
			
		} catch(Exception e) {
			return false;
		}
		return true;
	}
	
	public static List<Object> recuperar(String path) {
		List<Object> objects = new ArrayList<Object>();
		
		try (ObjectInputStream objLeitura = new ObjectInputStream(new FileInputStream(path))) {
			while(true) {
				Object obj = objLeitura.readObject();
				objects.add(obj);
				System.out.println(obj);
			}
		} catch (EOFException e2) {
			System.out.println("Dados recuperados com sucesso!");
		} catch (Exception e) {
			System.out.println("Arquivo não encontrado");
		}
		
		return objects;
	}
	
	public static void apagarArquivo(String path) {
		File arq = new File(path);
		
		if(arq.exists()) {
			boolean sucesso = arq.delete();
			
			if(sucesso)
				System.out.println("Apagado com sucesso!");
		}
	}
}
