from PIL import Image
import math

def rotation(point, angle):
    x = point[0]
    y = point[1]

    cosTheta = math.cos(angle)
    sinTheta = math.sin(angle)

    dx = - cosTheta * image.width / 2 + sinTheta * image.height / 2 + image.width / 2
    dy = - sinTheta * image.width / 2 - cosTheta * image.height / 2 + image.height / 2

    newX = cosTheta * x - sinTheta * y + dx
    newY = sinTheta * x + cosTheta * y + dy

    return (newX, newY)


def rotationFast(point, cosTheta, sinTheta):
    x = point[0]
    y = point[1]

    dx = - cosTheta * image.width / 2 + sinTheta * image.height / 2 + image.width / 2
    dy = - sinTheta * image.width / 2 - cosTheta * image.height / 2 + image.height / 2

    newX = cosTheta * x - sinTheta * y + dx
    newY = sinTheta * x + cosTheta * y + dy

    return (newX, newY)

def rotationNoCentering(point, angle):
    cosTheta = math.cos(-angle)
    sinTheta = math.sin(-angle)

    x = point[0]
    y = point[1]

    newX = cosTheta * x - sinTheta * y
    newY = sinTheta * x + cosTheta * y

    return (newX, newY)

if __name__ == '__main__':

    image = Image.open("quokka.jpeg")
    data = image.load()

    angle = .5

    cosTheta = math.cos(-angle)
    sinTheta = math.sin(-angle)
    
    # Calculate new canvas size
    corners = [
        [-image.width/2, -image.height/2],
        [image.width/2, -image.height/2],
        [image.width/2, image.height/2],
        [-image.width/2, image.height/2]
    ]

    maxX = 0
    maxY = 0

    for corner in corners:

        newCorner = rotationNoCentering(corner, angle)
        if abs(newCorner[0]) > maxX:
            maxX = abs(newCorner[0])
        if abs(newCorner[1]) > maxY:
            maxY = abs(newCorner[1])

    print(maxX)
    print(maxY)
    
    newImage = Image.new("RGB", (int(maxX*2), int(maxY*2)))
    newData = newImage.load()

    for y in range(newImage.height):
        for x in range(newImage.width):

            offsetX = (image.width - newImage.width)/2
            offsetY = (image.height - newImage.height)/2

            newX, newY = rotationFast((x + offsetX, y + offsetY), cosTheta, sinTheta)

            newX //= 1
            newY //= 1

            if 0 <= newX < image.width and 0 <= newY < image.height:
                newData[x, y] = data[newX, newY]
            else:
                newData[x, y] = (0, 0, 0)

    newImage.save("fastRotatedExpanded.png")