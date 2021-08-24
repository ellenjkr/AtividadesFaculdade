import cv2
import numpy as np


def threshold(image, t, below, above):
	new_image = np.zeros((image.shape[0], image.shape[1], 3), np.uint8) # Gera uma imagem vazia

	# Multiplica os valores de entrada (0 a 1) por 255 para que os tons variem entre 0 e 255
	t = t * 255.0
	below = below * 255.0
	above = above * 255.0

	# Percorre a matriz
	for i in range(0, image.shape[1]):
		for j in range(0, image.shape[0]):
			pixel = image[j, i] # Seleciona o pixel
			intensity_array = [] # Inicializa um array para guardar as "novas" intensidades do pixel
			for chanel_intensity in pixel: # Percorre os canais rgb do pixel
				# Verifica se o valor do canal é menor que o passado como parâmetro e seta o valor de x
				if chanel_intensity <= t: 
					x = below
				else:
					x = above
				intensity_array.append(x) # Adiciona o novo valor do canal ao array de intensidades
			new_image[j, i] = intensity_array # Substitui os valores do pixel pelo novo array de intensidades
	return new_image

if __name__ == '__main__':
	image = cv2.imread('image.jpg') # Carrega a imagem a ser processada
	new_image = threshold(image, 0.6, 0, 1) # Aplica a limiarização

	# Exibe a imagem gerada
	cv2.imshow('Imagem Original', new_image)
	cv2.waitKey(0)
	cv2.destroyAllWindows()
	