/** Related Values Processing Framework.
 *
 * Copyright (c) 2003-2019 Serge Brisson.
 *
 * This software is distributable under the LGPL license.
 * See details at the bottom of this file.
 *
 * $Id: HSQLDialect.java 4115 2019-08-04 14:17:56Z SFB $
 */

package org.rvpf.store.server.the.sql.dialect;

import java.io.File;

import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.rvpf.base.ClassDefImpl;
import org.rvpf.service.ServiceMessages;

/**
 * HSQL database dialect support.
 */
public final class HSQLDialect
    extends DialectSupport.Abstract
{
    /**
     * Constructs an instance.
     */
    public HSQLDialect()
    {
        super(DIALECT_NAME);
    }

    /** {@inheritDoc}
     */
    @Override
    public List<String> getCreateTableSQL()
    {
        final List<String> sql = new ArrayList<>();
        final StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("CREATE CACHED TABLE ");
        stringBuilder.append(getCatalogSchemaTable());
        stringBuilder.append(" (");
        stringBuilder.append(getPointColumn());
        stringBuilder.append(" BINARY(16) NOT NULL, ");
        stringBuilder.append(getStampColumn());
        stringBuilder.append(" BIGINT NOT NULL, ");
        stringBuilder.append(getVersionColumn());
        stringBuilder.append(" BIGINT NOT NULL, ");
        stringBuilder.append(getStateColumn());
        stringBuilder.append(" LONGVARBINARY, ");
        stringBuilder.append(getValueColumn());
        stringBuilder.append(" LONGVARBINARY,");
        stringBuilder.append(" PRIMARY KEY (");
        stringBuilder.append(getPointColumn());

        if (!isSnapshot()) {
            stringBuilder.append(",");
            stringBuilder.append(getStampColumn());
        }

        stringBuilder.append("))");
        sql.add(stringBuilder.toString());

        stringBuilder
            .append(
                "CREATE CACHED TABLE " + getCatalogSchemaTable() + " ("
                + getPointColumn() + " BINARY(16) NOT NULL, "
                + getStampColumn() + " BIGINT NOT NULL, " + getVersionColumn()
                + " BIGINT NOT NULL, " + getStateColumn() + " LONGVARBINARY, "
                + getValueColumn() + " LONGVARBINARY, PRIMARY KEY ("
                + getPointColumn());

        if (!isSnapshot()) {
            stringBuilder.append("," + getStampColumn());
        }

        stringBuilder.append("))");

        if (!isPullDisabled()) {
            stringBuilder.setLength(0);
            stringBuilder.append("CREATE UNIQUE INDEX ");
            stringBuilder.append(getCatalogSchemaTable());
            stringBuilder.append("_");
            stringBuilder.append(getVersionColumn());
            stringBuilder.append("_IX1 ON ");
            stringBuilder.append(getCatalogSchemaTable());
            stringBuilder.append(" (");
            stringBuilder.append(getVersionColumn());
            stringBuilder.append(")");
            sql.add(stringBuilder.toString());
        }

        if (!isSnapshot()) {
            stringBuilder.setLength(0);
            stringBuilder.append("CREATE INDEX ");
            stringBuilder.append(getCatalogSchemaTable());
            stringBuilder.append("_");
            stringBuilder.append(getPointColumn());
            stringBuilder.append("_IX1 ON ");
            stringBuilder.append(getCatalogSchemaTable());
            stringBuilder.append(" (");
            stringBuilder.append(getPointColumn());
            stringBuilder.append(",");
            stringBuilder.append(getStampColumn());
            stringBuilder.append(" DESC)");
            sql.add(stringBuilder.toString());
        }

        return sql;
    }

    /** {@inheritDoc}
     */
    @Override
    public Optional<String> getDefaultConnectionPassword()
    {
        return Optional.of(DEFAULT_CONNECTION_PASSWORD);
    }

    /** {@inheritDoc}
     */
    @Override
    public boolean getDefaultConnectionShared()
    {
        return true;
    }

    /** {@inheritDoc}
     */
    @Override
    public String getDefaultConnectionURL(
            final File storeDataDir,
            final String storeEntityName)
    {
        final String pathString = storeDataDir.getPath() + "/" + HSQL_DIR + "/";
        Path path;

        try {
            path = Paths.get(pathString + storeEntityName);
        } catch (final InvalidPathException exception) {
            getThisLogger()
                .warn(
                    ServiceMessages.INVALID_PATH,
                    pathString + storeEntityName);
            path = Paths.get(pathString + DEFAULT_DATABASE_NAME);
        }

        return DEFAULT_CONNECTION_URL + path.toString().replace('\\', '/');
    }

    /** {@inheritDoc}
     */
    @Override
    public String getDefaultConnectionUser()
    {
        return DEFAULT_CONNECTION_USER;
    }

    /** {@inheritDoc}
     */
    @Override
    public String getDefaultSchemaName()
    {
        return _DEFAULT_SCHEMA_NAME;
    }

    /** {@inheritDoc}
     */
    @Override
    protected Optional<ClassDefImpl> getDefaultDriverClassDef()
    {
        return Optional.of(DEFAULT_DRIVER_CLASS_DEF);
    }

    /** Default connection password. */
    public static final String DEFAULT_CONNECTION_PASSWORD = "";

    /** Default connection URL. */
    public static final String DEFAULT_CONNECTION_URL = "jdbc:hsqldb:file:";

    /** Default connection user. */
    public static final String DEFAULT_CONNECTION_USER = "sa";

    /** Default database name. */
    public static final String DEFAULT_DATABASE_NAME = "Default";

    /** Default driver class definition. */
    public static final ClassDefImpl DEFAULT_DRIVER_CLASS_DEF =
        new ClassDefImpl(
            "org.hsqldb.jdbcDriver");

    /** Dialect name. */
    public static final String DIALECT_NAME = "HSQL";

    /** HSQL base directory name. */
    public static final String HSQL_DIR = "hsql";

    /**  */

    private static final String _DEFAULT_SCHEMA_NAME = "PUBLIC";
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
