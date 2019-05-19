/*
  Copyright © 2019 Pasqual K. | All rights reserved
 */

package systems.reformcloud.examples.service;

import systems.reformcloud.api.ICloudService;

import javax.swing.*;
import java.io.Serializable;
import java.util.Locale;
import java.util.UUID;

/**
 * @author _Klaro | Pasqual K. / created on 19.05.2019
 */

public final class CloudServiceExample implements Serializable {
    public CloudServiceExample() {
        //Get the internal cloud service
        ICloudService iCloudService = ICloudService.instance.get();

        //Patches a task async
        iCloudService.patchAsync(
                () -> String.format(Locale.ROOT, "F-%d", 1),
                (v, t) -> t.printStackTrace()
        );

        //Get an online player which is cached
        iCloudService.getCachedPlayer("_Klaro");

        //Works fine with uuid too
        iCloudService.getCachedPlayer(UUID.randomUUID());
    }
}
