import objetos.ConnectSQL;

public class Ud18_04App {

    public static void main(String[] args) {

        ConnectSQL a = new ConnectSQL();

        a.abrirConnec();
        a.createDB("PelisYSalas");
		//Crear tablas
        a.createTable("PelisYSalas", "Peliculas", "Codigo int auto_increment primary key, Nombre char(100), CalificacionEdad int");
		a.createTable("PelisYSalas", "Salas", "Codigo int auto_increment primary key, Nombre char(100), Pelicula int, foreign key (Pelicula) references Peliculas(Codigo)");
        //Añadir datos
		a.insertData("PelisYSalas", "Peliculas", "(Nombre, CalificacionEdad) values(\"Peli1\", 18)");
		a.insertData("PelisYSalas", "Peliculas", "(Nombre, CalificacionEdad) values(\"Peli2\", 16)");
		a.insertData("PelisYSalas", "Peliculas", "(Nombre, CalificacionEdad) values(\"Peli3\", 12)");
		a.insertData("PelisYSalas", "Peliculas", "(Nombre, CalificacionEdad) values(\"Peli4\", 16)");
		a.insertData("PelisYSalas", "Peliculas", "(Nombre, CalificacionEdad) values(\"Peli5\", 18)");
	
		
		a.insertData("PelisYSalas", "Salas", "(Nombre, Pelicula) values(\"Sala1\", 1)");
		a.insertData("PelisYSalas", "Salas", "(Nombre, Pelicula) values(\"Sala2\", 1)");
		a.insertData("PelisYSalas", "Salas", "(Nombre, Pelicula) values(\"Sala3\", 4)");
		a.insertData("PelisYSalas", "Salas", "(Nombre, Pelicula) values(\"Sala4\", 2)");
		a.insertData("PelisYSalas", "Salas", "(Nombre, Pelicula) values(\"Sala5\", 3)");
		
        a.cerrarConnec();

    }

}