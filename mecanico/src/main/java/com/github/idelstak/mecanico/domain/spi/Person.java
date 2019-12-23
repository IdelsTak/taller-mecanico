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

import com.github.idelstak.mecanico.domain.api.Address;
import java.util.Objects;
import java.util.Optional;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
public class Person implements ReadOnlyPersonProperties {

    private final ReadOnlyStringWrapper namePropertyWrapper;
    private final ReadOnlyObjectWrapper<Address> addressPropertyWrapper;
    private final ReadOnlyStringWrapper phonePropertyWrapper;
    private final ReadOnlyStringWrapper emailPropertyWrapper;

    /**
     *
     * @param name
     * @param address
     * @param phone
     * @param email
     *
     * @throws IllegalArgumentException if the {@code name} is null
     */
    protected Person(String name, Address address, String phone, String email)
            throws IllegalArgumentException {

        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Name should not be null nor empty");
        }

        this.namePropertyWrapper = new ReadOnlyStringWrapper(name);
        this.addressPropertyWrapper = new ReadOnlyObjectWrapper<>(address);
        this.phonePropertyWrapper = new ReadOnlyStringWrapper(phone);
        this.emailPropertyWrapper = new ReadOnlyStringWrapper(email);
    }

    public static Person of(String name, Address address, String phone, String email) {
        return new Person(name, address, phone, email);
    }

    public static Person from(String name) {
        return new Person(name, null, "", "");
    }

    @Override
    public ReadOnlyStringProperty nameProperty() {
        return namePropertyWrapper.getReadOnlyProperty();
    }

    @Override
    public ReadOnlyObjectProperty<Address> addressProperty() {
        return addressPropertyWrapper.getReadOnlyProperty();
    }

    @Override
    public ReadOnlyStringProperty phoneProperty() {
        return phonePropertyWrapper.getReadOnlyProperty();
    }

    @Override
    public ReadOnlyStringProperty emailProperty() {
        return emailPropertyWrapper.getReadOnlyProperty();
    }

    public String getName() {
        return namePropertyWrapper.get();
    }

    public void setName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("Name should not be null nor empty");
        }
        namePropertyWrapper.set(name);
    }

    public Optional<Address> getAddress() {
        return Optional.ofNullable(addressPropertyWrapper.get());
    }

    public void setAddress(Address address) {
        addressPropertyWrapper.set(address);
    }

    public Optional<String> getPhone() {
        return Optional.ofNullable(phonePropertyWrapper.get());
    }

    public void setPhone(String phone) {
        phonePropertyWrapper.set(phone);
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(emailPropertyWrapper.get());
    }

    public void setEmail(String email) {
        emailPropertyWrapper.set(email);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.getName());
        hash = 17 * hash + Objects.hashCode(this.getAddress());
        hash = 17 * hash + Objects.hashCode(this.getPhone());
        hash = 17 * hash + Objects.hashCode(this.getEmail());
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
        var other = (Person) obj;
        if (!Objects.equals(this.getName(), other.getName())) {
            return false;
        }
        if (!Objects.equals(this.getAddress(), other.getAddress())) {
            return false;
        }
        if (!Objects.equals(this.getPhone(), other.getPhone())) {
            return false;
        }
        return Objects.equals(this.getEmail(), other.getEmail());
    }

    @Override
    public String toString() {
        return new StringBuilder("------------------------")
                .append(String.format("\nName: %s", getName()))
                .append(String.format("\nAddress: \n%s", getAddress().orElse(Address.EMPTY)))
                .append(String.format("\nPhone: %s", getPhone().orElse("N/A")))
                .append(String.format("\nEmail: %s", getEmail().orElse("N/A")))
                .append("\n------------------------")
                .toString();
    }

}
