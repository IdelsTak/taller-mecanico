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

import com.github.idelstak.mecanico.domain.spi.Address;
import com.github.idelstak.mecanico.domain.spi.Person;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
class SimplePerson implements Person, Person.Properties {

    private final SimpleStringProperty nameProperty;
    private final SimpleObjectProperty<Address> addressProperty;
    private final SimpleStringProperty phoneProperty;
    private final SimpleStringProperty emailProperty;

    SimplePerson(String name, Address address, String phone, String email) {
        this.nameProperty = new SimpleStringProperty(name);
        this.addressProperty = new SimpleObjectProperty<>(address);
        this.phoneProperty = new SimpleStringProperty(phone);
        this.emailProperty = new SimpleStringProperty(email);
    }

    @Override
    public SimpleStringProperty nameProperty() {
        return nameProperty;
    }

    @Override
    public SimpleObjectProperty<Address> addressProperty() {
        return addressProperty;
    }

    @Override
    public SimpleStringProperty phoneProperty() {
        return phoneProperty;
    }

    @Override
    public SimpleStringProperty emailProperty() {
        return emailProperty;
    }

    @Override
    public String getName() {
        return nameProperty.get();
    }

    @Override
    public void setName(String name) {
        nameProperty.set(name);
    }

    @Override
    public Address getAddress() {
        return addressProperty.get();
    }

    @Override
    public void setAddress(Address address) {
        addressProperty.set(address);
    }

    @Override
    public String getPhone() {
        return phoneProperty.get();
    }

    @Override
    public void setPhone(String number) {
        phoneProperty.set(number);
    }

    @Override
    public String getEmail() {
        return emailProperty.get();
    }

    @Override
    public void setEmail(String email) {
        emailProperty.set(email);
    }

    @Override
    public String toString() {
        return "Person's details go here";
    }

}
