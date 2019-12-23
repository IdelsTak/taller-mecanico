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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
public class VehicleTest {

//    public VehicleTest() {
//    }
//
//    @Test
//    public void testVinProperty() {
//    }
//
//    @Test
//    public void testMakeProperty() {
//    }
//
//    @Test
//    public void testModelProperty() {
//    }
//
//    @Test
//    public void testYearProperty() {
//    }
//
//    @Test
//    public void testColorProperty() {
//    }
//
//    @Test
//    public void testGetVIN() {
//    }
//
//    @Test
//    public void testSetVIN() {
//    }
//
//    @Test
//    public void testGetMake() {
//    }
//
//    @Test
//    public void testSetMake() {
//    }
//
//    @Test
//    public void testGetModel() {
//    }
//
//    @Test
//    public void testSetModel() {
//    }
//
//    @Test
//    public void testGetYear() {
//    }
//
//    @Test
//    public void testSetYear() {
//    }
//
//    @Test
//    public void testGetColor() {
//    }
//
//    @Test
//    public void testSetColor() {
//    }
//
//    @Test
//    public void testHashCode() {
//    }
//
//    @Test
//    public void testEquals() {
//    }
    @Test
    public void testToString() {
        System.out.println("testToString...");

        var VIN = "JH4TB2H26CC000000";
        var make = "Acura MDX";
        var model = "TB2H2";
        var year = 2001;
        var color = Color.GRAY;

        Vehicle vehicle = new BasicVehicle(VIN, make, model, year, color);

        var expectedToString = new StringBuilder("\n------------------------\n")
                .append("VIN: JH4TB2H26CC000000\n")
                .append("Make: Acura MDX\n")
                .append("Model: TB2H2\n")
                .append("Year: 2001\n")
                .append("Color: 0x808080ff\n")
                .append("------------------------")
                .toString();
        var actualToString = vehicle.toString();

        Assertions.assertEquals(expectedToString, actualToString);
    }

    private class BasicVehicle extends Vehicle {

        private BasicVehicle(
                String VIN,
                String make,
                String model,
                int year,
                Color color) {
            super(VIN, make, model, year, color);
        }

    }

}
