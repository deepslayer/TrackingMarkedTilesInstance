# Tile Marker Script for DreamBot

This project provides a script for the DreamBot framework that allows users to mark tiles in the game using a graphical overlay. The script stores the marked tiles and remembers them even when the player enters or exits an instanced area.

## Features

- Mark tiles by pressing the Shift key and clicking on the desired tile. (Make sure to allow user input while the script is running)
- The marked tiles are saved and loaded automatically.
- Supports dynamic/instanced regions, ensuring marked tiles are remembered correctly.
- Prevents duplicate marking of tiles.

## How to Use

1. **Setup DreamBot**: Ensure you have DreamBot installed. You can download it from the [DreamBot website](https://dreambot.org/).

2. **Clone the Repository**: Clone this repository to your local machine.

    ```sh
    git clone https://github.com/yourusername/TileMarkerScript.git
    ```

3. **Add Script to DreamBot**: Copy the `src` folder to the `Scripts` directory of your DreamBot installation.

4. **Compile the Script**:
    - Open the DreamBot client.
    - Go to the `Scripts` tab.
    - Click `Refresh` to compile the new script.

5. **Run the Script**:
    - Start Old School RuneScape from the DreamBot client.
    - Select the `Tile Marker` script from the script manager and run it.

## Usage Instructions

- **Marking Tiles**: 
    - Press and hold the Shift key.
    - Click on the tile you want to mark. The tile will be marked with a semi-transparent red overlay.
    - If the tile is already marked, it will not be marked again.

- **Exiting the Script**:
    - The script automatically saves the marked tiles when it stops running.

## Project Structure

- `src/MarkedTile.java`: Class representing a marked tile with coordinates and color.
- `src/TileManager.java`: Class for managing marked tiles, including saving and loading from a file.
- `src/TileMarkerScript.java`: The main script class that integrates with DreamBot and provides the tile marking functionality.
