# Screenie
Upload your best noob stomping moments to Discord with ease.

# How do I use Screenie?
To use Screenie, the setup is a bit confusing and un-intuitive. Sadly, it has to be this way to maintain the "speedy" model that this program is designed around.A user needs to set your Server and Channel through the config file, so grab the ServerID and ChannelID and put them into their respective lines in "config.properties". After this, go ahead and double click the screenie Jar file.

# Screenie has no UI, so how do I interact with it?
Through keybinds! Screenie is created with fast, responsive content uploads to your Discord server to be mainly used in the middle of an intense match of your favorite video game.

* F10 - Tells Screenie to shutdown and disconnect from Discord correctly.
* F11 - Sends a "quickie", also known as a quick screenshot. Pressing F11 sends no other details other than a screenshot.
* F12 - Opens the "more-time" menu, for when you just stomped on a no-skin in Fortnite and want to share the moment with a description or record the next 20 seconds and send it to Discord.

# Detailed Configuration Overview
As stated previously, the ```config.properties``` file can be a bit confusing at first, so lets go over it in detail here.
```
email=
password=
```
This is pretty simple, its your Discord E-Mail and password.
```
serverid=
channelid=
```
A little bit more complicated, this is the Server and Channel ID's. Gather these using Discord Developer mode.
```
fileformat=jpeg
```
Pretty self explanatory, if your upload speed is slow, use jpeg. If you want higher quality, use png.
```
clippyduration=20
```
This is the duration of your clips FFmpeg will record (in seconds). 15-20 seconds is recommended because of Discord's 8 megabyte upload limit. If you have Discord Nitro, feel free to change this up to as large as you'd like.
