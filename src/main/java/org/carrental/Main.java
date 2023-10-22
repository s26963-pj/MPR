package org.carrental;

import org.carrental.model.*;
import org.carrental.repository.CarRepository;
import org.carrental.repository.ClientRepository;
import org.carrental.service.CarService;
import org.carrental.service.ClientService;

import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        CarRepository carRepository = new CarRepository();
        CarService carService = new CarService(carRepository);

        Car car = new Car(null, "volkswagen", "golf", "123",
                CarClass.STANDARD, CarStatus.AVAILABLE);
        Car car2 = new Car(null, "volkswagen", "passat",
                "abc",
                CarClass.STANDARD, CarStatus.RENTED);
        Car car3 = new Car(null, "volkswagen", "passat",
                "zxc",
                CarClass.PREMIUM, CarStatus.AVAILABLE);
        Car createdCar = carService.createCar(car);
        carService.createCar(car2);
        carService.createCar(car3);

        System.out.println(createdCar);

        Car carById = carService.getById(0);

        System.out.println(carById);
        carService.updateModel(2, "polo");

        List<Car> availableCars = carService.getAvailableCars();

        System.out.println(availableCars);


        Car invalidCar = new Car(null, "volkswagen",
                "golf", "1234",
                CarClass.STANDARD, CarStatus.AVAILABLE);


        ClientRepository clientRepository = new ClientRepository();
        ClientService clientService = new ClientService(clientRepository);
        Client client = new Client(null, "Adam", "Kowalski", ClientClass.VIP);
        Client client2 = new Client(null, "Mariola", "Szuchanska", ClientClass.STANDARD);
        Client client3 = new Client(null, "Anna", "Smigol", ClientClass.VIP);

        Client createdClient = clientService.createClient(client);
        clientService.createClient(client2);
        clientService.createClient(client3);

        List<Client> availableClients = clientRepository.getAll();

        System.out.println(availableClients);

//        carService.createCar(invalidCar);


        // Plan działania
        // 1. Zaimplementowanie pozostałych metod z carRepository
        // 2. Utworzenie modelu,serwisu i repozytorium dla klienta
        // 3. Dodanie logów do CarService i ClientService wykorzystując np. log4j
        //
        // Kolejny zjazd:
        // Pokrycie projektu testami jednostkowymi i początek prac nad systemem rezerwacji

    }
}