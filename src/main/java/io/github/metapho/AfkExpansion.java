package io.github.metapho;

import me.clip.placeholderapi.expansion.Configurable;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class AfkExpansion extends PlaceholderExpansion implements Configurable {

    private int afkMinutes;
    private String yes;
    private String no;
    private Duration afkThreshold;

    @Override
    public @NotNull String getIdentifier() {
        return "afk";
    }

    @Override
    public @NotNull String getAuthor() {
        return "metapho";
    }

    @Override
    public @NotNull String getVersion() {
        return "1.0.0";
    }

    @Override
    public Map<String, Object> getDefaults() {
        Map<String, Object> defaults = new HashMap<>();
        defaults.put("afk-minutes", 5);
        defaults.put("afk-yes", "<green>yes</green>");
        defaults.put("afk-no", "<red>no</red>");
        return defaults;
    }

    @Override
    public String onPlaceholderRequest(Player player, @NotNull String params) {
        if (player == null) return "";

        if (afkThreshold == null) {
            this.afkMinutes = getInt("afk-minutes", 5);
            this.yes = getString("afk-yes", "<green>yes</green>");
            this.no  = getString("afk-no", "<red>no</red>");
            this.afkThreshold = Duration.ofMinutes(afkMinutes);
        }

        if (params.equalsIgnoreCase("is")) {
            return player.getIdleDuration().compareTo(afkThreshold) > 0 ? yes : no;
        }
        return null;
    }
}
