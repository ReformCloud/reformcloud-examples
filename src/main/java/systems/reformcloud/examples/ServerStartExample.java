/*
  Copyright © 2019 Pasqual K. | All rights reserved
 */

package systems.reformcloud.examples;

import systems.reformcloud.ReformCloudController;
import systems.reformcloud.configurations.Configuration;
import systems.reformcloud.meta.dev.DevProcess;
import systems.reformcloud.meta.server.ServerGroup;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author _Klaro | Pasqual K. / created on 19.05.2019
 */

public final class ServerStartExample implements Serializable {
    public void startServerOfServerGroup() {
        //Gets the server group Lobby
        ServerGroup serverGroup = ReformCloudController.getInstance().getServerGroup("Lobby");

        //The server group doesn't exists
        if (serverGroup == null) {
            System.out.println("FAIL");
            return;
        }

        //Starts a server of the group Lobby if enough resources are available else the server wont start anytime
        ReformCloudController.getInstance().startGameServer(serverGroup);

        //Starts a game server of the server group which is queued, means the process start when enough resources are available
        //The method returns a dev process, containing some information about the process
        DevProcess devProcess = ReformCloudController.getInstance().startQueuedProcess(serverGroup);
    }

    public void startGameServerWithTemplate() {
        //Gets the server group Lobby
        ServerGroup serverGroup = ReformCloudController.getInstance().getServerGroup("Lobby");

        //The server group doesn't exists
        if (serverGroup == null) {
            System.out.println("FAIL");
            return;
        }

        //Starts a game server of the group Lobby with the template BedWars
        ReformCloudController.getInstance().startGameServer(serverGroup, new Configuration(), "BedWars");
    }

    public void startGameServerWithOptions() {
        //Gets the server group Lobby
        ServerGroup serverGroup = ReformCloudController.getInstance().getServerGroup("Lobby");

        //The server group doesn't exists
        if (serverGroup == null) {
            System.out.println("FAIL");
            return;
        }

        //Starts a game server of the group Lobby with the config value 'owner'
        ReformCloudController.getInstance().startGameServer(serverGroup,
                new Configuration()
                        .addValue("owner", UUID.randomUUID())
        );
    }

    public void startGameServerWithOptionsAndTemplate() {
        //Gets the server group Lobby
        ServerGroup serverGroup = ReformCloudController.getInstance().getServerGroup("Lobby");

        //The server group doesn't exists
        if (serverGroup == null) {
            System.out.println("FAIL");
            return;
        }

        //Starts a game server of the group Lobby with the template BedWars and the config value 'owner'
        ReformCloudController.getInstance().startGameServer(serverGroup, new Configuration()
                .addValue("owner", UUID.randomUUID()), "BedWars");
    }
}
