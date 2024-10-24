package ficheros;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class GestorDeFicheros {

	public static String ajustarString(String s, int largo) {
		if (s.length() < largo) {
			s = s + " ".repeat(largo - s.length());
		}

		return s = s.substring(0, largo);
	}
	
	
public static ArrayList<Long> obtainPosFromRandom(RandomAccessFile file, String cadena, int largocadena, int largoentrada) {
		
		ArrayList<Long> res= new ArrayList<Long>();
		try {
			
			file.seek(0);
			
			while (file.getFilePointer() < file.length()) {
	            try {
	            	String cadSacada="";
	            	for (int i = 0; i < largocadena; i++) {
	    				cadSacada+=file.readChar();
	    				System.out.println(cadSacada);
	    			}
	            	
	            	cadena=ajustarString(cadena, largocadena);
	            	
	                
	                if (cadSacada.equals(cadena) ) {
	                    res.add(file.getFilePointer()-largocadena);
	                   
	                }
	                file.seek(file.getFilePointer() + largoentrada- largocadena); // Salta al siguiente registro
	            } catch (EOFException e) {
	                break; // Fin del archivo
	            }
	        }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   return res;
        
    }
	
	public static ArrayList<Long> obtainPosFromRandom(RandomAccessFile file, String cadena, int largocadena,int start, int largoentrada) {
		
		ArrayList<Long> res= new ArrayList<Long>();
		try {
			
			file.seek(start);
			
			while (file.getFilePointer() < file.length()) {
	            try {
	            	String cadSacada="";
	            	for (int i = 0; i < largocadena; i++) {
	    				cadSacada+=file.readChar();
	    			}
	            	
	            	cadena=ajustarString(cadSacada, largocadena);
	            	
	                
	                if (cadSacada.equals(cadena) ) {
	                    res.add(file.getFilePointer()-largocadena);
	                }
	                file.seek(file.getFilePointer() + largoentrada- largocadena); // Salta al siguiente registro
	            } catch (EOFException e) {
	                break; // Fin del archivo
	            }
	        }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   return res;
        
    }
	
	
public static ArrayList<Long> obtainPosFromRandom(RandomAccessFile file, int codigo, int largoentrada) {
		
		ArrayList<Long> res= new ArrayList<Long>();
		try {		 
			file.seek(0);
			
			while (file.getFilePointer() < file.length()) {
	            try {
	                int currentCodigo = file.readInt();
	                if (currentCodigo == codigo) {
	                    res.add(file.getFilePointer()-4);
	                }
	                file.seek(file.getFilePointer() + largoentrada- 4); // Salta al siguiente registro
	            } catch (EOFException e) {
	                break; // Fin del archivo
	            }
	        }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   return res;
        
    }
	
	public static ArrayList<Long> obtainPosFromRandom(RandomAccessFile file, int codigo,int start, int largoentrada) {
		
		ArrayList<Long> res= new ArrayList<Long>();
		try {		 
			file.seek(start);
			
			while (file.getFilePointer() < file.length()) {
	            try {
	                int currentCodigo = file.readInt();
	                if (currentCodigo == codigo) {
	                    res.add(file.getFilePointer()-4);
	                }
	                file.seek(file.getFilePointer() + largoentrada- 4); // Salta al siguiente registro
	            } catch (EOFException e) {
	                break; // Fin del archivo
	            }
	        }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   return res;
        
    }
	
	public static boolean searchFromRandom(RandomAccessFile file, int codigo,int start, int largoentrada) {
		try {		 
			file.seek(start);
			while (file.getFilePointer() < file.length()) {
	            try {
	                int currentCodigo = file.readInt();
	                if (currentCodigo == codigo) {
	                    return true;
	                }
	                file.seek(file.getFilePointer() + largoentrada- 4); // Salta al siguiente registro
	            } catch (EOFException e) {
	                break; // Fin del archivo
	            }
	        }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	   return false;
        
    }
	
	
	public static int readFromRandom_Int(RandomAccessFile file, int pos) {
		int res=0;
		try {
			file.seek(pos);
			res=file.readInt();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return res;
        
    }
	
	public static int readFromRandom_Int(RandomAccessFile file, long pos) {
		int res=0;
		try {
			file.seek(pos);
			res=file.readInt();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return res;
        
    }
	
	public static int readFromRandom_Int(RandomAccessFile file) {
		int res=0;
		try {
			res=file.readInt();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return res;
        
    }
	
	
	public static String readFromRandom_String(RandomAccessFile file, int pos, int largo) {
		String res="";
		try {
			file.seek(pos);
			for (int i = 0; i < largo; i++) {
				res+=file.readChar();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			res = null;
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			res = null;
			e.printStackTrace();
		}
		
		return res;
        
    }
	
	public static String readFromRandom_String(RandomAccessFile file, long pos, int largo) {
		String res="";
		try {
			file.seek(pos);
			for (int i = 0; i < largo; i++) {
				res+=file.readChar();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			res = null;
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			res = null;
			e.printStackTrace();
		}
		
		return res;
        
    }
	
	public static String readFromRandom_String(RandomAccessFile file, int largo) {
		String res="";
		try {
			for (int i = 0; i < largo; i++) {
				res+=file.readChar();
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			res = null;
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			res = null;
			e.printStackTrace();
		}
		
		return res;
        
    }
	
	
	public static Boolean readFromRandom_Boolean(RandomAccessFile file, int pos) {
		boolean res=false;
	;
		try {
			file.seek(pos);
			res=file.readBoolean();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return res;
        
        
    }
	
	public static Boolean readFromRandom_Boolean(RandomAccessFile file, long pos) {
		boolean res=false;
		
		try {
			file.seek(pos);
			res=file.readBoolean();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return res;
        
    }
	
	public static Boolean readFromRandom_Boolean(RandomAccessFile file) {
		Boolean res=false;
		try {
			res=file.readBoolean();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		return res;
        
    }
	
	
	


	public static Boolean overrideToRandomFile(RandomAccessFile raf, String s, int largo) {

		Boolean res = true;
		try {

			raf.writeChars(ajustarString(s, largo));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}

		return res;

	}

	public static Boolean overrideToRandomFile(RandomAccessFile raf, int i) {

		Boolean res = true;
		try {

			raf.writeInt(i);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}

		return res;

	}

	public static Boolean overrideToRandomFile(RandomAccessFile raf, boolean b) {

		Boolean res = true;
		try {

			raf.writeBoolean(b);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}

		return res;

	}

	public static Boolean overrideToRandomFile(RandomAccessFile raf, int pos, String s, int largo) {

		Boolean res = true;
		try {
			raf.seek(pos);
			raf.writeChars(ajustarString(s, largo));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}

		return res;

	}

	public static Boolean overrideToRandomFile(RandomAccessFile raf, int pos, int i) {

		Boolean res = true;
		try {
			raf.seek(pos);
			raf.writeInt(i);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}

		return res;

	}

	public static Boolean overrideToRandomFile(RandomAccessFile raf, int pos, boolean b) {

		Boolean res = true;
		try {
			raf.seek(pos);
			raf.writeBoolean(b);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}

		return res;

	}

	public static Boolean addToRandomFile(RandomAccessFile raf, String s, int largo) {

		Boolean res = true;
		try {
			raf.seek(raf.length());
			raf.writeChars(ajustarString(s, largo));
			;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}

		return res;

	}

	public static Boolean addToRandomFile(RandomAccessFile raf, int i) {

		Boolean res = true;
		try {
			raf.seek(raf.length());
			raf.writeInt(i);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}

		return res;

	}

	public static Boolean addToRandomFile(RandomAccessFile raf, boolean b) {

		Boolean res = true;
		try {
			raf.seek(raf.length());
			raf.writeBoolean(b);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			res = false;
			e.printStackTrace();
		}

		return res;

	}

	public static Boolean addToRandomFile(File f, boolean b) {

		Boolean res = (f.exists() && f.isFile());
		if (res) {
			RandomAccessFile raf = null;
			try {
				raf = new RandomAccessFile(f, "rw");
				raf.seek(raf.length());
				raf.writeBoolean(b);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				res = false;
				e.printStackTrace();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				res = false;
				e.printStackTrace();
			}

		}
		return res;

	}

	public static Boolean addToRandomFile(File f, int i) {

		Boolean res = (f.exists() && f.isFile());
		if (res) {
			RandomAccessFile raf = null;
			try {
				raf = new RandomAccessFile(f, "rw");
				raf.seek(raf.length());
				raf.writeInt(i);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				res = false;
				e.printStackTrace();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				res = false;
				e.printStackTrace();
			}

		}
		return res;

	}

	public static Boolean addToRandomFile(File f, String s, int largo) {
		Boolean res = (f.exists() && f.isFile());
		if (res) {
			RandomAccessFile raf = null;
			try {
				raf = new RandomAccessFile(f, "rw");
				raf.seek(raf.length());
				raf.writeChars(ajustarString(s, largo));
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				res = false;
				e.printStackTrace();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				res = false;
				e.printStackTrace();
			}

		}
		return res;

	}

	public static Boolean addToRandomFile(boolean b) {
		File f = GestorDeFicheros.fchoose();
		Boolean res = (f.exists() && f.isFile());
		if (res) {
			RandomAccessFile raf = null;
			try {
				raf = new RandomAccessFile(f, "rw");
				raf.seek(raf.length());
				raf.writeBoolean(b);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				res = false;
				e.printStackTrace();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				res = false;
				e.printStackTrace();
			}

		}
		return res;

	}

	public static Boolean addToRandomFile(int i) {
		File f = GestorDeFicheros.fchoose();
		Boolean res = (f.exists() && f.isFile());
		if (res) {
			RandomAccessFile raf = null;
			try {
				raf = new RandomAccessFile(f, "rw");
				raf.seek(raf.length());
				raf.writeInt(i);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				res = false;
				e.printStackTrace();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				res = false;
				e.printStackTrace();
			}

		}
		return res;

	}

	public static Boolean addToRandomFile(String s, int largo) {
		File f = GestorDeFicheros.fchoose();
		Boolean res = (f.exists() && f.isFile());
		if (res) {
			RandomAccessFile raf = null;
			try {
				raf = new RandomAccessFile(f, "rw");
				raf.seek(raf.length());
				raf.writeChars(ajustarString(s, largo));
				;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				res = false;
				e.printStackTrace();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				res = false;
				e.printStackTrace();
			}

		}
		return res;

	}

	public static <E> Boolean saveSerialObjt(Object obj, boolean append) {

		File ficheroGuardar = GestorDeFicheros.fchoose();
		try {
			FileOutputStream fo = new FileOutputStream(ficheroGuardar, append);
			ObjectOutputStream oos = new ObjectOutputStream(fo);

			oos.writeObject(obj);
			;

			return true;

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static <E> Boolean saveSerial(ArrayList<E> arra, boolean append) {

		File ficheroGuardar = GestorDeFicheros.fchoose();
		try {
			FileOutputStream fo = new FileOutputStream(ficheroGuardar, append);
			ObjectOutputStream oos = new ObjectOutputStream(fo);

			for (Object o : arra) {
				oos.writeObject(o);
				;
			}

			/*
			 * oos.reset(); oos.close(); fo.close();
			 */

			return true;

		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public static ArrayList<Object> readSerial(File f) {
		ArrayList<Object> objs = new ArrayList<Object>();

		try {

			FileInputStream fi = new FileInputStream(f);

			ObjectInputStream ois = new ObjectInputStream(fi);

			try {
				while (true) {
					objs.add((Object) ois.readObject());

				}

			} catch (EOFException eof) {

				System.out.println("Fin de lectura");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception eg) {
				eg.printStackTrace();
			}

			return objs;

		} catch (IOException ioe) {
			// TODO: handle exception
			ioe.printStackTrace();
			return objs;
		}
	}

	public static ArrayList<Object> readSerial() {
		ArrayList<Object> objs = new ArrayList<Object>();

		try {

			FileInputStream fi = new FileInputStream(GestorDeFicheros.fchoose());

			ObjectInputStream ois = new ObjectInputStream(fi);

			try {
				while (true) {
					objs.add((Object) ois.readObject());

				}

			} catch (EOFException eof) {

				System.out.println("Fin de lectura");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception eg) {
				eg.printStackTrace();
			}

			return objs;

		} catch (IOException ioe) {
			// TODO: handle exception
			ioe.printStackTrace();
			return objs;
		}
	}

	public static Boolean borrarDirRecursivo(File f) {

		try {

			if (f.isDirectory()) {
				for (File elementos : f.listFiles()) {
					borrarDirRecursivo(elementos);
				}
			}

			return f.delete();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	public static File fchoose() {

		File f = null;
		JFileChooser filechoser = new JFileChooser();
		filechoser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int seleccion = filechoser.showOpenDialog(filechoser);

		if (seleccion == 0) {
			f = filechoser.getSelectedFile();

			if (f.exists()) {
				if (f.isFile()) {
					System.out.println("Es un fichero");

				} else {
					System.out.println("No es un fichero");
				}
			} else {
				System.out.println("No existe el fichero/directorio");
			}

		} else {
			System.out.println("Nada seleccionado");

		}

		return f;
	}

	public static File fchooseDir() {

		File f = null;
		JFileChooser filechoser = new JFileChooser();
		filechoser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int seleccion = filechoser.showOpenDialog(filechoser);

		if (seleccion == 0) {
			f = filechoser.getSelectedFile();

			if (f.exists()) {

			} else {
				System.out.println("No existe el fichero/directorio");
			}

		} else {
			System.out.println("Nada seleccionado");

		}

		return f;
	}

	public static File fchooseExtension(String extension) {

		File f = null;
		JFileChooser filechoser = new JFileChooser();

		filechoser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean accept(File f) {
				if (f.getName().endsWith(extension)) {
					return true;
				}
				return false;
			}
		});

		filechoser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int seleccion = filechoser.showOpenDialog(filechoser);

		if (seleccion == 0) {
			f = filechoser.getSelectedFile();

			if (f.exists()) {

				System.out.println("Es un fichero");
			} else {
				System.out.println("No existe el fichero/directorio");
			}

		} else {
			System.out.println("Nada seleccionado");

		}

		return f;
	}

	public static File crearFichero() {
		try {
			JFileChooser filechoser = new JFileChooser();

			filechoser.showSaveDialog(null);

			File f = filechoser.getSelectedFile();

			if (f.exists()) {
				throw new IllegalArgumentException("Fichero incorrecto");
			}

			if (!f.getName().endsWith(".csv")) {
				throw new IllegalArgumentException("Fichero no es csv");
			}

			f.createNewFile();
			System.out.println("Se ha creado");
			return f;

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}

	}

}
