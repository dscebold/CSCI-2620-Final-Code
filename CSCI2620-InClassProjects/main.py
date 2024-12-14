import random

from PIL import Image

if __name__ == '__main__':

    image = Image.open("bugatti.jpeg")

    data = image.load()
    print(image.width)
    print(image.height)

    for i in range(image.height):
        for q in range(image.width):
            pixel = data[q, i]

            red = pixel[0]
            green = pixel[1]
            blue = pixel[2]

            data[q, i] = (red, green, blue)

            redFactor = .21
            greenFactor = .71
            blueFactor = .08

            avg = int(red * redFactor + blue * blueFactor + green * greenFactor)

            # v = max(red, green, blue)

            # avg = v
            '''
            if(blue > 150) :
                data[q, i] = (red, green, blue)
            else:
                data[q i] = (avg, avg, avg)
            '''
            data[q, i] = (avg, avg, avg)

    image.save("bugatti.png")
