from PIL import Image
import math

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

            newX //= 1
            newY //= 1

            if 0 <= newX < image.width and 0 <= newY < image.height:
                newData[x, y] = data[newX, newY]
            else:
                newData[x, y] = (0, 0, 0)



    newImage.save("fastRotated.png")