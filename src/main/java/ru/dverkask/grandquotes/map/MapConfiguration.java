package ru.dverkask.grandquotes.map;

import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

public class MapConfiguration {
    public static MapView mapView;
    public static void configureMapView(@NonNull MapRenderer mapRenderer) {
        mapView = Bukkit.createMap(Bukkit.getWorlds().get(0));
        mapView.getRenderers().clear();
        mapView.addRenderer(mapRenderer);
        mapView.setTrackingPosition(false);
        mapView.setScale(MapView.Scale.FARTHEST);
    }

    public static MapView mapView() {
        return mapView;
    }
}
