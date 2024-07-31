import java.awt.Color;
import java.io.Serializable;

public class MarkedTile implements Serializable {
    private final int worldX, worldY, plane;
    private final Color color;

    public MarkedTile(int worldX, int worldY, int plane, Color color) {
        this.worldX = worldX;
        this.worldY = worldY;
        this.plane = plane;
        this.color = color;
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }

    public int getPlane() {
        return plane;
    }

    public Color getColor() {
        return color;
    }
}
