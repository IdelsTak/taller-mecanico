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
package com.github.idelstak.mecanico.domain;

import com.github.idelstak.mecanico.domain.spi.Address;
import com.github.idelstak.mecanico.domain.spi.Person;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
public class Customer implements Person {

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
    public String toString() {
        return "Customer details go here";
    }

}
