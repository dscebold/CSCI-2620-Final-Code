from PIL import Image

if __name__ == '__main__':

    image = Image.open("stoat.jpg")
    data = image.load()

    imageOut = Image.new("RGB", (image.width, image.height))
    dataOut = imageOut.load()

    for row in range(image.height):
        for col in range(image.width):

            # Generic matrix operation
            a = 1
            b = -0
            c = 0
            d = .1
            e = 1
            f = 1

            x1 = a*col + b*row + c
            y1 = d*col + e*row + f

            if 0 <= x1 < image.width and 0 <= y1 < image.height:
                dataOut[x1, y1] = data[col, row]
            else:
                dataOut[col, row] = (0, 0, 0)


    imageOut.save("keystone.png")