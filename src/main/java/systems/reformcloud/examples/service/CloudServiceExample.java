/*
  Copyright © 2019 Pasqual K. | All rights reserved
 */

package systems.reformcloud.examples.service;

import systems.reformcloud.api.CloudService;

import java.io.Serializable;
import java.util.Locale;
import java.util.UUID;

/**
 * @author _Klaro | Pasqual K. / created on 19.05.2019
 */

public final class CloudServiceExample implements Serializable {
    public CloudServiceExample() {
        //Get the internal cloud service
        CloudService cloudService = CloudService.instance.get();

        //Patches a task async
        cloudService.patchAsync(
                () -> String.format(Locale.ROOT, "F-%d", 1),
                (v, t) -> t.printStackTrace()
        );

        //Get an online player which is cached
        cloudService.getCachedPlayer("_Klaro");

        //Works fine with uuid too
        cloudService.getCachedPlayer(UUID.randomUUID());
    }
}
