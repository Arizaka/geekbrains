1.
1.1 Создать классы Собака и Кот с наследованием от класса Животное.

1.2 Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
В качестве параметра каждому методу передается величина, означающая или длину препятствия
(для бега и плавания), или высоту (для прыжков).

1.3 У каждого животного есть ограничения на действия
бег: кот 200 м., собака 500 м.;
прыжок: кот 2 м., собака 0.5 м.;
плавание: кот не умеет плавать, собака 10 м.

1.4 При попытке животного выполнить одно из этих действий, оно должно сообщить результат в консоль.
(Например, dog1.run(150); -> результат: run: true)

1.5 * Добавить животным разброс в ограничениях.
То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.

2.
2.1 Создать класс Vehicle (моторизированный транспорт).

2.2 Создать три класса - Car (легковая машина) и Truck (грузовик), Cart(карт) которые
наследуют класс Vehicle.

2.3 В классе Vehicle создать переменные: int скорость движения, String марка машины,
int вес.

2.4 Создать методы: движение вперед, движение назад, оценить грузоподъемность

2.5 Для классов-наследников написать getter/setter на переменную вес и марку машины.

2.6 Описать работу методов движения в родительском классе или классе наследнике
так, чтобы метод выдавал в консоль пройденную дистанцию в заданном
направлении, а в качестве параметра принимал время (дистанция =
время*скорость). Помнить о том, что карт не умеет ездить назад.

2.7 *Для метода “оценить грузоподъемность” помнить, что карт грузы перевозить не
умеет. У Car и Truck должны быть дополнительные переменные “грузоподъемность”.
Метод должен принимать в качестве параметра вес груза. Ограничение на вес груза
для Car - 500, для Truck 2000. В результате работы метод должен проверить
проходит ли переданный груз по ограничению, и написать в консоль какой будет вес
машины + вес груза.

2.8 В классе Main создать объекты разных классов, применить различные методы