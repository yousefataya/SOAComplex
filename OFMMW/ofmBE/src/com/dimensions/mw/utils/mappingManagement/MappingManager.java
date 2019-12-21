package com.dimensions.mw.utils.mappingManagement;

import com.dimensions.mw.utils.OFMException;
import com.dimensions.mw.utils.mappingManagement.inMemoryData.MappingSingleton;

public class MappingManager {
    public void destroyInstance() {
        try {
            MappingSingleton instance = MappingSingleton.getInstance();
            if (instance != null) {
                instance.destroyInstance();
            }
        }
        catch (Exception instance) {
            // empty catch block
        }
    }

    public String getMappingValue(String mappingKey) throws Exception {
        String val = null;
        if (mappingKey != null && MappingSingleton.getInstance().getMappingDataMap() != null && MappingSingleton.getInstance().getMappingDataMap().get(mappingKey) != null) {
            val = MappingSingleton.getInstance().getMappingDataMap().get(mappingKey).getMappingValue();
        }
        return val;
    }

    public String getMandatoryMappingValue(String mappingKey) throws Exception {
        String val = null;
        if (mappingKey != null && MappingSingleton.getInstance().getMappingDataMap() != null && MappingSingleton.getInstance().getMappingDataMap().get(mappingKey) != null) {
            val = MappingSingleton.getInstance().getMappingDataMap().get(mappingKey).getMappingValue();
        }
        if (val == null || val == "") {
            throw new OFMException("OFM Application : Unable to Find Mapping [  [" + mappingKey + "] , Mapping Entry not Found", null);
        }
        return val;
    }
}

