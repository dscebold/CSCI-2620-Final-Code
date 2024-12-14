import math

from PIL import Image


def interpolate(start, end, percent):
    return (end - start) * percent + start

def interpolateRGB(start, end, percent):
    rStart = start[0]
    gStart = start[1]
    bStart = start[2]

    rEnd = end[0]
    gEnd = end[1]
    bEnd = end[2]

    r = interpolate(rStart, rEnd, percent)
    g = interpolate(gStart, gEnd, percent)
    b = interpolate(bStart, bEnd, percent)

    return r, g, b

def nnInterpolation(data, x, y):
    return data[math.floor(x), math.floor(y)]

def bilinearInterpolation(data, x, y):

    #Gather my pixels
    xStart = math.floor(x)
    xEnd = xStart + 1
    xPercent = x - xStart
    yStart = math.floor(y)
    yEnd = yStart + 1
    yPercent = y - yStart

    topLeft = data[int(xStart), int(yStart)]
    topRight = data[int(xEnd), int(yStart)]
    bottomLeft = data[int(xStart), int(yEnd)]
    bottomRight = data[int(xEnd), int(yEnd)]

    #Interpolate across the top
    top = interpolateRGB(topLeft, topRight, xPercent)

    #Interpolate axross the bottom
    bottom = interpolateRGB(bottomLeft, bottomRight, xPercent)

    #Interpolate vertically
    result = interpolateRGB(top, bottom, yPercent)

    #Return the result
    return (math.floor(result[0]), math.floor(result[1]), math.floor(result[2]))


if __name__ == '__main__':
    imageStart = Image.open("parrot.png")
    dataStart = imageStart.load()

    imageOut = Image.new("RGB", (imageStart.width, imageStart.height))
    dataOut = imageOut.load()

    minDimension = min(imageOut.width, imageOut.height)

    for row in range(imageOut.height):
        for col in range(imageOut.width):

            pixel = dataStart[col, row]

            colc = col - imageOut.width/2
            rowc = row - imageOut.height/2

            radius = math.sqrt(colc**2 + rowc**2)
            theta = math.atan2(rowc, colc)

            newRadius = (radius/(minDimension/2))**2

            if radius > minDimension/2:
                newRadius = radius/(minDimension/2)

            newCol = math.cos(theta)*newRadius*minDimension/2
            newRow = math.sin(theta)*newRadius*minDimension/2

            newCol += imageOut.width/2
            newRow += imageOut.height/2

            if newCol < 0 or newCol >= (imageOut.width - 1) or newRow < 0 or newRow >= (imageOut.height - 1):
                dataOut[col, row] = (0, 0, 0)
            else:
                dataOut[col, row] = bilinearInterpolation(dataStart, newCol, newRow)
                # dataOut[col, row] = dataStart[math.floor(newCol), math.floor(newRow)]

    imageOut.save("bulge.png")
