package Objectos;

public class Ejercicio8App {

	public static void main(String[] args) {
		ConnectSQL a = new ConnectSQL();

		a.abrirConnec();
		a.createDB("grandesAlmacenes"); // Creamos la BD
		// Creamos las tablas
		a.createTable("grandesAlmacenes", "Cajeros", "codigo int auto_increment primary key, nombre varchar(255)");
		a.createTable("grandesAlmacenes", "Productos", "codigo int auto_increment primary key, nombre varchar(100), precio int");
		a.createTable("grandesAlmacenes", "maquinasRegistradoras", "codigo int auto_increment primary key, piso int");
		a.createTable("grandesAlmacenes", "Venta", "cajero int, maquina int, producto int, primary key(cajero, maquina, producto), "
				+ "foreign key (cajero) references Cajeros(codigo), foreign key (maquina) references maquinasRegistradoras(codigo), "
				+ "foreign key (producto) references Productos(codigo)");
		//Insertamos a cajeros
		a.insertData("grandesAlmacenes", "Cajeros", "(nombre) values (\"c1\")");
		a.insertData("grandesAlmacenes", "Cajeros", "(nombre) values (\"c2\")");
		a.insertData("grandesAlmacenes", "Cajeros", "(nombre) values (\"c3\")");
		a.insertData("grandesAlmacenes", "Cajeros", "(nombre) values (\"c4\")");
		a.insertData("grandesAlmacenes", "Cajeros", "(nombre) values (\"c5\")");
		//Insertamos a productos
		a.insertData("grandesAlmacenes", "Productos", "(nombre, precio) values (\"p1\", 50)");
		a.insertData("grandesAlmacenes", "Productos", "(nombre, precio) values (\"p2\", 70)");
		a.insertData("grandesAlmacenes", "Productos", "(nombre, precio) values (\"p3\", 540)");
		a.insertData("grandesAlmacenes", "Productos", "(nombre, precio) values (\"p4\", 40)");
		a.insertData("grandesAlmacenes", "Productos", "(nombre, precio) values (\"p5\", 60)");
		//Insertamos a productos
		a.insertData("grandesAlmacenes", "maquinasRegistradoras", "(piso) values (1)");
		a.insertData("grandesAlmacenes", "maquinasRegistradoras", "(piso) values (2)");
		a.insertData("grandesAlmacenes", "maquinasRegistradoras", "(piso) values (3)");
		a.insertData("grandesAlmacenes", "maquinasRegistradoras", "(piso) values (4)");
		a.insertData("grandesAlmacenes", "maquinasRegistradoras", "(piso) values (5)");
		//Insertamos a venta
		a.insertData("grandesAlmacenes", "Venta", "(cajero, maquina, producto) values (1, 2, 3)");
		a.insertData("grandesAlmacenes", "Venta", "(cajero, maquina, producto) values (2, 4, 2)");
		a.insertData("grandesAlmacenes", "Venta", "(cajero, maquina, producto) values (3, 5, 3)");
		a.insertData("grandesAlmacenes", "Venta", "(cajero, maquina, producto) values (4, 1, 4)");
		a.insertData("grandesAlmacenes", "Venta", "(cajero, maquina, producto) values (5, 3, 5)");
		a.cerrarConnec();//cerramos conexion
	}

}
