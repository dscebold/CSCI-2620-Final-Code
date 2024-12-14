from PIL import Image
import math
from get_palette import get_palette
from print_palette import print_palette
from remap import remap
from nes_palette import nes_palette


if __name__ == '__main__':

  image = Image.open("cat.jpg")
  data = image.load()

  basic_palette = [
    (0,0,0),
    (64, 64, 64),
    (128, 128, 128),
    (192, 192, 192),
    (255,255,255),
    (255, 0, 0),
    (0, 255, 0),
    (0, 0, 255),
    ]

  image = Image.open("abstract.jpg")
  data = image.load()

  remap(image, data, basic_palette, "abstract_bichrome.png")

  entries = get_palette(image, data)

  print_palette(entries, 10, "abstract_palette.png")

  # remap(image, data, nes_palette, "remap_cat.png")
  #
  #
  #
  # for filename in ("cat.jpg", "abstract.jpg"):
  #   image = Image.open(filename)
  #   data = image.load()
  #
  #   entries = get_palette(image, data)
  #   entries = [x for x in entries if x[1] > 1]
  #
  #   print_palette(entries, 10, "palette_" + filename +".png")
