# Autoes: Ellen Junker, Kessy Roberta Staub e Mateus da Silva Francelino
# Data: 12/10/2021

import cv2
import numpy as np


class FireDetector():
	def __init__(self, image):
		super(FireDetector, self).__init__()
		self.original_image = image
		self.image = image

		# self.apply_blur()

	def apply_blur(self):  # Aplica um blur na imagem
		self.image = cv2.bilateralFilter(self.image, 9, 75, 75)  # Blur

	def fire_extraction(self):  # Cria uma máscara de acordo com a cor do fogo
		fire = np.zeros((self.image.shape[0], self.image.shape[1], 3), np.uint8)  # Imagem vazia para armazenar a parcela da imagem que é fogo
		non_fire = np.zeros((self.image.shape[0], self.image.shape[1], 3), np.uint8)  # Imagem vazia para armazenar a parcela da imagem que nao é fogo

		# Percorre a imagem
		for i in range(0, self.image.shape[0]):
			for j in range(0, self.image.shape[1]):
				pixel = self.image[i, j].copy()  # Pega o pixel

				if pixel[0] >= 0 and pixel[0] < 140 and pixel[1] > 50 and pixel[1] <= 255 and pixel[2] > 170 and pixel[2] <= 255:  # Tons para o fogo
					fire[i, j] = pixel  # Adiciona o fogo à imagem "fire"

					# Zera o pixel
					pixel[0] = 0
					pixel[1] = 0
					pixel[2] = 0
					non_fire[i, j] = pixel  # Zera o fogo na imagem "non_fire"
				else:  # Se não for fogo
					non_fire[i, j] = pixel  # Adiciona o pixel à imagem "non_fire"

					# Zera o pixl
					pixel[0] = 0
					pixel[1] = 0
					pixel[2] = 0
					fire[i, j] = pixel  # Retira o pixel da imagem "fire"

		return (fire, non_fire) 

	def build_mask(self, fire_image):  # Apply threshold to the mask 
		gray = cv2.cvtColor(fire_image, cv2.COLOR_BGR2GRAY)
		_, mask = cv2.threshold(gray, 128, 255, cv2.THRESH_BINARY | cv2.THRESH_OTSU)

		return mask

	def convert_mask(self, mask):  # Convert the mask values to bits
		result = cv2.bitwise_and(self.image, self.image, mask=mask)

		return result

	def apply_canny(self, image):  # Get fire edges
		gray = cv2.cvtColor(image, cv2.COLOR_BGR2GRAY)
		canny = cv2.Canny(gray, 100, 200)

		return canny

	def apply_fire_contour(self, mask):  # Apply a contour to the fire 
		contour = cv2.bitwise_and(self.image, self.image, mask=mask)
		_, thr = cv2.threshold(mask, 100, 255, 0)
		contours, _ = cv2.findContours(thr, cv2.RETR_TREE, cv2.CHAIN_APPROX_NONE)
		contour = cv2.drawContours(contour, contours, -1, (255, 0, 0), 3)

		return contour 

	def add_contour2image(self, contour):  # Add the contour to the original image
		_sum = cv2.add(self.original_image, contour)

		return _sum
