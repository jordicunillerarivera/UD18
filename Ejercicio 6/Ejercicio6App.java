package objectos;

public class Ejercicio6App {

	public static void main(String[] args) {
		ConnectSQL a = new ConnectSQL();
		
		a.abrirConnec();
		a.createDB("PiezasyProveedores"); //Creamos la BD
		//Creamos las tablas
		a.createTable("PiezasyProveedores", "Piezas", "codigo int auto_increment primary key, nombre varchar(100)");
		a.createTable("PiezasyProveedores", "Proveedores", "id char(4), nombre varchar(100)");
		a.createTable("PiezasyProveedores", "Suministra", "codigoPieza int, idProveedor int, precio int, foreign key (CodigoPieza) references Piezas (codigo)");
		//Insert piezas
		a.insertData("PiezasyProveedores", "Piezas", "(nombre) values (\"tuerca\")");
		a.insertData("PiezasyProveedores", "Piezas", "(nombre) values (\"tornillo\")");
		a.insertData("PiezasyProveedores", "Piezas", "(nombre) values (\"broca\")");
		a.insertData("PiezasyProveedores", "Piezas", "(nombre) values (\"martillo\")");
		a.insertData("PiezasyProveedores", "Piezas", "(nombre) values (\"bisagra\")");
		//Insert proveedores
		a.insertData("PiezasyProveedores", "Proveedores", "(id, nombre) values (1, \"proveedor1\")");
		a.insertData("PiezasyProveedores", "Proveedores", "(id, nombre) values (2, \"proveedor2\")");
		a.insertData("PiezasyProveedores", "Proveedores", "(id, nombre) values (3, \"proveedor3\")");
		a.insertData("PiezasyProveedores", "Proveedores", "(id, nombre) values (4, \"proveedor4\")");
		a.insertData("PiezasyProveedores", "Proveedores", "(id, nombre) values (5, \"proveedor5\")");
		//Insert Suministra
		a.insertData("PiezasyProveedores", "Suministra", "(codigoPieza, idProveedor, precio) values (1, 2, 50)");
		a.insertData("PiezasyProveedores", "Suministra", "(codigoPieza, idProveedor, precio) values (2, 3, 10)");
		a.insertData("PiezasyProveedores", "Suministra", "(codigoPieza, idProveedor, precio) values (3, 5, 30)");
		a.insertData("PiezasyProveedores", "Suministra", "(codigoPieza, idProveedor, precio) values (4, 1, 20)");
		a.insertData("PiezasyProveedores", "Suministra", "(codigoPieza, idProveedor, precio) values (5, 4, 80)");
		a.cerrarConnec();//cerramos conexion
		
		
		
	}

}
