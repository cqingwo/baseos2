package com.cqwo.base.data;

import com.cqwo.base.core.cache.CWMCache;
import com.cqwo.base.core.config.CWMConfig;
import com.cqwo.base.core.data.CWMData;
import com.cqwo.base.core.sms.CWMSMS;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@Setter
public class DataService {

    @Autowired
    private CWMCache cwmCache;

    @Autowired
    private CWMData cwmData;

    @Autowired
    private CWMSMS cwmSMS;

    @Autowired
    private CWMConfig cwmConfig;


}
