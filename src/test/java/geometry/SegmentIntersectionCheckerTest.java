package geometry;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Тесты проверки пересечения отрезков")
public class SegmentIntersectionCheckerTest {

    @ParameterizedTest(name = "{0}")
    @MethodSource("helpers.SegmentDataProvider#intersectingSegmentsProvider")
    @Description("Проверка пересекающихся отрезков")
    void shouldReturnTrueForIntersectingSegments(String description,
                                                 Segment s1, Segment s2) {

        boolean result = checkIntersection(s1, s2);

        assertTrue(result, description);
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("helpers.SegmentDataProvider#nonIntersectingSegmentsProvider")
    @Description("Проверка непересекающихся отрезков")
    void shouldReturnFalseForNonIntersectingSegments(String description,
                                                     Segment s1, Segment s2) {

        boolean result = checkIntersection(s1, s2);

        assertFalse(result, description);
    }

    @Step("Проверяем пересечение отрезков")
    private boolean checkIntersection(Segment s1, Segment s2) {
        return SegmentIntersectionChecker.intersects(s1, s2);
    }

    @Test
    @Description("Погрешность double (EPS) - граничный случай")
    void shouldHandleFloatingPointPrecision() {

        Segment s1 = new Segment(0, 0, 1e-10, 1e-10);
        Segment s2 = new Segment(0, 1e-10, 1e-10, 0);

        assertTrue(
                SegmentIntersectionChecker.intersects(s1, s2),
                "Должны пересекаться даже при очень маленьких значениях"
        );
    }

    @Test
    @Description("Проверка симметричности")
    void shouldBeSymmetric() {
        Segment s1 = new Segment(0, 0, 5, 5);
        Segment s2 = new Segment(0, 5, 5, 0);

        assertEquals(
                SegmentIntersectionChecker.intersects(s1, s2),
                SegmentIntersectionChecker.intersects(s2, s1)
        );
    }
}
