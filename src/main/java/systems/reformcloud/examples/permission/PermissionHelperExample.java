/*
  Copyright © 2019 Pasqual K. | All rights reserved
 */

package systems.reformcloud.examples.permission;

import java.io.Serializable;
import systems.reformcloud.ReformCloudController;
import systems.reformcloud.api.permissions.PermissionHelper;
import systems.reformcloud.player.permissions.player.PermissionHolder;

/**
 * @author _Klaro | Pasqual K. / created on 28.06.2019
 */

public final class PermissionHelperExample implements Serializable {

  public PermissionHelperExample() {
    PermissionHelper permissionHelper =
        ReformCloudController.getInstance().getPermissionHelper().orElse(null);
    if (permissionHelper == null) {
      //Permissions are not enabled
      return;
    }

    PermissionHolder permissionHolder = permissionHelper.getPermissionHolder("_Klaro"); //Execute
    // async, needs a while to get all needed information
    if (permissionHolder == null) {
      //The permission holder could not be found
      return;
    }

    System.out.println(permissionHolder.getUniqueID()); //Prints the uuid of the permission holder
    System.out.println(permissionHelper.getGroupPrefix("admin")); //Prints the prefix of the
    // admin permission group

    System.out.println(permissionHelper.getPlayerGroupPermissions("_Klaro")); //Prints the
    // permissions of the user
  }

}
