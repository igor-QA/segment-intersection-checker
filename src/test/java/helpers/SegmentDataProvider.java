package helpers;

import geometry.Segment;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class SegmentDataProvider {

    public static Stream<Arguments> intersectingSegmentsProvider() {
        return Stream.of(
                Arguments.of(
                        "Классическое пересечение крест-накрест",
                        new Segment(0, 0, 5, 5),
                        new Segment(0, 5, 5, 0)
                ),
                Arguments.of(
                        "Пересечение в общей конечной точке (T-образное)",
                        new Segment(0, 0, 3, 3),
                        new Segment(3, 3, 5, 1)
                ),
                Arguments.of(
                        "Пересечение в общей конечной точке (конец-в-конец)",
                        new Segment(1, 1, 4, 4),
                        new Segment(4, 4, 6, 2)
                ),
                Arguments.of(
                        "Отрезки пересекаются внутри",
                        new Segment(1, 1, 5, 1),
                        new Segment(3, 0, 3, 2)
                ),
                Arguments.of(
                        "Коллинеарные пересекающиеся отрезки (наложение)",
                        new Segment(0, 0, 5, 0),
                        new Segment(2, 0, 7, 0)
                ),
                Arguments.of(
                        "Коллинеарные отрезки с общей точкой (касание)",
                        new Segment(0, 0, 3, 0),
                        new Segment(3, 0, 5, 0)
                ),
                Arguments.of(
                        "Горизонтальный и вертикальный отрезки пересекаются",
                        new Segment(0, 1, 4, 1),
                        new Segment(2, 0, 2, 3)
                )
        );
    }

    public static Stream<Arguments> nonIntersectingSegmentsProvider() {
        return Stream.of(
                Arguments.of(
                        "Параллельные отрезки, не пересекаются",
                        new Segment(0, 0, 4, 0),
                        new Segment(0, 2, 4, 2)
                ),
                Arguments.of(
                        "Отрезки в разных местах, не пересекаются",
                        new Segment(0, 0, 2, 2),
                        new Segment(3, 3, 5, 5)
                ),
                Arguments.of(
                        "Коллинеарные отрезки, но не пересекаются (с зазором)",
                        new Segment(0, 0, 3, 0),
                        new Segment(4, 0, 6, 0)
                ),
                Arguments.of(
                        "Отрезки близко, но не касаются",
                        new Segment(0, 0, 2, 2),
                        new Segment(2, 1, 4, 3)
                ),
                Arguments.of(
                        "Один отрезок над другим по вертикали",
                        new Segment(0, 0, 3, 0),
                        new Segment(1, 1, 2, 1)
                )
        );
    }
}