/*
 *  Copyright (C) Esaph, Julian Auguscik - All Rights Reserved
 *  * Unauthorized copying of this file, via any medium is strictly prohibited
 *  * Proprietary and confidential
 *  * Written by Julian Auguscik <esaph.re@gmail.com>, March  2020
 *
 */

package esaph.spotlight;

import androidx.annotation.Nullable;

import java.io.Serializable;

import esaph.elib.esaphcommunicationservices.PipeData;

public class SpotLightUser extends PipeData<SpotLightUser> implements Serializable
{
    private long UID;
    private String Benutzername;
    private String Vorname;
    private long Alter;
    private String Region;
    private int type;
    private boolean WF;
    private short WatchingStatus;
    private String descriptionPlopp;

    public SpotLightUser(long UID, String Benutzername, String Vorname, long Alter, String Region, boolean WF, String descriptionPlopp) //Für benutzer
    {
        this.descriptionPlopp = descriptionPlopp;
        this.UID = UID;
        this.Benutzername = Benutzername;
        this.Vorname = Vorname;
        this.Alter = Alter;
        this.Region = Region;
        this.type = 1;
        this.WF = WF;
    }

    public SpotLightUser(long UID, String Benutzername, String Vorname, long Alter, String Region, boolean WF, short WatchingStatus, String descriptionPlopp) //Für benutzer
    {
        this.descriptionPlopp = descriptionPlopp;
        this.UID = UID;
        this.Benutzername = Benutzername;
        this.WatchingStatus = WatchingStatus;
        this.Vorname = Vorname;
        this.Alter = Alter;
        this.Region = Region;
        this.type = 1;
        this.WF = WF;
    }

    @Override
    public boolean equals(@Nullable Object obj)
    {
        if(obj instanceof SpotLightUser)
        {
            SpotLightUser spotLightUser = (SpotLightUser) obj;
            if(spotLightUser.getUID() == this.getUID())
            {
                return true;
            }
        }
        return super.equals(obj);
    }

    public String getDescriptionPlopp()
    {
        return descriptionPlopp;
    }

    public long getUID() {
        return UID;
    }

    public short getWatchingStatus()
    {
        return this.WatchingStatus;
    }

    public boolean wasFriends()
    {
        return this.WF;
    }

    public int getType()
    {
        return type;
    }

    public String getRegion()
    {
        return this.Region;
    }

    public String getVorname() {
        return this.Vorname;
    }

    public String getBenutzername() {
        return this.Benutzername;
    }

    public long getAlter()
    {
        return this.Alter;
    }
}
