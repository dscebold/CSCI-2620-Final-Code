from PIL import Image
from io import StringIO




if __name__ == '__main__':

    image = Image.open("christmasCar.jpg")
    data = image.load()

    string = StringIO()
    string.write(f"P3\n{image.width} {image.height}\n255\n")

    for y in range(image.height):
        for x in range(image.width):

            pixel = data[x,y]
            string.write(f"{pixel[0]} {pixel[1]} {pixel[2]} ")

        string.write("\n")

    with open("p3.ppm", "w") as file:
        file.write(string.getvalue())

        file.close()

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


