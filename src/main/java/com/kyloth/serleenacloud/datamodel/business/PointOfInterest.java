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
 * Name: PointOfInterest.java
 * Package: com.kyloth.serleenacloud.datamodel.business
 * Author: Nicola Mometto
 *
 * History:
 * Version  Programmer      Changes
 * 1.0.0    Nicola Mometto  Creazione file, codice e javadoc iniziali
 */

package com.kyloth.serleenacloud.datamodel.business;

import com.kyloth.serleenacloud.datamodel.geometry.Point;

/**
 * Classe che rappresenta un Punto di Interesse nella mappa.
 *
 * @use Viene utilizzata da Render.Renderer durante la creazione dei quadranti raster. E' disponibile un metodo che ritorna un valore di un enum che identifica il tipo di punto di interesse
 *
 * @author Nicola Mometto <nicola.mometto@studenti.unipd.it>
 * @version 1.0
 */

public class PointOfInterest extends Point {

    /**
     * Enumerazione per le diverse possibili categorie di Punti di Interesse.
     */

    public static enum POIType {
        FOOD, INFO, WARNING
    }

    /**
     * Nome del Punto di Interesse.
     */

    String name;

    /**
     * Categoria del Punto di Interesse.
     */

    POIType type;

    /**
     * Crea un nuovo Punto di Interesse inizializzandone i campi dati.
     *
     * @param latitude La latitudine del Punto di Interesse.
     * @param longitude La longitudine del Punto di Interesse.
     * @param name Il nome del Punto di Interesse.
     * @param type La categoria del Punto di Interesse.
     */

    public PointOfInterest(double latitude, double longitude, String name, POIType type) {
        super(latitude, longitude);
        this.name = name;
        this.type = type;
    }

    /**
     * Metodo "getter" per ottenere il nome del Punto di Interesse.
     *
     * @return Restituisce il nome del Punto di Interesse.
     */

    public String getName() {
        return name;
    }

    /**
     * Metodo "gettere" per ottenere la categoria del Punto di Interesse.
     *
     * @return Restituisce la categoria del Punto di Interesse.
     */

    public POIType getPOIType() {
        return type;
    }
}