/******************************************************************************
* Copyright (c) 2015 Nicola Mometto
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*  Nicola Mometto
*  Antonio Cavestro
*  Sebastiano Valle
*  Gabriele Pozzan
******************************************************************************/


/**
 * Name: UserDao.java
 * Package: com.kyloth.serleenacloud.persistence.jdbc
 * Author: Nicola Mometto
 *
 * History:
 * Version  Programmer      Changes
 * 1.0.0    Nicola Mometto  Creazione file, codice e javadoc iniziali
 */

package com.kyloth.serleenacloud.persistence.jdbc;

import com.kyloth.serleenacloud.persistence.ITempTokenDao;
import com.kyloth.serleenacloud.persistence.IUserDao;
import com.kyloth.serleenacloud.datamodel.auth.TempToken;
import com.kyloth.serleenacloud.datamodel.auth.User;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe che concretizza ITempTokenDao per database MySQL utilizzando JDBC.
 *
 * @field tpl : JdbcTemplate Template JDBC per la connessione alla base di dati
 * @author Nicola Mometto <nicola.mometto@studenti.unipd.it>
 * @version 1.0
 */

public class TempTokenDao implements ITempTokenDao {


    /**
     * Template JDBC per la connessione alla base di dati.
     */

    private JdbcTemplate tpl;


    /**
     * DAO per oggetti di tipo User.
     */

    private IUserDao ud;

    /**
     * Costruisce un nuovo TempTokenDao.
     *
     * @param ds DataSource per la connessione al database.
     */

    TempTokenDao(JDBCDataSource ds) {
        this.tpl = ds.getTpl();
        this.ud = ds.userDao();
    }

    void removeOld() {
        tpl.update("DELETE From TempTokens WHERE Date <= (?)", new Object[] {new Date()});
        return;
    }

    public void persist(TempToken t) {
        removeOld();

        User u = ud.findDeviceId(t.getDeviceId());
        if (u != null) {
            tpl.update("UPDATE Users SET DeviceId = NULL WHERE Email = ?", new Object[] {u.getEmail()});
        }

        tpl.update("DELETE From TempTokens WHERE DeviceId = ?",
                   new Object[] {t.getDeviceId()});
        tpl.update("INSERT INTO TempTokens(Date, DeviceId, Token) VALUES (?, ?, ?)",
                   new Object[] {t.getDate(), t.getDeviceId(), t.getToken()});
        return;
    }

    public String deviceId(final String token) {
        removeOld();
        return tpl.queryForObject("SELECT DeviceId " +
                                  "FROM TempTokens " +
                                  "WHERE Token = ?",
                                  new Object[] { token },
                                  String.class);
    }
}
