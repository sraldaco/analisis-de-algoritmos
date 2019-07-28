# Vargas Aldaco Alejandro
## Reposición 4 - Análisis de algoritmos

### Ejercicio 2

Precondiciones: Un arreglo de tamaño n de números reales y un número real x.

Postcondiciones: Determinar si x es elemento del arreglo y determinar su posición en el caso de que sí sea elemento del arreglo. Se debe usar el paradigma divide y vencerás como alternativa a la búsqueda lineal.



int find(element, low, high, array) 

	if low > high then return -1

	medium = (low + high) / 2

	if array[medium] == element then return medium

	pos = find(element, low, medium -1, array)

	if pos not equals -1 then return pos

	pos = find(element, medium, high, array)

	if pos not equals -1 then return pos

	return -1


	
Como se divide en dos el arreglo y se verifica el elemento de en medio, el mejor de los casos se tiene cuando el elemento está en la posición de en medio y en ese caso la complejidad es constante. Si el elemento se encuentra al final como recorre izquierda y después derecha el peor caso la complejidad es O(cn) -> O(n), si no está el elemento es similar a este caso. Si el elemento está a la izquierda la complejidad es O(cn/2) -> O(n/2), debido a que en cada llamada recursiva revisa del lado izquierdo y no es hasta que termina de revisar el lado izquierdo que comienza a buscar en el lado derecho.


La implementación del algoritmo se encuentra en el archivo Search.java que está en la carpeta src. 