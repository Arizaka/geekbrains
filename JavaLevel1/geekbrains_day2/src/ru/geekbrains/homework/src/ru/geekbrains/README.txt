Урок 2. Основные конструкции
1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами; У матрицы две диагонали, заполнить нужно обе. Массив int изначально проинициализирован нулями, поэтому нужно только написать условие, по которому выставлять 1.

5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);

6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят. Массив делить пополам не нужно! Для массива {1,2,3,4,10} результат должен быть true.

7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Сдвигать элементы массивы нужно по карусели. То есть массив {1,2,3,4,5} при n=1, превращается в {5,1,2,3,4}, а при n = -1 - в {2,3,4,5,1}

8. Дан одномерный массив, состоящий из 0 и 1. Нужно преобразовать его в массив, который
будет содержать числа, отображающие сколько 0 или 1 стоит подряд. Пример:
массив [0,0,0,0,1,1,1,1,1,1,1,0,0,1,1,1,1] преобразуется в [4,7,2,4].

9. Дан массив целых чисел. Нужно узнать среднее арифметическое всех чисел
массива, стоящих на нечетных позициях. Arr[1], arr[3] и т.д.

10. Дан массив целых чисел и некое целое число N. Нужно узнать, есть ли в массиве
число, равное N. Если есть - вывести в консоль сумму всех чисел от 0 элемента, до
элемента, который равен N включительно.

11. Посчитать сумму всех элементов квадратной матрицы.
