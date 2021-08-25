/** Related Values Processing Framework.
 *
 * Copyright (c) 2003-2019 Serge Brisson.
 *
 * This software is distributable under the LGPL license.
 * See details at the bottom of this file.
 *
 * $Id: G30V1.java 3976 2019-05-11 17:26:10Z SFB $
 */

package org.rvpf.pap.dnp3.object.groupCategory.analogInputs;

import java.nio.ByteBuffer;

import java.util.Optional;

import org.rvpf.pap.dnp3.object.ObjectInstance;
import org.rvpf.pap.dnp3.object.ObjectVariation;
import org.rvpf.pap.dnp3.object.content.ObjectFlags;

/**
 * Analog Input 32-bit with flag.
 */
public final class G30V1
    extends G30V3
    implements ObjectInstance.WithFlags
{
    /** {@inheritDoc}
     */
    @Override
    public void dumpToBuffer(final ByteBuffer buffer)
    {
        buffer.put(_flags.getFlags());

        super.dumpToBuffer(buffer);
    }

    /** {@inheritDoc}
     */
    @Override
    public ObjectFlags getFlags()
    {
        return _flags;
    }

    /** {@inheritDoc}
     */
    @Override
    public int getObjectLength()
    {
        return ObjectFlags.BYTES + super.getObjectLength();
    }

    /** {@inheritDoc}
     */
    @Override
    public ObjectVariation getObjectVariation()
    {
        return AnalogInputVariation.INTEGER_WITH_FLAG;
    }

    /** {@inheritDoc}
     */
    @Override
    public void loadFromBuffer(final ByteBuffer buffer)
    {
        _flags.setFlags(buffer.get());

        super.loadFromBuffer(buffer);
    }

    /** {@inheritDoc}
     */
    @Override
    public void setFlags(final Optional<ObjectFlags> objectFlags)
    {
        _flags.setFlags(objectFlags);
    }

    private final ObjectFlags _flags = new ObjectFlags();
}

/* This is free software; you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License
 * version 2.1 as published by the Free Software Foundation.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301, USA
 */
