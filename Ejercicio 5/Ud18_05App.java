import objetos.ConnectSQL;

public class Ud18_05App {

    public static void main(String[] args) {

        ConnectSQL a = new ConnectSQL();

        a.abrirConnec();
        a.createDB("Directores");
		//Crear tablas
        a.createTable("Directores", "Despachos", "Numero int primary key, Capacidad int");
		a.createTable("Directores", "Directores", "DNI char(8) primary key, NomApels char(255), DNIJefe char(8), Despacho int, foreign key (DNIJefe) references Directores(DNI), foreign key (Despacho) references Despachos(Numero)");
        //Añadir datos
		a.insertData("Directores", "Despachos", "(Numero, Capacidad) values(1, 18)");
		a.insertData("Directores", "Despachos", "(Numero, Capacidad) values(2, 28)");
		a.insertData("Directores", "Despachos", "(Numero, Capacidad) values(3, 15)");
		a.insertData("Directores", "Despachos", "(Numero, Capacidad) values(4, 21)");
		a.insertData("Directores", "Despachos", "(Numero, Capacidad) values(5, 23)");
	
		
		a.insertData("Directores", "Directores", "(DNI, NomApels, DNIJefe, Despacho) values(\"2456874A\",\"Nom1\",\"2456874A\", 1)");
		a.insertData("Directores", "Directores", "(DNI, NomApels, DNIJefe, Despacho) values(\"2456874B\",\"Nom2\",\"2456874A\", 1)");
		a.insertData("Directores", "Directores", "(DNI, NomApels, DNIJefe, Despacho) values(\"2456874C\",\"Nom3\",\"2456874B\", 1)");
		a.insertData("Directores", "Directores", "(DNI, NomApels, DNIJefe, Despacho) values(\"2456874D\",\"Nom4\",\"2456874C\", 1)");
		a.insertData("Directores", "Directores", "(DNI, NomApels, DNIJefe, Despacho) values(\"2456874G\",\"Nom5\",\"2456874A\", 1)");
		
        a.cerrarConnec();

    }

}