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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Hiram K. <hiram.kamau@outlook.com>
 */
public class AddressTest {
    
//    public AddressTest() {
//    }
//
//    @Test
//    public void testFrom() {
//    }
//
//    @Test
//    public void testDetailsProperty() {
//    }
//
//    @Test
//    public void testGetDetails() {
//    }
//
//    @Test
//    public void testSetDetails() {
//    }
//
//    @Test
//    public void testHashCode() {
//    }
//
//    @Test
//    public void testEquals() {
//    }

    @Test
    public void testToString() {
        var unexpectedAddress = Address.EMPTY;
        var actualAddress = Address.from("P.O. Box 19000");
        
        Assertions.assertNotEquals(unexpectedAddress, actualAddress);
    }
    
}
