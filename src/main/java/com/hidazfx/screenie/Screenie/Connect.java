package com.hidazfx.screenie.Screenie;

import java.io.File;

import com.google.common.util.concurrent.FutureCallback;
import com.hidazfx.screenie.Screenie.configuration.LoadConfig;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;
import de.btobastian.javacord.entities.Channel;
import de.btobastian.javacord.entities.Server;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

public class Connect {
	public static DiscordAPI api;
	
	public static void send(String email, String password) {
        DiscordAPI api = Javacord.getApi(LoadConfig.email(), LoadConfig.password());
        // connect
        api.connect(new FutureCallback<DiscordAPI>() {
            @Override
            public void onSuccess(DiscordAPI api) {
                // register listener
            	Server server = api.getServerById(LoadConfig.serverid());
            	Channel channel = api.getChannelById(LoadConfig.channelid());
            	channel.sendFile(new File("screenie." + Main.fileformat));
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }
	
	public static void sendDescription(String email, String password, String string) {
        DiscordAPI api = Javacord.getApi(LoadConfig.email(), LoadConfig.password());
        // connect
        api.connect(new FutureCallback<DiscordAPI>() {
            @Override
            public void onSuccess(DiscordAPI api) {
                // register listener
            	Server server = api.getServerById(LoadConfig.serverid());
            	Channel channel = api.getChannelById(LoadConfig.channelid());
            	channel.sendFile(new File("screenie." + Main.fileformat));
            	channel.sendMessage(string);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }


}
