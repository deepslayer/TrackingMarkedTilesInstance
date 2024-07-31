import org.dreambot.api.input.Keyboard;
import org.dreambot.api.input.Mouse;
import org.dreambot.api.input.event.impl.keyboard.awt.Key;
import org.dreambot.api.methods.map.Tile;
import org.dreambot.api.script.AbstractScript;
import org.dreambot.api.script.Category;
import org.dreambot.api.script.ScriptManifest;
import org.dreambot.api.wrappers.map.Region;

import java.awt.*;
import java.util.List;

@ScriptManifest(category = Category.MISC, name = "Tile Marker", author = "Deep Slayer", version = 1.0)
public class TileMarkerScript extends AbstractScript {

    private final TileManager tileManager = new TileManager();
    private boolean marking = false;

    @Override
    public void onStart() {
        tileManager.loadTiles();
    }

    @Override
    public void onExit() {
        tileManager.saveTiles();
    }

    @Override
    public int onLoop() {
        if (Keyboard.isPressed(Key.SHIFT) && Mouse.getLastClicked() != null) {
            marking = true;
        }
        return 100;
    }

    @Override
    public void onPaint(Graphics g) {
        if (marking) {
            Tile selectedTile = Mouse.getTileOnCursor();
            if (selectedTile != null) {
                // Convert to world coordinates if in an instance
                Tile worldTile = Region.fromInstance(selectedTile);
                if (!tileManager.isTileMarked(worldTile)) {
                    MarkedTile markedTile = new MarkedTile(worldTile.getX(), worldTile.getY(), worldTile.getZ(), Color.RED);
                    tileManager.addTile(markedTile);
                }
                marking = false;
            }
        }

        for (MarkedTile tile : tileManager.getMarkedTiles()) {
            Tile worldTile = new Tile(tile.getWorldX(), tile.getWorldY(), tile.getPlane());
            List<Tile> instanceTiles = Region.toInstance(worldTile);
            if (instanceTiles.isEmpty()) {
                instanceTiles.add(worldTile);  // If no instance, use the world tile itself
            }
            for (Tile instanceTile : instanceTiles) {
                Polygon tilePoly = instanceTile.getPolygon();
                if (tilePoly != null) {
                    g.setColor(tile.getColor());
                    g.drawPolygon(tilePoly);
                    g.setColor(new Color(tile.getColor().getRed(), tile.getColor().getGreen(), tile.getColor().getBlue(), 50)); // Semi-transparent fill
                    g.fillPolygon(tilePoly);
                }
            }
        }
    }
}
