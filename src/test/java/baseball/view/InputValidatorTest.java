package baseball.view;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("InputValidator 클래스")
@SuppressWarnings({"InnerClassMayBeStatic", "NonAsciiCharacters"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputValidatorTest {

    @Nested
    class validateBaseballNumber_메서드는 {

        @Nested
        class 만약_1과_9사이의_중복되지_않는_3자리_숫자를_입력받으면 {
            private final String givenValidInput1 = "123";
            private final String givenValidInput2 = "456";
            private final String givenValidInput3 = "719";

            @Test
            void 예외가_발생하지_않는다() {
                InputValidator.validateBaseballNumber(givenValidInput1);
                InputValidator.validateBaseballNumber(givenValidInput2);
                InputValidator.validateBaseballNumber(givenValidInput3);
            }
        }

        @Nested
        class 만약_2자리_이하의_수를_입력받으면 {
            private final String givenInput = "21";

            @Test
            void IllegalArgumentException_예외를_던진다() {
                assertThatThrownBy(() -> InputValidator.validateBaseballNumber(givenInput))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        class 만약_4자리_이상의_수를_입력받으면 {
            private final String givenInput = "2147";

            @Test
            void IllegalArgumentException_예외를_던진다() {
                assertThatThrownBy(() -> InputValidator.validateBaseballNumber(givenInput))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        class 만약_중복된_값이있는_3자리_숫자를_입력받으면 {
            private final String givenInput = "211";

            @Test
            void IllegalArgumentException_예외를_던진다() {
                assertThatThrownBy(() -> InputValidator.validateBaseballNumber(givenInput))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    class validateGameStatus_메서드는 {

        @Nested
        class 만약_1이나_2를_입력받는_경우 {
            private final String givenValidInput1 = "1";
            private final String givenValidInput2 = "2";

            @Test
            void 예외가_발생하지_않는다() {
                InputValidator.validateGameStatus(givenValidInput1);
                InputValidator.validateGameStatus(givenValidInput2);
            }
        }

        @Nested
        class 만약_1이나_2가_아닌_다른값을_입력받는_경우 {
            private final String givenInput = "3";

            @Test
            void IllegalArgumentException_예외를_던진다() {
                assertThatThrownBy(() -> InputValidator.validateGameStatus(givenInput))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}