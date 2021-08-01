import objetos.ConnectSQL;

public class Ud18_03App {

    public static void main(String[] args) {

        ConnectSQL a = new ConnectSQL();

        a.abrirConnec();
        a.createDB("Almacenes");
		//Crear tablas
        a.createTable("Almacenes", "Almacenes", "Codigo int auto_increment primary key, Lugar char(100), Capacidad int");
		a.createTable("Almacenes", "Cajas", "NumReferencia char(5) primary key, Contenido char(100), Valor int, Almacen int, foreign key (Almacen) references Almacenes(Codigo)");
        //Añadir datos
		a.insertData("Almacenes", "Almacenes", "(Lugar, Capacidad) values(\"Departamento\", 100)");
		a.insertData("Almacenes", "Almacenes", "(Lugar, Capacidad) values(\"Departamento\", 70)");
		a.insertData("Almacenes", "Almacenes", "(Lugar, Capacidad) values(\"Departamento\", 110)");
		a.insertData("Almacenes", "Almacenes", "(Lugar, Capacidad) values(\"Departamento\", 50)");
		a.insertData("Almacenes", "Almacenes", "(Lugar, Capacidad) values(\"Departamento\", 85)");
	
		
		a.insertData("Almacenes", "Cajas", "(NumReferencia, Contenido, Valor, Almacen) values(\"ABC01\",\"Teclados\",50, 1)");
		a.insertData("Almacenes", "Cajas", "(NumReferencia, Contenido, Valor, Almacen) values(\"ABC02\",\"Ratones\",40, 3)");
		a.insertData("Almacenes", "Cajas", "(NumReferencia, Contenido, Valor, Almacen) values(\"ABC03\",\"Pantallas\",20, 2)");
		a.insertData("Almacenes", "Cajas", "(NumReferencia, Contenido, Valor, Almacen) values(\"ABC04\",\"Graficas\",10, 1)");
		a.insertData("Almacenes", "Cajas", "(NumReferencia, Contenido, Valor, Almacen) values(\"ABC05\",\"Camaras\",5, 4)");
		
        a.cerrarConnec();

    }

}