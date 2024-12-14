from PIL import Image

if __name__ == '__main__':

    image1 = Image.open("keystone.png")
    data1 = image1.load()
    image2 = Image.open("stoat.jpg")
    data2 = image2.load()

    image3 = Image.new("RGB", (image1.width, image1.height))
    data3 = image3.load()
    sumError = 0

    for row in range(image1.height):
        for col in range (image1.width):
            data3[col, row] = tuple(map(lambda a,b:abs(a-b), data1[col, row], data2[col, row]))
            sumError += data3[col, row][0] + data3[col, row][1] + data3[col, row][2]

    print((sumError/(image3.width * image3.height)))

    image3.save("diff.png")