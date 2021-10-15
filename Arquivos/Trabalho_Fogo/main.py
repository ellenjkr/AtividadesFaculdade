# Autoes: Ellen Junker, Kessy Roberta Staub e Mateus da Silva Francelino
# Data: 12/10/2021

import cv2
from FireDetector import FireDetector


if __name__ == '__main__':
    image = cv2.imread('Images/imagem3.jpg')

    fire_detector = FireDetector(image)
    fire, non_fire = fire_detector.fire_extraction()
    mask = fire_detector.build_mask(fire)
    bit_mask = fire_detector.convert_mask(mask)
    canny = fire_detector.apply_canny(bit_mask)
    contour = fire_detector.apply_fire_contour(mask)
    contoured_image = fire_detector.add_contour2image(contour)

    cv2.imshow('Original', image)
    cv2.imshow('Fire', fire)
    cv2.imshow('Non Fire', non_fire)
    cv2.imshow('Mask', mask)
    cv2.imshow('Canny', canny)
    cv2.imshow('Contour', contour)
    cv2.imshow('Contoured Image', contoured_image)

    cv2.waitKey()
    cv2.destroyAllWindows()
