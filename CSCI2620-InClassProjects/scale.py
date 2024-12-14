from PIL import Image

def scale(originalImage, amount):
    blankImage = Image.new("RGB", (int(originalImage.width * amount), int(originalImage.height * amount)))
    blankImageData = blankImage.load()
    originalData = originalImage.load()

    for y in range(blankImage.height):
        for x in range(blankImage.width):

            currentX = x
            currentY = y

            pixel = originalData[int(currentX/amount), int(currentY/amount)]

            blankImageData[x, y] = pixel

    return blankImage

if __name__ == '__main__':
    image = Image.open("quokka.jpeg")

    data = image.load()
    print(image.width)
    print(image.height)

    scaledImage = scale(image, 1.5)
    scaledImage.save("scaledImage.png")




