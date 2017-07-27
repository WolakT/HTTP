package com.sda.rest.controller;

import com.sda.rest.model.Car;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CarControllerTest {

    private CarController carController;

    @Before
    public void setUp() {
        carController = new CarController();
    }

    @Test
    public void shouldCreateCar() {
        Car car = getDefaultCar();
        Integer expectedId = 0;
        Integer actualId = carController.createCar(car);

        assertEquals(expectedId, actualId);
    }

    @Test
    public void shouldGetCar() {
        Car car = getDefaultCar();
        carController.createCar(car);

        Car actual = carController.getCar(0);

        assertEquals(car, actual);
    }


    @Test
    public void shouldUpdateCar() {
        Car car = getDefaultCar();
        carController.createCar(car);

        Car updated = getDefaultCar();
        updated.setMaxSpeed(210);
        updated.setModel("Astra V");

        carController.updateCar(0, updated);

        assertEquals(updated, carController.getCar(0));
    }


    @Test
    public void shouldDeleteCar() {
        Car car = getDefaultCar();
        carController.createCar(car);

        Car deletedCar = carController.deleteCar(0);

        assertEquals(car, deletedCar);
    }


    private Car getDefaultCar() {
        Car car = new Car();
        car.setMake("Opel");
        car.setModel("Astra");
        car.setMaxSpeed(190);
        car.setYear(1991);
        return car;
    }
}