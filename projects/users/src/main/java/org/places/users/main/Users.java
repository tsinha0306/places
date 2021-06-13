package org.places.users.main;

import org.places.users.config.Settings;

public class Users {
    private final Settings settings;

    public Users(Settings settings) {
        this.settings = settings;
    }

    public Settings getSettings() {
        return settings;
    }
}