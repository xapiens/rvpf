/** Related Values Processing Framework.
 *
 * Copyright (c) 2003-2019 Serge Brisson.
 *
 * This software is distributable under the LGPL license.
 * See details at the bottom of this file.
 *
 * $Id: CIPMessages.java 3961 2019-05-06 20:14:59Z SFB $
 */

package org.rvpf.pap.cip;

import org.rvpf.base.logger.Messages;

/**
 * CIP messages.
 */
public enum CIPMessages
    implements Messages.Entry
{
    CONNECT_FAILED,
    ELEMENT_COUNT_MISMATCH,
    READ_TAG_FAILED,
    SLOT,
    TCP_ADDRESS,
    TCP_PORT,
    TIMEOUT,
    TUPLE_ITEMS,
    TUPLE_REQUIRED,
    TUPLE_SIZE_MISMATCH,
    VALUES_MUST_BE_NUMBER,
    WRITE_TAG_FAILED;

    /** {@inheritDoc}
     */
    @Override
    public String getBundleName()
    {
        return _BUNDLE_NAME;
    }

    /** {@inheritDoc}
     */
    @Override
    public synchronized String toString()
    {
        if (_string == null) {
            _string = Messages.getString(this);
        }

        return _string;
    }

    private static final String _BUNDLE_NAME = "org.rvpf.messages.cip";

    private String _string;
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
