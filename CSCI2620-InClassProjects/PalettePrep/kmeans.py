from PIL import Image
import math
from get_palette import get_palette
from print_palette import print_palette
from remap import remap
from remap import remapDither
from nes_palette import nes_palette
import random
import time

basic_palette = [
        (0,0,0),
        (64, 64, 64),
        (128, 128, 128),
        (192, 192, 192),
        (255,255,255),
        (255, 0, 0),
        (0, 255, 0),
        (0, 0, 255),
        ]
def true_random_color():
    return (int(random.random()*255), int(random.random()*255), int(random.random()*255))


def nes_random_color():
    global next_random_color
    next_random_color += 1
    next_random_color %= len(nes_palette)
    return nes_palette[next_random_color]


def basic_random_color():
    global next_random_color
    next_random_color += 1
    next_random_color %= len(basic_palette)
    return basic_palette[next_random_color]


def color_distance(one, two):
    r_diff = one[0] - two[0]
    g_diff = one[1] - two[1]
    b_diff = one[2] - two[2]

    return math.sqrt(r_diff**2+g_diff**2+b_diff**2)


def colorDistanceL1(one, two):
    r_diff = one[0] - two[0]
    g_diff = one[1] - two[1]
    b_diff = one[2] - two[2]

    return abs(r_diff) + abs(g_diff) + abs(b_diff)


if __name__ == '__main__':

    start_time = time.time()

    image = Image.open("fish.jpg")
    data = image.load()

    sampling_probability = .1
    entries = get_palette(image, data, sampling_probability)

    count_clusters = 256

    cluster_centers = []

    for i in range(count_clusters):
        cluster_centers.append(true_random_color())

    # print(cluster_centers)

    closest_pixels = [[] for i in range(count_clusters)]
    # print(closest_pixels)

    totalSteps = 2

    for step in range(totalSteps):
        print("Starting step: " + str(step+1) + "/" + str(totalSteps), end="\n")

        print("Building cluster distance matrix")
        cluster_center_distances = []
        for i in range(count_clusters):
            row = []
            for j in range(count_clusters):
                distance = color_distance(cluster_centers[i], cluster_centers[j])
                row.append(distance)
            cluster_center_distances.append(row)
        print("Done building cluster distance matrix")

        skips = 0

        for pixel in entries:
            min_distance = 4420
            min_index = 0
            for i in range(count_clusters):

                # Check triangle inequality
                cluster_distance = cluster_center_distances[min_index][i]
                if cluster_distance > min_distance * 2:
                    continue

                center = cluster_centers[i]
                distance = colorDistanceL1(pixel[0], center)


                if distance < min_distance:
                    min_distance = distance
                    min_index = i

            closest_pixels[min_index].append(pixel)

        # print(closest_pixels[0][:10])

        for i in range(count_clusters):
            sum_r = 0
            sum_g = 0
            sum_b = 0

            pixel_count = 0

            for j in range(len(closest_pixels[i])):

                sum_r += closest_pixels[i][j][0][0] * closest_pixels[i][j][1]
                sum_g += closest_pixels[i][j][0][1] * closest_pixels[i][j][1]
                sum_b += closest_pixels[i][j][0][2] * closest_pixels[i][j][1]

                pixel_count += closest_pixels[i][j][1]

            if pixel_count > 0:
                sum_r //= pixel_count
                sum_g //= pixel_count
                sum_b //= pixel_count

                cluster_centers[i] = (sum_r, sum_g, sum_b)

            else:
                cluster_centers[i] = true_random_color()



    if (len(cluster_centers) <= 0):
        print(cluster_centers)

    print("Remapping Image", end="\n")
    filename = "fish_kmc_" + str(count_clusters) + "_" + str(totalSteps) + "_" + str(
        sampling_probability) + "_dither.png"
    print("Remapping to " + filename)
    remapDither(image, data, cluster_centers, filename)

    end_time = time.time()

    print("Runtime (s): " + str((end_time - start_time)))

