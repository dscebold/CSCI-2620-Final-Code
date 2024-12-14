from PIL import Image
import math

if __name__ == '__main__':

    image = Image.open("quokka.jpeg")
    data = image.load()
    newImage = Image.new("RGB", (image.width, image.height))
    newData = newImage.load()

    rotation = .5
    center = (image.width/2, image.height/2)

    for y in range(image.height):
        for x in range(image.width):

            dx = x - center[0]
            dy = y - center[1]

            originalRadius = math.sqrt(dx**2 + dy**2)
            originalAngle = math.atan2(dy, dx)
            newAngle = originalAngle - rotation
            sampleX = math.cos(newAngle) * originalRadius + center[0]
            sampleY = math.sin(newAngle) * originalRadius + center[1]
            sampleX //= 1
            sampleY //= 1

            if 0 <= sampleX < image.width and 0 <= sampleY < image.height:
                newData[x, y] = data[sampleX, sampleY]
            else:
                newData[x, y] = (0, 0, 0)



    newImage.save("rotated.png")