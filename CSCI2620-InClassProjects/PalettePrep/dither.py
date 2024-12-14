from PIL import Image



if __name__ == '__main__':

    image = Image.open("fish2.png")
    data = image.load()

    errorMatrix = []

    for x in range(image.width + 1):
        row = []
        for y in range(image.height + 1):
            row.append(0)
        errorMatrix.append(row)

    for y in range(image.height):
        for x in range(image.width):

            pixel = data[x, y]
            k = (pixel[0] + pixel[1] + pixel[2])//3

            k += errorMatrix[x][y]

            out = 0

            if k >= 128:
                out = 255

            data[x,y] = (out, out, out)

            error = k - out
            quarterError = error/4
            errorMatrix[x + 1][y] += quarterError
            errorMatrix[x - 1][y + 1] += quarterError
            errorMatrix[x][y + 1] += quarterError
            errorMatrix[x + 1][y + 1] += quarterError


    image.save("fish2_dither2.png")