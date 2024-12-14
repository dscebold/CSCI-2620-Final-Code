

def rgbToCMYK(red, green, blue):

    red /= 255
    green /= 255
    blue /= 255

    v = max(red, green, blue)

    if v == 0:
        return (0, 0, 0, 1)

    k = 1 - v

    c = 1 - red/v
    m = 1 - green/v
    y = 1 - blue/v

    return (c, m, y, k)


def cmykToRGB(cyan, magenta, yellow, k):

    v = 1 - k

    red = v - v * cyan
    green = v - v * magenta
    blue = v - v * yellow

    return (round(red * 255), round(green * 255), round(blue * 255))

from PIL import Image

if __name__ == '__main__':

    print(rgbToCMYK(0, 0, 0))
    print(rgbToCMYK(50, 100, 75))
    print(cmykToRGB(*rgbToCMYK(50, 100, 75)))

    image = Image.open("stoat.jpg")
    data = image.load()

    for row in range(image.height):
        for col in range(image.width):

            pixel = data[col, row]

            cmyk = rgbToCMYK(*pixel)

            cmyk2 = (min(1, cmyk[0] * 2), cmyk[1], cmyk[2], cmyk[3])

            rgb = cmykToRGB(*cmyk2)

            data[col, row] = rgb

    image.save("cmykStoat.png")