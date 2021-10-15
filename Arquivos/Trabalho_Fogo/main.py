# Autores: Ellen Junker, Kessy Roberta Staub e Mateus da Silva Francelino
# Data: 12/10/2021

import cv2
from FireDetector import FireDetector
from glob import glob
import matplotlib.pyplot as plt
import os

if __name__ == '__main__':


    img_names = glob(os.path.join('fire_images','*.png')) #<<< para pegar as imagens sem fogo
    #img_names = glob(os.path.join('non_fire_images','*.png')) #<<< para pegar as imagens com fogo


    for fn in img_names:
        image=cv2.imread(fn)

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
