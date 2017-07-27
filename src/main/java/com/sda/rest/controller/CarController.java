package com.sda.rest.controller;


import com.sda.rest.model.Car;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/v1/car")
public class CarController {

    private static List<Car> cars = new ArrayList<>();;

    public CarController() {

    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car getCar(@PathParam("id") Integer id) {
        return cars.get(id);
    }

    @POST
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer createCar(Car car) {
        cars.add(car);
        return cars.size() - 1;
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Integer updateCar(@PathParam("id") Integer id, Car car) {
        cars.remove(id.intValue());
        cars.add(car);
        return cars.size() - 1;
    }


    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Car deleteCar(@PathParam("id") Integer id) {
        Car car = cars.get(id);
        cars.remove(id.intValue());
        return car;
    }
}

