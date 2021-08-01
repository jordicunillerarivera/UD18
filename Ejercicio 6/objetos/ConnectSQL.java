package Objectos;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.sql.Connection;

public class ConnectSQL {

		// Atributos
    private static Connection conexion;

    	// Metodos
    // Metodo para abrir la conexion
    public void abrirConnec() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://192.168.1.45:3306?useTimezone=true&serverTimezone=UTC",
                    "remote", "PasswordRoot8?");
            System.out.println("Servidor conectado.");

        } catch (SQLException | ClassNotFoundException ex) {

            System.out.println("No se pudo conectar con la BD.");
            System.out.println(ex);

        }

    }

    // Metodo para cerrar la conexion
    public void cerrarConnec() {
        try {

            conexion.close();
            System.out.println("Conexión finalizada.");

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());
            System.out.println("Error, cerrando conexión.");

        }
    }

    // Metodo para crear la BD
    public void createDB(String name) {
        try {
            String Query = "CREATE DATABASE " + name;
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
            System.out.println("BD creada con exito!");
            System.out.println("Se ha creado la BD " + name);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al crear la BD.");
        }
    }
    
    // Metodo para crear un string con los datos de la tabla a crear 
    public String datosCrearTabla() {
    	
    	int numAtrib = Integer.parseInt(JOptionPane.showInputDialog("Cuantos atributos va a tener la tabla?"));
    	String string = "";
    	
    	for (int i = 0; i < numAtrib; i++) {
			
    		String nombre = JOptionPane.showInputDialog("Introduce el nombre del atributo " + (i+1));
    		String tipo = JOptionPane.showInputDialog("Que tipo es");
    		
    		if (i == 0) {
    			string = nombre + " " + tipo;
			} else {
				string += ", " + nombre + " " + tipo;
			}
		}
    	
    	int numPrim = Integer.parseInt(JOptionPane.showInputDialog("Cuantas claves primarias va a tener la tabla?"));
    	
    	for (int i = 0; i < numPrim; i++) {
			
    		String primary = JOptionPane.showInputDialog("Cual va a ser la primary key " + (i+1) +"?");
    		
			string += ", PRIMARY KEY(" + primary + ")";
		}
    	
    	int numfora = Integer.parseInt(JOptionPane.showInputDialog("Cuantas claves foraneas va a tener la tabla?"));
    	
    	for (int i = 0; i < numfora; i++) {
			
    		String foreign = JOptionPane.showInputDialog("Cual va a ser la foreign key " + (i+1) +"?");
    		String foreignTabla = JOptionPane.showInputDialog("A que tabla hace referencia?");
    		String foreignAtributo = JOptionPane.showInputDialog("A que atributo de la tabla " + foreignTabla + " hace referencia?");
    		
			string += ", FOREIGN KEY("+foreign+") REFERENCES "+foreignTabla+"("+foreignAtributo+")";
		}
    	
    	return string;
    }

    // Metodo para crear la tabla
    public void createTable(String db, String name) {
        try {
            String Querydb = "USE " + db + ";";
            Statement stdb = conexion.createStatement();
            stdb.executeUpdate(Querydb);

            String Query = "CREATE TABLE " + name + " (" + datosCrearTabla() + ");";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
            System.out.println("Tabla creada con exito!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al crear la tabla.");

        }
    }
    
 // Metodo para crear la tabla
    public void createTable(String db, String name, String datosTabla) {
        try {
            String Querydb = "USE " + db + ";";
            Statement stdb = conexion.createStatement();
            stdb.executeUpdate(Querydb);

            String Query = "CREATE TABLE " + name + " (" + datosTabla + ");";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
            System.out.println("Tabla creada con exito!!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al crear la tabla.");

        }
    }
    
    // Metodo para crear un string con los datos de la tabla a insertar
    public String datosInsertarTabla() {
    	
    	int numAtrib = Integer.parseInt(JOptionPane.showInputDialog("Cuantos atributos va a querer insertar en la tabla?"));
    	String string = "";
    	String string1 = "";
    	String string2 = "";
    	
    	for (int i = 0; i < numAtrib; i++) {
			
    		String nombre = JOptionPane.showInputDialog("Introduce el nombre del atributo " + (i+1));
    		String valor = JOptionPane.showInputDialog("Introduce el valor del atributo " + nombre);
    		
    		if (i == 0) {
    			string1 = nombre;
			} else {
				string1 += ", " + nombre;
			}
    		
    		if (i == 0) {
    			string2 = "\"" + valor + "\"";
			} else {
				string2 += ", \"" + valor + "\"";
			}
		}
    	
    	string = "(" + string1 + ") VALUES (" + string2 + ")";
		System.out.println(string);
    	
    	return string;
    }

    // Metodo para insertar datos en la tabla
    public void insertData(String db, String table_name) {
        try {
            String Querydb = "USE " + db + ";";
            Statement stdb = conexion.createStatement();
            stdb.executeUpdate(Querydb);

            String Query = "INSERT INTO " + table_name + " " + datosInsertarTabla() + ";";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
            System.out.println("Datos almacenados correctamente");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al insertar");
        }

    }
    
 // Metodo para insertar datos en la tabla
    public void insertData(String db, String table_name, String datosTabla) {
        try {
            String Querydb = "USE " + db + ";";
            Statement stdb = conexion.createStatement();
            stdb.executeUpdate(Querydb);

            String Query = "INSERT INTO " + table_name + " " + datosTabla + ";";
            Statement st = conexion.createStatement();
            st.executeUpdate(Query);
            System.out.println("Datos almacenados correctamente");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error al insertar");
        }

    }

    // Metodo para hacer coger el valor
    public void getValues(String db, String table_name) {
        try {
            String Querydb = "USE " + db + ";";
            Statement stdb = conexion.createStatement();
            stdb.executeUpdate(Querydb);
            
            int numeroBus = Integer.parseInt("Cuantas columnas quieres consultar");
            String busqueda = "";
            
            for (int i = 0; i < numeroBus; i++) {
				
            	
            	
			}

            String Query = "SELECT "+busqueda+" FROM " + table_name;
            Statement st = conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);

            while (resultSet.next()) {
                System.out.println(
                        "ID: " + resultSet.getString("ID") + " " + "Nombre: " + resultSet.getString("Nombre") + " ");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en la adquisicion de datos");
        }

    }
    
    // Metodo para hacer coger el valor
    public void getValues(String db, String busqueda, String table_name) {
        try {
            String Querydb = "USE " + db + ";";
            Statement stdb = conexion.createStatement();
            stdb.executeUpdate(Querydb);

            String Query = "SELECT "+busqueda+" FROM " + table_name;
            Statement st = conexion.createStatement();
            java.sql.ResultSet resultSet;
            resultSet = st.executeQuery(Query);

            while (resultSet.next()) {
                System.out.println(
                        "ID: " + resultSet.getString("ID") + " " + "Nombre: " + resultSet.getString("Nombre") + " ");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error en la adquisicion de datos");
        }

    }

}