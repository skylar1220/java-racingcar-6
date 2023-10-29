package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class DistanceTest {

    @Test
    void from은_거리값을_받아_객체를_생성한다() {
        Distance distance = Distance.from(1);
        assertThat(distance).isInstanceOf(Distance.class);
    }

    @Test
    void increase는_거리값을_증가시킨다() {
        Distance distance = Distance.from(0);
        distance.increase();
        assertEquals(1, distance.getValue());
    }

    @ParameterizedTest
    @CsvSource({"2, 1", "1,0"})
    void getMaxDistance는_자신의_거리값이_현재_거리의_최대값과_동일하거나_클때_자신의_거리값을_최대값으로_반환한다(int myValue, int maxValue) {
        Distance distance = Distance.from(myValue);
        assertEquals(myValue, distance.getMaxDistance(maxValue));
    }

    @ParameterizedTest
    @CsvSource({"1, 2", "0,1"})
    void getMaxDistance는_자신의_거리값이_현재_거리의_최대값보다_작을때_기존_최뎃값을_반환한다(int myValue, int maxValue) {
        Distance distance = Distance.from(myValue);
        assertEquals(maxValue, distance.getMaxDistance(maxValue));
    }

    @ParameterizedTest
    @CsvSource({"2, 1, true", "1, 2, false"})
    void isMax는_자신의_거리값과_현재_거리의_최대값보다_큰지를_반환한다(int myValue, int maxValue, boolean isMax) {
        Distance distance = Distance.from(myValue);
        assertEquals(isMax, distance.isMax(maxValue));
    }
}
