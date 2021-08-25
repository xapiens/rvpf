/** Related Values Processing Framework.
 *
 * Copyright (c) 2003-2019 Serge Brisson.
 *
 * This software is distributable under the LGPL license.
 * See details at the bottom of this file.
 *
 * $Id: G42V6.java 3976 2019-05-11 17:26:10Z SFB $
 */

package org.rvpf.pap.dnp3.object.groupCategory.analogOutputs;

import java.io.Serializable;

import java.nio.ByteBuffer;

import java.util.Optional;

import org.rvpf.pap.dnp3.object.ObjectInstance;
import org.rvpf.pap.dnp3.object.ObjectVariation;
import org.rvpf.pap.dnp3.object.content.ObjectFlags;

/**
 * Analog Output Event Double-precision without time.
 */
public class G42V6
    extends ObjectInstance.Abstract
    implements ObjectInstance.WithValue, ObjectInstance.WithFlags
{
    /** {@inheritDoc}
     */
    @Override
    public void dumpToBuffer(final ByteBuffer buffer)
    {
        buffer.put(_flags.getFlags());
        buffer.putDouble(_value);
    }

    /** {@inheritDoc}
     */
    @Override
    public final ObjectFlags getFlags()
    {
        return _flags;
    }

    /** {@inheritDoc}
     */
    @Override
    public int getObjectLength()
    {
        return ObjectFlags.BYTES + Double.BYTES;
    }

    /** {@inheritDoc}
     */
    @Override
    public ObjectVariation getObjectVariation()
    {
        return AnalogOutputEventVariation.DOUBLE_WITHOUT_TIME;
    }

    /** {@inheritDoc}
     */
    @Override
    public final Serializable getValue()
    {
        return Double.valueOf(_value);
    }

    /** {@inheritDoc}
     */
    @Override
    public void loadFromBuffer(final ByteBuffer buffer)
    {
        _flags.setFlags(buffer.get());
        _value = buffer.getDouble();
    }

    /** {@inheritDoc}
     */
    @Override
    public void setFlags(final Optional<ObjectFlags> objectFlags)
    {
        _flags.setFlags(objectFlags);
    }

    /** {@inheritDoc}
     */
    @Override
    public final void setValue(final Serializable value)
    {
        _value = WithValue.doubleValue(value);
    }

    private final ObjectFlags _flags = new ObjectFlags();
    private double _value;
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
