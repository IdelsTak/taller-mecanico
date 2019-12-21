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
public class PersonFactory {

    public static Person from(Person other) {
        return new SimplePerson(
                other.getName(),
                other.getAddress(),
                other.getPhone(),
                other.getEmail());
    }

    public static Person of(
            String name,
            Address address,
            String phone,
            String email) {

        Person person = new Person.Customer() {
            @Override
            public String getName() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void setName(String name) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public Address getAddress() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void setAddress(Address address) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public String getPhone() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void setPhone(String number) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public String getEmail() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void setEmail(String email) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public SimpleStringProperty nameProperty() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public SimpleObjectProperty<Address> addressProperty() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public SimpleStringProperty phoneProperty() {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public SimpleStringProperty emailProperty() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        
        return new SimplePerson(name, address, phone, email);
    }

//    public static Customer of(
//            String name,
//            Address address,
//            String phone,
//            String email){
//        return of(name, address, phone, email);        
//    }
}
