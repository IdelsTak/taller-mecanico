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
package com.github.idelstak.mecanico.domain.spi;

import javafx.scene.paint.Color;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
public interface Vehicle {

    /**
     *
     * @return the Vehicle Identification Number (VIN).
     */
    String getVIN();

    void setVIN(String VIN);

    String getMake();

    void setMake(String make);

    String getModel();

    void setModel(String model);

    int getYear();

    void setYear(int year);

    Color getColor();

    void setColor(Color color);

    @Override
    public String toString();

}