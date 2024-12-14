from PIL import Image


def flip_horizontal(originalImage):
    blankImage = Image.new("RGB", [originalImage.width, originalImage.height])
    blankImageData = blankImage.load()
    originalData = originalImage.load()

    for i in range(originalImage.height):
        for q in range(originalImage.width):
            pixel = originalData[q, i]
            blankImageData[(originalImage.width - 1) - q, i] = pixel

    return blankImage

def flip_vertical(originalImage):
    blankImage = Image.new("RGB", [originalImage.width, originalImage.height])
    blankImageData = blankImage.load()
    originalData = originalImage.load()

    for i in range(originalImage.height):
        for q in range(originalImage.width):
            pixel = originalData[q, i]
            blankImageData[q, (originalImage.height - 1) - i] = pixel

    return blankImage


def rotate90(originalImage):
    blankImage = Image.new("RGB", [originalImage.height, originalImage.width])
    blankImageData = blankImage.load()
    originalData = originalImage.load()

    for y in range(originalImage.height):
        for x in range(originalImage.width):
            pixel = originalData[x, y]
            blankImageData[(originalImage.height - y - 1), x] = pixel

    return blankImage


def translate(originalImage, dx, dy):
    blankImage = Image.new("RGB", (originalImage.width + dx, originalImage.height + dy))
    blankImageData = blankImage.load()
    originalData = originalImage.load()

    for y in range(originalImage.height):
        for x in range(originalImage.width):
            pixel = originalData[x, y]
            blankImageData[x + dx, y + dy] = pixel

    return blankImage


def transform(originalImage, a, b, c, d, e, f):
    blankImage = Image.new("RGB", (originalImage.width, originalImage.height))
    blankImageData = blankImage.load()
    originalData = originalImage.load()

    for y in range(originalImage.height):
        for x in range(originalImage.width):

            newX = x * a + y * b + 1 * c
            newY = x * d + y * e + 1 * f

            pixel = originalData[x, y]
            blankImageData[newX, newY] = pixel

    return blankImage


if __name__ == '__main__':
    image = Image.open("quokka.jpeg")

    data = image.load()
    print(image.width)
    print(image.height)

    pixel = data[0, 0]
    print(pixel)
    # red = pixel[0]
    # green = pixel[1]
    # blue = pixel[2]

    red, green, blue = pixel
    print(red)

    packed_int = 0

    packed_int += red << 16
    packed_int += green << 8
    packed_int += blue << 0

    print(packed_int)

    redUnpacked = packed_int >> 16 & 0xff
    greenUnpacked = packed_int >> 8 & 0xff
    blueUnpacked = packed_int >> 0 & 0xff

    print(redUnpacked)
    print(greenUnpacked)
    print(blueUnpacked)

    pixel2 = red, green, blue

    print(pixel2)

    flippedImage = flip_horizontal(image)
    flippedImage.save("flippedHorizontalImage.png")

    flippedImage = flip_vertical(image)
    flippedImage.save("flippedVerticalImage.png")

    doubleFlipped = flip_horizontal(flippedImage)
    doubleFlipped.save("doubleFlipped.png")

    rotated90 = rotate90(image)
    rotated90.save("rotated90Image.png")

    translatedImage = translate(image, 20, 20)
    translatedImage.save("translatedImage.png")

    transformedImage = transform(image, -1, 0, (image.width - 1), 0, 1, 0)
    transformedImage.save("transformedImage.png")


