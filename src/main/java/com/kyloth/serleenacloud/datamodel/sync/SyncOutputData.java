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
 * Name: SyncOutputData.java
 * Package: com.kyloth.serleenacloud.datamodel.sync
 * Author: Nicola Mometto
 *
 * History:
 * Version  Programmer      Changes
 * 1.0.0    Nicola Mometto  Creazione file, codice e javadoc iniziali
 */

package com.kyloth.serleenacloud.datamodel.sync;

import com.kyloth.serleenacloud.datamodel.business.Experience;
import com.kyloth.serleenacloud.datamodel.business.WeatherForecast;
import com.kyloth.serleenacloud.datamodel.business.EmergencyContact;

import java.util.Arrays;

/**
 * Classe che modella i dati di sincronizzazione in output.
 *
 * @use Aggrega tutte le informazioni richiesta dall'applicativo Android durante la sincronizzazione, viene utilizzata da DataRestController
 * @field experiences : Iterable<Experience> Insieme delle esperienze da sincronizzare
 * @field forecastData : Iterable<WeatherForecast> Insieme dei dati meteo da sincronizzare
 * @field emergencyData : Iterable<EmergencyContact> Insieme dei dati relativi ai contatti di emergenza da sincronizzare
 * @author Nicola Mometto <nicola.mometto@studenti.unipd.it>
 * @version 1.0
 */

public class SyncOutputData {

    /**
     * Insieme delle esperienze da sincronizzare.
     */

    private Iterable<Experience> experiences;

    /**
     * Insieme dei dati meteo da sincronizzare.
     */

    private Iterable<WeatherForecast> forecastData;

    /**
     * Insieme dei contatti di emergenza da sincronizzare.
     */

    private Iterable<EmergencyContact> emergencyData;

    /**
     * Crea un nuovo oggetto SyncOutputData.
     *
     * @param experiences Insieme delle esperienze da sincronizzare.
     * @param forecastData Insieme dei dati meteo da sincronizzare.
     * @param emergencyData Insieme dei contatti di emergenza da sincronizzare.
     */

    public SyncOutputData(Iterable<Experience> experiences, Iterable<WeatherForecast> forecastData, Iterable<EmergencyContact> emergencyData) {
        this.experiences = experiences;
        this.forecastData = forecastData;
        this.emergencyData = emergencyData;
    }

    /**
     * Crea un nuovo oggetto SyncOutputData.
     *
     * @param experiences Array delle esperienze da sincronizzare.
     * @param forecastData Array dei dati meteo da sincronizzare.
     * @param emergencyData Array dei contatti di emergenza da sincronizzare.
     */

    public SyncOutputData(Experience[] experiences, WeatherForecast[] forecastData, EmergencyContact[] emergencyData) {
        this.experiences = Arrays.asList(experiences);
        this.forecastData = Arrays.asList(forecastData);
        this.emergencyData = Arrays.asList(emergencyData);
    }

    /**
     * Metodo getter per ottenere l'insieme delle rsperienze da sincronizzare.
     *
     * @return Restituisce l'insieme delle esperienze da sincronizzare.
     */

    public Iterable<Experience> getExperiences() {
        return experiences;
    }

    /**
     * Metodo getter per ottenere l'insieme dei dati meteo da sincronizzare.
     *
     * @return Restituisce l'insieme dei dati meteo da sincronizzare.
     */

    public Iterable<WeatherForecast> getWeatherData() {
        return forecastData;
    }

    /**
     * Metodo getter per ottenere l'insieme dei contatti di emergenza da sincronizzare.
     *
     * @return Restituisce l'insieme dei contatti di emergenza da sincronizzare.
     */

    public Iterable<EmergencyContact> getEmergencyData() {
        return emergencyData;
    }

}
