package Objectos;

public class Ejercicio7App {

	public static void main(String[] args) {
		ConnectSQL a = new ConnectSQL();

		a.abrirConnec();
		a.createDB("Cientificos"); // Creamos la BD
		// Creamos las tablas
		a.createTable("Cientificos", "Cientificos", "dni varchar(8) primary key, nombre varchar(255)");
		a.createTable("Cientificos", "Proyecto", "id char(4) primary key, nombre varchar(255), horas int");
		a.createTable("Cientificos", "AsignadoA", "cientifico varchar(8), proyecto char(4), primary key (cientifico, proyecto), foreign key (cientifico) references Cientificos(dni), foreign key (proyecto) references Proyecto(id)");
		// Insert cientificos
		a.insertData("Cientificos", "Cientificos", "(dni, nombre) values (\"1234567A\", \"c1\")");
		a.insertData("Cientificos", "Cientificos", "(dni, nombre) values (\"1234567B\", \"c2\")");
		a.insertData("Cientificos", "Cientificos", "(dni, nombre) values (\"1234567C\", \"c3\")");
		a.insertData("Cientificos", "Cientificos", "(dni, nombre) values (\"1234567D\", \"c4\")");
		a.insertData("Cientificos", "Cientificos", "(dni, nombre) values (\"1234567E\", \"c5\")");
		// Insert poyecto
		a.insertData("Cientificos", "Proyecto", "(id, nombre) values (1, \"p1\")");
		a.insertData("Cientificos", "Proyecto", "(id, nombre) values (2, \"p2\")");
		a.insertData("Cientificos", "Proyecto", "(id, nombre) values (3, \"p3\")");
		a.insertData("Cientificos", "Proyecto", "(id, nombre) values (4, \"p4\")");
		a.insertData("Cientificos", "Proyecto", "(id, nombre) values (5, \"p5\")");
		// Insert asignadoA
		a.insertData("Cientificos", "AsignadoA", "(cientifico, proyecto) values(\"1234A\", 5)");
		a.insertData("Cientificos", "AsignadoA", "(cientifico, proyecto) values(\"1234B\", 4)");
		a.insertData("Cientificos", "AsignadoA", "(cientifico, proyecto) values(\"1234C\", 3)");
		a.insertData("Cientificos", "AsignadoA", "(cientifico, proyecto) values(\"1234D\", 2)");
		a.insertData("Cientificos", "AsignadoA", "(cientifico, proyecto) values(\"1234E\", 1)");
		a.cerrarConnec();//cerramos conexion
	}

}
