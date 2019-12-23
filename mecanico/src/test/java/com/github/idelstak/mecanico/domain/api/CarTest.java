/*
 * Copyright (C) 2019 Hiram K. <hiram.kamau@outlook.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.idelstak.mecanico.domain.api;

import javafx.scene.paint.Color;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
public class CarTest {

    /**
     * Test of create method, of class Car.
     */
    @org.junit.jupiter.api.Test
    public void testCreate() {
        System.out.println("testCreate...");

        String VIN = "JH4TB2H26CC000000";
        String make = "Acura MDX";
        String model = "TB2H2";
        int year = 2001;
        Color color = Color.GRAY;

        Car expectedCar = new Car(VIN, make, model, year, color);
        Car actualCar = Car.create(VIN, make, model, year, color);

        System.out.println(String.format(
                "Testing whether %s \nis equal to \n%s",
                new Object[]{expectedCar, actualCar}));

        assertEquals(expectedCar, actualCar);
    }

}
