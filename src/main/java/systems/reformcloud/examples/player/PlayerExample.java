/*
  Copyright © 2019 Pasqual K. | All rights reserved
 */

package systems.reformcloud.examples.player;

import systems.reformcloud.ReformCloudController;
import systems.reformcloud.api.IDefaultPlayerProvider;
import systems.reformcloud.meta.info.ServerInfo;
import systems.reformcloud.player.implementations.OfflinePlayer;
import systems.reformcloud.player.implementations.OnlinePlayer;

import java.io.Serializable;

/**
 * @author _Klaro | Pasqual K. / created on 19.05.2019
 */

public final class PlayerExample implements Serializable {
    public PlayerExample() {
        //Gets the offline player out of the database
        OfflinePlayer offlinePlayer = ReformCloudController.getInstance().getOfflinePlayer("_Klaro");

        //If the player is null, the player doesn't exists
        if (offlinePlayer == null) {
            System.out.println("Fail");
            return;
        }

        //Adds a meta to the offline player
        offlinePlayer.getPlayerMeta().put("cool", true);
        offlinePlayer.getPlayerMeta().put("best", "shrug");
        //Updates the offline player
        ReformCloudController.getInstance().updateOfflinePlayer(offlinePlayer);

        //Prints out the spigot version of the player which was used
        System.out.println(offlinePlayer.getSpigotVersion().name());
        //Prints the meta value from above
        System.out.println(offlinePlayer.getPlayerMeta().get("cool"));

        //Get the online player
        OnlinePlayer onlinePlayer = ReformCloudController.getInstance().getOnlinePlayer("_Klaro");

        //The player is not online
        if (onlinePlayer == null) {
            System.out.println("FAIL");
            return;
        }

        //Prints the current server and proxy of the player to the console
        System.out.println(onlinePlayer.getCurrentProxy() + "/Server=" + onlinePlayer.getCurrentServer());

        //Get the player executor apu instance
        IDefaultPlayerProvider iDefaultPlayerProvider = IDefaultPlayerProvider.instance.get();

        //Get the server info of Lobby-01
        ServerInfo serverInfo = ReformCloudController.getInstance().getServerInfo("Lobby-01");

        //The server is not online
        if (serverInfo == null) {
            System.out.println("FAIL");
            return;
        }

        //Sends the player to the server
        iDefaultPlayerProvider.sendPlayer(onlinePlayer.getUniqueID(), serverInfo);

        //Sends the player to the server named Lobby-01
        iDefaultPlayerProvider.sendPlayer(onlinePlayer.getUniqueID(), "Lobby-01");

        //Sends the player a specific message
        iDefaultPlayerProvider.sendMessage(onlinePlayer.getUniqueID(), "_Klaro is cool");

        //Kicks the player from the network
        iDefaultPlayerProvider.kickPlayer(onlinePlayer.getUniqueID(), "Good bye");
    }
}
