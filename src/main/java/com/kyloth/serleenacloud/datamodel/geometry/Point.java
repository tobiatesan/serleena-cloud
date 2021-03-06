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
 * Name: Point.java
 * Package: com.kyloth.serleenacloud.datamodel.geometry
 * Author: Nicola Mometto
 *
 * History:
 * Version  Programmer      Changes
 * 1.0.0    Nicola Mometto  Creazione file, codice e javadoc iniziali
 */

package com.kyloth.serleenacloud.datamodel.geometry;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Rappresenta un generico punto geografico
 *
 * @field latitude : double Valore della latitudine del punto geografico
 * @field longitude : double Valore della longitudine del punto geografico
 * @author  Nicola Mometto <nicola.mometto@studenti.unipd.it>
 * @version 1.0
 */

public class Point {
    
    /**
     * Latitudine relativa al punto geografico.
     */

    private double latitude;
    
    /**
     * Longitudine relativa al punto geografico.
     */

    private double longitude;


    /**
     * Crea un nuovo generico punto geografico, data latitudine e longitudine
     *
     * @param  latitude Coordinata latitudinale del punto da creare
     * @param  longitude Coordinata longitudinale del punto da creare
     */

    @JsonCreator
    public Point(@JsonProperty("latitude") double latitude,
                 @JsonProperty("longitude") double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    /**
     * Restituisce la latitudine del punto geografico
     *
     * @return Coordinata latitudinale
     */

    public double getLatitude() {
        return latitude;
    }

    /**
     * Restituisce la longitudine del punto geografico
     *
     * @return Coordinata longitudinale
     */

    public double getLongitude() {
        return longitude;
    }
}
