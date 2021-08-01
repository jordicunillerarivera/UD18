import objetos.ConnectSQL;

public class Ud18_02App {

	public static void main(String[] args) {
		
        ConnectSQL a = new ConnectSQL();
		
		a.abrirConnec();
		a.createDB("Empleados");
		// Crear tablas
		a.createTable("Empleados", "Departamentos", "Codigo int primary key, Nombre char(100), Presupuesto int");
		a.createTable("Empleados", "Empleados",
				"DNI varchar(8) primary key, Nombre char(100), Apellidos char(255), Departamento int, foreign key (Departamento) references Departamentos(Codigo)");
		// Añadir datos
		a.insertData("Empleados", "Departamentos", "(Codigo, Nombre, Presupuesto) values(1,\"Departamento\", 500)");
		a.insertData("Empleados", "Departamentos", "(Codigo, Nombre, Presupuesto) values(2,\"Departamento2\", 600)");
		a.insertData("Empleados", "Departamentos", "(Codigo, Nombre, Presupuesto) values(3,\"Departamento3\", 450)");
		a.insertData("Empleados", "Departamentos", "(Codigo, Nombre, Presupuesto) values(4,\"Departamento4\", 650)");
		a.insertData("Empleados", "Departamentos", "(Codigo, Nombre, Presupuesto) values(5,\"Departamento5\", 600)");

		a.insertData("Empleados", "Empleados",
				"(DNI, Nombre, Apellidos, Departamento) values(\"16557A\",\"Juan\",\"Lopez Gonzalez\", 1)");
		a.insertData("Empleados", "Empleados",
				"(DNI, Nombre, Apellidos, Departamento) values(\"165387A\",\"Anna\",\"Marin Castell\", 3)");
		a.insertData("Empleados", "Empleados",
				"(DNI, Nombre, Apellidos, Departamento) values(\"103157A\",\"Jose Luis\",\"Padilla Gonzalez\", 4)");
		a.insertData("Empleados", "Empleados",
				"(DNI, Nombre, Apellidos, Departamento) values(\"397153F\",\"Pedro\",\"Armando Maradona\", 2)");
		a.insertData("Empleados", "Empleados",
				"(DNI, Nombre, Apellidos, Departamento) values(\"364782B\",\"Alfredo\",\"Toca Mela\", 1)");
		a.cerrarConnec();
		
	}

}
