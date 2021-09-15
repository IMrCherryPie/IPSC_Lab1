
//Симметрическая разность двух коллекций - это множество элементов, одновременно не принадлежащих обоим исходным коллекциям.

package com.DSTU;

import java.util.ArrayList;
import java.util.Collection;

public class ExampleSymmetricDifference<T>{

    <T> Collection<T> symmetricDifference(Collection<T> a, Collection<T> b) {
        // Объединяем коллекции.
        Collection<T> result = new ArrayList<>(a);
        result.addAll(b);

        // Получаем пересечение коллекций.
        Collection<T> intersection = new ArrayList<>(a);
        intersection.retainAll(b);

        // Удаляем элементы, расположенные в обоих коллекциях.
        result.removeAll(intersection);

        return result;
    }
}
