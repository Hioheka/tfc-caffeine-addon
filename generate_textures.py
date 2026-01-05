#!/usr/bin/env python3
from PIL import Image
import os

# Create directories
os.makedirs("src/main/resources/assets/teaaddon/textures/items", exist_ok=True)
os.makedirs("src/main/resources/assets/teaaddon/textures/blocks", exist_ok=True)

# Tea seeds - brown color
img = Image.new('RGB', (16, 16), color=(139, 90, 43))
img.save("src/main/resources/assets/teaaddon/textures/items/tea_seeds.png")

# Tea leaves - dark green color
img = Image.new('RGB', (16, 16), color=(34, 139, 34))
img.save("src/main/resources/assets/teaaddon/textures/items/tea_leaves.png")

# Tea plant growth stages - gradually darkening green
for i in range(8):
    # Start light green, get darker and more saturated
    green_value = 100 + (i * 7)  # 100 to 149
    img = Image.new('RGB', (16, 16), color=(20, green_value, 20))
    img.save(f"src/main/resources/assets/teaaddon/textures/blocks/tea_plant_{i}.png")

print("All textures generated successfully!")
