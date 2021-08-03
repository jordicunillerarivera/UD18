package Objectos;

public class Ejercicio9App {

	public static void main(String[] args) {
		ConnectSQL a = new ConnectSQL();

		a.abrirConnec();// abrimos la conexion
		a.createDB("Investigadores"); // Creamos la BD
		// Creamos las tablas
		a.createTable("Investigadores", "Facultad", "codigo int primary key, nombre varchar(100)");
		a.createTable("Investigadores", "Investigadores",
				"dni varchar(8) primary key, nombre varchar(255), facultad int, foreign key (facultad) references Facultad(codigo)");
		a.createTable("Investigadores", "Equipos",
				"nSerie char(4) primary key, nombre varchar(100), facultad int, foreign key (facultad) references Facultad(codigo)");
		a.createTable("Investigadores", "Reserva",
				"dni varchar(8), nSerie char(4), comienzo datetime, fin datetime, primary key(dni, nSerie), foreign key (dni) references Investigadores(dni), foreign key (nSerie) references Equipos(nSerie)");
		// Insertamos a Facultad
		a.insertData("Investigadores", "Facultad", "(codigo, nombre) values (1, \"f1\")");
		a.insertData("Investigadores", "Facultad", "(codigo, nombre) values (2, \"f2\")");
		a.insertData("Investigadores", "Facultad", "(codigo, nombre) values (3, \"f3\")");
		a.insertData("Investigadores", "Facultad", "(codigo, nombre) values (4, \"f4\")");
		a.insertData("Investigadores", "Facultad", "(codigo, nombre) values (5, \"f5\")");
		// Insertamos investigadores
		a.insertData("Investigadores", "Investigadores", "(dni, nombre, facultad) values (\"1234567A\", \"i1\", 3)");
		a.insertData("Investigadores", "Investigadores", "(dni, nombre, facultad) values (\"1234567B\", \"i2\", 4)");
		a.insertData("Investigadores", "Investigadores", "(dni, nombre, facultad) values (\"1234567C\", \"i3\", 2)");
		a.insertData("Investigadores", "Investigadores", "(dni, nombre, facultad) values (\"1234567D\", \"i4\", 5)");
		a.insertData("Investigadores", "Investigadores", "(dni, nombre, facultad) values (\"1234567E\", \"i5\", 1)");
		// Insertamos equipos
		a.insertData("Investigadores", "Equipos", "(nSerie, nombre, facultad) values (1, \"e1\" , 2)");
		a.insertData("Investigadores", "Equipos", "(nSerie, nombre, facultad) values (2, \"e2\" , 3)");
		a.insertData("Investigadores", "Equipos", "(nSerie, nombre, facultad) values (3, \"e3\" , 4)");
		a.insertData("Investigadores", "Equipos", "(nSerie, nombre, facultad) values (4, \"e4\" , 5)");
		a.insertData("Investigadores", "Equipos", "(nSerie, nombre, facultad) values (5, \"e5\" , 1)");
		// Insertamos reserva
		a.insertData("Investigadores", "Reserva",
				"(dni, nSerie, comienzo, fin) values (\"1234567A\", 5, \"2020-01-01\", \"2021-01-01\")");
		a.insertData("Investigadores", "Reserva",
				"(dni, nSerie, comienzo, fin) values (\"1234567B\", 3, \"2020-04-01\", \"2021-04-01\")");
		a.insertData("Investigadores", "Reserva",
				"(dni, nSerie, comienzo, fin) values (\"1234567C\", 4, \"2020-06-01\", \"2021-06-01\")");
		a.insertData("Investigadores", "Reserva",
				"(dni, nSerie, comienzo, fin) values (\"1234567D\", 2, \"2020-03-01\", \"2021-03-01\")");
		a.insertData("Investigadores", "Reserva",
				"(dni, nSerie, comienzo, fin) values (\"1234567E\", 1, \"2020-11-01\", \"2021-11-01\")");
		a.cerrarConnec();// cerramos conexion
	}
}
