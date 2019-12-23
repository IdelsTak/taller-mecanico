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

import com.github.idelstak.mecanico.domain.spi.ReadOnlyVehicleProperties;
import java.util.Objects;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.paint.Color;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
public abstract class Vehicle implements ReadOnlyVehicleProperties {

    private final ReadOnlyStringWrapper vinProperty;
    private final ReadOnlyStringWrapper makeProperty;
    private final ReadOnlyStringWrapper modelProperty;
    private final ReadOnlyIntegerWrapper yearProperty;
    private final ReadOnlyObjectWrapper<Color> colorProperty;

    protected Vehicle(
            String vin,
            String make,
            String model,
            int year,
            Color color) throws IllegalArgumentException {

        if (StringUtils.isBlank(vin)) {
            throw new IllegalArgumentException("VIN should not be null nor blank");
        }
        if (StringUtils.isBlank(make)) {
            throw new IllegalArgumentException("Car make should not be null nor blank");
        }
        if (StringUtils.isBlank(model)) {
            throw new IllegalArgumentException("Car model should not be null nor blank");
        }
        if (ObjectUtils.isEmpty(color)) {
            throw new IllegalArgumentException("Car color should not be null");
        }

        this.vinProperty = new ReadOnlyStringWrapper(vin);
        this.makeProperty = new ReadOnlyStringWrapper(make);
        this.modelProperty = new ReadOnlyStringWrapper(model);
        this.yearProperty = new ReadOnlyIntegerWrapper(year);
        this.colorProperty = new ReadOnlyObjectWrapper<>(color);
    }

    protected Vehicle(Vehicle other) {
        this(other.getVin(),
                other.getMake(),
                other.getModel(),
                other.getYear(),
                other.getColor());
    }

    @Override
    public ReadOnlyStringProperty vinProperty() {
        return vinProperty.getReadOnlyProperty();
    }

    @Override
    public ReadOnlyStringProperty makeProperty() {
        return makeProperty.getReadOnlyProperty();
    }

    @Override
    public ReadOnlyStringProperty modelProperty() {
        return modelProperty.getReadOnlyProperty();
    }

    @Override
    public ReadOnlyIntegerProperty yearProperty() {
        return yearProperty.getReadOnlyProperty();
    }

    @Override
    public ReadOnlyObjectProperty<Color> colorProperty() {
        return colorProperty.getReadOnlyProperty();
    }

    public String getVin() {
        return vinProperty.get();
    }

    public void setVin(String vin) {
        if (StringUtils.isBlank(vin)) {
            var message = "VIN should not be null nor empty";
            throw new IllegalArgumentException(message);
        }

        vinProperty.set(vin);
    }

    public String getMake() {
        return makeProperty.get();
    }

    public void setMake(String make) {
        if (StringUtils.isBlank(make)) {
            var message = "Vehicle make should not be null nor empty";
            throw new IllegalArgumentException(message);
        }

        makeProperty.set(make);
    }

    public String getModel() {
        return modelProperty.get();
    }

    public void setModel(String model) {
        if (StringUtils.isBlank(model)) {
            var message = "Vehicle model should not be null nor empty";
            throw new IllegalArgumentException(message);
        }

        modelProperty.set(model);
    }

    public int getYear() {
        return yearProperty.get();
    }

    public void setYear(int year) {
        yearProperty.set(year);
    }

    public Color getColor() {
        return colorProperty.get();
    }

    public void setColor(Color color) {
        if (ObjectUtils.isEmpty(color)) {
            throw new IllegalArgumentException("Color should not be null");
        }

        colorProperty.set(color);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.getVin());
        hash = 43 * hash + Objects.hashCode(this.getMake());
        hash = 43 * hash + Objects.hashCode(this.getModel());
        hash = 43 * hash + Objects.hashCode(this.getYear());
        hash = 43 * hash + Objects.hashCode(this.getColor());
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Vehicle other = (Vehicle) obj;
        if (!Objects.equals(this.getVin(), other.getVin())) {
            return false;
        }
        if (!Objects.equals(this.getMake(), other.getMake())) {
            return false;
        }
        if (!Objects.equals(this.getModel(), other.getModel())) {
            return false;
        }
        if (!Objects.equals(this.getYear(), other.getYear())) {
            return false;
        }

        return Objects.equals(this.getColor(), other.getColor());
    }

    /**
     * Returns a string representation of this {@code Vehicle}.<br>
     * This method is intended to be used only for informational purposes.<br>
     * The returned string cannot be {@code null}.
     *
     * @return the string representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("\n------------------------");
        sb.append(String.format("\nVIN: %s", getVin()));
        sb.append(String.format("\nMake: %s", getMake()));
        sb.append(String.format("\nModel: %s", getModel()));
        sb.append(String.format("\nYear: %d", getYear()));
        sb.append(String.format("\nColor: %s", getColor()));
        sb.append("\n------------------------");
        return sb.toString();
    }

}
