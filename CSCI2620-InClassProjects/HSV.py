import math

def rgbToHSV(red, green, blue):

    maxVal = max(red, green, blue)
    minVal = min(red, green, blue)
    diffVal = maxVal - minVal

    # Black Exception
    if maxVal == 0:
        return (0, 0, 0)

    value255 = maxVal

    sat = diffVal/maxVal

    if diffVal == 0:
        hue360 = 0
    else:
        if red == maxVal:
            hue360 = 0 + 60 * (green - blue) / diffVal
        if green == maxVal:
            hue360 = 120 + 60 * (blue - red) / diffVal
        if blue == maxVal:
            hue360 = 240 + 60 * (red - green) / diffVal

    if hue360 < 0:
        hue360 += 360

    return (hue360/360, sat, value255/255)


def hsvToRGB(hue, saturation, value):

    maxVal = value
    minVal = (value - saturation*value)
    diffVal = maxVal - minVal

    baseAngle = 0
    if 1/6 < hue <= 3/6:
        baseAngle = 120
    if 3/6 < hue <= 5/6:
        baseAngle = 240

    rotatePositive = False
    if 0 < hue <= 1/6 or 2/6 < hue <= 3/6 or 4/6 < hue <= 5/6:
        rotatePositive = True

    if rotatePositive:
        midVal = (((hue * 360 - baseAngle) * diffVal)/60) + minVal
    else:
        midVal = (((baseAngle - hue * 360) * diffVal)/60) + minVal

    if baseAngle == 0:
        if rotatePositive:
            return (round(maxVal * 255), round(midVal * 255), round(minVal * 255))
        else:
            return (round(maxVal * 255), round(minVal * 255), round(midVal * 255))
    if baseAngle == 120:
        if rotatePositive:
            return (round(minVal * 255), round(maxVal * 255), round(midVal * 255))
        else:
            return (round(midVal * 255), round(maxVal * 255), round(minVal * 255))
    if baseAngle == 240:
        if rotatePositive:
            return (round(midVal * 255), round(minVal * 255), round(maxVal * 255))
        else:
            return (round(minVal * 255), round(midVal * 255), round(maxVal * 255))


if __name__ == '__main__':

    hsvVals = rgbToHSV(235, 240, 64)

    print(hsvVals)

    print(hsvToRGB(hsvVals[0], hsvVals[1], hsvVals[2]))
