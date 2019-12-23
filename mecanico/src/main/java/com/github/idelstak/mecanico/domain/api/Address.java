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

import com.github.idelstak.mecanico.domain.spi.ReadOnlyAddressProperty;
import java.util.Objects;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
public class Address implements ReadOnlyAddressProperty {

    public static final Address EMPTY = new Empty();
    private final ReadOnlyStringWrapper detailsPropertyWrapper;

    /**
     * Meant to be used by the {@link Empty} address only.
     */
    private Address() {
        this.detailsPropertyWrapper = new ReadOnlyStringWrapper(null);
    }

    /**
     * Throws an {@link IllegalArgumentException} when a {@code null} or empty
     * string is supplied to it.
     *
     * @param details the non{@code null} and non-empty address details
     */
    protected Address(String details) {
        if (StringUtils.isBlank(details)) {
            var message = "Address details should not be null nor empty";
            throw new IllegalArgumentException(message);
        }

        this.detailsPropertyWrapper = new ReadOnlyStringWrapper(details);
    }

    /**
     * Creates an {@code Address} from the supplied details.
     *
     * @param details
     *
     * @return a new {@code Address} instance.
     */
    public static Address from(String details) {
        return new Address(details);
    }

    @Override
    public ReadOnlyStringProperty detailsProperty() {
        return detailsPropertyWrapper.getReadOnlyProperty();
    }

    public String getDetails() {
        return detailsPropertyWrapper.get();
    }

    /**
     * Throws an {@link IllegalArgumentException} when a {@code null} or empty
     * string is supplied to it.
     *
     * @param details
     */
    public void setDetails(String details) {
        if (StringUtils.isBlank(details)) {
            var message = "Address details should not be null nor empty";
            throw new IllegalArgumentException(message);
        }
        detailsPropertyWrapper.set(details);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.getDetails());
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
        var other = (Address) obj;
        return Objects.equals(this.getDetails(), other.getDetails());
    }

    @Override
    public String toString() {
        return new StringBuilder("------------------------")
                .append(String.format("\n%s", getDetails()))
                .append("\n------------------------")
                .toString();
    }

    /**
     * A Convenience whose main purpose is to provide a "N/A" string
     * representation of this class.
     * <p>
     * It has null details. And throws an {@link UnsupportedOperationException}
     * when its {@link Empty#setDetails(java.lang.String) setDetails} method is
     * supplied with a value.
     */
    public static class Empty extends Address {

        private Empty() {
            super();
        }

        @Override
        public String toString() {
            return "N/A";
        }

        @Override
        public void setDetails(String details) {
            throw new UnsupportedOperationException("Shouldn't add details to an empty address");
        }

    }

}
