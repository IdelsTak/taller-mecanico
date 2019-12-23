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

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
public class Car extends Vehicle {

    /**
     * Factory builder for a {@code Car}.Provides a facility for verification
     * of the parameters needed to create a {@code Car} object.
     *
     * @param VIN   the vehicle identification number
     * @param make  the make of the vehicle
     * @param model the vehicle's model
     * @param year  the vehicle's year of manufacture (YOM)
     * @param color the vehicle's color
     *
     * @return a new {@code Car} object
     */
    public static Car create(
            String VIN,
            String make,
            String model,
            int year,
            Color color) throws IllegalArgumentException {

        if (VIN == null || VIN.isBlank()) {
            throw new IllegalArgumentException("VIN should not be null nor blank");
        }
        if (make == null || make.isBlank()) {
            throw new IllegalArgumentException("Car make should not be null nor blank");
        }
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Car model should not be null nor blank");
        }
        if (color == null) {
            throw new IllegalArgumentException("Car color should not be null");
        }

        return new Car(VIN, make, model, year, color);
    }

    /**
     * Made {@code protected} for testing purposes. Otherwise, should be
     * {@code private}.
     *
     * @param VIN
     * @param make
     * @param model
     * @param year
     * @param color
     */
    protected Car(String VIN, String make, String model, int year, Color color) {
        super(VIN, make, model, year, color);
    }

    @Override
    public String toString() {
        return String.format("Car: %s", super.toString());
    }

}
