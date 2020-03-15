package esaph.spotlight.Esaph.EsaphLifeCloudBackup;

import java.util.ArrayList;

import esaph.spotlight.navigation.globalActions.CMTypes;
import esaph.spotlight.navigation.kamera.PostEditingFragments.EsaphTagging.EsaphHashtag;

public class LifeCloudUploadFoto extends LifeCloudUpload
{
    public LifeCloudUploadFoto(ArrayList<EsaphHashtag> esaphHashtag, String beschreibung, String PID, long uhrzeit, short messageStatus, short LIFECLOUD_TYPE) {
        super(esaphHashtag, beschreibung, PID, uhrzeit, messageStatus, CMTypes.FPIC, LIFECLOUD_TYPE);
    }
}
