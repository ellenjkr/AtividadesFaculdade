import cv2
import numpy as np


def run_erosion(binary_image):
	binary_image = np.where(binary_image > 0, 1, binary_image)
	# binary_image = np.matrix([[0, 0, 0, 0, 0], [0, 1, 1, 1, 0], [0, 1, 1, 1, 0], [0, 1, 1, 1, 0], [0, 0, 0, 0, 0]])
	# binary_image = np.matrix([[0, 1, 2, 3, 4], [5, 6, 7, 8, 9], [10, 11, 12, 13, 14], [15, 16, 17, 18, 19], [20, 21, 22, 23, 24]])
	structuring_segment = np.matrix([[0, 1, 0], [1, 1, 1], [0, 1, 0]])

	erosion = np.zeros((binary_image.shape[0], binary_image.shape[1], 3), np.uint8)
	for i in range(0, binary_image.shape[0]):
		for j in range(0, binary_image.shape[1]):
			pixel = binary_image[i, j].copy()

			if i != 0 and j != 0 and i != binary_image.shape[0] - 1 and j != binary_image.shape[1] - 1:
				# print(i, j)
				up = binary_image[i - 1, j]
				down = binary_image[i + 1, j]
				left = binary_image[i, j - 1]
				right = binary_image[i, j + 1]

				if pixel[0] == 1 and up[0] == 1 and down[0] == 1 and left[0] == 1 and right[0] == 1:
					pixel[0] = 1
					pixel[1] = 1
					pixel[2] = 1
				else:
					pixel[0] = 0
					pixel[1] = 0
					pixel[2] = 0
			else:
				pixel[0] = 0
				pixel[1] = 0
				pixel[2] = 0

			erosion[i, j] = pixel

	erosion = np.where(erosion > 0, 255, erosion)

	return erosion


if __name__ == '__main__':
	image = cv2.imread('teste.png')
	binary_image = np.where(image > 0, 1, image)
	
	erosion = run_erosion(binary_image)
	cv2.imshow('Imagem Original', erosion)
	cv2.waitKey(0)
	cv2.destroyAllWindows()

# Traceback (most recent call last):
#   File "C:\Users\CLIENTE\Downloads\Backups\Ellen\Faculdade\Processamento Digital de Imagens\Atividade M1\erosao.py", line 10, in <module>
#     erosion = cv2.erode(img,structuring_segment,iterations = 1)
# cv2.error: OpenCV(4.5.3) C:/Users/runneradmin/AppData/Local/Temp/pip-req-build-sn_xpupm/opencv/modules/imgproc/src/morph.simd.hpp:649: error: (-215:Assertion failed) _kernel.type() == CV_8U in function 'cv::opt_AVX2::`anonymous-namespace'::MorphFilter<struct cv::opt_AVX2::`anonymous namespace'::MinOp<unsigned char>,struct cv::opt_AVX2::A0x49ae5d40::MorphVec<struct cv::opt_AVX2::`anonymous namespace'::VMin<struct cv::hal_AVX2::v_uint8x32> > >::MorphFilter'


 



















# https://www.youtube.com/watch?v=2LAooUu1IjQ
# https://docs.opencv.org/4.5.2/d9/d61/tutorial_py_morphological_ops.html

# [0 , 1 , 2 , 3 , 4 ]
# [5 , 6 , 7 , 8 , 9 ]
# [10, 11, 12, 13, 14]
# [15, 16, 17, 18, 19]
# [20, 21, 22, 23, 24]

# [0, 0, 0, 0, 0]
# [0, 1, 1, 1, 0]
# [0, 1, 1, 1, 0]
# [0, 1, 1, 1, 0]
# [0, 0, 0, 0, 0]

# cv2.imshow('Imagem Original', image)
 
# cv2.waitKey(0)
# cv2.destroyAllWindows()

# a matriz menor é o segmento estrutural (structuring segment)
# 0 1 0
# 1 1 1
# 0 1 0
# ambas são compostas por zeros e 1's
# vamos fazer A erosão B (A é a image, B é o segmento estrutural)
# pegamos o centro do segmento estrutural, nesse caso é o 1. Posicionamos esse centro em cada pixel da imagem
# quando posicionamos nos zeros ele nao altera nada porque nao tem "match", zero nao é igual ao centro do segmento estrutural (1)
# se ele encaixa no 1 mas nao tem match nas outras posições (os 1's envolta do 1) ele substitui esse 1 por 0