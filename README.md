# Tea Addon for TerraFirmaCraft

![Build Status](../../actions/workflows/build.yml/badge.svg)

A Minecraft 1.7.10 Forge mod that adds Tea crops to TerraFirmaCraft.

## Features

- **Tea Seeds**: Plantable seeds that grow into tea plants
- **Tea Plant**: 8 growth stages with climate requirements (5-30°C, 200-500mm rainfall)
- **Tea Leaves**: Harvestable food item (2 hunger, 0.3 saturation)

## Requirements

- Minecraft 1.7.10
- Forge 10.13.4.1614-1558 (or compatible 1.7.10 version)
- TerraFirmaCraft 0.79.29.922

## Download (Easy Way)

**No need to build!** Every commit automatically builds the JAR file using GitHub Actions.

### Option 1: Download from GitHub Actions (Latest Build)
1. Go to the [Actions tab](../../actions/workflows/build.yml)
2. Click on the latest successful build (green checkmark ✓)
3. Scroll down to "Artifacts" section
4. Download `teaaddon-jar`
5. Extract the ZIP file to get the `.jar` file

### Option 2: Download from Releases (Stable Versions)
1. Go to the [Releases page](../../releases)
2. Download the latest `teaaddon-1.0.0.jar` file
3. No extraction needed!

### Installation
1. Download the JAR file using one of the methods above
2. Place it in your `.minecraft/mods/` folder
3. Make sure TerraFirmaCraft is also installed
4. Launch Minecraft with Forge

## Building (For Developers)

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
