from PIL import Image
import math

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

    image = Image.open("quokka.jpeg")
    data = image.load()
    newImage = Image.new("RGB", (image.width, image.height))
    newData = newImage.load()

    rotation = .5


    cosTheta = math.cos(-rotation)
    sinTheta = math.sin(-rotation)

    dx = - cosTheta * image.width/2 + sinTheta * image.height/2 + image.width/2
    dy = - sinTheta * image.width/2 - cosTheta * image.height/2 + image.height/2

    for y in range(image.height):
        for x in range(image.width):

            newX = cosTheta * x - sinTheta * y + dx
            newY = sinTheta * x + cosTheta * y + dy

            if newX < 0 or newX >= (image.width - 1) or newY < 0 or newY >= (image.height - 1):
                newData[x, y] = (0, 0, 0)
            else:
                newData[x, y] = bilinearInterpolation(data, newX, newY)



    newImage.save("fastRotatedInterpolation.png")