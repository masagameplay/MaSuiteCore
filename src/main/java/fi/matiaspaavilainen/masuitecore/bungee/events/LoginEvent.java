package fi.matiaspaavilainen.masuitecore.bungee.events;

import fi.matiaspaavilainen.masuitecore.core.managers.MaSuitePlayer;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class LoginEvent implements Listener {

    public LoginEvent() { }

    @EventHandler
    public void onLogin(PostLoginEvent e) {
        MaSuitePlayer msp = new MaSuitePlayer();
        if (msp.find(e.getPlayer().getUniqueId()).getUniqueId() != null) {
            msp = msp.find(e.getPlayer().getUniqueId());
            if (msp.getNickname() != null) {
                e.getPlayer().setDisplayName(msp.getNickname());
            }
        }
        msp.setUsername(e.getPlayer().getName());
        msp.setUniqueId(e.getPlayer().getUniqueId());
        msp.setLastLogin(System.currentTimeMillis() / 1000);
        msp.setFirstLogin(System.currentTimeMillis() / 1000);
        msp.create();
    }
}