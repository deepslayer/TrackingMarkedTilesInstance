import org.dreambot.api.methods.map.Tile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TileManager {
    private static final String FILE_PATH = "D:\\marked_tiles.dat"; // Adjust to your file path
    private final List<MarkedTile> markedTiles = new ArrayList<>();

    public void addTile(MarkedTile tile) {
        if (!isTileMarked(tile)) {
            markedTiles.add(tile);
            saveTiles();
        }
    }

    public void removeTile(MarkedTile tile) {
        markedTiles.remove(tile);
        saveTiles();
    }

    public List<MarkedTile> getMarkedTiles() {
        return markedTiles;
    }

    public void loadTiles() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            markedTiles.clear();
            markedTiles.addAll((List<MarkedTile>) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveTiles() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(markedTiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isTileMarked(Tile tile) {
        for (MarkedTile markedTile : markedTiles) {
            if (markedTile.getWorldX() == tile.getX() && markedTile.getWorldY() == tile.getY() && markedTile.getPlane() == tile.getZ()) {
                return true;
            }
        }
        return false;
    }

    public boolean isTileMarked(MarkedTile tile) {
        for (MarkedTile markedTile : markedTiles) {
            if (markedTile.getWorldX() == tile.getWorldX() && markedTile.getWorldY() == tile.getWorldY() && markedTile.getPlane() == tile.getPlane()) {
                return true;
            }
        }
        return false;
    }
}
