package ru.dverkask.grandquotes.api.map;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;

import java.util.List;

public class QuoteMap {
    private final MapView mapView;

    public QuoteMap(MapView mapView) {
        this.mapView = mapView;
    }

    public ItemStack generateMap() {
        ItemStack mapItem = new ItemStack(Material.FILLED_MAP);
        MapMeta   mapMeta = (MapMeta) mapItem.getItemMeta();

        mapMeta.setMapView(mapView);
        mapMeta.lore(List.of(
                Component.text("123") /* TODO from config */
        ));

        mapMeta.addItemFlags(
                ItemFlag.HIDE_ATTRIBUTES,
                ItemFlag.HIDE_ITEM_SPECIFICS,
                ItemFlag.HIDE_UNBREAKABLE
        );

        mapItem.setItemMeta(mapMeta);

        return mapItem;
    }

    public void giveMapToPlayer(Player player, ItemStack mapItem) {
        /*
            TODO check for able to add item
         */
        player.getInventory().addItem(mapItem);
    }
}
