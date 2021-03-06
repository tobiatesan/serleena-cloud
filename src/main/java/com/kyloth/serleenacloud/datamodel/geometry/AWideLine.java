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
 * Name: AWideLine.java
 * Package: com.kyloth.serleenacloud.datamodel.geometry
 * Author: Nicola Mometto
 *
 * History:
 * Version  Programmer      Changes
 * 1.0.0    Nicola Mometto  Creazione file, codice e javadoc iniziali
 */

package com.kyloth.serleenacloud.datamodel.geometry;

import java.util.Arrays;


/**
 * Rappresenta una generica entita` di mappa composta da una collezione ordinata
 * di Point
 * 
 * @field points : Iterable<Point> Insieme dei punti che definiscono le coordinate dell'entità
 * @author  Nicola Mometto <nicola.mometto@studenti.unipd.it>
 * @version 1.0
 */

public abstract class AWideLine {
    
    /**
     * Insieme dei punti che definiscono le coordinate dell'entità.
     */

    private Iterable<Point> points;

    /**
     * Crea un nuovo oggetto AWideLine
     *
     * @param points La collezione di oggetti Point associati
     */

    public AWideLine(Iterable<Point> points) {
        this.points = points;
    }
    /**
     * Crea un nuovo oggetto AWideLine
     *
     * @param points Array di oggetti Point associati
     */

    public AWideLine(Point[] points) {
        this.points = Arrays.asList(points);
    }

    /**
     * Ritorna la collezione di oggetti Point associata
     *
     * @return La collezione di oggetti Point
     */

    public Iterable<Point> getPoints() {
        return points;
    }

}
