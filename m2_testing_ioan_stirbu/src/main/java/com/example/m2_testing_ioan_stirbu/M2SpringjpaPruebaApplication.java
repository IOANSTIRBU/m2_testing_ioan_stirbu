package com.example.m2_testing_ioan_stirbu;

import com.example.m2_testing_ioan_stirbu.entities.Avion;
import com.example.m2_testing_ioan_stirbu.entities.Nave;
import com.example.m2_testing_ioan_stirbu.enumeradores.DaysNave;
import com.example.m2_testing_ioan_stirbu.repositories.AvionesRepository;
import com.example.m2_testing_ioan_stirbu.repositories.NavesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class M2SpringjpaPruebaApplication implements CommandLineRunner {

    @Autowired
    NavesRepository navesRepository;

    @Autowired
    AvionesRepository avionesRepository;

    public static void main(String[] args) {

        SpringApplication.run(M2SpringjpaPruebaApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        Scanner sc = new Scanner(System.in);

        mensaje();//Mensaje de bienvenida a la app

        abrirApp();//Cargando app

        elegirOpc();//Elegir al que menu queramos acceder


    }


    private void mensaje() {
        System.out.println("Bienvenido/a a la  App de Spring-Framework , Spring-Data JPA y Spring Rest \n\n\n");
        System.out.println("BIENVENIDO/A A LA APP DE VEHICULOS AÉREOS");
    }

    private void abrirApp() throws InterruptedException {

        System.out.println("Cargando...");
        Thread.sleep(2000);
    }


    private void elegirOpc() {

        System.out.println("Por favor seleccione una Base de datos: elige del (1 o 2) para poder continuar con la operacion");
        int opc = sc.nextInt();

        if (opc == 1) {
            mostrarMenuNaves();
        } else if (opc == 2) {
            mostrarMenuAviones();
        }
    }


    static Scanner sc = new Scanner(System.in);

    public void mostrarMenuNaves() {

        boolean salir = false;
        while (!salir) {

            System.out.println("********-Menu DB Nave-********");
            System.out.print("0.Ver datos de la DB de naves" +
                    "\n1.Se puede pilotar la nave?" +
                    "\n2.Crear la DB de naves " +
                    "\n3.Actualizar datos en la DB de naves" +
                    "\n4.Eliminar una nave en la DB de naves" +
                    "\n5.Eliminar todas los datos de la DB de naves" +
                    "\n6.Salir de la DB de naves" +
                    "\n7.Mostrador de naves\n" +
                    "Elige una opcion:");

            int opc = sc.nextInt();

            /*Hacer una tienda de naves en el que el usuario comprara una nave si existe, sino existe pues tendra que
             * ir a la opcion  */

            try {

                switch (opc) {
                    case 0:
                        System.out.println("Has elegido la opcion 0: Ver datos de la DB de Naves\n");
                        verDatosNave();
                        break;
                    case 1:
                        System.out.println("Has elegido la opcion 1: Se puede pilotar?\n");
                        pilotarNave();
                        break;
                    case 2:
                        System.out.println("Has elegido la opcion 2: Crear la DB de naves\n");
                        crearNaves();
                        break;
                    case 3:
                        System.out.println("Has elegido la opcion 4: Actualizar los datos de la DB de Naves\n");
                        actualizarNaves();
                        break;
                    case 4:
                        System.out.println("Has elegido la opcion 5: Eliminar una nave de la base de datos de Naves\n");
                        eliminarUnaNave();
                        break;
                    case 5:
                        System.out.println("Has elegido la opcion 5: Eliminar naves de la base de datos de Naves\n");
                        eliminarNaves();
                        break;
                    case 6:
                        System.out.println("Has elegido la opcion 5: Salir de la Base de datos de Naves");
                        System.out.println("Seguro que quieres salir de esta base de datos? pulsa (1)-->Si (2)-->No");
                        opc = sc.nextInt();
                        sc.nextLine();
                        if (opc == 1) {
                            salir = true;
                            System.out.println("Si quiero salir de la base de datos y de la App");
                            System.out.println("Hasta pronto y muchas gracias por entrar a esta DB");
                            System.exit(0);
                        } else if (opc == 2) {
                            salir = false;
                            System.out.println("No, quiero seguir en esta base de datos gracias!");

                        }
                        break;
                    case 7:
                        System.out.println("Has elegido la opcion 7: Abrir tienda de naves\n");
                        MostradorNaves();
                        break;

                    default:
                        System.out.println("Has elegido una opcion no valida!");

                }

            } catch (IllegalArgumentException | InterruptedException  | IllegalStateException  e) {
                e.printStackTrace();
            }


        }
    }

    private void pilotarNave() {

        System.out.println("Digame un numero del 1 al 7 que indicara el dia de la semana");
        int opcNave = sc.nextInt();
        sc.nextLine();

        switch (opcNave) {

            case 1:
                System.out.println("Elegiste: " + DaysNave.LUNES);
                System.out.println("Enhorabuena ya puede pilotar Atlantis\n");
                break;
            case 2:
                System.out.println("Elegiste: " + DaysNave.MARTES);
                System.out.println("Enhorabuena ya puede pilotar Discovery\n");
                break;
            case 3:
                System.out.println("Elegiste: " + DaysNave.MIERCOLES);
                System.out.println("Enhorabuena ya puede pilotar Corazon de Oro\n");
                break;
            case 4:
                System.out.println("Elegiste: " + DaysNave.JUEVES);
                System.out.println("Enhorabuena ya puede pilotar Enterprise\n");
                break;
            case 5:
                System.out.println("Elegiste: " + DaysNave.VIERNES);
                System.out.println("Enhorabuena ya puede pilotar Halcón Milenario\n");
                break;
            case 6:
                System.out.println("Elegiste: " + DaysNave.SABADO);
                System.out.println("Enhorabuena ya puede pilotar Leonov\n");
                break;
            case 7:
                System.out.println("Elegiste: " + DaysNave.DOMINGO);
                System.out.println("Enhorabuena ya puede pilotar Planet Express\n");
                break;
            default:
                System.out.println("Lo sentimos pero el numero introducido no es correcto, pruebe con otro");


        }


    }


    public void verDatosNave() {
        List<Nave> naves = navesRepository.findAll();//Hace una consulta SQL
        //Comprobar si existe naves en la DB sino existen crearlos
        if (naves.isEmpty()) {
            System.out.println("No existen naves en la Base de datos de naves");
            System.out.println("Para eso debera crear una nave con la opcion 2 gracias \n\n");

        } else {
            System.out.println(naves);

        }

    }


    public void crearNaves() {

        //(Crear en DB)Guardar objetos Repositorio en el DB(INSERT INTO)
        boolean salir = false;
        while (!salir) {
            try {
                System.out.println("Dime el nombre de la nave:  por favor pongalo separado por -");
                String nombre = sc.next();
                sc.nextLine();
                System.out.println("Dime la dimension de la nave:");
                Double dimension = sc.nextDouble();
                sc.nextLine();
                System.out.println("Dime el precio de la nave:");
                Double precio = sc.nextDouble();
                sc.nextLine();
                Nave nave1 = new Nave(null, nombre, dimension, precio);
                navesRepository.save(nave1);
                System.out.println("Nave creada correctamente en la DB");
                salir = true;

            } catch (InputMismatchException e) {
               e.printStackTrace(System.out);
                System.out.println("No se deben de meter letras solo numeros gracias");
            }
        }
    }



    public void actualizarNaves() {
        //Hacer Update en la DB

        boolean exist = false;
        while (!exist) {

            System.out.println("Deseas actualizar una nave elige opcion (1)-->Si (2)-->(No):");
            int opc = sc.nextInt();
            if (opc == 1) {
                System.out.println("Si deseo actualizar una nave" + "\n");

                System.out.println("Dime el id de la nave al que quieras:");
                Long id = sc.nextLong();
                Optional<Nave> naveOpt = navesRepository.findById(id);
                if (naveOpt.isEmpty()) {
                    System.out.println("Lo sentimos pero no existe la nave que solicitaste");
                    continue;
                }

                Nave nave = naveOpt.get();

                System.out.println("Dime el nombre de la nave (actual: " + nave.getNombre() + ")");
                String nombre = sc.next();
                nave.setNombre(nombre);
                System.out.println("Dime la dimension de la nave (actual:" + nave.getDimension() + ")");
                Double dimension = sc.nextDouble();
                sc.nextLine();
                nave.setDimension(dimension);
                System.out.println("Dime el precio de la nave (actual: " + nave.getPrecio() + ")");
                Double precio = sc.nextDouble();
                sc.nextLine();
                nave.setPrecio(precio);

                navesRepository.save(nave);
                System.out.println("Nave actualizada correctamente");

            } else if (opc == 2) {
                exist = true;
                System.out.println("No deseo actualizar una nave gracias!");
            }


        }
    }

    public void eliminarUnaNave() {
        //Borrar en la DB

        System.out.println("Deseas eliminar una nave por id? elige opcion (1)-->Si (2)-->(No):");
        int opc = sc.nextInt();
        if (opc == 1) {
            System.out.println("Dime el id de la nave que quieres eliminar por favor");
            Long id = sc.nextLong();

            boolean exists = navesRepository.existsById(id);

            if (exists) {
                navesRepository.deleteById(id);
                System.out.println("Nave con id " + id + " borrado");
                System.out.println("Nave eliminada correctamente");
            } else {
                System.out.println("No existe la nave con el id " + id);

            }

        } else if (opc == 2) {
            System.out.println("No deseo eliminar nave gracias!");
        }



    }


    private void eliminarNaves() {

        System.out.println("Estas seguro que quieres borrar la DB de naves (Si-->(1) o (2)-->No)");
        int opc = sc.nextInt();
        if (opc == 1) {
            System.out.println("Escribe (true)");
            boolean confirmar = sc.nextBoolean();
            if (confirmar)
            System.out.println("Dime un id para asegurar");
            Long id = sc.nextLong();
            if(navesRepository.existsById(id)) {
                navesRepository.deleteAll();
                System.out.println("Base de datos de naves eliminada correctamente");
                confirmar = true;
            }else{
                System.out.println("No existe la DB para eliminar ");
            }

        } else if (opc == 2) {
            System.out.println("No deseo eliminar la DB de naves gracias! ");
        }


    }

    private void MostradorNaves() throws InterruptedException {

        Scanner sc = new Scanner(System.in);

        System.out.println("Hola elige una nave (por favor: Escriba el nombre gracias)" +
                                     "\nAtlantis" +
                                    "\nDiscovery" +
                                    "\nLeonov" +
                                    "\nEnterprise" +
                                    "\nGalactica");

        String nombre = sc.next();
        abrirApp();
        if ("Atlantis".equalsIgnoreCase(nombre)) {
            System.out.println("Has elegido la nave Atlantis");
            datosAtlantis();
        }else if("Discovery".equalsIgnoreCase(nombre)){
            System.out.println("Has elegido la nave Discovery");
            datosDiscovery();
        }else if("Leonov".equalsIgnoreCase(nombre)){
            System.out.println("Has elegido la nave Leonov");
            datosLeonov();

        }else if ("Enterprise".equalsIgnoreCase(nombre)){
            System.out.println("Has elegido la nave Enterprise");
            datosEnterprise();
        }else if ("Galactica".equalsIgnoreCase(nombre)){
            System.out.println("Has elegido la nave Galactica");
            datosGalactica();
        }




    }




    private void datosAtlantis() {
        System.out.print("Eslora: 21 Km aproximadamente.\n" +
                "Tripulación: Al ser una ciudad puede ser habitada por miles de personas\n" +
                "Sistema propulsor: Seis motores hiperespaciales. Capacidad de salto al hiperespacio.\n" +
                "Alimentación: 3 ZPM (Modulos de punto cero)\n" +
                "Defensa: Escudo de plasma de tecnologia Antigua\n\n");


    }

    private void datosDiscovery() {
        System.out.print("Eslora: 140,1 metros\n" +
                "Diámetro del módulo de comando: 16,5 metros\n" +
                "Masa: 5.440 toneladas\n" +
                "Sistema propulsor: seis motores de propulsión a plasma que utilizan amoniaco líquido como combustible\n" +
                "Máxima fuerza de empuje: 2,75 Mega Newtons\n\n");

    }


    private void datosLeonov() {
        System.out.print("Eslora: 90 metros aproximadamente\n" +
                "Ancho máximo (módulo de comando): 39 metros aproximadamente\n" +
                "Tripulación: diez hombres: siete rusos y tres americanos" +
                "Aerofrenado: escudos térmicos en la novela, globo-paracaídas (ballute) en la película\n\n");

    }

    private void datosEnterprise() {
        System.out.print("Eslora: 288 metros. Ampliado a 304.8 metros después de reparaciones mayores.\n" +
                "Masa: 500.000 toneladas\n" +
                "Tripulación: 430-500 personas\n" +
                "Sistema propulsor: motor de curvatura o motor warp alimentado por un reactor de antimateria.\n\n");

    }

    private void datosGalactica() {
        System.out.print("Eslora: 1.414 metros\n" +
                "Tripulación: Su dotación completa consta de 2800 hombres " +
                "Sistema propulsor: Motores FTL (Faster Than Light): según parece, consiste en una tecnología similar al hiperespacio, " +
                "que permite teletransportar la nave de manera casi instantanea hacia unas coordenadas previamente calculadas.\n\n");


    }




    //AQUI TERMINA EL CODIGO DE NAVES


    //TODO empezar con el menu de aviones
    public void mostrarMenuAviones() {

        System.out.println("1.Crear la DB de aviones ");
        System.out.println("2.Leer datos en la DB de aviones");
        System.out.println("3.Comida gratis en el vuelo?");
        System.out.println("3.Actualizar datos en la DB de aviones");
        System.out.println("4.Eliminar datos en la DB de aviones");
        System.out.println("5.Salir de la DB de de aviones");
        System.out.println("Elige una opcion:");

        int opc = sc.nextInt();

        boolean salir = false;
        while (!salir) {
            switch (opc) {
                case 1:
                    System.out.println("Has elegido la opcion 1: Creacion de la Base de datos de aviones");
                    crearAviones();
                    break;
                case 2:
                    System.out.println("Has elegido la opcion 2: Leer datos en la Base de datos de aviones");
                    leerAviones();
                    break;
                case 3:
                    System.out.println("Has elegido la opcion 3: Actualizar datos en la Base de datos de aviones");
                    actualizarAviones();
                    break;
                case 4:
                    System.out.println("Has elegido la opcion 4: Eliminar datos de la Base de datos de aviones");
                    eliminarAviones();
                    break;
                case 5:
                    System.out.println("Has elegido la opcion 5: Salir de la Base de datos de aviones");
                    salir = true;
                    break;
                default:
                    System.out.println("Has elegido una opcion no valida!");

            }

        }


    }

    private void crearAviones() {
        Avion av1 = new Avion(null, "Airbus 319", 23.3, 156, 7.200);
        Avion av2 = new Avion(null, "Airbus 330", 132.4, 293, 7.400);
        Avion av3 = new Avion(null, "Boeing 777", 162.7, 550, 17.370);

        avionesRepository.save(av1);
        avionesRepository.save(av2);
        avionesRepository.save(av3);

    }

    private void leerAviones() {

        //Consultar, recuperar, buscar del objeto naves, leer
        List<Avion> aviones = avionesRepository.findAll();
        if (!aviones.isEmpty()) {
            System.out.println(aviones);
        } else {
            System.out.println("No se han encontrado naves en la DB!");
        }

        //System.out.println(aviones);
    }


    private void actualizarAviones() {

        int opc = sc.nextInt();
        System.out.println("Deseas actualizar un avion elige opcion (1)-->Si (2)-->(No):");
        if (opc == 1) {
            System.out.println("Si deseo actualizar un avion");
            System.out.println("Dime el codigo del avion");
            //TODO preguntar usuario el codigo de la nave que quiere cambiar o actualizar
            Avion av1 = new Avion(null, "Airbus 319", 23.3, 156, 7.200);
            av1.setId(4L);
            avionesRepository.save(av1);

        } else if (opc == 2) {
            System.out.println("No deseo actualizar una nave gracias!");
        }


    }

    private void eliminarAviones() {
        //Borrar en la DB
        //TODO preguntar al usuario si realmente quiere eliminar ese avion
        Avion av1 = new Avion(null, "Airbus 319", 23.3, 156, 7.200);
        avionesRepository.delete(av1);

    }

}

//AQUI TERMINA EL CODIGO DE AVIONES




