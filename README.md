# Tea Addon for TerraFirmaCraft

A Minecraft 1.7.10 Forge mod that adds Tea crops to TerraFirmaCraft.

## Features

- **Tea Seeds**: Plantable seeds that grow into tea plants
- **Tea Plant**: 8 growth stages with climate requirements (5-30°C, 200-500mm rainfall)
- **Tea Leaves**: Harvestable food item (2 hunger, 0.3 saturation)

## Requirements

- Minecraft 1.7.10
- Forge 10.13.4.1614-1558 (or compatible 1.7.10 version)
- TerraFirmaCraft 0.79.29.922
- Java 1.8

## Building

### Prerequisites

1. Install Java Development Kit (JDK) 8
2. Ensure `JAVA_HOME` is set correctly

### Build Steps

```bash
# On Linux/Mac
./gradlew setupDecompWorkspace
./gradlew build

# On Windows
gradlew.bat setupDecompWorkspace
gradlew.bat build
```

The compiled mod will be located at: `build/libs/teaaddon-1.0.0.jar`

## Installation

1. Build the mod using the instructions above
2. Copy `teaaddon-1.0.0.jar` to your Minecraft `mods/` folder
3. Ensure TerraFirmaCraft is also installed
4. Launch Minecraft with Forge

## Development

### Project Structure

```
src/main/java/com/dion/teaaddon/
├── TeaAddon.java              # Main mod class
├── blocks/
│   └── BlockTeaPlant.java     # Tea plant block with 8 growth stages
└── items/
    ├── ItemTeaSeed.java       # Tea seed item
    └── ItemTeaLeaf.java       # Tea leaf food item

src/main/resources/
├── mcmod.info                 # Mod metadata
├── assets/teaaddon/
    ├── lang/
    │   └── en_US.lang        # English localization
    └── textures/
        ├── items/
        │   ├── tea_seeds.png
        │   └── tea_leaves.png
        └── blocks/
            └── tea_plant_0.png through tea_plant_7.png
```

### Climate Requirements

The tea plant requires:
- Temperature: 5-30°C
- Rainfall: 200-500mm

These values are checked during the plant's growth tick.

## Credits

Based on the cabbage crop system from TerraFirmaCraft.

## License

This is a derivative work based on TerraFirmaCraft. Please respect the original mod's licensing terms.
