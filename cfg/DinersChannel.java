/*
 * jPOS Project [http://jpos.org]
 * Copyright (C) 2000-2008 Alejandro P. Revilla
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.jpos.iso.channel;

import org.jpos.iso.ISOMsg;

import java.io.IOException;

public class DinersChannel extends ASCIIChannel {
    @Override
    public void sendMessageTrailler(ISOMsg m, byte[] b) throws IOException {
        serverOut.write(3);
    }

    @Override
    public void getMessageTrailler() throws IOException {
        byte[] b = new byte[1];
        serverIn.readFully(b,0,1);
    }
}

