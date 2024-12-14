import sys

from PIL import Image
from io import StringIO




if __name__ == '__main__':

    image = Image.open("christmasCar.jpg")
    data = image.load()

    string = bytearray()

    string.extend(f"P6\n{image.width} {image.height}\n255\n".encode())

    for y in range(image.height):
        for x in range(image.width):

            pixel = data[x,y]

            r = pixel[0]
            g = pixel[1]
            b = pixel[2]

            string.append(r)
            string.append(g)
            string.append(b)

    with open("p6.ppm", "wb") as file:
        file.write(string)

        file.close()


    zipped = zip(string)
    print(len(list(zipped)))

    quit()

    ppm_string = string.getvalue()
    parts = ppm_string.split()

    assert parts[0] == "P3"
    width = int(parts[1])
    height = int(parts[2])
    assert parts[3] == "255"

    new_image = Image.new("RGB", (width, height))
    new_data = new_image.load()

    col = 0
    row = 0
    currPix = 4

    while currPix < parts.__len__():

        tempPixel = ( int(parts[currPix]), int(parts[currPix + 1]), int(parts[currPix + 2]))

        currPix += 3

        new_data[col, row] = tempPixel

        col += 1

        if col >= width:
            col = 0
            row += 1


    new_image.save("car.png")


