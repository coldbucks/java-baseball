package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Ball 클래스")
@SuppressWarnings({"InnerClassMayBeStatic", "NonAsciiCharacters"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BallTest {
    private final int BALL_LOWER_BOUND = 0;
    private final int BALL_UPPER_BOUND = 3;

    @Nested
    class valueOf_메서드는 {

        @Nested
        class 만약_0과_3사이의_값을_입력받으면 {

            @Test
            void Ball_객체를_리턴한다() {
                for (int i = BALL_LOWER_BOUND; i < BALL_UPPER_BOUND; i++) {
                    assertThat(Ball.valueOf(i)).isInstanceOf(Ball.class);
                }
            }
        }

        @Nested
        class 만약_주어진_범위보다_더_높은_값을_입력받으면 {
            private final Integer givenNumber = BALL_UPPER_BOUND + 1;

            @Test
            void BaseballGameException을_던진다() {
                assertThatThrownBy(() -> Ball.valueOf(givenNumber))
                        .isInstanceOf(BaseballGameException.class);
            }
        }

        @Nested
        class 만약_주어진_범위보다_더_낮은_값을_입력받으면 {
            private final Integer givenNumber = BALL_LOWER_BOUND - 1;

            @Test
            void BaseballGameException을_던진다() {
                assertThatThrownBy(() -> Ball.valueOf(givenNumber))
                        .isInstanceOf(BaseballGameException.class);
            }
        }
    }
}
