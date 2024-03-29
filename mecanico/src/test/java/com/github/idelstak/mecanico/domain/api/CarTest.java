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
     * Test of
     * {@link Car#of(java.lang.String, java.lang.String, java.lang.String, int, javafx.scene.paint.Color) of}
     * method, of class {@code Car}.
     */
    @org.junit.jupiter.api.Test
    public void testOf() {
        var VIN = "JH4TB2H26CC000000";
        var make = "Acura MDX";
        var model = "TB2H2";
        var year = 2001;
        var color = Color.GRAY;
        var expectedCar = new Car(VIN, make, model, year, color);
        var actualCar = Car.of(VIN, make, model, year, color);

        assertEquals(expectedCar, actualCar);
    }

}
