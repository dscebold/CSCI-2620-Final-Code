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
    newImage = Image.new("RGB", (image.width*2, image.height*2))
    newData = newImage.load()

    for y in range(image.height):
        for x in range(image.width):

            newX = x - image.width/2
            newY = y - image.height/2



            if newX < 0 or newX >= image.width/2 or newY < 0 or newY >= image.height*2:
                newData[x, y] = (255, 255, 255)
            else:
                newData[x, y] = data[math.floor(newX), math.floor(newY)]



    newImage.save("edges.png")