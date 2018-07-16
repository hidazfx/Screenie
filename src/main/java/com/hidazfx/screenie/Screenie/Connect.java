package com.hidazfx.screenie.Screenie;

import java.io.File;
import java.io.IOException;

import com.google.common.util.concurrent.FutureCallback;
import com.hidazfx.screenie.Screenie.configuration.LoadConfig;
import com.hidazfx.screenie.record.RecentClippy;

import de.btobastian.javacord.DiscordAPI;
import de.btobastian.javacord.Javacord;
import de.btobastian.javacord.entities.Channel;
import de.btobastian.javacord.entities.Server;
import de.btobastian.javacord.entities.message.Message;
import de.btobastian.javacord.listener.message.MessageCreateListener;

public class Connect {
	public static DiscordAPI api;
	public static String SERVER_NAME;
	public static String CHANNEL_NAME;
	public static boolean serverLoaded = false;
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
            	try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	channel.sendMessage(string);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
	}
	
        public static void sendClippy(String email, String password) {
            DiscordAPI api = Javacord.getApi(LoadConfig.email(), LoadConfig.password());
            // connect
            api.connect(new FutureCallback<DiscordAPI>() {
                @Override
                public void onSuccess(DiscordAPI api) {
                    // register listener
                	Server server = api.getServerById(LoadConfig.serverid());
                	Channel channel = api.getChannelById(LoadConfig.channelid());
                	channel.sendFile(RecentClippy.lastFileModified("clippy/"));
                	SERVER_NAME = server.getName();
                	CHANNEL_NAME = channel.getName();
                	serverLoaded = true;
                }

                @Override
                public void onFailure(Throwable t) {
                    t.printStackTrace();
                }
            });
        }
        
        public static void downloadData(String email, String password) {
            DiscordAPI api = Javacord.getApi(LoadConfig.email(), LoadConfig.password());
            // connect
            api.connect(new FutureCallback<DiscordAPI>() {
                @Override
                public void onSuccess(DiscordAPI api) {
                    // register listener
                	Server server = api.getServerById(LoadConfig.serverid());
                	Channel channel = api.getChannelById(LoadConfig.channelid());
                	SERVER_NAME = server.getName();
                	CHANNEL_NAME = channel.getName();
                	serverLoaded = true;
                	
                }

                @Override
                public void onFailure(Throwable t) {
                    t.printStackTrace();
                }
            });
        }
        


}
