/*
  Copyright © 2019 Pasqual K. | All rights reserved
 */

package systems.reformcloud.examples.addons;

import systems.reformcloud.ReformCloudController;
import systems.reformcloud.addons.dependency.DependencyLoader;
import systems.reformcloud.addons.dependency.util.DynamicDependency;
import systems.reformcloud.utility.ControllerAddonImpl;

import java.io.Serializable;

/**
 * @author _Klaro | Pasqual K. / created on 19.05.2019
 */

public final class AddonsExample extends ControllerAddonImpl implements Serializable {
    /**
     * The method will be called while the controller or client is loading the addon.
     * This will be after loading the cloud configuration so all properties of the cloud system are ready to use.
     * You can properly load an dependency for the environment
     */
    @Override
    public void onAddonClazzPrepare() {
        DynamicDependency dynamicDependency = new DynamicDependency(
                null /*If this is null the cloud will try to download the dependency from the maven global repo */
        ) {
            @Override
            public String getGroupID() {
                //The group id of the addon
                return "com.google.code.gson";
            }

            @Override
            public String getName() {
                //The name of the dependency
                return "gson";
            }

            @Override
            public String getVersion() {
                //The version of the dependency
                return "2.8.5";
            }
        };
        //Loads the dependency dynamically
        DependencyLoader.loadDependency(dynamicDependency);
    }

    /**
     * This method get called when the cloud enables the addons.
     * The network is now initialized so all packets can be handled and sent
     */
    @Override
    public void onAddonLoading() {
        //Prints a line to the console
        ReformCloudController.getInstance().getLoggerProvider().info().accept("Hello world");
    }

    @Override
    public void onAddonReadyToClose() {
        //Prints an error to the console
        ReformCloudController.getInstance().getLoggerProvider().serve().accept("Goodbye world :(");
    }
}
