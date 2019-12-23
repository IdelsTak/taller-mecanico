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

import com.github.idelstak.mecanico.domain.spi.VehicleProperties;
import java.util.Objects;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.paint.Color;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
public abstract class Vehicle implements VehicleProperties {

    private final SimpleStringProperty vinProperty;
    private final SimpleStringProperty makeProperty;
    private final SimpleStringProperty modelProperty;
    private final SimpleIntegerProperty yearProperty;
    private final SimpleObjectProperty<Color> colorProperty;

    protected Vehicle(String VIN, String make, String model, int year, Color color) {
        this.vinProperty = new SimpleStringProperty(VIN);
        this.makeProperty = new SimpleStringProperty(make);
        this.modelProperty = new SimpleStringProperty(model);
        this.yearProperty = new SimpleIntegerProperty(year);
        this.colorProperty = new SimpleObjectProperty<>(color);
    }

    @Override
    public SimpleStringProperty vinProperty() {
        return vinProperty;
    }

    @Override
    public SimpleStringProperty makeProperty() {
        return makeProperty;
    }

    @Override
    public SimpleStringProperty modelProperty() {
        return modelProperty;
    }

    @Override
    public SimpleIntegerProperty yearProperty() {
        return yearProperty;
    }

    @Override
    public SimpleObjectProperty<Color> colorProperty() {
        return colorProperty;
    }

    public String getVIN() {
        return vinProperty.get();
    }

    public void setVIN(String VIN) {
        vinProperty.set(VIN);
    }

    public String getMake() {
        return makeProperty.get();
    }

    public void setMake(String make) {
        makeProperty.set(make);
    }

    public String getModel() {
        return modelProperty.get();
    }

    public void setModel(String model) {
        if (model.isBlank()) {
            throw new IllegalArgumentException("Vehicle model should not be blank");
        }
        
        var message = "Car model should not be null";
        var nonNullModel = Objects.requireNonNull(model, message);
        
        modelProperty.set(nonNullModel);
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
        var message = "Color should not be null";
        var nonNullColor = Objects.requireNonNull(color, message);
        
        colorProperty.set(nonNullColor);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.getVIN());
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
        if (!Objects.equals(this.getVIN(), other.getVIN())) {
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
        sb.append(String.format("\nVIN: %s", getVIN()));
        sb.append(String.format("\nMake: %s", getMake()));
        sb.append(String.format("\nModel: %s", getModel()));
        sb.append(String.format("\nYear: %d", getYear()));
        sb.append(String.format("\nColor: %s", getColor()));
        sb.append("\n------------------------");
        return sb.toString();
    }

}
